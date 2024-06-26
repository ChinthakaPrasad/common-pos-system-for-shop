package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;
    private Connection connection;
    public DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "1234");
    }
    public DbConnection getInstance() throws SQLException, ClassNotFoundException {
        return dbConnection==null? dbConnection= new DbConnection():dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
