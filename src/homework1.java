import java.sql.*;

/**
 * Created by UserX on 10/23/2016.
 */
public class homework1 {

    // JDBC driver name and database URL

    static final String DB_URL = "jdbc:mysql://localhost/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Letmein1";

    public static void main(String[] args) {
       // createDB();
        createTables();
    }
    private static void  createDB() {
        Connection conn = null;
        Statement stmt = null;
        try

        {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE minions_db";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
  }

  private static void createTables(){
      try {
          Connection connection = DriverManager.getConnection(DB_URL+"minions_db", USER, PASS);
          Statement statement = connection.createStatement();
          String sql = "CREATE TABLE towns(\n" +
                  "id int primary key auto_increment,\n" +
                  "country varchar(50)\n" +
                  ")\n"+
                  "CREATE TABLE villains(\n" +
                  "id int primary key auto_increment,\n" +
                  "name varchar(50),\n" +
                  "evilness ENUM('good', 'bad', 'evil', 'super evil')\n"+
                  ")\n"+""
                  ;
          statement.executeUpdate(sql);
      } catch (SQLException e) {
          e.printStackTrace();
      }

  }
}
