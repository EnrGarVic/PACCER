package niveles;

// Clase que define un nivel en el juego
public class Nivel {
    private int[][] lvlData; // Datos del nivel

    // Constructor para inicializar con datos del nivel
    public Nivel(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    // Método para obtener el índice del sprite en una posición específica
    public int getSpriteIndex(int x, int y) {
        return lvlData[y][x];
    }

    // Método para obtener los datos del nivel
    public int[][] getLevelData() {
        return lvlData;
    }
}