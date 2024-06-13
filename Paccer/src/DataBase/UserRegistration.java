package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration {
    public static void registerUser(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/login";
        String user = "root";
        String pass = "4231";
        
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            
            System.out.println("Usuario registrado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
}
