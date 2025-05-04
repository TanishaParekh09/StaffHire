import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystemGUI extends JFrame{
    private ArrayList<StaffHire> staffList;
    
    //GUI components
    private JTextField txtjobID, txtjobTitle, txtemployeeName, txtdateOfJoining, 
            txtrecruiter, txtMonthlySalary, txtweeklyWorkingHours, txthourlyWages, txtshifts;
    
    private JTextField txtTerminateNumber;
    private JTextField txtDisplayNumber;
    
    public RecruitmentSystemGUI() {
        staffList = new ArrayList<>();
        setTitle("Recruitment System");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,500);
        
        //Labels and Text Fields
        addLabel("Job ID:", 50,50);
        txtjobID = addTextField(130,50);
        
        addLabel("Job Title:", 50,130);
        txtjobTitle = addTextField(170,130);
        
        addLabel("Employee Name:" , 50,130);
        txtemployeeName = addTextField(170,130);
        
        addLabel("Date Of Joining:", 50,170);
        txtdateOfJoining = addTextField(170,170);
        
        addLabel("Recruiter:", 50,210);
        txtrecruiter = addTextField(130,210);
        
        addLabel("Monthly Salary:", 400,50);
        txtMonthlySalary = addTextField(530,50);
        
        addLabel("Weekly Working Hours:", 400,90);
        txtweeklyWorkingHours = addTextField(530,90);
        
        addLabel("Hourly Wages:", 400,130);
        txthourlyWages = addTextField(530,130);
        
        addLabel("Shifts:", 400,170);
        txtshifts = addTextField(530,170);
        
        addLabel("Terminate Job ID:", 400,210);
        txtTerminateNumber = addTextField(530,210);
        
        addLabel("Display Job ID:", 400,250);
        txtDisplayNumber = addTextField(530,250);
        
        //Buttons
        addButton("Add Full Time Staff", 50, 300, e -> addFullTimeStaff());
        addButton("Add Part Time Staff", 250, 300, e -> addPartTimeStaff());
        addButton("Terminate Part Time Staff", 450, 300, e -> terminatePartTimeStaff());
        addButton("Display All Staff", 650, 300, e -> displayAllStaff());
        
        setVisible(true);
    }
     
    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x,y, 150, 25);
        add(lbl);
    }
    
    private JTextField addTextField(int x, int y){
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 160, 25);
        add(txt);
        return txt;
    }
    
    private void addButton(String text, int x, int y, ActionListener action) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 170, 40);
        btn.addActionListener(action);
        add(btn);
    }
    
    private void addFullTimeStaff() {
        try{
            int jobID = Integer.parseInt(txtjobID.getText());
            String jobTitle = txtjobTitle.getText();
            String contractType = "Full-Time";
            String qualification = "Bachelor";
            String recruiter = txtrecruiter.getText();
            double salary = Double.parseDouble(txtMonthlySalary.getText());
            int workingHours = Integer.parseInt(txtweeklyWorkingHours.getText());
            
            FullTimeStaffHire fullTime = new FullTimeStaffHire(jobID, jobTitle, contractType,txtemployeeName.getText(), 
                                         txtdateOfJoining.getText(), qualification, recruiter, false, salary, workingHours);
            staffList.add(fullTime);
            showMessage("Full-Time Staff added succesfully.");
            clearFields();
        }
        catch(Exception e) {
            showError("Error: Please fill in valid input for Full-Time Staff.");
        }
    }
    
    private void addPartTimeStaff() {
        try {
        int jobID = Integer.parseInt(txtjobID.getText());
        String jobTitle = txtjobTitle.getText();
        String contractType = "Part-Time";
        String qualification = "Intermediate";
        String recruiter = txtrecruiter.getText();
        int workingHours = Integer.parseInt(txtweeklyWorkingHours.getText());
        double hourlyWage = Double.parseDouble(txthourlyWages.getText());
        String shift = txtshifts.getText();
        showMessage("Part-Time Staff added.");
        clearFields();

        } catch(Exception e) {
        showError("Check inputs for Part-Time staff.");
        }
    }

    
    private void terminatePartTimeStaff()  {
        try {
            int jobID = Integer.parseInt(txtTerminateNumber.getText().trim());
            boolean found = false;
            
            for (StaffHire s : staffList) {
              if (s instanceof PartTimeStaffHire) {
                PartTimeStaffHire partTime = (PartTimeStaffHire) s;
                if (partTime.getnewjobID() == jobID) {
                    partTime.terminateStaff();
                    showMessage("Part-Time Staff with Job ID" + jobID + " terminated.");
                    found = true;
                    break ;
                }
              }
            }
        } catch (Exception e) {
            showError("An unexpected error occurred: " + e.getMessage());
        }
    }
    
    private void displayAllStaff() {
        for (StaffHire s : staffList) {
            System.out.println("---- Staff Details ----");
            System.out.println("----------\n");
        }
    }
    
    private void clearFields() {
        txtjobID.setText("");
        txtjobTitle.setText("");
        txtemployeeName.setText("");
        txtdateOfJoining.setText("");
        txtrecruiter.setText("");
        txtMonthlySalary.setText("");
        txtweeklyWorkingHours.setText("");
        txthourlyWages.setText("");
        txtshifts.setText("");
        txtTerminateNumber.setText("");
        txtDisplayNumber.setText("");
    }
    
    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    
    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", 
        JOptionPane.ERROR_MESSAGE);
    }
    
    public static void main(String[] args) {
         new RecruitmentSystemGUI();
    }

}
 
