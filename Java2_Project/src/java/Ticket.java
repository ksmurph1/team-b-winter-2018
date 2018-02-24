/**
 * Ticket POJO
 */
public class Ticket {
    private String appName;
    private String ticketStatus;
    private String priority;
    private String assignee;
    private String summary;
    private String detailedDescription;
    
    public Ticket()
    {
    }
    
    public Ticket(String appName, String ticketStatus, String priority, String assignee, 
            String summary, String detailedDescription)
    {
        this.appName = appName;
        this.ticketStatus = ticketStatus;
        this.priority = priority;
        this.assignee = assignee;
        this.summary = summary;
        this.detailedDescription = detailedDescription;
    }

    public String getAppName() {
        return appName;
    }
    
    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }
    
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getPriority() {
        return priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }
    
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getSummary() {
        return summary;
    }
    
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }
}
