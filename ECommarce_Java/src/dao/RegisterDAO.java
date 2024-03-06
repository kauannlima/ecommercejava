package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbutil.DBUtil;
import pojo.RegisterInfo;

public class RegisterDAO {

    public static boolean registerUser(RegisterInfo userDetails) {
        boolean registrationStatus = false;
        
        try {
            Connection conn = DBUtil.getConnection();
            
            // Verifique se o usuário já existe antes de tentar registrar
            if (!isUserExists(userDetails.getUserName(), conn)) {
                String query = "INSERT INTO users (user_name, password) VALUES (?, ?)";
                
                try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                    preparedStatement.setString(1, userDetails.getUserName());
                    preparedStatement.setString(2, userDetails.getPassword());
                    
                    int rowsAffected = preparedStatement.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        registrationStatus = true;
                    }
                }
            }
            
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return registrationStatus;
    }

    private static boolean isUserExists(String userName, Connection conn) {
        boolean userExists = false;
        
        try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE user_name = ?")) {
            preparedStatement.setString(1, userName);
            userExists = preparedStatement.executeQuery().next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return userExists;
    }
}
