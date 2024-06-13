package niveles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;
import utils.LoadSave;
import static utils.LoadSave.LEVEL_ATLAS;
import static main.Game.*;

// Clase que maneja los niveles del juego
public class ManejoDeNiveles {
    private Game game; // Instancia del juego
    private BufferedImage[] levelSprite; // Sprites del nivel
    private Nivel levelOne; // Primer nivel

    // Constructor para inicializar el gestor de niveles
    public ManejoDeNiveles(Game game) {
        this.game = game;
        importOutsideSprites();
        levelOne = new Nivel(LoadSave.getLevelData());
    }

    // Método para importar los sprites del nivel
    private void importOutsideSprites() {
        BufferedImage image = LoadSave.getSpriteAtlas(LEVEL_ATLAS);
        levelSprite = new BufferedImage[2];
        for(int j = 0; j < 2; j++) {
            levelSprite[j] = image.getSubimage(j * 32, 0, 32, 32);
        }
    }

    // Método para dibujar el nivel en la pantalla
    public void draw(Graphics g) {
        for (int j = 0; j < TILES_IN_HEIGHT; j++) {
            for (int i = 0; i < TILES_IN_WIDTH; i++) {
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index], i * TILES_SIZE, j * TILES_SIZE, TILES_SIZE, TILES_SIZE, null);
            }
        }
    }

    // Método para actualizar la lógica del nivel
    public void update() {
        // Lógica de actualización del nivel (actualmente vacío)
    }

    // Método para obtener el nivel actual
    public Nivel getCurrentLevel() {
        return levelOne;
    }
}