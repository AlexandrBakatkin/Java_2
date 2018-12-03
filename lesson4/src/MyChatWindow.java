import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MyChatWindow extends JFrame {
    private JTextField jTextField;
    private JTextArea textArea;

    public MyChatWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setBounds(500, 200, 500, 300);
        JPanel panelMain = new JPanel(new BorderLayout());
        JPanel panelDown = new JPanel(new BorderLayout());

        JButton jbEnter = new JButton("Enter");
        textArea = new JTextArea();
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        jTextField = new JTextField();
        JScrollPane scrollPane = new JScrollPane(textArea);

        jbEnter.addActionListener(e -> sendMsg());
        jTextField.addActionListener(e -> sendMsg());

        panelMain.add(scrollPane, BorderLayout.CENTER);
        panelDown.add(jTextField, BorderLayout.CENTER);
        panelDown.add(jbEnter, BorderLayout.LINE_END);
        panelMain.add(panelDown, BorderLayout.SOUTH);
        Container container = getContentPane();
        container.add(panelMain);

        setVisible(true);
    }

    public void sendMsg(){
        Date date = new Date();
        if (jTextField.getText().equals("")){
            jTextField.grabFocus();
            return;
        }
        textArea.append(date.toString() + " - Пользователь1: " + "\n");
        textArea.append(jTextField.getText() + "\n");
        textArea.append("\n");
        jTextField.setText("");
        jTextField.grabFocus();
    }
}