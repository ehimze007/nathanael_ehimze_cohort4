public class Course {
    private final String courseCode;
    private final int courseUnit;
    private final int courseScore;
    private final int gradeUnit;

    public Course(String courseCode, int courseUnit, int courseScore, int gradeUnit) {
        this.courseCode = courseCode;
        this.courseUnit = courseUnit;
        this.courseScore = courseScore;
        this.gradeUnit = gradeUnit;
    }

    public void display() {
        // Print course details in tabular form
        System.out.printf("| %-26s | %-21d | %-10s | %-19d |\n", courseCode, courseUnit, getGrade(courseScore), gradeUnit);
    }

    public int getCourseUnit() {
        return this.courseUnit;
    }

    public int getGradeUnit() {
        return this.gradeUnit;
    }

    private static String getGrade(int score) {
        if (score >= 70 && score <= 100) return "A";
        else if (score >= 60) return "B";
        else if (score >= 50) return "C";
        else if (score >= 45) return "D";
        else if (score >= 40) return "E";
        else return "F";
    }
}