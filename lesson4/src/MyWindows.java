import javax.swing.*;
import java.awt.*;

public class MyWindows extends JFrame {
    public MyWindows(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Window");
        setBounds(500, 200, 200, 300);
        JButton jb1 = new JButton("Button #1");
        JButton jb2 = new JButton("Button #2");
        add(jb1, BorderLayout.NORTH);
        add(jb2, BorderLayout.SOUTH);
        setVisible(true);
    }
}
