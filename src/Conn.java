import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Conn{
    Connection connection;
    Statement statement;
    public Conn(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system","root","MySql@2025");
            statement = connection.createStatement();
            System.out.println("Databases work perfectly,for team alpha");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String [] args){
        new Conn();
    }
}