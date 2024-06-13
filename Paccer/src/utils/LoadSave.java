package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;



import static main.Game.*;

public class LoadSave {
	public static final String COCHE = "coche.png";
	public static final String POLICIA = "police.png";
	public static final String TERRAIN_DATA = "data.png";
	public static final String LEVEL_ATLAS = "level_tiles.png";
    public static final String MENU_BACKGROUND = "fondo.png";
    public static final String LOGO = "gameLogo3.png";
    public static final String GAMELOGO = "gameLogo.png";
    public static final String DIA = "dia.png";

     public static BufferedImage getSpriteAtlas(String fileName) {
        BufferedImage image = null;
        try (InputStream is = LoadSave.class.getResourceAsStream("/" + fileName)) {
            if (is != null) {
                image = ImageIO.read(is);
        } else {
            throw new FileNotFoundException("Image " + fileName + " was not found!");
        }
            
    } catch (IOException e) {
        e.printStackTrace();
    }
        return image;
    
    }

    public static int[][] getLevelData() {
        int[][] levelData = new int[TILES_IN_HEIGHT][TILES_IN_WIDTH];
        BufferedImage image = getSpriteAtlas(TERRAIN_DATA);
        
        for (int j = 0; j < image.getHeight(); j++) {
            for (int i = 0; i < image.getWidth(); i++) {
                Color color = new Color(image.getRGB(i, j));
                int value = color.getRed();
                if (value >= 2) {
                    value = 1;
                }
                levelData[j][i] = value;
            }
        }
        return levelData;
    }
}