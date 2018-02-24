import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 * Bean for Application
 */
@Named(value = "applicationBean")
@Dependent
public class ApplicationBean {

    /**
     * Creates a new instance of ApplicationBean
     */
    public ApplicationBean() {
    }
    
}
