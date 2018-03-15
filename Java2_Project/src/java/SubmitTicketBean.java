
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * Bean for Ticket
 */
@Named(value = "sbmtktBean")
@RequestScoped
public class SubmitTicketBean extends SubmitTicket {
    private static final String SQL_INSERT = "INSERT INTO `database`.`Ticket` "
    		+ "(`idApplication`, `Name`, `Status`,"
    		+ "`Priority`, `Assignee`,"
    		+ " `Summary`, `Detailed Description`) VALUES (?, ?, ?, ?, ?, ?, ?);";
     
    private static final String SQL_SELECT = "SELECT * FROM `database`.`Ticket`";
    private static final String SQL_SELECT_APPS = "SELECT * FROM `database`.`Application`";
    private static final String SQL_SELECT_APP_NAME = "SELECT * FROM `database`.`Application` WHERE `Name` = ?";
    private static final String SQL_UPDATE_TICKET_STATUS = "UPDATE `database`.`Ticket` SET Status = ? WHERE id = ?";
    
    /**
     * Creates a new instance of TicketBean
     */
    public SubmitTicketBean() {
    }
    
    public List<String> getApplications() throws ClassNotFoundException
    {
        Connection con = getConnection();
        List<String> ApplicationsList = new ArrayList<>();
            try {
                PreparedStatement pst = con.prepareStatement(SQL_SELECT_APPS);
                ResultSet applications_rs = pst.executeQuery();
                while(applications_rs.next()){
                    //Retrieve by column name
                    String name = applications_rs.getString("Name");
                    ApplicationsList.add(name);
                }
 			  
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                }
                
                return ApplicationsList; 		
        
    }
    
    public int getApplicationId(String app_name) throws ClassNotFoundException
    {
        ResultSet result_rs = null;
        Connection con = getConnection();
        int application_id = -1;
        String app_status = null;
        try
        {
            PreparedStatement pst = con.prepareStatement(SQL_SELECT_APP_NAME);
            pst.setObject(1, app_name);
            result_rs = pst.executeQuery();
            pst.execute();
            pst.close();
            
            while(result_rs.next()){
                //Retrieve by column name
                app_status = result_rs.getString("Status");
                if(app_status.equals("OPEN")) {
                    application_id = result_rs.getInt("id");
                }
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
                
        return application_id; 		
        
    }
    
    public String addTicket() throws ClassNotFoundException
    {
        int idApplication = getApplicationId(this.getAppName());        
        if(idApplication == -1) {
            System.out.println("Application is not OPEN");
            return "Application is not OPEN";
        }
        Connection con = getConnection();
      
        try {   
            PreparedStatement pst = con.prepareStatement(SQL_INSERT);
            pst.setObject(1, idApplication);
            pst.setObject(2, this.getAppName());
            pst.setObject(3, this.getTicketStatus());
            pst.setObject(4, this.getPriority());
            pst.setObject(5, this.getAssignee());
            pst.setObject(6, this.getSummary());
            pst.setObject(7, this.getDetailedDescription());
        
            pst.execute();
            con.close();
            return "addTicketConfirmation";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
    
    public List<SubmitTicket> getOpenTickets() throws ClassNotFoundException
    {
        List<SubmitTicket> FullTicketsList = new ArrayList<SubmitTicket>();
        List<SubmitTicket> OpenTicketsList = new ArrayList<SubmitTicket>();
        FullTicketsList = getAllTickets();
        for (SubmitTicket ticket_temp : FullTicketsList) {
            SubmitTicket open_ticket = new SubmitTicket();
            if(ticket_temp.getTicketStatus().equals("OPEN")) {
                open_ticket.setAppId(ticket_temp.getAppId());
                open_ticket.setAppName(ticket_temp.getAppName());
                open_ticket.setTicketStatus(ticket_temp.getTicketStatus());
                open_ticket.setPriority(ticket_temp.getPriority());
                open_ticket.setAssignee(ticket_temp.getAssignee());
                open_ticket.setSummary(ticket_temp.getSummary());
                open_ticket.setDetailedDescription(ticket_temp.getDetailedDescription());
                OpenTicketsList.add(open_ticket);
            }
        }
             
        return OpenTicketsList; 		
    }
    
    public List<SubmitTicket> getAllTickets() throws ClassNotFoundException
    {
        ResultSet ticket_rs = null;
        Connection con = getConnection();
        List<SubmitTicket> TicketsList = new ArrayList<SubmitTicket>();
            try {
                PreparedStatement pst = con.prepareStatement(SQL_SELECT);
                ticket_rs = pst.executeQuery();
                while(ticket_rs.next()){
                    SubmitTicket open_ticket = new SubmitTicket();
                    //Retrieve by column name
                    String idapplication = ticket_rs.getString("idApplication");
                    System.out.println(idapplication);
                    String appname = ticket_rs.getString("Name");
                    System.out.println(appname);
                    String status = ticket_rs.getString("Status");
                    System.out.println(status);
                    String priority = ticket_rs.getString("Priority");
                    System.out.println(priority);
                    String assignee = ticket_rs.getString("Assignee");
                    System.out.println(assignee);
                    String summary = ticket_rs.getString("Summary");
                    System.out.println(summary);
                    String description = ticket_rs.getString("Detailed Description");
                    System.out.println(description);
                    open_ticket.setAppId(idapplication);
                    open_ticket.setAppName(appname);
                    open_ticket.setTicketStatus(status);
                    open_ticket.setAssignee(assignee);
                    open_ticket.setPriority(priority);
                    open_ticket.setSummary(summary);
                    open_ticket.setDetailedDescription(description);
                    TicketsList.add(open_ticket);
                }
 			  
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
                e1.printStackTrace();
            }
                
                return TicketsList; 		
    }
         
    public String editTicket() throws ClassNotFoundException
    {
        Connection con = getConnection();
        List<SubmitTicket> TicketsList = new ArrayList<SubmitTicket>();
        
        
            try {
                PreparedStatement pst = con.prepareStatement(SQL_UPDATE_TICKET_STATUS);
                pst.setObject(1, this.getTicketStatus());
                //pst.setObject(2, this.getId());
                pst.executeUpdate();
                
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
                e1.printStackTrace();
                }
                
            return "openTickets";
    }
      
    
    /**
     * Note: Make sure to update the url and credentials to your own
     * 
     * @return new database connection
     * @throws java.lang.ClassNotFoundException
     */
    public Connection getConnection() throws ClassNotFoundException {
      Connection con = null;
      String url = "jdbc:mysql://127.0.0.1:3306/database";
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
