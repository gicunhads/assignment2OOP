package assignment3;

public class Intern extends Employee {

    int GPA;
    double OriginalSalary;

    public Intern(String ID, String name, double grossSalary, int GPA) {
        super(ID, name, grossSalary);
        this.GPA = GPA;
        this.OriginalSalary = grossSalary;
        this.grossSalary = getNetSalary(); // because gpa doesnt pay taxes


        System.out.printf("Employee %s was registered successfully%n", ID);
    }

    public void updateGPA(int newGPA) {
        this.GPA = newGPA;
    }

    @Override
    public double getNetSalary() {
        if (0 <= GPA && GPA <= 5) {
            return 0; // No salary for GPA < 5
        } else if (5 < GPA && GPA <= 8) {
            return this.grossSalary; // Full salary
        } else if (8 < GPA && GPA <= 10) {
            return DoubleFormat.truncate(this.OriginalSalary + 1000); // Bonus for high GPA case
        } else {
            System.out.println("Invalid GPA value. Please enter a value between 0 and 10");
            return -1;
        }
    }

    @Override
    public String getEmployeesInfo() {
        return String.format("%s's gross salary is %.2f SEK per month. GPA: %d",
                this.name, getGrossSalary(), this.GPA);

    }
}
