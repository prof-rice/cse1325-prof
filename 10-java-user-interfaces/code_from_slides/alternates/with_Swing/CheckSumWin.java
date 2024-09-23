import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.Security;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

// <a href="https://www.flaticon.com/free-icons/new" title="new icons">New icons created by Freepik - Flaticon</a>
// <a href="https://www.flaticon.com/free-icons/verified" title="verified icons">Verified icons created by VectorPortal - Flaticon</a>

public class CheckSumWin extends JFrame {
    public CheckSumWin() {
        super("CheckSumWin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 200);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem addFile    = new JMenuItem("Add File");
        JMenuItem csum       = new JMenuItem("Generate Checksums");
        JMenuItem quit       = new JMenuItem("Quit");
        
        addFile.addActionListener(event -> onAddFileClick());
        csum.addActionListener(event -> onGenerateChecksumsClick());
        quit.addActionListener(event -> System.exit(0));

        
        file.add(addFile);
        file.add(csum);
        file.add(quit);
        
        menubar.add(file);
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Nim Controls");

        JButton addFileButton  = new JButton(new ImageIcon("add_file.png"));
          addFileButton.setToolTipText("Add a file");
          toolbar.add(addFileButton);
          addFileButton.addActionListener(event -> onAddFileClick());

        JButton genCheckSumButton = new JButton(new ImageIcon("gen_checksum.png"));
          genCheckSumButton.setToolTipText("Generate checksums");
          toolbar.add(genCheckSumButton);
          genCheckSumButton.addActionListener(event -> onGenerateChecksumsClick());
          
        algorithms = new JComboBox<String>(Security.getAlgorithms("MessageDigest").toArray(new String[0]));
          toolbar.add(algorithms);

        // getContentPane().add(toolbar, BorderLayout.PAGE_START);
        add(toolbar, BorderLayout.PAGE_START);
        
        
        // /////////////////////////// ////////////////////////////////////////////
        // D I S P L A Y
        // Provide a text entry box to show the checksum table
        display = new JLabel();
        add(display, BorderLayout.CENTER);

        // Make everything in the JFrame visible
        setVisible(true);
    }
    
    // Listeners
    
    protected void onAddFileClick() {
        final JFileChooser fc = new JFileChooser(file);  // Create a file chooser dialog
        int result = fc.showOpenDialog(this);            // Run dialog, return button clicked
        if (result == JFileChooser.APPROVE_OPTION) {     // If OK was clicked,
            file = fc.getSelectedFile();                 // Obtain the selected File object
        }
     }

    protected void onGenerateChecksumsClick() {
        try {
            byte[] fileContents = Files.readAllBytes(file.toPath());
            byte[] digest = MessageDigest.getInstance((String) algorithms.getSelectedItem()).digest(fileContents);
            display.setText(String.format("<html>%s<br>%0" + (digest.length*2) + "x%n</html>", 
                file.getName(), new BigInteger(1, digest)));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to generate checksum: " + e);
        }
    }

    private File file;
    private JComboBox<String> algorithms;
    private JLabel display;
    
    public static void main(String[] args) {
        new CheckSumWin();
    }
}
