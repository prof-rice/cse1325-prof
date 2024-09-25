import java.awt.*;
import javax.swing.*;

public class MenuDemo extends JFrame {
    public MenuDemo(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem anew       = new JMenuItem("New");
        JMenuItem open       = new JMenuItem("Open");
        JMenuItem save       = new JMenuItem("Save");
        JMenu     saveAs     = new JMenu("Save As");
        JMenuItem saveAsExam = new JMenuItem("Exam");
        JMenuItem saveAsQuiz = new JMenuItem("Quiz");
        JMenuItem exit       = new JMenuItem("Exit");
        
        file.add(anew);
        file.add(open);
        file.add(save);
        saveAs.add(saveAsExam);
        saveAs.add(saveAsQuiz);
        file.add(saveAs);
        file.add(exit);
        
        menubar.add(file);
        setJMenuBar(menubar);
        
        setVisible(true); 
    }
    public static void main(String[] args) {
        MenuDemo myApp = new MenuDemo("Menu Demo");
        myApp.setVisible(true);
    }
}
