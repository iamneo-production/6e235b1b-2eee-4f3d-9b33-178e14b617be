package utility;
//import java.sql.DriverManager;
import java.sql.*;

public class ConnectionManager {
    
    static String jdbcUrl= "jdbc:mysql://localhost:3306/BlogDB?useSSL=false";
    static String jdbcUsername= "root";
    static String jdbcPassword= "examly";
    
    public Connection connect(){
        Connection connection= null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
