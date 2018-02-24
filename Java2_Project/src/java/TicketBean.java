import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 * Bean for Ticket
 */
@Named(value = "ticketBean")
@Dependent
public class TicketBean {

    /**
     * Creates a new instance of TicketBean
     */
    public TicketBean() {
    }
    
}
