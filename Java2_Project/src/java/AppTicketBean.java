
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

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
@ApplicationScoped
public class AppTicketBean extends ApplicationBean 
{
    private ITicketDataLayer dl=new TicketDataLayer();
    private Integer selectedItem=0; // +getter +setter
    private Map<Integer, String> availableItems;//id -> name, value, label pair
    
    
    public void setAppById(final int id)
    {
        
        Application app=dl.getAppById(id);
        setAppName(app.getAppName());
        setAppDetails(app.getAppDetails());
        setAppStatus(app.getAppStatus());
    }
    
    public AppTicketBean()
    {
        // load all the apps
        Application[] apps=dl.loadApps();
        
        // fill availableItems map
        this.availableItems=Arrays.stream(apps).collect(
                java.util.stream.Collectors.toMap(a->a.getId(),a->a.getAppName()));
        // set selected item to first item by default
        if (apps != null && apps.length > 0)
        {
           this.selectedItem=apps[0].getId();
        }
    }
    public Map<Integer, String> getAvailableItems()
    {
        return availableItems;
    }

    public int getSelectedItem()
    {
        /*if (this.id !=0)
        {
            selectedItem=this.id;
        }*/
        return selectedItem;
    }
    
    public void setSelectedItem(final int item)
    {
       selectedItem=item; 
    }
    
}
