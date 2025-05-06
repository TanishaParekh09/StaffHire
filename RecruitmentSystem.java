import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem{
    private JFrame frame;
    private ArrayList<StaffHire> staffList;
    
    //GUI components
    private JTextField txtjobID, txtjobTitle, txtemployeeName, txtdateOfJoining,txtqualification,
          txtrecruiter, txtMonthlySalary, txtweeklyWorkingHours, txthourlyWages, txtshift;
    
    private JTextField txtTerminateNumber;
    private JTextField txtDisplayNumber;
    
    public RecruitmentSystem() {
        staffList = new ArrayList<>();
        frame = new JFrame("Recruitment System");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,500);
        
        //Labels and Text Fields
        addLabel("Job ID:", 50,50);
        txtjobID = addTextField(190,50);
        
        addLabel("Job Title:", 50,80);
        txtjobTitle = addTextField(190,80);
        
        
        addLabel("Employee Name:" , 50,110);
        txtemployeeName = addTextField(190,110);
        
        addLabel("Qualification:" , 50,140);
        txtqualification = addTextField(190,140);
        
        addLabel("Date Of Joining:", 50,170);
        txtdateOfJoining = addTextField(190,170);
        
        addLabel("Recruiter:", 50,200);
        txtrecruiter = addTextField(190,200);
        
        addLabel("Monthly Salary:", 400,50);
        txtMonthlySalary = addTextField(550,50);
        
        addLabel("Weekly Working Hours:", 400,80);
        txtweeklyWorkingHours = addTextField(550,80);
        
        addLabel("Hourly Wages:", 400,110);
        txthourlyWages = addTextField(550,110);
        
        addLabel("Shift:", 400,140);
        txtshift = addTextField(550,140);
        
        addLabel("Terminate Job ID:", 400,170);
        txtTerminateNumber = addTextField(550,170);
        
        addLabel("Display Job ID:", 400,200);
        txtDisplayNumber = addTextField(550,200);
        
        //Buttons
        addButton("Add Full Time Staff", 50, 300, e -> addFullTimeStaff());
        addButton("Add Part Time Staff", 250, 300, e -> addPartTimeStaff());
        addButton("Terminate Part Time Staff", 450, 300, e -> terminatePartTimeStaff());
        addButton("Display All Staff", 650, 300, e -> displayAllStaff());
        addButton("Set Monthly Salary", 50, 400, e -> setFullTimeSalary());
        addButton("Set shift", 250, 400, e -> setPartTimeshifts()); 
        addButton("Clear All Fields", 450, 400, e -> clearAllFields());
        frame.setVisible(true);
    }
     
    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x,y, 150, 25);
        frame.add(lbl);
    }
    
    private JTextField addTextField(int x, int y){
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 160, 25);
        frame.add(txt);
        return txt;
    }
    
    private void addButton(String text, int x, int y, ActionListener action) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 170, 40);
        btn.addActionListener(action);
        frame.add(btn);
    }
    
    private void addFullTimeStaff() {
        try{
            int jobID = Integer.parseInt(txtjobID.getText());
            String jobTitle = txtjobTitle.getText();
            String contractType = "Full-Time";
            String employeeName = txtemployeeName.getText();
            String academicQualification = txtqualification.getText();
            int hourlyWages = Integer.parseInt(txthourlyWages.getText());
            String recruiter = txtrecruiter.getText();
            boolean hasJoined = true;
            double MonthlySalary = Double.parseDouble(txtMonthlySalary.getText());
            int dateOfJoining = Integer.parseInt(txtdateOfJoining.getText());
            int weeklyWorkingHours = Integer.parseInt(txtweeklyWorkingHours.getText());
            String shift = txtshift.getText();
            
             FullTimeStaffHire fullTime = new FullTimeStaffHire(jobID, jobTitle, contractType, employeeName, dateOfJoining,
                                          academicQualification, hourlyWages,recruiter, hasJoined, MonthlySalary, 
                                          weeklyWorkingHours, shift);
            staffList.add(fullTime);
            JOptionPane.showMessageDialog(frame, "Full-Time Staff added succesfully.");
            clearAllFields();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(frame, " Full-Time Staff added successfully.");
        }
    }
    
    
    private void addPartTimeStaff() {
        try {
        int jobID = Integer.parseInt(txtjobID.getText());
        String jobTitle = txtjobTitle.getText();
        String contractType = "Part-Time";
        String academicQualification = txtqualification.getText();
        String shift = txtshift.getText();
        String recruiter = txtrecruiter.getText();
        boolean hasJoined = true;
        int weeklyWorkingHours = Integer.parseInt(txtweeklyWorkingHours.getText());
        double hourlyWages = Double.parseDouble(txthourlyWages.getText());
        int dateOfJoining = Integer.parseInt(txtdateOfJoining.getText());
        
        PartTimeStaffHire partTime = new PartTimeStaffHire( jobID, jobTitle, contractType,academicQualification, dateOfJoining, 
                            recruiter,  hasJoined, shift, weeklyWorkingHours, hourlyWages);
        staffList.add(partTime);
        JOptionPane.showMessageDialog(frame, "Part-Time staff is added successfully.");
        } catch(Exception e) {
        JOptionPane.showMessageDialog(frame, " Part-Time staff added successfully.");
        }
    }
    
    private void setPartTimeshifts() {
        try {
            int jobID = Integer.parseInt(txtjobID.getText());
            String newshift = txtshift.getText();
            for (StaffHire s : staffList) {
                if (s instanceof PartTimeStaffHire && s.getjobID() == jobID) {
                    ((PartTimeStaffHire) s).terminateStaff();
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "shifts updated successfully for Part-Time Staff.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid Input");
        }
    }
    
    private void setFullTimeSalary() {
        try {
            int jobID = Integer.parseInt(txtjobID.getText());
            double newSalary = Double.parseDouble(txtMonthlySalary.getText());
            for (StaffHire s : staffList) {
                if (s instanceof FullTimeStaffHire && s.getjobID() == jobID)
                ((FullTimeStaffHire) s).setMonthlySalary(newSalary);
                return;
            } 
            JOptionPane.showMessageDialog(frame, "Salary updated successfully for Full Time staff");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input for salary.");
        }
    }

    
    private void terminatePartTimeStaff()  {
        try {
            int jobID = Integer.parseInt(txtTerminateNumber.getText().trim());
            boolean found = false;
            
            for (StaffHire s : staffList) {
              if (s instanceof PartTimeStaffHire) {
                PartTimeStaffHire partTime = (PartTimeStaffHire) s;
                if (partTime.getjobID() == jobID) {
                    partTime.terminateStaff();
                    JOptionPane.showMessageDialog(frame, "Part-Time Staff with Job ID" + jobID + " terminated.");
                    found = true;
                    break ;
                }
              }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "An unexpected error occurred: " + e.getMessage());
        }
    }
    
    private void displayAllStaff() {
        StringBuilder displayText = new StringBuilder();
        
        for (StaffHire s : staffList) {
            
            if (s instanceof FullTimeStaffHire) {
                FullTimeStaffHire fullTime = (FullTimeStaffHire) s;
                displayText.append("Staff Type: Full-Time\n");
                displayText.append("Monthly Salary: ").append(fullTime.getMonthlySalary()).append("\n");
                displayText.append("Weekly Working Hours: ").append(fullTime.getWeeklyWorkingHours()).append("\n");
                displayText.append("Job ID: ").append(fullTime.getjobID()).append("\n");
                displayText.append("Job Title: ").append(fullTime.getjobTitle()).append("\n");
                displayText.append("EmployeeName: ").append(fullTime.getemployeeName()).append("\n");
                displayText.append("Qualification: ").append(fullTime.getacademicQualification()).append("\n");
                displayText.append("Date Of Joining: ").append(fullTime.getdateOfJoining()).append("\n");
                displayText.append("Recruiter: ").append(fullTime.getrecruiter()).append("\n");
                displayText.append("shift: ").append(fullTime.getshift()).append("\n");
                displayText.append("Hourly Wages: ").append(fullTime.gethourlyWages()).append("\n");
            } 
            else if (s instanceof PartTimeStaffHire) {
                PartTimeStaffHire partTime = (PartTimeStaffHire) s;
                displayText.append("Staff Type: Part-Time\n");
                displayText.append("Weekly Working Hours: ").append(partTime.getWeeklyWorkingHours()).append("\n");
                displayText.append("Hourly Wages: ").append(partTime.gethourlyWages()).append("\n");
                displayText.append("Is Terminated: ").append(partTime.isTerminated()).append("\n");
                displayText.append("Job ID: ").append(partTime.getjobID()).append("\n");
                displayText.append("Job Title: ").append(partTime.getjobTitle()).append("\n");
                displayText.append("EmployeeName: ").append(partTime.getemployeeName()).append("\n");
                displayText.append("Qualification: ").append(partTime.getacademicQualification()).append("\n");
                displayText.append("Recruiter: ").append(partTime.getrecruiter()).append("\n");
                displayText.append("shift: ").append(partTime.getshift()).append("\n");
            }
            
            displayText.append("----------\n\n");
        }
        
        // Display in a JTextArea within a JScrollPane
        JTextArea textArea = new JTextArea(displayText.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        
        JOptionPane.showMessageDialog(frame, scrollPane, "Staff Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    private void clearAllFields() {
        txtjobID.setText("");
        txtjobTitle.setText("");
        txtqualification.setText("");
        txtemployeeName.setText("");
        txtdateOfJoining.setText("");
        txtrecruiter.setText("");
        txtMonthlySalary.setText("");
        txtweeklyWorkingHours.setText("");
        txthourlyWages.setText("");
        txtshift.setText("");
        txtTerminateNumber.setText("");
        txtDisplayNumber.setText("");
    }
    
    public static void main(String[] args) {
         new RecruitmentSystem();
    }

}
 
