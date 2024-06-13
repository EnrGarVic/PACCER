// Paquete de entidades
package jugadores;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

// Clase abstracta que define una entidad genérica en el juego
public abstract class Coche {
    // Coordenadas y dimensiones de la entidad
    protected float x, y;
    protected int width, height;
    // Rectángulo que representa la hitbox de la entidad
    public Rectangle2D.Float hitbox;

    // Constructor para inicializar la entidad
    public Coche(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Método para dibujar la hitbox (útil para depuración)
    protected void drawHitbox(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }

    // Método para inicializar la hitbox con las coordenadas y dimensiones dadas
    protected void initHitbox(float x, float y, float width, float height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }

    // Método para actualizar la posición de la hitbox según la posición de la entidad
    protected void updateHitbox() {
        hitbox.x = (int) x;
        hitbox.y = (int) y;
    }

    // Método para obtener la hitbox de la entidad
    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }
}