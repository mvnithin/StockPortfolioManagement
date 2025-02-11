package stockportfolio;
import java.sql.*;
public class DBconnection {
    private static final String url="jdbc:mysql://localhost:3306/stock_portfolio";
    private static final String username="root";
    private static final String password="root";
    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
