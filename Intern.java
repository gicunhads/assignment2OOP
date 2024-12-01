public class Intern extends Employee {

int GPA;
double salary;

    public Intern (String ID, String name, double grossSalary, int GPA) {
        super(ID, name, grossSalary);
        this.name = name;
        this.grossSalary = grossSalary;
        this.GPA = GPA;

        System.out.println(String.format("Employee %s was registered successfully", ID));
    }

    
    public void updateGPA(int newGPA){
        this.GPA = newGPA;
    }

    @Override
    public double getGrossSalary() {
        if (0 <= GPA && GPA < 5) {
            salary = 0;
        } else if (5 <= GPA && GPA < 8) {
            salary = this.grossSalary;

        } else if (8 <= GPA && GPA <= 10) {
            salary = (this.grossSalary + 1000);
        }
        else {
            System.out.println("Invalid GPA value. Please enter a value between 0 and 10");
            return -1;
        }
        return salary;
    }

    @Override
    public void getEmployeesInfo(){
        System.out.println(String.format("%s's gross salary is %.2f SEK per month. GPA: %s", this.name, salary, this.GPA));
    }
}