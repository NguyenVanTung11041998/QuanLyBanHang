package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataProvider {
    private static DataProvider instance;
    private Connection connection;
    public static DataProvider getInstance() {
        if(instance == null)
            instance = new DataProvider();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    private DataProvider() 
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanHang_PTPMTCP", "sa", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet GetData(String query)
    {
        ResultSet data = null;
        try {
            Statement state = connection.createStatement();
            data = state.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public ResultSet GetDataSearch(String query, String search)
    {
        ResultSet data = null;
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setString(1, search);
            data = pre.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    public ResultSet GetById(String query, int id)
    {
        ResultSet data = null;
        try {
            PreparedStatement pre = connection.prepareStatement(query);
            pre.setInt(1, id);
            data = pre.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
