package multijugador;

import java.io.*;
import java.net.*;

import jugadores.Jugador1;
import jugadores.Jugador2;

import main.Game;

public class Cliente {
    private Game game;
    private String serverAddress = "localhost";
    private int serverPort = 5005;
    private Jugador2 clientPlayer;
    private Jugador1 serverPlayer;

    public Cliente(Game game) {
        this.game = game;
        this.serverPlayer = game.getPlayer1();
        this.clientPlayer = game.getPlayer2();
    }

    public void start() {
        try (Socket socket = new Socket(serverAddress, serverPort)) {
        	game.startGame();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String clientMessage = clientPlayer.serialize();
                out.println(clientMessage);

                String serverMessage = in.readLine();
                if (serverMessage != null) {
                	serverPlayer.deserialize(serverMessage);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client exception: " + e.getMessage());
        }
    }
}