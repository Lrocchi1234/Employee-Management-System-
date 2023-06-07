import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection con;

    public Connection createDBConnection() {
        try {
            // Load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            // Get connection
            String url = "jdbc:mysql://localhost:3306/employeeDB?useSSL=false";
            String username = "root";
            String password = "Bonamax2040!";
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Database connection closed successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
