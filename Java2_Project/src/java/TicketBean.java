

import java.util.Arrays;
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
    private Ticket[] tickets;
    
    public ImmutableTicket[] getTickets()
    {
        return tickets;
    }
    
    public ImmutableTicket getTicket(final int id)
    {
        // get ticket with matching id
        return Arrays.stream(tickets).filter(t->t.getTicketID() == id).findFirst().get();
    }
    /**
     * Creates a new instance of TicketBean
     */
    public TicketBean() 
    {
        tickets=dl.getTickets();
    }
}
