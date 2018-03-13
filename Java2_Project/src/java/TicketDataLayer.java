/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author kerry
 */
final class TicketDataLayer implements ITicketDataLayer 
{
    private final static String PROPSNAME="/database.properties";
    private static Connection connection;
    private static Properties props;
    static
    {
       props = new Properties();
      
       try
       {
           InputStream in=TicketDataLayer.class.getResourceAsStream(PROPSNAME);
       props.load(in);  
       String driver = props.getProperty("jdbc.driver");
       if (driver != null) 
       {
          Class.forName(driver);

          connection = DriverManager.getConnection(props.getProperty("jdbc.url"),
              props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
          
       }
       }
       catch (Exception ex)
       {
           System.out.println(ex.getStackTrace());
       }
    }

    @Override
    public Ticket[] getTickets()
    {
       ArrayList<Ticket> result=new ArrayList<Ticket>();
       if (connection != null)
       {
            try (PreparedStatement statement=
                    connection.prepareStatement(props.getProperty("jdbc.getticketsSQL")))
            {
                ResultSet rset=statement.executeQuery();
                while (rset.next())
                {
                    result.add(new Ticket(rset.getObject("id", Integer.TYPE),rset.getObject("idApplication", Integer.TYPE),
                           rset.getObject("Status",String.class),rset.getObject("Priority", String.class),
                           rset.getObject("Assignee",String.class), rset.getObject("Summary",String.class),
                           rset.getObject("Detailed Description",String.class)));
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex.getStackTrace());
            }
       }
       return result.toArray(new Ticket[result.size()]);
    }

    @Override
    public void updateTicket(final ImmutableTicket ticket) 
    {
       if (connection != null && ticket != null)
       {
            try (PreparedStatement statement=
                    connection.prepareStatement(props.getProperty("jdbc.updateticketSQL")))
            {
                statement.setInt(1, ticket.getAppID());
                statement.setString(2, ticket.getTicketStatus());
                statement.setString(3, ticket.getPriority());
                statement.setString(4, ticket.getAssignee());
                statement.setString(5, ticket.getSummary());
                statement.setString(6, ticket.getDetailedDescription());
                statement.setInt(7,ticket.getTicketID());
                statement.execute();               
            }
            catch (Exception ex)
            {
                System.out.println(ex.getStackTrace());
            }
       }
    }

    @Override
    public Application getAppById(int id) 
    {
       Application app=null;
       if (connection != null)
       {
            try (PreparedStatement statement=
                    connection.prepareStatement(props.getProperty("jdbc.getappbyidSQL")))
            {
                statement.setInt(1, id);
                ResultSet rset=statement.executeQuery();
                rset.first();
                app=new Application(rset.getObject("Name", String.class),rset.getObject("Details", String.class),
                           rset.getObject("Status",String.class));
                
            }
            catch (Exception ex)
            {
                System.out.println(ex.getStackTrace());
            }
       }
       return app; 
    }

    @Override
    public Application[] loadApps()
    {
       ArrayList<Application> result=new ArrayList<Application>();
       if (connection != null)
       {
            try (PreparedStatement statement=
                    connection.prepareStatement(props.getProperty("jdbc.getappsSQL")))
            {
                ResultSet rset=statement.executeQuery();
                while (rset.next())
                {
                    result.add(new Application(rset.getObject("id", Integer.TYPE),rset.getObject("Name", String.class),
                           rset.getObject("Details",String.class),rset.getObject("Status", String.class)));
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex.getStackTrace());
            }
       }
       return result.toArray(new Application[result.size()]); 
    }
    
}
