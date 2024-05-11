public class Tutor extends Teacher {

    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;
    
    


    // Constructor and other methods...

    
    
    // Constructor with specified parameters
    public Tutor(int teacherId, String teacherName, String address, String workingType, String employmentStatus,
                 int workingHours, double salary, String specialization, String academicQualifications,
                 int performanceIndex) {
        super(teacherId, teacherName, address, workingType, employmentStatus); // calling the constructor of the superclass teacher using super
        super.setWorkingHours(workingHours); // Set working hours directly, inherited from teacher class
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualifications = academicQualifications;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;//accc to question 
    }

    // Accessor methods for each attribute
    public double getSalary() {
        return salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getAcademicQualifications() {
        return academicQualifications;
    }

    public int getPerformanceIndex() {
        return performanceIndex;
    }

    public boolean isCertified() {
        return isCertified;
    }
    public void setCertified(boolean certified) {
        this.isCertified = certified;
    }

    // Method to set salary based on performance and working hours
    public void setSalary(double newSalary, int newPerformanceIndex) {
        if (performanceIndex >= 5 && getWorkingHours() >= 20) {
            double appraisal = 0;
            if (newPerformanceIndex >= 5 && newPerformanceIndex <= 7) {
                appraisal = 0.05;
            } else if (newPerformanceIndex >= 8 && newPerformanceIndex <= 9) {
                appraisal = 0.1;
            } else if (newPerformanceIndex == 10) {
                appraisal = 0.2;
            }
            this.salary = newSalary + (newSalary * appraisal);
            this.performanceIndex = newPerformanceIndex;
            this.isCertified = true;
        } else {
            System.out.println("Salary cannot be approved yet.");
        }
    }

    // Method to remove tutor if not certified
    public void removeTutor() {
        if (!isCertified) { //checking if the tutors iscertified attribute is false
            salary = 0;
            specialization = "";
            academicQualifications = "";
            performanceIndex = 0;
            isCertified = false;
        } else {
            System.out.println("Cannot remove certified tutor.");
        }
    }
    
    

    // Display method to output tutor information
    @Override //override the display method from the teacher class
    public void display() {
        super.display();//calling the display method of the super class 
        if (isCertified) {
           
            System.out.println("Salary: " + salary);
            System.out.println("Specialization: " + specialization);
            System.out.println("Academic Qualifications: " + academicQualifications);
            System.out.println("Performance Index: " + performanceIndex);
        } 
    }
}
