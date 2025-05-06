public class FullTimeStaffHire extends StaffHire {
    //Instance varialbles specific to FulLTime Staff
    private double MonthlySalary;
    private int WeeklyWorkingHours;
    private int hourlyWages;
    private int dateOfJoining;
    private String shift;
    
    //Constructor to initialize the FullTimeStaffHire  
    public FullTimeStaffHire(int jobID, String jobTitle, String contractType, 
    String employeeName, int dateOfJoining, String academicQualification, int hourlyWages,
    String recruiter, boolean hasJoined, double MonthlySalary, int WeeklyWorkingHours, String shift) {
        super(jobID, jobTitle, contractType, academicQualification, 
        recruiter, hasJoined);
        this.MonthlySalary = MonthlySalary;
        this.WeeklyWorkingHours = WeeklyWorkingHours;
        
    }
        //Accessor methods
        public double getMonthlySalary() {
            return MonthlySalary;
        }
        
        public int getWeeklyWorkingHours() {
            return WeeklyWorkingHours;
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
        
        public int gethourlyWages() {
            return hourlyWages;
        }
        
        public int getdateOfJoining() {
            return dateOfJoining;
        }
        
        public String getshift() {
            return shift;
        }
    
        
        //Updates the salary for the staff if they are appointed
        public void setMonthlySalary(double MonthlySalary) {
            if(super.getHasJoined()) {
                this.MonthlySalary = MonthlySalary;
            } else {
                System.out.println("salary updated.");
            }
        }
        //Mutator method to set weekly Working Hours
        public void setWeeklyWorkingHours(int newweeklyWorkingHours) {
            this.WeeklyWorkingHours = newweeklyWorkingHours;
            System.out.println("Weekly working Hours has been changed to:" + WeeklyWorkingHours);
        }
        //Display Method
        public void display() {
            //Display common attributes
            if(super.getHasJoined()) {
                System.out.println("MonthlySalary:" + MonthlySalary);
                System.out.println("Weekly Working Hours:" + WeeklyWorkingHours);
            } else {
                System.out.println("Full-Time staff updated.");
            }
        }
    }
