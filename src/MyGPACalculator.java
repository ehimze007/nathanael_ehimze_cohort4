import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyGPACalculator {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Grade Point Average (GPA) Calculator");

        // Initialize variables for GPA calculation
        List<Course> courses = new ArrayList<>();
        int courseUnit;
        int courseScore;
        String courseCode;

        // Input and calculate GPA for each course
        while (true) {
            // Input course details
            System.out.print("Enter Course and Code (or enter 'completed' to finish): ");
            courseCode = userInput.nextLine();
            if (courseCode.isEmpty()) {
                System.out.println("Please enter a valid value or enter 'exit' to leave");
                continue;
            }
            if (courseCode.equalsIgnoreCase("completed") || courseCode.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                System.out.print("Enter Course Unit: ");
                courseUnit = Integer.parseInt(userInput.nextLine());
                if (courseUnit <= 0) {
                    System.out.println("Error: Course Unit must be a positive integer. Please enter a valid value.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error: Course Unit must be an integer. Please enter a valid value.");
                continue;
            }

            try {
                System.out.print("Enter Course Score: ");
                courseScore = Integer.parseInt(userInput.nextLine());
                if (courseScore < 0 || courseScore > 100) {
                    System.out.println("Error: Course Score must be between 0 and 100. Please enter a valid value.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Error: Course Score must be an integer. Please enter a valid value.");
                continue;
            }

            // Calculate grade and grade unit
            int gradeUnit = calculateGradePoint(courseScore);

            // Add course to the list
            courses.add(new Course(courseCode, courseUnit, courseScore, gradeUnit));

        }
        // Print table header and course details in tabular form
        printTableHeader();
        for (Course course : courses) {
            course.display();
        }
        //Print table footer
        System.out.println("|---------------------------------------------------------------------------------------|");

        // Calculate and print GPA
        double gpa = calculateGPA(courses);
        System.out.printf("Your GPA is = %.2f to 2 decimal places.\n", gpa);

    }

    // Method to print table header
    private static void printTableHeader() {
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
    }

    // Method to calculate grade point based on the grading system
    private static int calculateGradePoint(int score) {
        if (score >= 70 && score <= 100) return 5;
        else if (score >= 60) return 4;
        else if (score >= 50) return 3;
        else if (score >= 45) return 2;
        else if (score >= 40) return 1;
        else return 0;
    }

    // Method to calculate GPA
    private static double calculateGPA(List<Course> courses) {
        int totalQualityPoints = 0;
        int totalGradeUnits = 0;

        for (Course course : courses) {
            totalQualityPoints += (course.getCourseUnit() * course.getGradeUnit());
            totalGradeUnits += course.getCourseUnit();
        }

        if (totalGradeUnits == 0) return 0.0;
        return (double) totalQualityPoints / totalGradeUnits;
    }
}