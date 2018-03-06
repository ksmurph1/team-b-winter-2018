package java;
import java.io.Serializable;
import javax.faces.event.NamedEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named("navigationController")
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
}
