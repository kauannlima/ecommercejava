package dbutil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseInitializer {

	public static void initializeDatabase() {
		try {
			Connection conn = DBUtil.getConnection();

			conn.createStatement().executeUpdate("USE ecommerce_java");

			createUsersTable(conn);
			createProductsTable(conn);
			insertProducts(conn);

			DBUtil.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createUsersTable(Connection conn) throws Exception {
		Statement statement = conn.createStatement();
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (" + "id INT AUTO_INCREMENT PRIMARY KEY,"
				+ "user_name VARCHAR(255) UNIQUE," + "password VARCHAR(255)" + ")");
	}

	private static void createProductsTable(Connection conn) throws Exception {
	    Statement statement = conn.createStatement();
	    statement.executeUpdate("CREATE TABLE IF NOT EXISTS products (" +
	            "id INT AUTO_INCREMENT PRIMARY KEY," +
	            "prod_name VARCHAR(255) UNIQUE," +
	            "prod_description VARCHAR(1000)," +
	            "prod_price DECIMAL(10,2)," +
	            "INDEX idx_prod_name (prod_name)" +
	            ")");
	}



	private static void insertProducts(Connection conn) throws Exception {
		String insertProductsSQL = "INSERT INTO products (prod_name, prod_description, prod_price) VALUES (?, ?, ?)";
		try (PreparedStatement preparedStatement = conn.prepareStatement(insertProductsSQL)) {
	
			preparedStatement.setString(1, "Smartphone");
			preparedStatement.setString(2, "Um Smarthphone poderoso para todas as suas necessidades de computação.");
			preparedStatement.setBigDecimal(3, new BigDecimal("1299.99"));
			preparedStatement.executeUpdate();
			
		

			preparedStatement.setString(1, "Fones de Ouvido");
			preparedStatement.setString(2, "Fones de ouvido de alta qualidade para uma experiência musical imersiva.");
			preparedStatement.setBigDecimal(3, new BigDecimal("99.99"));
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "Camiseta");
			preparedStatement.setString(2, "Uma camiseta confortável e estilosa para o seu dia a dia.");
			preparedStatement.setBigDecimal(3, new BigDecimal("29.99"));
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "Calça Jeans");
			preparedStatement.setString(2, "Uma calça jeans durável e elegante para várias ocasiões.");
			preparedStatement.setBigDecimal(3, new BigDecimal("49.99"));
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "Tênis");
			preparedStatement.setString(2, "Tênis moderno e confortável para seus passeios e atividades físicas.");
			preparedStatement.setBigDecimal(3, new BigDecimal("79.99"));
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "Notebook");
			preparedStatement.setString(2, "Um notebook poderoso para todas as suas necessidades de computação.");
			preparedStatement.setBigDecimal(3, new BigDecimal("1299.99"));
			preparedStatement.executeUpdate();
		}
	}



	

	
}