
/**
 * Ticket POJO
 */
public class Ticket extends ImmutableTicket
{
    public Ticket (){}
    public Ticket(int id,int appId, String status, String priority, String assignee, 
            String summary, String detailedDescription)
    {
      super(id,appId,status,priority,assignee,summary,detailedDescription);    
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }
}
