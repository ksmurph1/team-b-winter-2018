
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
public class AppTicketBean extends ApplicationBean 
{
    private ITicketDataLayer dl=new TicketDataLayer();
    private Integer selectedItem; // +getter +setter
    private Map<Integer, String> availableItems;//id -> name, value, label pair
    
    private int id;
    
    public void setAppById(final int id)
    {
        this.id=id;
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
        this.selectedItem=apps[0].getId();
        
    }
    public Map<Integer, String> getAvailableItems()
    {
        return availableItems;
    }

    public int getSelectedItem()
    {
        if (this.id !=0)
        {
            selectedItem=this.id;
        }
        return selectedItem;
    }
    
    public void setSelectedItem(final int item)
    {
       selectedItem=item; 
    }

}
