import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class LoginScreen extends JFrame implements ActionListener {
    // Declare UI components here
    JLabel labelUsername, labelPassword;
    JTextField textUsername;
    JPasswordField textPassword;
    JButton buttonLogIn;

    public LoginScreen() {
        // Initialize UI components here
        labelUsername = new JLabel("Officer Name:");
        labelPassword = new JLabel("Unit Number:");
        textUsername = new JTextField();
        textPassword = new JPasswordField();
        buttonLogIn = new JButton("Log In");
        
        getContentPane().setBackground(new Color(135, 206, 235));
        
        
        // Add action listener for button
        buttonLogIn.addActionListener(this);

        // Set layout and add components to the frame
        setLayout(new GridLayout(10, 2));
        add(labelUsername);
        add(textUsername);
        add(labelPassword);
        add(textPassword);
        add(new JLabel());
        add(buttonLogIn);

        setTitle("Log In");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogIn) {
            // Check username and password
            String username = textUsername.getText();
            char[] password = textPassword.getPassword();
            if (username.equals("admin") && new String(password).equals("admin")) {
                // Correct username and password, show main screen
                new PoliceStationManagementSystem();
                setVisible(false);
            } else {
                // Incorrect username and password, show error message
                JOptionPane.showMessageDialog(this, "Invalid officer name or unit number.");
            }
        }
    }
}