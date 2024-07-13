import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        GUI gui = createGUI();
        addLoginActionListener(gui);
        gui.frame().setVisible(true);
    }

    private static GUI createGUI() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 110, 350, 25);
        panel.add(messageLabel);

        return new GUI(frame, userText, passwordText, loginButton, messageLabel);
    }

    private static void addLoginActionListener(GUI gui) {
        gui.loginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkUsernameAndPassword(gui);
            }
        });
    }

    private static void checkUsernameAndPassword(GUI gui) {
        String username = gui.userText().getText();
        String password = new String(gui.passwordText().getPassword());

        if (username.equals("Tarık") && password.equals("123456789")) {
            gui.messageLabel().setText("Login succesfull.");
        } else if (username.equals("Ziya") && password.equals("987654321")) {
            gui.messageLabel().setText("Login succesfull.");
        } else {
            gui.messageLabel().setText("Login failed. Please check your username and password.");
        }
    }

    private record GUI(JFrame frame, JTextField userText, JPasswordField passwordText, JButton loginButton, JLabel messageLabel) {
    }
}
