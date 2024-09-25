import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainWin extends JFrame {// implements ActionListener {

    private String NAME = "Nim";
    private String VERSION = "1.4J";
    private String FILE_VERSION = "1.0";
    private String MAGIC_COOKIE = "Nim𓎯";

    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        filename = new File("untitled.nim");
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem anew       = new JMenuItem("New Game");
        JMenuItem open       = new JMenuItem("Open Game");
        JMenuItem save       = new JMenuItem("Save Game");
        JMenuItem saveas     = new JMenuItem("Save Game As");
        JMenuItem quit       = new JMenuItem("Quit");
        JMenu     help       = new JMenu("Help");
        JMenuItem rules      = new JMenuItem("Rules");
        JMenuItem about      = new JMenuItem("About");
        
        anew.addActionListener(event -> onNewGameClick());
        open.addActionListener(event -> onOpenGameClick());
        save.addActionListener(event -> onSaveGameClick());
        saveas.addActionListener(event -> onSaveGameAsClick());
        quit.addActionListener(event -> onQuitClick());
        rules.addActionListener(event -> onRulesClick());
        about.addActionListener(event -> onAboutClick());

        
        file.add(anew);
        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(quit);
        help.add(rules);
        help.add(about);
        
        menubar.add(file);
        menubar.add(help);
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Nim Controls");

        // Add a New Game stock icon
        JButton anewB  = new JButton(UIManager.getIcon("FileView.fileIcon"));
          anewB.setActionCommand("New Game");
          anewB.setToolTipText("Create a new game, discarding any in progress");
          anewB.setBorder(null);
          toolbar.add(anewB);
          anewB.addActionListener(event -> onNewGameClick());
        
        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create the 3 buttons using the icons provided
        button1  = new JButton(new ImageIcon("button1.png"));
          button1.setActionCommand("Select one stick");
          button1.setToolTipText("Select one stick");
          toolbar.add(button1);
          button1.addActionListener(event -> onButtonClick(1));

        button2    = new JButton(new ImageIcon("button2.png"));
          button2.setActionCommand("Select two sticks");
          button2.setToolTipText("Select two sticks");
          toolbar.add(button2);
          button2.addActionListener(event -> onButtonClick(2));

        button3 = new JButton(new ImageIcon("button3.png"));
          button3.setActionCommand("Select three sticks");
          button3.setToolTipText("Select three sticks");
          toolbar.add(button3);
          button3.addActionListener(event -> onButtonClick(3));
        
        toolbar.add(Box.createHorizontalStrut(25));
        
        // Create a toggle button to enable or disable the computer player
        computerPlayer = new JToggleButton(new ImageIcon("freepik_robot.png"));
          computerPlayer.setActionCommand("Enable computer player");
          computerPlayer.setToolTipText("Enable for computer to be Player 2");
          computerPlayer.setBorder(null);
          toolbar.add(computerPlayer);
          computerPlayer.addActionListener(event -> onComputerPlayerClick());

        // "Horizontal glue" expands as much as possible, pushing the "X" to the right
        toolbar.add(Box.createHorizontalGlue());
        
        // Create a custom Quit button (not available in Swing stock icons)
        JButton quitB  = new JButton("X");
          quitB.setActionCommand("Quit");
          quitB.setToolTipText("Exit game");
          quitB.setBorder(null);
          toolbar.add(quitB);
          quitB.addActionListener(event -> onQuitClick());
        toolbar.addSeparator();

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // S T I C K S   D I S P L A Y
        // Provide a text entry box to show the remaining sticks
        sticks = new JLabel();
        sticks.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(sticks, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        
        // Make everything in the JFrame visible
        setVisible(true);
        
        // Start a new game
        onNewGameClick();
    }
    
    // Listeners
    
    protected void onNewGameClick() {         // Create a new game
        nim = new Nim();
        setSticks();
        msg.setFont(new JLabel().getFont());    // Reset to default font
    }
    
    protected void onOpenGameClick() {         // Create a new game
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter nimFiles = new FileNameExtensionFilter("Nim files", "nim");
        fc.addChoosableFileFilter(nimFiles);         // Add "Nim file" filter
        fc.setFileFilter(nimFiles);                  // Show Nim files only by default
        
        int result = fc.showOpenDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();        // Obtain the selected File object
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a Nim file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible Nim file format");
                
                nim = new Nim(br);                   // Open a new game
                if(computerPlayer.isSelected()) 
                    computerPlayer.doClick();        // Turn off AI (can be turned on if desired)
                         // doClick() generates a click event, while setSelected(false) does not
                setSticks();                         // Update the user interface
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }

    protected void onSaveGameClick() {         // Create a new game
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            nim.save(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }

    protected void onSaveGameAsClick() {         // Create a new game
        final JFileChooser fc = new JFileChooser(filename);  // Create a file chooser dialog
        FileFilter nimFiles = new FileNameExtensionFilter("Nim files", "nim");
        fc.addChoosableFileFilter(nimFiles);         // Add "Nim file" filter
        fc.setFileFilter(nimFiles);                  // Show Nim files only by default
        
        int result = fc.showSaveDialog(this);        // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) { // Also CANCEL_OPTION and ERROR_OPTION
            filename = fc.getSelectedFile();         // Obtain the selected File object
            if(!filename.getAbsolutePath().endsWith(".nim"))  // Ensure it ends with ".nim"
                filename = new File(filename.getAbsolutePath() + ".nim");
            onSaveGameClick();                       // Delegate to Save method
        }
    }

    protected void onButtonClick(int button) {  // Select 1, 2, or 3 sticks from pile
        try {
            // Catch the "impossible" out of sticks exception
            nim.takeSticks(button);
            setSticks();
        } catch(Exception e) {
            sticks.setText("FAIL: " + e.getMessage() + ", start new game");
        }
    }
            
    protected void onComputerPlayerClick() {   // Enable / disable computer player
        setSticks();
        // Java Swing requires action to visually indicate enabled / disabled button
        computerPlayer.setBorder(computerPlayer.isSelected() ? BorderFactory.createLineBorder(Color.black) : null);
    }
    protected void onRulesClick() {             // Show the rules
        String s = "The Rules of Nim\n\nCopyright 2017-2020 by George F. Rice - CC BY 4.0\n\n" +
            "The two players alternate taking 1 to 3 sticks from the pile.\n" +
            "The goal is to force your opponent to take the last stick (called misère rules).\n" +
            "If the computer button is up, it's a two player game. If down, the computer is always Player 2.)";
        JOptionPane.showMessageDialog(this, s);
    }
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("The Game of Nim");
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>" + NAME + "</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version " + VERSION + "</p>"
          + "<p>Copyright 2017-2020 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
     }
    protected void onQuitClick() {System.exit(0);}   // Exit the game

    public static void main(String[] args) {
        MainWin myApp = new MainWin("The Game of Nim");
        myApp.setVisible(true);
    }

    private void setSticks() {              // Update display, robot move
        // s collects the status message
        String s = "";
        
        // If the robot is enabled and it's their turn, move the robot
        if(nim.sticksLeft() > 0) {
            if(computerPlayer.isSelected() && nim.currentPlayer() == 2) {
                int move = 1;
                try {
                    move = nim.optimalMove();
                } catch(Exception e) {
                    System.err.println("Invalid optimal move: " + e.getMessage());
                }
                s += "Robot plays " + move + ", ";
                nim.takeSticks(move);
            }
        }
        
        // Report who's turn it is, or (if all sticks gone) who won
        
        if (nim.sticksLeft() > 0) {
            s += "Player " + nim.currentPlayer() + "'s turn";
        } else {
            s += "Player " + nim.currentPlayer() +  " wins!";
            msg.setFont(new Font("SansSerif", Font.BOLD, 18));
        }
        
        // Display the collected status on the status bar
        msg.setText(s);

        // Update the visual display of sticks
        s = "";
        for(int i=0; i<nim.sticksLeft(); ++i) s += ("| ");
        s += "  (" + (nim.sticksLeft()) + " sticks)";
        sticks.setText(s);

        // Set sensitivity of the human stick selectors so user can't make an illegal move
        button1.setEnabled(nim.sticksLeft() > 0);
        button2.setEnabled(nim.sticksLeft() > 1);
        button3.setEnabled(nim.sticksLeft() > 2);
    }
    
    private Nim nim;
    private File filename;
    
    private JLabel sticks;                  // Display of sticks on game board
    private JLabel msg;                     // Status message display
    private JButton button1;                // Button to select 1 stick
    private JButton button2;                // Button to select 2 sticks
    private JButton button3;                // Button to select 3 sticks
    private JToggleButton computerPlayer;   // Button to enable robot
}
