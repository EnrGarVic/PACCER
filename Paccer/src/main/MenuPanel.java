package main;

import javax.swing.JPanel;
import javax.swing.border.Border;
import utils.LoadSave;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

// Clase que representa el panel del menú
public class MenuPanel extends JPanel {
    private Game game; // Instancia del juego
    private BufferedImage background, logo;

    // Constructor para inicializar con el juego
    public MenuPanel(Game game) {
        this.game = game;
        background = LoadSave.getSpriteAtlas(LoadSave.MENU_BACKGROUND);
        logo = LoadSave.getSpriteAtlas(LoadSave.LOGO);
        setLayout(null);

        // Botón Login
        JButton Login_BTN = new JButton("LOGIN");
        Login_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                handleLogin();
            }
        });
        Login_BTN.setBounds(329, 624, 186, 38);
        add(Login_BTN);

        // Botón Sign In
        JButton SignIn_BTN = new JButton("SIGN IN");
        SignIn_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                handleSignIn();
            }
        });
        SignIn_BTN.setBounds(329, 674, 186, 38);
        add(SignIn_BTN);

        // Botón Ranking
        JButton Ranking_BTN = new JButton("RANKING");
        Ranking_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                showRankingPanel();
            }
        });
        Ranking_BTN.setBounds(329, 724, 186, 38);
        add(Ranking_BTN);

        setPanelSize();
    }

    // Método para establecer el tamaño del panel
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size :" + " " + GAME_WIDTH + " | " + GAME_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
        g.drawImage(logo, 175, 170, 500, 500, null);
    }

    // Método para manejar el login
    private void handleLogin() {
        LoginPanel loginPanel = new LoginPanel(game);
        loginPanel.setVisible(true);
    }

    // Método para manejar el sign in
    private void handleSignIn() {
        SignUpPanel signUpPanel = new SignUpPanel();
        signUpPanel.setVisible(true);
    }

    // Método para mostrar el ranking
    private void showRankingPanel() {
        RankingPanel rankingPanel = new RankingPanel();
        JFrame rankingFrame = new JFrame("Ranking");
        rankingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rankingFrame.setSize(400, 300);
        rankingFrame.add(rankingPanel);
        rankingFrame.setVisible(true);
    }
}
