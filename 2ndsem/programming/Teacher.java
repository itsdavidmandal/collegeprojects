public class Teacher {//declared a public class teacher 
    //attributes defined according to the question 
    private int teacherId;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;

    // declaring constructors for the "teacher" class.
    public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus) {
        //initializing the attributes 
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.address = address;
        this.workingType = workingType;
        this.employmentStatus = employmentStatus;
        this.workingHours = 0; 
    }

    // adding the accessor methods
    public int getTeacherId() {
        return teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getAddress() {
        return address;
    }

    public String getWorkingType() {
        return workingType;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    // Method to set working hours
    public void setWorkingHours(int WorkingHours) {
        this.workingHours = WorkingHours;
    }

    // displaying teacher info
    public void display() {//public method named display within the teacher class
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Teacher Name: " + teacherName);
        System.out.println("Address: " + address);
        System.out.println("Working Type: " + workingType);
        System.out.println("Employment Status: " + employmentStatus);
        System.out.println("Working Hours: " + (workingHours > 0 ? workingHours : "Not assigned"));
    }
}
