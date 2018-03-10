

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Bean for Ticket
 */
@Named(value = "ticketBean")
@RequestScoped
public class TicketBean 
{
    private ITicketDataLayer dl=new TicketDataLayer();
    
    public ImmutableTicket[] getTickets()
    {
        return dl.getTickets();
    }
    /**
     * Creates a new instance of TicketBean
     */
    public TicketBean() 
    {
        
    }
}
