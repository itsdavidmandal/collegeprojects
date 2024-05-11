public class Lecturer extends Teacher {

    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;

    // Constructor with specified parameters
    public Lecturer(int teacherId, String teacherName, String address, String workingType, String employmentStatus,
                    String department, int yearsOfExperience,int workingHours) {
        super(teacherId, teacherName, address, workingType, employmentStatus);
        super.setWorkingHours(workingHours);
        this.department = department;
        this.yearsOfExperience = yearsOfExperience;
        this.gradedScore = 0;
        this.hasGraded = false;
    }

    // Accessor methods for each attribute
    public String getDepartment() {
        return department;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getGradedScore() {
        return gradedScore;
    }

    public boolean isHasGraded() {
        return hasGraded;
    }

    // Mutator method for gradedScore
    public void setGradedScore(int gradedScore) {
        this.gradedScore = gradedScore;
    }

    // Method to grade assignments based on criteria
    public void gradeAssignment(int gradedScore, String department, int yearsOfExperience) {
        if (yearsOfExperience >= 5 && department.equals(this.department)) {
            if (gradedScore >= 70) {
                this.gradedScore = gradedScore;
                this.hasGraded = true;
                System.out.println("Assignment graded: A");
            } else if (gradedScore >= 60) {
                this.gradedScore = gradedScore;
                this.hasGraded = true;
                System.out.println("Assignment graded: B");
            } else if (gradedScore >= 50) {
                this.gradedScore = gradedScore;
                this.hasGraded = true;
                System.out.println("Assignment graded: C");
            } else if (gradedScore >= 40) {
                this.gradedScore = gradedScore;
                this.hasGraded = true;
                System.out.println("Assignment graded: D");
            } else {
                this.gradedScore = gradedScore;
                this.hasGraded = true;
                System.out.println("Assignment graded: E");
            }
            //yaha
        } else {
            System.out.println("Lecturer not eligible to grade this assignment.");
        }
    }

    // Display method to output lecturer information
    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + department);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Graded Score: " + (hasGraded ? gradedScore : "Not graded yet"));
    }
}
