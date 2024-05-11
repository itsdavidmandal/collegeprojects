//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------Importing all the necessarry classes and itnerfaces from packages in Java's libraries----------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.net.URI;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.io.IOException;
import java.awt.Color;
//---------------------------------------------------------Declaring a java class named TeacherGUI------------------------------------------------------------------------------------------------------------------------------------------
public class TeacherGUI extends JFrame {
    // -------------- Declaring the private instances so that only the variables are accessible within the teachergui class only 
    //----- Text fields 
    
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Declaring a static ArrayList named `teacherList` in the `TeacherGUI` class, accessible only within the class. 
    //It stores objects of type `Teacher`. 
    //Being static, it's shared among all instances of `TeacherGUI` and initialized as an empty ArrayList.
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static ArrayList<Teacher> teacherList = new ArrayList<>(); 
     // initialising a constructor named as "TeacherGUI"
    public TeacherGUI() {
        //initialising a new arraylist named as teacherlist so that it can store objects 
        teacherList = new ArrayList<>(); 

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Setting up the frame
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 400); 
        setLocationRelativeTo(null);
        
        // Creating a panel to store all the components 
        JPanel contentPane1 = new GradientPanel(new Color(255, 255, 255), new Color(58, 59, 175));
        contentPane1.setLayout(null); 
        
        // Label for the Title in the frame 
        JLabel nameLabel = new JLabel("TEACHER MANAGEMENT SYSTEM");
        nameLabel.setBounds(50, 20, 300, 30);

        // Line separator added 
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(0, 50, contentPane1.getWidth(), 1); 
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // BUTTONS 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Initialising all the buttons 
        JButton tutorButton = new JButton("Tutor");
        JButton lecturerButton = new JButton("Lecturer");
        JButton projectButton = new JButton("Project Details");
        
        // Creating a "Dimension " class named as "buttonSize " so that it can be used to set up the sizes of other components
        Dimension buttonSize = new Dimension(150, 40);
        
        
        // Setting up the size of the buttons 
        tutorButton.setSize(buttonSize);
        lecturerButton.setSize(buttonSize);
        projectButton.setSize(buttonSize);

        // Setting up the locations of the buttons 
        tutorButton.setLocation(50, 180);
        lecturerButton.setLocation(250, 180);
        projectButton.setLocation(450, 180);
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // Dealing with the panels 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Add contentPane1 to the frame
        add(contentPane1); 
        
