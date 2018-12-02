import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyChatWindow extends JFrame {
    private JTextField jTextField;
    private JTextArea textArea;

    public MyChatWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setBounds(500, 200, 500, 300);

        JButton jbEnter = new JButton("Enter");
        add(jbEnter, BorderLayout.SOUTH);

        jTextField = new JTextField();
        textArea = new JTextArea();
        textArea.setFocusable(false);
        add(textArea);

        add(jTextField, BorderLayout.NORTH);

        jbEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });


        setVisible(true);
    }

    public void sendMsg(){
        textArea.append(jTextField.getText() + "\n");
        jTextField.setText("");
        jTextField.grabFocus();
    }
}
