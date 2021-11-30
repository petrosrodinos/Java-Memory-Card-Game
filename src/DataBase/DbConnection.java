package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


//i klasi afti kanei tin sindesi me tin basi dedomenon
public class DbConnection{

    private final String username;
    private final String password;
    private final String databaseName;
    private Connection connection;
    private static DbConnection instance;
    ResultSet rs;
    PreparedStatement stmt;
    

    private DbConnection(String username, String password, String dbname) {
        this.username = username;
        this.password = password;
        this.databaseName = dbname;
        this.initConnection();
    }

    private void initConnection() {
        String url = "jdbc:mysql://localhost/" + this.databaseName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, this.username, this.password);
            System.out.println("Connection established");
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error Connecting to Data Base");
            JOptionPane.showMessageDialog(null, "Error Connecting to Data Base");  
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    

    public static DbConnection getInstance(String username, String password, String dbname) {
        if (instance != null) {
            return instance;
        }
        instance = new DbConnection(username, password, dbname);
        return instance;
    }

    PreparedStatement prepareStatement(String q) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
