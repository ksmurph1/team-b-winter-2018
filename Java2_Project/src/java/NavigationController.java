

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="navigationController")
@RequestScoped
public class NavigationController implements Serializable {
   public String moveToHomePage() {
      return "index";
   }
   
   public String moveToAddApplicationPage() {
      return "addApplication";
   }
   
   public String moveToAddApplicationConfirmationPage() {
       return "addApplicationConfirmation";
   }
   
   public String moveToEditApplicationPage() {
       return "editApplication";
   }
   
   public String moveToSubmitTicketPage() {
       return "submitTicket";
   }
   
   public String moveToOpenTicketsPage() {
       return "openTickets";
   }
   
   public String moveToDisplayTicketsPage() {
       return "displayAllTickets";
   }
   
}
