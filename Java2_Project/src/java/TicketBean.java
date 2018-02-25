import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * Bean for Ticket
 */
@Named(value = "ticketBean")
@RequestScoped
public class TicketBean {

    /**
     * Creates a new instance of TicketBean
     */
    public TicketBean() {
    }
    
    /**
     * Note: Make sure to update the url and credentials to your own
     * 
     * @return new database connection
     * @throws java.lang.ClassNotFoundException
     */
    public Connection getConnection() throws ClassNotFoundException {
      Connection con = null;
      String url = "jdbc:mysql://127.0.0.1:3306/my_database";
      String user = "root";
      String password = "E,scky96+PJy";
      
      Class.forName("com.mysql.jdbc.Driver");
      
      try {
         con = DriverManager.getConnection(url, user, password);
         System.out.println("Connection completed.");
      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      
      finally {
      }
      return con;
   }
    
}
