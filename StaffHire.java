public class StaffHire {
    //Instance Variables
    private int newjobID;
    private String jobTitle;
    private String contractType;
    private String employeeName;
    private String dateOfJoining;
    private String academicQualification;
    private String recruiter;
    private boolean hasJoined;
    
    // Constructor to initialize the values
    public StaffHire(int newjobID, String jobTitle, String contractType, 
    String academicQualification,  String recruiter, boolean hasJoined) {
         this.newjobID = newjobID;
         this.jobTitle = jobTitle;
         this.contractType = contractType;
         this.employeeName = employeeName;
         this.dateOfJoining = dateOfJoining;
         this.academicQualification = academicQualification;
         this.recruiter = recruiter;
         this.hasJoined = hasJoined;
         }
    //getter and setter methods
    public int getnewjobID()
    {
        return newjobID;
    }
    
    public String getjobTitle() 
    {
        return jobTitle;
    }
    
    public String getcontractType()
    {
        return contractType;
    }
    
    public  String getemployeeName()
    {
        return employeeName;
    }
    
    public String getdateOfJoining()
    {
        return dateOfJoining;
    }
    
    public String getacademicQualification()
    {
        return academicQualification;
    }
    
    public String getrecruiter()
    {
        return recruiter;
    }
    
    public boolean gethasJoined()
    {
        return hasJoined;
    }
    
    //display methods
    public void showDetails() {
         System.out.println("New Job ID:" +newjobID);
         System.out.println("Job Title:" +jobTitle);
         System.out.println("Contract Type:" +contractType);
         System.out.println("Employee Name:" + employeeName);
         System.out.println("Joining Date:" + dateOfJoining);
         System.out.println("Education:" +academicQualification);
         System.out.println("Recruiter:" +recruiter);
         System.out.println("Status:" +(hasJoined?"Joined":"Not Joined"));
         }
                       
    //Method to update the joining status of the employee
    public void changeJoinStatus(boolean newStatus) {
         this.hasJoined =newStatus;
         }
}