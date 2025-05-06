public class PartTimeStaffHire extends StaffHire {
    //Attributes
    private int WeeklyWorkingHours;
    private double hourlyWages;
    private String shift;
    private boolean isTerminated;
    private String academicQualification;
   
    //Constructor
    public PartTimeStaffHire(int jobID, String jobTitle, String contractType,String academicQualification,int dateOfJoining, 
                           String recruiter, boolean hasJoined, String shift, int WeeklyWorkingHour, double hourlyWages) {
        super(jobID, jobTitle, contractType, academicQualification, recruiter, hasJoined);
        
        this.WeeklyWorkingHours = WeeklyWorkingHours;
        this.hourlyWages = hourlyWages;
        this.shift = shift;
        this.isTerminated = false;
    }
    
    //Getter and Setters
    public int getWeeklyWorkingHours() {
        return WeeklyWorkingHours;
    }
    
    public void setWeeklyWorkingHours(int NewWeeklyWorkingHours) {
        this.WeeklyWorkingHours = NewWeeklyWorkingHours;
    }
    
    public double gethourlyWages() {
        return hourlyWages;
    }
    
    public void sethourlyWages(int NewhourlyWages) {
        this.hourlyWages = NewhourlyWages;
    }
    
    public String getshift() {
        return shift;
    }
    
    public String getjobTitle() {
        return jobTitle;
    }
    
    public String getemployeeName(){
        return employeeName;
    }
    
    public String getacademicQualification() {
        return academicQualification;
    }
    
    public String getrecruiter() {
        return recruiter;
    }
    
    public void setshift(String Newshift) {
        if(getHasJoined()) {
            this.shift = Newshift;
            System.out.println("shift updated to:" + shift);
        } else {
            System.out.println("cannot change shift. staff has joined");
    }
    } 
    
    public boolean isTerminated() {
      return isTerminated;
    }
     
    public void terminateStaff() {
        if (isTerminated) {
            System.out.println("This employee is already terminated");
        } 
        else{
            isTerminated = true;
            System.out.println("Staff has been terminated");
        }
   }

    //Display method
    public void displayAllStaff() {
        //Call the display method from the superclass
        if (WeeklyWorkingHours>0) {
        System.out.println("Weekly Working Hours:" + WeeklyWorkingHours);
        System.out.println("Wages per Hour:" + hourlyWages);
        System.out.println("Shifts:" + shift);
        System.out.println(" Is Terminated:" + isTerminated);
        System.out.println("Job ID:" + jobID);
        System.out.println("Job Title:" +jobTitle);
        System.out.println("Contract Type:" +contractType);
        System.out.println("Employee Name:" + employeeName);
        System.out.println("Joining Date:" + dateOfJoining);
        System.out.println("Academic Qualification:" +academicQualification);
        System.out.println("Recruiter:" +recruiter);
        System.out.println("hasJoined:" +hasJoined);
       }
   }
}
    