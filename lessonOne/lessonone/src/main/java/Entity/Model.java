package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Model {

    private Connection connectionDB = null;
    private Properties properties = new Properties();
    private static final String URL = "jdbc:mysql://localhost:3306/userlist";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    public void getConnect() {
        try {
/*            String serverName = "188.120.224.64/phpmyadmin";
            String mydatabase = "userlist-stat-finance";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;*/
            System.out.println("log");
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            properties.setProperty("useUnicode", "true");
            properties.setProperty("useJDBCCompliantTimezoneShift", "true");
            properties.setProperty("serverTimezone", "UTC");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectionDB = DriverManager.getConnection(URL, properties);
            System.out.println(connectionDB.toString() + "log 2");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (SQLException sq) {
            sq.printStackTrace();
            System.out.println("SQLException in getConnect");
        }
    }
    public void resetConnect() {
        try {
            if (!connectionDB.isClosed()) {
                connectionDB.close();
            }
        } catch (SQLException sq) {
            System.out.println("SQLException in resetConnect");
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        model.getConnect();
        model.resetConnect();
    }
}
