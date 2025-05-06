public class StaffHire {
    //Instance Variables
   public int jobID;
   public String jobTitle;
   public String contractType;
   public String employeeName;
   public String dateOfJoining;
   public String academicQualification;
   public String recruiter;
   public boolean hasJoined;
    
    // Constructor to initialize the values
    public StaffHire(int jobID, String jobTitle, String contractType, 
    String academicQualification,  String recruiter, boolean hasJoined) {
         this.jobID = jobID;
         this.jobTitle = jobTitle;
         this.contractType = contractType;
         this.employeeName = employeeName;
         this.dateOfJoining = dateOfJoining;
         this.academicQualification = academicQualification;
         this.recruiter = recruiter;
         this.hasJoined = hasJoined;
         }
    //getter and setter methods
    public int getjobID()
    {
        return jobID;
    }
    
    public String getJobTitle() 
    {
        return jobTitle;
    }
    
    public String getContractType()
    {
        return contractType;
    }
    
    public  String getEmployeeName()
    {
        return employeeName;
    }
    
    public String getDateOfJoining()
    {
        return dateOfJoining;
    }
    
    public String getAcademicQualification()
    {
        return academicQualification;
    }
    
    public String getRecruiter()
    {
        return recruiter;
    }
    
    public boolean getHasJoined()
    {
        return hasJoined;
    }
    
    //display methods
    public void showDetails() {
         System.out.println("Job ID:" + jobID);
         System.out.println("Job Title:" +jobTitle);
         System.out.println("Contract Type:" +contractType);
         System.out.println("Employee Name:" + employeeName);
         System.out.println("Joining Date:" + dateOfJoining);
         System.out.println("Education:" +academicQualification);
         System.out.println("Recruiter:" +recruiter);
         System.out.println("hasJoined:" +hasJoined);
         }
}