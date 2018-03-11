
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kerry
 */
@ManagedBean(name="appTktBean")
@RequestScoped
public class AppTicketBean extends ApplicationBean 
{
    private ITicketDataLayer dl=new TicketDataLayer();
    public void setAppById(final int id)
    {
        Application app=dl.getAppById(id);
        setAppName(app.getAppName());
        setAppDetails(app.getAppDetails());
        setAppStatus(app.getAppStatus());
    }
}
