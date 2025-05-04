public class PartTimeStaffHire extends StaffHire {
    //Attributes
    private int workingHour;
    private double hourlyWages;
    private String shift;
    private String staffName;
    private String joiningDate;
    private String appointedBy;
    private boolean isJoined;
    private boolean isTerminated;
    
    //Constructor
    public PartTimeStaffHire(int jobID, String jobTitle, String contractType, String academicQualification, String recruiter,
     boolean hasJoined) {
        super(jobID, jobTitle, contractType, academicQualification, recruiter, hasJoined);
        
        this.workingHour = workingHour;
        this.hourlyWages = hourlyWages;
        this.shift = shift;
        this.staffName = "";
        this.joiningDate = "";
        this.appointedBy = "";
        this.isJoined = false;
        this.isTerminated = false;
    }
    
    //Getter and Setters
    public int getWorkingHour() {
        return workingHour;
    }
    
    public double getHourlyWages() {
        return hourlyWages;
    }
    
    public String getShift() {
        return shift;
    }
    
    public String getStaffName() {
        return staffName;
    }
    
    public String getJoiningDate() {
        return joiningDate;
    }
    
    public String getAppointedBy() {
        return appointedBy;
    }
    
    public boolean isJoined() {
        return isJoined;
    }
    
    public boolean isTerminated() {
        return isTerminated;
    }
    
    //Method to terminate the staff 
    public void terminateStaff() {
        if (isTerminated) {
            System.out.println("This employee is already terminated");
        } 
        else{
            staffName = "";
            joiningDate = "";
            appointedBy = "";
            isJoined = false;
            isTerminated = true;
            System.out.println("Staff has been terminated");
        }
   }

    //Display method
    public void display() {
        //Call the display method from the superclass
        if (workingHour>0) {
        System.out.println("Working Hours per Day:" + workingHour);
        System.out.println("Wages per Hour:" + hourlyWages);
        System.out.println("Shifts:" + shift);
        System.out.println("Staff Name:" + staffName);
        System.out.println("Joining Date:" + joiningDate);
        System.out.println("Appointed By:" + appointedBy);
        System.out.println("Is Joined:" + isJoined);
        System.out.println(" Is Terminated:" + isTerminated);
       }
   }
}
    