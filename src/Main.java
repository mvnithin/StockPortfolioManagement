import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String url="";
    private static final String username="root";
    private static final String password="root";
    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}