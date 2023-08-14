import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiPanelApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private SignUpPanel signUpPanel;
    private LoginPanel loginPanel;
    private ProfilePanel profilePanel;

    public MultiPanelApp() {
        // Set up the main JFrame
        setTitle("MultiPanel Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panels
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        signUpPanel = new SignUpPanel();
        loginPanel = new LoginPanel();
        profilePanel = new ProfilePanel();

        // Add panels to the card panel
        cardPanel.add(signUpPanel, "SignUp");
        cardPanel.add(loginPanel, "Login");
        cardPanel.add(profilePanel, "Profile");

        // Show the login panel by default
        cardLayout.show(cardPanel, "Login");

        // Add the card panel to the JFrame
        add(cardPanel);

        // Show the JFrame
        setVisible(true);
    }

    private class SignUpPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton createAccountButton;

    public SignUpPanel() {
        setLayout(new GridLayout(3, 1));

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        createAccountButton = new JButton("Create Account");

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform account creation logic here

                // After account creation, switch to the login panel
                cardLayout.show(cardPanel, "Login");
            }
        });

        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(createAccountButton);
      }
    }


    private class LoginPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton;

    public LoginPanel() {
        setLayout(new GridLayout(4, 1));

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        createAccountButton = new JButton("Create Account");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform login logic here

                // After successful login, switch to the profile panel
                cardLayout.show(cardPanel, "Profile");
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the sign-up panel
                cardLayout.show(cardPanel, "SignUp");
            }
        });

        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(createAccountButton);
      }
    }


    private class ProfilePanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JButton updateButton;

    public ProfilePanel() {
        setLayout(new GridLayout(5, 1));

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        nameField = new JTextField(20);
        updateButton = new JButton("Update");

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform profile update logic here
            }
        });

        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Name:"));
        add(nameField);
        add(updateButton);
     }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MultiPanelApp());
    }
}
