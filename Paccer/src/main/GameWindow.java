package main;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Clase que representa la ventana del juego
public class GameWindow {
    private JFrame jframe;

    // Constructor para inicializar la ventana con el panel del menú
    public GameWindow(JPanel panel) {
        jframe = new JFrame();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
        jframe.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent arg0) {
                // No implementado
            }

            @Override
            public void windowLostFocus(WindowEvent arg0) {
                if (panel instanceof GamePanel) {
                    ((GamePanel) panel).getGame().windowFocusLost();
                }
            }
        });
    }

    // Método para cambiar el panel actual
    public void setPanel(JPanel panel) {
        jframe.getContentPane().removeAll();
        jframe.add(panel);
        jframe.revalidate();
        jframe.repaint();
        panel.requestFocus();
    }
}
