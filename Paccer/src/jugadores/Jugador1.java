package jugadores;

import static utils.HelpMethods.CanMoveHere;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.Game;
import utils.LoadSave;

// Clase que define al jugador, hereda de Coche
public class Jugador1 extends Coche {
    private BufferedImage carImage; // Imagen del jugador (coche)
    private boolean left, up, right, down; // Direcciones de movimiento
    private float playerSpeed = 1.0f; // Velocidad del jugador
    private int[][] lvlData; // Datos del nivel
    private String lastDirection = "UP"; // Última dirección del movimiento

    // Constructor para inicializar al jugador
    public Jugador1(float x, float y, int width, int height) {
        super(x, y, width, height);
        loadImage();
        initHitbox(x, y, 17 * Game.SCALE, 16 * Game.SCALE);
    }

    // Método para actualizar la lógica del jugador
    public void update() {
        updatePos();
    }

    // Método para renderizar al jugador en la pantalla
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        double rotation = 0;

        // Determinar la rotación basada en la última dirección
        switch (lastDirection) {
            case "LEFT":
                rotation = Math.toRadians(270);
                break;
            case "RIGHT":
                rotation = Math.toRadians(90);
                break;
            case "DOWN":
                rotation = Math.toRadians(180);
                break;
            default: // "UP"
                rotation = 0;
                break;
        }

        // Calcular el centro de la imagen para la rotación
        double centerX = hitbox.x + width / 2;
        double centerY = hitbox.y + height / 2;

        // Aplicar rotación y dibujar imagen
        g2d.rotate(rotation, centerX, centerY);
        g2d.drawImage(carImage, (int) hitbox.x, (int) hitbox.y, width, height, null);
        g2d.rotate(-rotation, centerX, centerY); // Resetear rotación
    }

    // Método para actualizar la posición del jugador según las teclas presionadas
    private void updatePos() {
        if (!left && !right && !up && !down)
            return;

        float xSpeed = 0, ySpeed = 0;

        if (left && !right) {
            xSpeed = -playerSpeed;
            lastDirection = "LEFT";
        } else if (right && !left) {
            xSpeed = playerSpeed;
            lastDirection = "RIGHT";
        }

        if (up && !down) {
            ySpeed = -playerSpeed;
            lastDirection = "UP";
        } else if (down && !up) {
            ySpeed = playerSpeed;
            lastDirection = "DOWN";
        }

        // Verifica si el jugador puede moverse a la nueva posición
        if (CanMoveHere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height, lvlData)) {
            hitbox.x += xSpeed;
            hitbox.y += ySpeed;
        }
    }

    // Método para cargar la imagen del jugador
    private void loadImage() {
        carImage = LoadSave.getSpriteAtlas(LoadSave.COCHE);
    }

    // Método para cargar los datos del nivel
    public void loadLvlData(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    // Métodos para resetear las direcciones de movimiento
    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    // Métodos getter y setter para las direcciones de movimiento
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public String serialize() {
        return left + "," + right + "," + up + "," + down + "," + hitbox.x + "," + hitbox.y + "," + lastDirection;
    }

    public void deserialize(String data) {
        String[] fields = data.split(",");
        this.left = Boolean.parseBoolean(fields[0]);
        this.right = Boolean.parseBoolean(fields[1]);
        this.up = Boolean.parseBoolean(fields[2]);
        this.down = Boolean.parseBoolean(fields[3]);
        this.hitbox.x = Float.parseFloat(fields[4]);
        this.hitbox.y = Float.parseFloat(fields[5]);
        this.lastDirection = fields[6];
    }
}