        // Add various components to the contentPane1 panel 
        contentPane1.add(separator);
        contentPane1.add(nameLabel);
        contentPane1.add(tutorButton);
        contentPane1.add(lecturerButton);
        contentPane1.add(projectButton);
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // FOOTER SECTION 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        
        JLabel footerLabel = new JLabel("© David Ramovich Mandal | 23047335. All rights reserved.");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setBackground(new Color(58, 59, 175)); 
        footerLabel.setOpaque(true);
        footerLabel.setBounds(0, 335, getWidth(), 30); // Adjusted bounds
        contentPane1.add(footerLabel);
        setContentPane(contentPane1);
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // BUTTONS AND THEIR ACTION LISTENERS 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Creating a new instance of the  TutorFrame
        tutorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TutorFrame();
                }
            });
        // Creating a new instance of the  LecturerFrame
        lecturerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new LecturerFrame();
                }
            });
        // Button for opening a link
        projectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(new URI("https://drive.google.com/drive/folders/1C0LmIwgSL2QClRmCQx61WBa5KMaxUbC3?usp=sharing"));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error opening link: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        setVisible(true); // Set the main frame visible
    }
    
    // This static method allows access to the list of teachers stored in the `teacherList` ArrayList.
    public static ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }
    
    // Entry point of the program; creates an instance of TeacherGUI on the Event Dispatch Thread (EDT)

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new TeacherGUI(); // Create instance of TeacherGUI on the EDT
                }
            });
    }
}
// Decalring a Java class known as TutorFrame
class TutorFrame extends JFrame {
    // Calling the TutorFrame when a new instance of the TutorFrame class is created
    public TutorFrame() {
        // Create a new ArrayList called teacherList and assign it the value returned by the getTeacherList method of the TeacherGUI class
        ArrayList<Teacher> teacherList = TeacherGUI.getTeacherList();
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Setting up the frame
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        setTitle("Tutor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 750);
        setLocationRelativeTo(null);

        JPanel contentPane2 = new GradientPanel(new Color(255, 255, 255), new Color(58,59,175));
        setContentPane(contentPane2);
        setLayout(null);

        JLabel nameLabel = new JLabel("TEACHER MANAGEMENT SYSTEM");
        nameLabel.setBounds(50, 20, 300, 30);

        // Create a separator to represent the horizontal line
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(0, 50, getWidth(), 1); 

        // Add the label and separator to the frame
        add(nameLabel);
        add(separator);
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // BUTTONS 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Initialising the buttons
        JButton addTutorButton = new JButton("Add Tutor");
        JButton setSalaryButton = new JButton("Set Salary");
        JButton backButton = new JButton("Back");
        JButton displayInfoButton = new JButton("Display Tutor Information");
        JButton clearFieldsButton = new JButton("Clear Fields");
        JButton removeTutorbutton = new JButton(" Remove Tutor");

        // Creating a "Dimension " class named as "buttonSize " so that it can be used to set up the sizes of other components
        Dimension buttonSize = new Dimension(150,50);
        
        // Setting the sizes of the buttons 
        addTutorButton.setSize(buttonSize);
        setSalaryButton.setSize(buttonSize);
        backButton.setSize(buttonSize);
        displayInfoButton.setSize(200,50);
        clearFieldsButton.setSize(buttonSize);
        removeTutorbutton.setSize(buttonSize);
        
        // Setting the location of the buttons
        addTutorButton.setLocation(50, 400); 
        setSalaryButton.setLocation(250, 400);
        backButton.setLocation(50, 500);
        displayInfoButton.setLocation(250, 500);
        clearFieldsButton.setLocation(50, 600);
        add(removeTutorbutton);
        
        // Adding the buttons to the frame 
        add(addTutorButton);
        add(setSalaryButton);
        add(backButton);
        add(displayInfoButton);
        add(clearFieldsButton);
        removeTutorbutton.setLocation(250, 600);
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // TEXT FIELDS  
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        
        //Initialisation 
        JTextField teacherIdField = new JTextField();
        JTextField teacherNameField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField workingTypeField = new JTextField();
        JTextField employmentStatusField = new JTextField();
        JTextField workingHoursField = new JTextField();
        JTextField salaryField = new JTextField();
        JTextField specializationField = new JTextField();
        JTextField academicQualificationsField= new JTextField();
        JTextField performanceIndexField= new JTextField();

        // Creating a "Dimension " class named as "fieldSize " so that it can be used to set up the sizes of other components
        Dimension fieldSize = new Dimension(200, 30);
        
        // Setting the size
        teacherIdField.setSize(fieldSize);
        teacherNameField.setSize(fieldSize);
        addressField.setSize(fieldSize);
        workingHoursField.setSize(fieldSize);
        salaryField.setSize(fieldSize);
        specializationField.setSize(fieldSize);
        performanceIndexField.setSize(fieldSize);
        
        // Setting the locations 
        teacherIdField.setLocation(200, 100);
        teacherNameField.setLocation(200, 130);
        addressField.setLocation(200, 160);
        workingHoursField.setLocation(200, 240);
        salaryField.setLocation(200, 270);
        specializationField.setLocation(200, 300);
        performanceIndexField.setLocation(200, 360);
        
        // Adding the fields to the frame 
        add(teacherIdField);
        add(teacherNameField);
        add(addressField);
        add(workingHoursField);
        add(salaryField);
        add(specializationField);
        add(performanceIndexField);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // DROP DOWN BOXES   
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        String[] workingTypeOptions = {"Full Time", "Part Time", "Freelancer"};
        JComboBox<String> workingTypeComboBox = new JComboBox<>(workingTypeOptions);
        workingTypeComboBox.setSize(new Dimension(200, 30));
        workingTypeComboBox.setLocation(200, 190);
        add(workingTypeComboBox);
        
        String[] employmentStatusOptions = {"Active", "Inactive"};
        JComboBox<String> employmentStatusComboBox = new JComboBox<>(employmentStatusOptions);
        employmentStatusComboBox.setSize(new Dimension(200, 30));
        employmentStatusComboBox.setLocation(200, 210);
        add(employmentStatusComboBox);

        String[] academicQualificationsOptions = {"+2", "Bachelors", "Masters", "PhD"};
        JComboBox<String> academicQualificationsComboBox = new JComboBox<>(academicQualificationsOptions);
        academicQualificationsComboBox.setSize(new Dimension(200, 30));
        academicQualificationsComboBox.setLocation(200, 330);
        add(academicQualificationsComboBox);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // LABELS  
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        
        // Initialising the labels 
        JLabel labelforteacheridfield = new JLabel("Teacher ID ");
        JLabel labelforteachername = new JLabel("Teacher Name ");
        JLabel labelforaddress = new JLabel("Address");
        JLabel labelforworkingtype= new JLabel("Working Type");
        JLabel labelforemploymentstatus = new JLabel("Employment status");
        JLabel labelforworkinghours = new JLabel("Working Hours");
        JLabel labelforsalary = new JLabel("Salary");
        JLabel labelforspecialisation = new JLabel("Specialisation");
        JLabel labelforacademicqualifications = new JLabel("academic Qualifications");
        JLabel labelforperformanceindex = new JLabel("Performance Index");

        // Setting the boundries 
        labelforteacheridfield.setBounds(50, 100, 200, 30);
        labelforteachername.setBounds(50, 130, 200, 30);
        labelforaddress.setBounds(50, 160, 200, 30);
        labelforworkingtype.setBounds(50, 190, 200, 30);
        labelforemploymentstatus.setBounds(50, 210, 200, 30);
        labelforworkinghours.setBounds(50, 240, 200, 30);
        labelforsalary.setBounds(50, 270, 200, 30);
        labelforspecialisation.setBounds(50, 300, 200, 30);
        labelforacademicqualifications.setBounds(50, 330, 200, 30);
        labelforperformanceindex.setBounds(50, 360, 200, 30);
        
        // Adding the fields to the frame         
        add(labelforteacheridfield);
        add(labelforteachername);
        add(labelforaddress);
        add(labelforworkingtype);
        add(labelforemploymentstatus);
        add(labelforworkinghours);
        add(labelforsalary);
        add(labelforspecialisation);
        add(labelforacademicqualifications);
        add(labelforperformanceindex);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // FOOTER SECTION 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        JLabel footerLabel = new JLabel("© David Ramovich Mandal | 23047335. All rights reserved.");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setBackground(new Color(58, 59, 175)); //
        footerLabel.setOpaque(true);
        footerLabel.setBounds(0, 685, getWidth(), 30); // Adjusted bounds
        contentPane2.add(footerLabel);
        setContentPane(contentPane2);

        setVisible(true);
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // BUTTONS AND THEIR ACTION LISTENERS 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        setSalaryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                    //Setting up the frame
                    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

                    // Open a new frame to set the salary 
                    JFrame setSalaryFrame = new JFrame("Set Salary");
                    setSalaryFrame.setSize(300, 200);
                    setSalaryFrame.setLocationRelativeTo(null);
                    setSalaryFrame.setLayout(new FlowLayout());

                    // Text fields for tutor ID and performance index
                    JTextField tutorIdField = new JTextField("Tutor ID");
                    JTextField performanceIndexField = new JTextField("Performance Index");
                    
                    // Dimension of the fields 
                    tutorIdField.setPreferredSize(new Dimension(150, 30));
                    performanceIndexField.setPreferredSize(new Dimension(150, 30));

                    // Button to set the salary
                    JButton setSalaryButton = new JButton("Set Salary");

                    // Add components to the frame
                    setSalaryFrame.add(tutorIdField);
                    setSalaryFrame.add(performanceIndexField);
                    setSalaryFrame.add(setSalaryButton);

                    // Action listener for the set salary button
                    setSalaryButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int tutorId = Integer.parseInt(tutorIdField.getText());
                                int performanceIndex = Integer.parseInt(performanceIndexField.getText());

                                // Find the tutor in the teacherList
                                Tutor foundTutor = null;
                                for (Teacher teacher : teacherList) {
                                    if (teacher instanceof Tutor && teacher.getTeacherId() == tutorId) {
                                        foundTutor = (Tutor) teacher;
                                        break;
                                    }
                                }

                                if (foundTutor != null) {
                                    // Tutor found, update salary
                                    double currentSalary = foundTutor.getSalary();
                                    int workingHours = foundTutor.getWorkingHours();

                                    if (performanceIndex >= 5 && workingHours > 20) {
                                        // Calculate appraisal based on performance index
                                        double appraisal = 0 ;
                                        if (performanceIndex >= 8 && performanceIndex <= 9) {
                                            appraisal = 0.1;
                                        } else if (performanceIndex == 10) {
                                            appraisal = 0.2;
                                        } else if (performanceIndex >= 5 && performanceIndex <=7){
                                            appraisal = 0.05;
                                        }

                                        // Calculate new salary
                                        double newSalary = currentSalary * (1 + appraisal);
                                        foundTutor.setSalary(newSalary,performanceIndex );

                                        // Update certification status
                                        foundTutor.setCertified(true);

                                        // Show updated salary in dialog box
                                        JOptionPane.showMessageDialog(null, "Salary updated successfully.\nNew salary: $" + newSalary, "Salary Update", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        // Salary not updated, show error message
                                        JOptionPane.showMessageDialog(null, "Salary not updated. Performance index should be 5 or greater and working hours should be more than 20.", "Salary Update Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    // Tutor not found, show error message
                                    JOptionPane.showMessageDialog(null, "Tutor with ID " + tutorId + " not found.", "Tutor Not Found", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });

                    setSalaryFrame.setVisible(true);
                }
            });

        clearFieldsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    teacherIdField.setText("");
                    teacherNameField.setText("");
                    addressField.setText("");
                    workingTypeField.setText("");
                    employmentStatusField.setText("");
                    workingHoursField.setText("");
                    salaryField.setText("");
                    specializationField.setText("");
                    academicQualificationsField.setText("");
                    performanceIndexField.setText("");
                }
            });
            // To remove the tutor 
        removeTutorbutton.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    try {
                        int teacherIdToRemove = Integer.parseInt(teacherIdField.getText());

                        // Iterate through the teacherList to find the tutor with the matching ID
                        for (int i = 0; i < teacherList.size(); i++) {
                            Teacher teacher = teacherList.get(i);
                            if (teacher instanceof Tutor && teacher.getTeacherId() == teacherIdToRemove) {
                                // Remove the tutor from the list
                                teacherList.remove(i);
                                JOptionPane.showMessageDialog(null, "Tutor with ID " + teacherIdToRemove + " removed successfully.", "Tutor Removed", JOptionPane.INFORMATION_MESSAGE);

                                return; // Exit the loop once the tutor is removed
                            }
                        }

                        // If no tutor with the entered ID is found
                        JOptionPane.showMessageDialog(null, "Tutor with ID " + teacherIdToRemove + " not found.", "Tutor Not Found", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid numeric teacher ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        // To display the info of the tutors 
        displayInfoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Gather and display information for the appropriate class
                    displayTeacherInfo();
                }
            });
        // To go back 
        backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Dispose of the current TutorFrame
                    dispose();

                }
            });

        addTutorButton.addActionListener(new ActionListener() {

                // Get tutor information from text fields and add the tutor
                // Example: int teacherId = Integer.parseInt(teacherIdField.getText());
                // Create a new Tutor object and add it to the list
                @Override
                public void actionPerformed(ActionEvent e) {
                    try{
                        //validate empty or not bhanera 
                        if (teacherIdField.getText().isEmpty() || teacherNameField.getText().isEmpty() ||
                        addressField.getText().isEmpty()  ||
                        specializationField.getText().isEmpty() ) {
                            JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit method if any field is empty
                        }

                        // Validate string input
                        if (!isAlphabetic(teacherNameField.getText()) || !isAlphabetic(addressField.getText()) ||

                        !isAlphabetic(specializationField.getText()) ) {
                            JOptionPane.showMessageDialog(null, "Please enter valid alphabetic characters for name, address,specialization.", "Input Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit method if any field contains non-alphabetic characters
                        }
                        // Getting the values entered in various input fields and then storing it in corresponding variables 
                        int teacherId = Integer.parseInt(teacherIdField.getText());
                        String teacherName = teacherNameField.getText();
                        String address = addressField.getText();
                        String employmentStatus = (String) employmentStatusComboBox.getSelectedItem();
                        String workingType = (String) workingTypeComboBox.getSelectedItem();
                        int workingHours = Integer.parseInt(workingHoursField.getText());
                        double salary = Double.parseDouble(salaryField.getText());
                        String specialization = specializationField.getText();
                        String academicQualifications = (String) academicQualificationsComboBox.getSelectedItem();
                        int performanceIndex = Integer.parseInt(performanceIndexField.getText());
                        // validation
                        // Checking if the tutor exists in the teacher list or not 
                        // If the id already exists , then the "exists " is set to "true" and the corresponding code is run
                        boolean exists = false;
                        for (Teacher teacher : teacherList) {
                            if (teacher.getTeacherId() == teacherId) {
                                exists = true;
                                break;
                            }
                        }

                        if (exists) { 
                            // runs if the exist is set to "true"
                            JOptionPane.showMessageDialog(null, "Lecturer with the same ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Creating a new Tutor object "tutor" with the input values and add to the teacherlist
                            Tutor tutor = new Tutor(teacherId, teacherName, address, workingType, employmentStatus, workingHours, salary, specialization, academicQualifications, performanceIndex);
                            teacherList.add(tutor);
                            // Creating a new string builder object called tutorinfo and adding info from the tuor object to it 
                            StringBuilder tutorInfo = new StringBuilder();
                            tutorInfo.append("Teacher ID: ").append(teacherId).append("\n");
                            tutorInfo.append("Teacher Name: ").append(teacherName).append("\n");
                            tutorInfo.append("Address: ").append(address).append("\n");
                            tutorInfo.append("Employment Status: ").append(employmentStatus).append("\n");
                            tutorInfo.append("Working Type: ").append(workingType).append("\n");
                            tutorInfo.append("Working Hours: ").append(workingHours).append("\n");
                            tutorInfo.append("Salary: ").append(salary).append("\n");
                            tutorInfo.append("Specialization: ").append(specialization).append("\n");
                            tutorInfo.append("Academic Qualifications: ").append(academicQualifications).append("\n");
                            tutorInfo.append("Performance Index: ").append(performanceIndex).append("\n");

                            JOptionPane.showMessageDialog(null, "Tutor added successfully.\n\n" + tutorInfo.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

    }

    private void displayTeacherInfo() {
        ArrayList<Teacher> teacherList = TeacherGUI.getTeacherList();

        StringBuilder info = new StringBuilder();
        boolean teacherFound = false;
        
        info.setLength(0);// ensuring the "info " object is empty     
        for (Teacher teacher : teacherList) {
            if (teacher instanceof Tutor) {
                
                Tutor tutor = (Tutor) teacher;
                info.append("Tutor ID: ").append(tutor.getTeacherId()).append("\n");
                info.append("Tutor Name: ").append(tutor.getTeacherName()).append("\n");
                info.append("Address: ").append(tutor.getAddress()).append("\n");
                info.append("Working Type: ").append(tutor.getWorkingType()).append("\n");
                info.append("Employment Status: ").append(tutor.getEmploymentStatus()).append("\n");
                info.append("Working Hours: ").append(tutor.getWorkingHours()).append("\n");
                info.append("Salary: ").append(tutor.getSalary()).append("\n");
                info.append("Specialization: ").append(tutor.getSpecialization()).append("\n");
                info.append("Academic Qualifications: ").append(tutor.getAcademicQualifications()).append("\n");
                info.append("Performance Index: ").append(tutor.getPerformanceIndex()).append("\n");
                teacherFound = true;
            } 
        }

        if (teacherFound) {
            //Initialize text area with info string, 
            //wrap it with scroll pane, 
            //and set it to non-editable.
            JTextArea textArea = new JTextArea(info.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setEditable(false);
            // Display the gathered information in a dialog
            JOptionPane.showMessageDialog(null, scrollPane, "Teacher Information", JOptionPane.PLAIN_MESSAGE);        System.out.println(info.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No teacher information available.", "Teacher Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("No teacher information available.");
        }
    }
    // Method to check if a given string contains only alphabetic characters (ignoring case)
    private boolean isAlphabetic(String input) {
        // Regular expression pattern to match one or more alphabetic characters
        return input.matches("[a-zA-Z ]+");
    }

}

class LecturerFrame extends JFrame {
    public LecturerFrame() {
        ArrayList<Teacher> teacherList = TeacherGUI.getTeacherList();
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //Setting up the frame
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        
        setTitle("Lecturer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 700);
        setLocationRelativeTo(null);

        JPanel contentPane = new GradientPanel(new Color(255, 255, 255), new Color(58, 59, 175));
        setContentPane(contentPane);
        setLayout(null);

        JLabel nameLabel = new JLabel("TEACHER MANAGEMENT SYSTEM");
        nameLabel.setBounds(50, 20, 300, 30);
        
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(0, 50, getWidth(), 1);
        
        // Add the label and separator to the frame
        add(nameLabel);
        add(separator);
        
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // TEXT FIELDS  
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        
        //Initialising the text fields
        JTextField lecturerIdField = new JTextField();
        JTextField lecturerNameField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField workingTypeField = new JTextField();
        JTextField employmentStatusField = new JTextField();
        JTextField departmentField = new JTextField(); // New field for department
        JTextField experienceField = new JTextField(); // New field for years of experience
        JTextField workingHoursField = new JTextField();
        
        // Creating a "Dimension " class named as "buttonSize " so that it can be used to set up the sizes of other components
        Dimension fieldSize = new Dimension(250, 30);

        // Setting the size 
        lecturerIdField.setSize(fieldSize);
        lecturerNameField.setSize(fieldSize);
        addressField.setSize(fieldSize);
        departmentField.setSize(fieldSize); 
        experienceField.setSize(fieldSize); 
        workingHoursField.setSize(fieldSize); 

        //Setting the location 
        lecturerIdField.setLocation(250, 100);
        lecturerNameField.setLocation(250, 130);
        addressField.setLocation(250, 160);
        departmentField.setLocation(250, 250); 
        experienceField.setLocation(250, 280); 
        workingHoursField.setLocation(250, 310);

        // Adding the fields to the frame and the panel 

        add(lecturerIdField);
        add(lecturerNameField);
        add(addressField);
        contentPane.add(departmentField); 
        contentPane.add(experienceField); 
        contentPane.add(workingHoursField);
        
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // DROP DOWN BOXES   
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        String[] employmentStatusOptions = {"Active", "Inactive"};
        String[] workingTypeOptions = {"Full Time", "Part Time", "Freelancer"};

        JComboBox<String> employmentStatusComboBox = new JComboBox<>(employmentStatusOptions);
        JComboBox<String> workingTypeComboBox = new JComboBox<>(workingTypeOptions);

        employmentStatusComboBox.setSize(fieldSize);
        employmentStatusComboBox.setLocation(250, 220); 
        contentPane.add(employmentStatusComboBox);

        workingTypeComboBox.setSize(fieldSize);
        workingTypeComboBox.setLocation(250, 190); 
        contentPane.add(workingTypeComboBox);
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // LABELS  
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //Initialising the fields 
        JLabel labelForLecturerIdField = new JLabel("Lecturer ID ");
        JLabel labelForLecturerName = new JLabel("Lecturer Name ");
        JLabel labelForLecturerAddress = new JLabel("Lecturer Address");
        JLabel labelForLecturerWorkingType = new JLabel("Lecturer Working Type");
        JLabel labelForLecturerEmploymentStatus = new JLabel("Lecturer Employment Status");
        JLabel labelForDepartment = new JLabel("Department"); // New label for department
        JLabel labelForExperience = new JLabel("Years of Experience"); // New label for years of experience
        JLabel labelForWorkingHours = new JLabel("Working Hours"); 
        
        // Setting the boundaries 
        
        labelForLecturerIdField.setBounds(50, 100, 200, 30);
        labelForLecturerName.setBounds(50, 130, 200, 30);
        labelForLecturerAddress.setBounds(50, 160, 200, 30);
        labelForLecturerWorkingType.setBounds(50, 190, 200, 30);
        labelForLecturerEmploymentStatus.setBounds(50, 220, 200, 30);
        labelForDepartment.setBounds(50, 250, 200, 30); // Position for department label
        labelForExperience.setBounds(50, 280, 200, 30); // Position for years of experience label
        labelForWorkingHours.setBounds(50, 310, 200, 30); // Position for working hours label
        
        // Adding the fields to the frame 
        add(labelForLecturerIdField);
        add(labelForLecturerName);
        add(labelForLecturerAddress);
        add(labelForLecturerWorkingType);
        add(labelForLecturerEmploymentStatus);
        add(labelForDepartment); 
        contentPane.add(labelForExperience); 
        contentPane.add(labelForWorkingHours); 
        
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // BUTTONS 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Initialising the buttons 
        JButton addLecturerButton = new JButton("Add Lecturer");
        JButton backButton = new JButton("Back");
        JButton displayButton = new JButton("Display");
        JButton gradeAssignmentsButton = new JButton("Grade Assignments");
        JButton clearFieldsButton = new JButton("Clear Fields");


        // Button sizes
        
        Dimension buttonSize = new Dimension(150, 40);
        
        addLecturerButton.setSize(buttonSize);
        gradeAssignmentsButton.setSize(buttonSize);
        backButton.setSize(buttonSize);
        displayButton.setSize(200, 40);
        clearFieldsButton.setSize(buttonSize);
        
        // Button locations :                
        addLecturerButton.setLocation(50, 470);
        gradeAssignmentsButton.setLocation(250, 470);
        backButton.setLocation(50, 520);
        displayButton.setLocation(250, 520);
        clearFieldsButton.setLocation(50, 570);
        
        // Adding the button to the frame 
        add(addLecturerButton);
        add(gradeAssignmentsButton);
        add(backButton);
        add(displayButton);
        add(clearFieldsButton);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // FOOTER SECTION 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 
        JLabel footerLabel = new JLabel("© David Ramovich Mandal | 23047335. All rights reserved.");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setBackground(new Color(58, 59, 175)); //
        footerLabel.setOpaque(true);
        footerLabel.setBounds(0, 635, getWidth(), 30); // Adjusted bounds
        contentPane.add(footerLabel);
        setContentPane(contentPane);
        setVisible(true);

        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        // BUTTONS AND THEIR ACTION LISTENERS 
        //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Close the current frame
                }
            });

        // the button to add the info of the lecturer
        addLecturerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        if (lecturerIdField.getText().isEmpty() || lecturerNameField.getText().isEmpty() ||
                        addressField.getText().isEmpty() || departmentField.getText().isEmpty() ||
                        experienceField.getText().isEmpty() || workingHoursField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit method if any field is empty
                        }

                        if (!isAlphabetic(lecturerNameField.getText()) || !isAlphabetic(addressField.getText()) ||

                        !isAlphabetic(departmentField.getText()) 
                        ) {
                            JOptionPane.showMessageDialog(null, "Please enter valid alphabetic characters for name, address, working type, employment status, specialization, and academic qualifications.", "Input Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit method if any field contains non-alphabetic characters
                        }
                        int lecturerId = Integer.parseInt(lecturerIdField.getText());
                        String lecturerName = lecturerNameField.getText();
                        String address = addressField.getText();
                        String employmentStatus = (String) employmentStatusComboBox.getSelectedItem();
                        String workingType = (String) workingTypeComboBox.getSelectedItem();
                        String department = departmentField.getText(); // Retrieve department
                        int experience = Integer.parseInt(experienceField.getText()); // Retrieve years of experience
                        int workingHours = Integer.parseInt(workingHoursField.getText());

                        // Check if lecturer with the same ID already exists
                        //to paste after the get text wala method
                        boolean exists = false;
                        for (Teacher teacher : teacherList) {
                            if (teacher.getTeacherId() == lecturerId) {
                                exists = true;
                                break;
                            }
                        }

                        if (exists) {
                            JOptionPane.showMessageDialog(null, "Lecturer with the same ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Create a new Lecturer object and add it to the teacherList
                            Lecturer lecturer = new Lecturer(lecturerId, lecturerName, address, workingType, employmentStatus, department, experience, workingHours);
                            teacherList.add(lecturer);

                            StringBuilder lecturerInfo = new StringBuilder();
                            lecturerInfo.append("Lecturer ID: ").append(lecturerId).append("\n");
                            lecturerInfo.append("Lecturer Name: ").append(lecturerName).append("\n");
                            lecturerInfo.append("Address: ").append(address).append("\n");
                            lecturerInfo.append("Employment Status: ").append(employmentStatus).append("\n");
                            lecturerInfo.append("Working Type: ").append(workingType).append("\n");
                            lecturerInfo.append("Working Hours: ").append(workingHours).append("\n");
                            lecturerInfo.append("Department: ").append(department).append("\n");
                            lecturerInfo.append("Experience: ").append(experience).append("\n");
                            

                            JOptionPane.showMessageDialog(null, "Lecturer added successfully.\n\n" + lecturerInfo.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);

                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        // display feature :
        displayButton.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Gather and display information for the appropriate class
                    displayLecturerInfo();
                }
            });

        gradeAssignmentsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame gradeAssignmentFrame = new JFrame("Grade Assignments");
                    gradeAssignmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    gradeAssignmentFrame.setSize(400, 400);
                    gradeAssignmentFrame.setLocationRelativeTo(null);
                    gradeAssignmentFrame.setLayout(null); // Set the layout to null for manual component positioning
                
                    JLabel nameLabel = new JLabel("TEACHER MANAGEMENT SYSTEM");
                    nameLabel.setBounds(50, 20, 300, 30);
                    gradeAssignmentFrame.add(nameLabel);
                
                    // TEXT FIELDS
                    JTextField teacherIdField = new JTextField();
                    JTextField gradedScoreField = new JTextField();
                    JTextField departmentField = new JTextField();
                    JTextField yearsOfExperienceField = new JTextField();
                
                    teacherIdField.setBounds(200, 50, 150, 30);
                    gradedScoreField.setBounds(200, 100, 150, 30);
                    departmentField.setBounds(200, 150, 150, 30);
                    yearsOfExperienceField.setBounds(200, 200, 150, 30);
                
                    gradeAssignmentFrame.add(teacherIdField);
                    gradeAssignmentFrame.add(gradedScoreField);
                    gradeAssignmentFrame.add(departmentField);
                    gradeAssignmentFrame.add(yearsOfExperienceField);
                
                    // TEXT LABELS
                    JLabel teacherIdLabel = new JLabel("Teacher ID:");
                    JLabel gradedScoreLabel = new JLabel("Graded Score:");
                    JLabel departmentLabel = new JLabel("Department:");
                    JLabel yearsOfExperienceLabel = new JLabel("Years of Experience:");
                
                    teacherIdLabel.setBounds(50, 50, 100, 30);
                    departmentLabel.setBounds(50, 150, 100, 30);
                    yearsOfExperienceLabel.setBounds(50, 200, 150, 30);
                    gradedScoreLabel.setBounds(50, 100, 100, 30);
                
                    gradeAssignmentFrame.add(gradedScoreLabel);
                    gradeAssignmentFrame.add(teacherIdLabel);
                    gradeAssignmentFrame.add(departmentLabel);
                    gradeAssignmentFrame.add(yearsOfExperienceLabel);
                
                    // BUTTONS
                    JButton confirmButton = new JButton("Confirm");
                    confirmButton.setBounds(150, 250, 100, 30);
                    gradeAssignmentFrame.add(confirmButton);
                
                    // FOOTER SECTION
                    JLabel footerLabel = new JLabel("© David Ramovich Mandal | 23047335. All rights reserved.");
                    footerLabel.setForeground(Color.WHITE);
                    footerLabel.setBackground(new Color(58, 59, 175));
                    footerLabel.setOpaque(true);
                    footerLabel.setBounds(0, 335, gradeAssignmentFrame.getWidth(), 30);
                    gradeAssignmentFrame.add(footerLabel);

                    

                    confirmButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    int teacherId = Integer.parseInt(teacherIdField.getText());
                                    int gradedScore = Integer.parseInt(gradedScoreField.getText());
                                    String department = departmentField.getText();
                                    int yearsOfExperience = Integer.parseInt(yearsOfExperienceField.getText());

                                    // Validate years of experience
                                    if (yearsOfExperience < 5) {
                                        JOptionPane.showMessageDialog(gradeAssignmentFrame, "Years of experience cannot be less than 5 years.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }

                                    // Check if the department exists
                                    boolean departmentExists = false;
                                    for (Teacher teacher : teacherList) {
                                        if (teacher instanceof Lecturer && ((Lecturer) teacher).getDepartment().equalsIgnoreCase(department)) {
                                            departmentExists = true;
                                            break;
                                        }
                                    }
                                    if (!departmentExists) {
                                        JOptionPane.showMessageDialog(gradeAssignmentFrame, "The department entered does not exist.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }

                                    // Check if lecturer ID has already been added earlier
                                    boolean lecturerIdExists = false;
                                    for (Teacher teacher : teacherList) {
                                        if (teacher.getTeacherId() == teacherId) {
                                            lecturerIdExists = true;
                                            break;
                                        }
                                    }
                                    if (!lecturerIdExists) {
                                        JOptionPane.showMessageDialog(gradeAssignmentFrame, "Lecturer with the entered ID does not exist.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }

                                    // Perform grading of assignments here
                                    // Perform grading of assignments
                                    String grade;
                                    if (gradedScore >= 70) {
                                        grade = "A";
                                    } else if (gradedScore >= 60) {
                                        grade = "B";
                                    } else if (gradedScore >= 50) {
                                        grade = "C";
                                    } else if (gradedScore >= 40) {
                                        grade = "D";
                                    } else {
                                        grade = "E";
                                    }

                                    // Display grading information
                                    System.out.println("Grading Information:");

                                    System.out.println("Graded Score: " + gradedScore);
                                    System.out.println("Grade: " + grade);
                                    // Close the grade assignment frame after grading
                                    gradeAssignmentFrame.dispose();
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(gradeAssignmentFrame, "Invalid input. Please enter valid numeric values.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }

                        });
                    /*contentPane4.add(confirmButton);

                    // Add the panel to the frame's content pane
                    gradeAssignmentFrame.getContentPane().add(contentPane4);

                    // Make the frame visible
                    gradeAssignmentFrame.setVisible(true);*/
                    gradeAssignmentFrame.setVisible(true);

                }
            });

        clearFieldsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lecturerIdField.setText("");
                    lecturerNameField.setText("");
                    addressField.setText("");
                    workingTypeField.setText("");
                    employmentStatusField.setText("");
                    departmentField.setText("");
                    workingHoursField.setText("");
                    experienceField.setText("");

                }
            });

    }

    private void displayLecturerInfo() {
        ArrayList<Teacher> teacherList = TeacherGUI.getTeacherList();

        StringBuilder info = new StringBuilder();
        boolean teacherFound = false;

        info.setLength(0);    
        for (Teacher teacher : teacherList) {
            if (teacher instanceof Lecturer) {
                // For Tutor objects
                Lecturer lecturer = (Lecturer) teacher;
                info.append("Lecturer ID: ").append(lecturer.getTeacherId()).append("\n");
                info.append("Lecturer Name: ").append(lecturer.getTeacherName()).append("\n");
                info.append("Address: ").append(lecturer.getAddress()).append("\n");
                info.append("Working Type: ").append(lecturer.getWorkingType()).append("\n");
                info.append("Employment Status: ").append(lecturer.getEmploymentStatus()).append("\n");
                info.append("Department: ").append(lecturer.getDepartment()).append("\n");
                info.append("Years of Experience: ").append(lecturer.getYearsOfExperience()).append("\n");
                info.append("Working Hours: ").append(lecturer.getWorkingHours()).append("\n\n");
                teacherFound = true;
            } 
        }

        if (teacherFound) {
            JTextArea textArea = new JTextArea(info.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setEditable(false);
            // Display the gathered information in a dialog
            JOptionPane.showMessageDialog(null, scrollPane, "lecturer Information", JOptionPane.PLAIN_MESSAGE);        System.out.println(info.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No lecturer information available.", "lecturer Information", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("No teacher information available.");
        }
    }

    private boolean isAlphabetic(String input) {
        return input.matches("[a-zA-Z ]+");
    }
}


// Copied code from the internet to make the gui more attractive . Dont know much in detail about the code 
// Custom JPanel class that paints a gradient background 
class GradientPanel extends JPanel {
    // Start and end colors for the gradient
    private Color startColor;
    private Color endColor;
    // Constructor to initialize the start and end colors
    public GradientPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
        setOpaque(false); // Make the panel transparent
    }
    // Override the paintComponent method to paint the gradient background
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, startColor, w, 0, endColor);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        g2d.dispose();
    }
}

