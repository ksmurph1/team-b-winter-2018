package java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 * Bean for Application
 */
@Named("applicationBean")
@RequestScoped
public class ApplicationBean{
    private static final String SQL_INSERT = "INSERT INTO `my_database`.`Application` "
    		+ "(`idApplication`, "
    		+ "`Application Name`, `Application Details`,"
    		+ " `Application Status`) VALUES (?, ?, ?, ?);";
    private static final String SQL_SELECT = "SELECT * FROM `my_database`.`Application` "
    		+ "WHERE name = ?";
    private static final String SQL_UPDATE = "UPDATE  `my_database`.`Application` "
    		+ "SET "
    		+ "Details = ?"
    		+ " , Status = ?" 
    		+ " WHERE Name = ?";
    
    private String appName;
    private String appDetails;
    private String appStatus = "Open";
    
    /**
     * Creates a new instance of ApplicationBean
     */
    public ApplicationBean() {
    }

    public String getAppName() {
        return appName;
    }

    public String getAppDetails() {
        return appDetails;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setAppDetails(String appDetails) {
        this.appDetails = appDetails;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }
    
    /**
     * 
     * @throws ClassNotFoundException 
     */
    public String addApplication() throws ClassNotFoundException
    {
        Application newApp = new Application();
        newApp.setAppName(this.appName);
        newApp.setAppDetails(this.appDetails);
        newApp.setAppStatus(this.appStatus);
        int id = (int) (Math.random() * 256);
        
        Connection con = getConnection();
      
        try {   
            PreparedStatement pst = con.prepareStatement(SQL_INSERT);
            
            pst.setObject(1, id);
            pst.setObject(2, newApp.getAppName());
            pst.setObject(3, newApp.getAppDetails());
            pst.setObject(4, newApp.getAppStatus());
        
            pst.execute();
            con.close();
            return "addApplicationConfirmation";
            
        } catch (SQLException e) {
            return null;
        }
    }
    public Application getApplication() throws ClassNotFoundException
    {
    	 Application infoApp = new Application();
    	 infoApp.setAppName(this.appName);
         Connection con = getConnection();
         ResultSet rs;
 		try {
 			PreparedStatement pst = con.prepareStatement(SQL_SELECT);
 			pst.setObject(1, infoApp.getAppName());
 			 rs = pst.executeQuery();
 			  while(rs.next()){
 		            //Retrieve by column name
 				 infoApp.setAppDetails(rs.getString("appDetails"));
 				infoApp.setAppStatus(rs.getString("appStatus"));
 		        }
 			  
 		} catch (SQLException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
 		return infoApp;
    }
    public String editApplication() throws ClassNotFoundException
    {
        Application newApp = new Application();
        newApp.setAppName(this.appName);
       
        Connection con = getConnection();
        try {   
            PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
            pst.setObject(1, newApp.getAppDetails());
            pst.setObject(2, newApp.getAppStatus());
            pst.setObject(3, newApp.getAppName());
        
            pst.execute();
            con.close();
            return "addApplicationConfirmation";
            
        } catch (SQLException e) {
            return null;
        }
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
