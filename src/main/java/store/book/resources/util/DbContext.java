package store.book.resources.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbContext {

    String database = "BookStore";
    String user = "sa";
    String password = "123";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionString = "jdbc:sqlserver://localhost;databaseName=" + database
                + ";TrustServerCertificate=True";
        Connection con = DriverManager.getConnection(connectionString, user, password);
        System.out.println("Connected to the database successfully!");
        return con;
    }

}
