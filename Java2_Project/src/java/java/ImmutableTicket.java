package java;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kerry
 */
class ImmutableTicket 
{
    protected int    id;
    protected int appId;
    protected String status;
    protected String priority;
    protected String assignee;
    protected String summary;
    protected String detailedDescription;
    
    ImmutableTicket(int id,int appId, String status, String priority, String assignee, 
            String summary, String detailedDescription)
    {
        this.appId = appId;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
        this.summary = summary;
        this.detailedDescription = detailedDescription;
        this.id=id;
    }
    ImmutableTicket()
    {}
    public int getTicketID()
    {
        return id;
    }
    
    public String getTicketStatus() 
    {
        return status;
    }
    

    public String getPriority() 
    {
        return priority;
    }
    
    public String getAssignee() 
    {
        return assignee;
    }
    
    public String getSummary() 
    {
        return summary;
    }
    
    public String getDetailedDescription() 
    {
        return detailedDescription;
    }
}
