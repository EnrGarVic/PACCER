package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import DataBase.UserRegistration;
import utils.LoadSave;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SignUpPanel extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    public SignUpPanel() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage background = LoadSave.getSpriteAtlas(LoadSave.MENU_BACKGROUND);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsser = new JLabel("USER");
        lblUsser.setForeground(new Color(255, 255, 255));
        lblUsser.setBounds(69, 32, 70, 15);
        contentPane.add(lblUsser);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(69, 105, 110, 15);
        contentPane.add(lblPassword);

        textField = new JTextField();
        textField.setBounds(69, 48, 270, 34);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(69, 123, 270, 34);
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("SIGN UP");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                UserRegistration.registerUser(username, password);
                JOptionPane.showMessageDialog(SignUpPanel.this, "User registered successfully!");
                dispose();
            }
        });
        btnNewButton.setBounds(167, 189, 117, 25);
        contentPane.add(btnNewButton);
    }
}
