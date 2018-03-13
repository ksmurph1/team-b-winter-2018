

import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Bean for Ticket
 */
@ManagedBean(name="ticketBean")
@ViewScoped
public class TicketBean 
{
    private ITicketDataLayer dl=new TicketDataLayer();
    //private Ticket[] tickets;
    private Ticket ticket=new Ticket();
    private int appId;
    
    public ImmutableTicket[] getOpenTickets()
    {
        // make sure get from database in case updated
        // only display open tickets
        return (ImmutableTicket[])Arrays.stream(dl.getTickets()).filter(
                t->"NEW".equals(t.getTicketStatus()) || "OPEN".equals(
                        t.getTicketStatus())).toArray(ImmutableTicket[]::new);
    }
    
    public ImmutableTicket getTicket(final int id)
    {
           // get ticket with matching id
           return Arrays.stream(dl.getTickets()).filter(t->t.getTicketID() == id).findFirst().get();
    }
    
    public void setTicket(final int id)
    {
        ImmutableTicket immutableTkt=getTicket(id); 
        ticket=new Ticket(immutableTkt.getTicketID(),immutableTkt.getAppID(),immutableTkt.getTicketStatus(),
                immutableTkt.getPriority(),immutableTkt.getAssignee(),immutableTkt.getSummary(),
                immutableTkt.getDetailedDescription());
    }
    /**
     * Creates a new instance of TicketBean
     */
    public TicketBean() 
    {
      // tickets=dl.getTickets();
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
    public String saveTicket()
    {
        dl.updateTicket(ticket);
        return "/openTickets.xhtml?faces-redirect=true";
    }
}
