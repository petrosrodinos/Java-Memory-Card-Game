package DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

//afti h klasi einai ypefthini gia ton xirismo tis basis
public class DBController {

    private final DbConnection singleDbConnection;
    String namenow;
    ResultSet rs;
    PreparedStatement stmt;
    static String user;

    public DBController(DbConnection connection) {
        this.singleDbConnection = connection;
    }

    //eisagogi xristi
    public void insertUser(String name) throws SQLException {
        DBController.user = name;
        if(!userExists(name)){            
            try (PreparedStatement statement = this.singleDbConnection.getConnection().prepareStatement(
                "INSERT INTO projectjava2020 (name, besttime, bestscore) VALUES (?, ?, ?)"
        )) {            
            statement.setString(1, name);
            statement.setInt(2, 0);
            statement.setInt(3, 0);
            statement.executeUpdate();
            System.out.println("User Added");
        }
            
        }else{
            System.out.println("User Already Exists");
        }
    }
    //elegxei an iparxei o xristis poy dosame   
    public boolean userExists(String name) throws SQLException{
        
        String q = "SELECT name FROM `projectjava2020`";
            
        stmt = this.singleDbConnection.getConnection().prepareStatement(q);                       
        rs = stmt.executeQuery();
            
        while(rs.next()){
            namenow = rs.getString("name");
            if(namenow.equals(name)){
                stmt.close();
                rs.close();
                return true;
            }
        }         
        return false;
    }
    
    //enimeronei to table tou xristi gia to score kai time
    public void updateUser(int score,int time) throws SQLException{
        if(betterData(score,time)){
            try{
                String q = "UPDATE projectjava2020 SET besttime = ? ,bestscore= ? WHERE name= ? ";
                stmt = this.singleDbConnection.getConnection().prepareStatement(q);
                stmt.setInt(1, time);
                stmt.setInt(2, score);
                stmt.setString(3, user);        
                stmt.executeUpdate();
                System.out.println("User Updated");
            }catch(SQLException ex){
                System.out.println("Problem Updating User");
        }
        }else{
            System.out.println("Not Better Try Harder");
        }
    }
    
    public boolean betterData(int score,int time) throws SQLException{ 
        try{
            String q = "SELECT besttime,bestscore FROM projectjava2020 WHERE name= ? ";
            stmt = this.singleDbConnection.getConnection().prepareStatement(q);
            stmt.setString(1, user);
            rs = stmt.executeQuery();
            while (rs.next()) {
                if(rs.getInt("besttime")<time || rs.getInt("bestscore")>score){
                    return false;
                }
            }           
        }catch(SQLException ex){
            System.out.println("Problem Finding User Previous Data");
        }
        return true;
    }
    
    //epistrefei tis klaseis olon ton paikton pou iparxoun stin basi
    public List<Player> retrieveAllUsers() throws SQLException {
        List<Player> studentsList = new ArrayList<>();
        try (Statement statement = this.singleDbConnection.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT *  FROM projectjava2020");
            while (rs.next()) {
                studentsList.add(new Player(rs.getString("name"), rs.getInt("besttime"), rs.getInt("bestscore")));
            }
        }
        return studentsList;
    }


}
