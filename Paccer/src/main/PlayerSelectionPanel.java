package main;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import utils.LoadSave;

public class PlayerSelectionPanel extends JPanel {
    private Game game;
    private BufferedImage background, logo;

    public PlayerSelectionPanel(Game game) {
        this.game = game;
        background = LoadSave.getSpriteAtlas(LoadSave.DIA);
        logo = LoadSave.getSpriteAtlas(LoadSave.LOGO);
        setLayout(null);

        // Botón Player 1
        JButton player1_BTN = new JButton("Player 1");
        player1_BTN.setBounds(329, 674, 186, 38);
        player1_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                handlePlayer1();
            }
        });
        add(player1_BTN);

        // Botón Player 2
        JButton player2_BTN = new JButton("Player 2");
        player2_BTN.setBounds(329, 724, 186, 38);
        player2_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                handlePlayer2();
            }
        });
        add(player2_BTN);

        setPanelSize();
    }

    private void setPanelSize() {
        Dimension size = new Dimension(Game.GAME_WIDTH, Game.GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size :" + " " + Game.GAME_WIDTH + " | " + Game.GAME_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(logo, 175, 170, 500, 500, null);
    }

    private void handlePlayer1() {
        System.out.println("Player 1 seleccionado");
        game.setIsServer(true);
        game.startServer();
    }

    private void handlePlayer2() {
        System.out.println("Player 2 seleccionado");
        game.startClient();
    }
}
