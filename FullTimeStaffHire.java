public class FullTimeStaffHire extends StaffHire {
    //Instance varialbles specific to FulLTime Staff
    private double MonthlySalary;
    private int weeklyWorkingHours;
    
    //Constructor to initialize the FullTimeStaffHire  
    public FullTimeStaffHire(int jobID, String jobTitle, String contractType, 
    String employeeName, String dateOfJoining, String academicQualification,
    String recruiter, boolean hasJoined, double MonthlySalary, int WeeklyWorkingHours) {
        super(jobID, jobTitle, contractType, academicQualification, 
        recruiter, hasJoined);
        this.MonthlySalary = MonthlySalary;
        this.weeklyWorkingHours = weeklyWorkingHours;
    }
        //Accessor methods
        public double getMonthlySalary() {
            return MonthlySalary;
        }
        
        public int getWeeklyWorkingHours() {
            return weeklyWorkingHours;
        }
        //Updates the salary for the staff if they are appointed
        public void setMonthlySalary(double newMonthlySalary) {
            if(super.gethasJoined()) {
                this.MonthlySalary = MonthlySalary;
            } else {
                System.out.println("No Staff appointed to set the salary.");
            }
        }
        //Mutator method to set weekly Working Hours
        public void setWeeklyWorkingHours(int newweeklyWorkingHours) {
            this.weeklyWorkingHours = newweeklyWorkingHours;
            System.out.println("Weekly working Hours has been changed to:" + newweeklyWorkingHours);
        }
        //Display Method
        public void display() {
            //Display common attributes
            if(super.gethasJoined()) {
                System.out.println("MonthlySalary:" + MonthlySalary);
                System.out.println("Weekly Working Hours:" + weeklyWorkingHours);
            } else {
                System.out.println("No Full-Time staff details is available.");
            }
        }
    }
