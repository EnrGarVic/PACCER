package main;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import teclado.InputsTeclado;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

// Clase que representa el panel del juego
public class GamePanel extends JPanel {
    private Game game; // Instancia del juego

    // Constructor para inicializar con el juego
    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
        addKeyListener(new InputsTeclado(this, game));
    }

    // Método para establecer el tamaño del panel
    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size :" + " " + GAME_WIDTH + " | " + GAME_HEIGHT);
    }

    // Método para pintar los componentes del panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

    // Método para obtener el juego
    public Game getGame() {
        return game;
    }
}
