

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Bean for Ticket
 */
@ManagedBean(name="ticketBean")
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
