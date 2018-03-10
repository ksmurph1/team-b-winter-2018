/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author kerry
 */
final class TicketDataLayer implements ITicketDataLayer 
{
    private final static String PROPSNAME="../../../../src/conf";
    private static Connection connection;
    private static Properties props;
    static
    {
       props = new Properties();
       try(FileInputStream in = new FileInputStream(PROPSNAME))
       {
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
            {}
       }
       return (Ticket[])result.toArray();
    }

    @Override
    public void saveTicket(ImmutableTicket ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
