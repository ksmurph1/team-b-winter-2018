

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
    private Ticket ticket=new Ticket();
    private int appId;
    
    public ImmutableTicket[] getTickets()
    {
        return tickets;
    }
    
    public ImmutableTicket getTicket(final int id)
    {
        // get ticket with matching id
        ticket=Arrays.stream(tickets).filter(t->t.getTicketID() == id).findFirst().get();
        return ticket;
    }
    /**
     * Creates a new instance of TicketBean
     */
    public TicketBean() 
    {
        tickets=dl.getTickets();
    }
    public int getAppID()
    {
        return appId;
    }
    
    public String getStatus() 
    {
        return ticket.getTicketStatus();
    }
    

    public String getPriority() 
    {
        return ticket.getPriority();
    }
    
    public String getAssignee() 
    {
        return ticket.getAssignee();
    }
    
    public String getSummary() 
    {
        return ticket.getSummary();
    }
    
    public String getDetailedDescription() 
    {
        return ticket.getDetailedDescription();
    }
    public void setStatus(String status) 
    {
        ticket.setStatus(status);
    }

    
    public void setPriority(String priority) 
    {
        ticket.setPriority(priority);
    }
    
    public void setAssignee(String assignee) 
    {
        ticket.setAssignee(assignee);
    }

    
    public void setSummary(String summary) 
    {
        ticket.setSummary(summary);
    }

    public void setDetailedDescription(String detailedDescription) 
    {
        ticket.setDetailedDescription(detailedDescription);
    }
    
    public void setAppID(int id)
    {
       this.appId=id;    
    }
    
    public void saveTicket()
    {
    //    dl.updateTicket(ticket);
    }
}
