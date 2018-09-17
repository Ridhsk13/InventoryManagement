package application.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {

    private String host = "jdbc:mysql://localhost:3306/inventorymanagement";
    private String user = "root";
    private String pwd = "ridhs7474";
    private Connection connection;

    public DatabaseController() {
    }

    public Connection getDbConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(host,user,pwd);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
