package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;
import pojo.Product;

public class ProductManagementDAO {

    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        try {
            Connection conn = DBUtil.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                Product product = new Product(rs.getString("id"), rs.getString("prod_name"),
                        rs.getString("prod_description"), rs.getBigDecimal("prod_price"));
                productList.add(product);
            }
            DBUtil.closeConnection(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }

    public static Product getProductById(String productId) {
        Product product = null;

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE id = ?");
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getString("id"), rs.getString("prod_name"), rs.getString("prod_description"),
                        rs.getBigDecimal("prod_price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public static List<Product> getProductsByName(String productName) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps;

            if (productName == null || productName.trim().isEmpty()) {
                ps = conn.prepareStatement("SELECT * FROM products");
            } else {
                ps = conn.prepareStatement("SELECT * FROM products WHERE prod_name LIKE ?");
                ps.setString(1, "%" + productName + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString("id"), rs.getString("prod_name"),
                        rs.getString("prod_description"), rs.getBigDecimal("prod_price"));
                productList.add(product);
            }

            DBUtil.closeConnection(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }


}
