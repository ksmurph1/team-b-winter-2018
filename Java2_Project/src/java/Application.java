
public class Application {
    private int id;
    private String appName;
    private String appDetails;
    private String appStatus;
    
    public Application()
    {
    }
    
    public Application(String name, String details, String status)
    {
        this.appName = name;
        this.appDetails = details;
        this.appStatus = status;
    }
    
    Application(int id, String name, String details, String status)
    {
        this(name,details,status);
        this.id=id;
    }
    
    public String getAppName() {
        return appName;
    }
    
    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDetails() {
        return appDetails;
    }
    
    public void setAppDetails(String appDetails) {
        this.appDetails = appDetails;
    }

    public String getAppStatus() {
        return appStatus;
    }
    
    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }
    
    int getId()
    {
        return this.id;
    }
}
