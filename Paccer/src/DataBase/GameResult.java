package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private static final String URL = "jdbc:mysql://localhost:3306/login";
    private static final String USER = "root";
    private static final String PASS = "4231";

    public static void insertWinner(String winner) {
        String query = "INSERT INTO games (winner) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, winner);
            pstmt.executeUpdate();

            System.out.println("Game result inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<RankingEntry> getRanking() {
        String query = "SELECT winner, COUNT(*) AS wins\n"
        		+ "FROM games\n"
        		+ "WHERE winner IS NOT NULL\n"
        		+ "GROUP BY winner\n"
        		+ "ORDER BY wins DESC;\n";
        List<RankingEntry> ranking = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String winner = rs.getString("winner");
                int wins = rs.getInt("wins");
                ranking.add(new RankingEntry(winner, wins));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ranking;
    }
}
