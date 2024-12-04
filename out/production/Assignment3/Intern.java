
package assignment3;
public class Intern extends Employee {

    int GPA;

    public Intern(String ID, String name, double grossSalary, int GPA) {
        super(ID, name, grossSalary); // Initialize grossSalary via the parent class
        this.GPA = GPA;


        System.out.println(String.format("Employee %s was registered successfully", ID));
    }

    public void updateGPA(int newGPA) {
        this.GPA = newGPA;
    }

    @Override
    public double getNetSalary() {
        if (0 <= GPA && GPA < 5) {
            return 0; // No salary for GPA < 5
        } else if (5 <= GPA && GPA < 8) {
            return this.grossSalary; // Full salary
        } else if (8 <= GPA && GPA <= 10) {
            return this.grossSalary + 1000; // Bonus for high GPA
        } else {
            System.out.println("Invalid GPA value. Please enter a value between 0 and 10");
            return -1;
        }
    }

    @Override
    public String getEmployeesInfo() {
        return String.format("%s's gross salary is %.2f SEK per month. GPA: %s", this.name, this.getNetSalary(), this.GPA);
    }
}