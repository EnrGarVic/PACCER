package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DataBase.UserLogin;
import utils.LoadSave;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class LoginPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField textField;
    private Game game;
    private BufferedImage background, logo;

    public LoginPanel(Game game) {
        this.game = game;
        background = LoadSave.getSpriteAtlas(LoadSave.GAMELOGO);
        logo = LoadSave.getSpriteAtlas(LoadSave.LOGO);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        passwordField = new JPasswordField();
        passwordField.setBounds(69, 121, 264, 36);
        contentPane.add(passwordField);

        textField = new JTextField();
        textField.setBounds(69, 48, 264, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblUsser = new JLabel("USER");
        lblUsser.setForeground(new Color(255, 255, 255));
        lblUsser.setBounds(69, 32, 70, 15);
        contentPane.add(lblUsser);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(69, 105, 110, 15);
        contentPane.add(lblPassword);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                boolean authenticated = UserLogin.authenticateUser(username, password);
                if (authenticated) {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Login successful!");
                    game.setCurrentUser(username); // Almacenar el nombre de usuario en la clase Game
                    game.showPlayerSelectionPanel();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password.");
                }
            }
        });
        btnNewButton.setBounds(158, 192, 117, 25);
        contentPane.add(btnNewButton);
    }
}