package assignment3;
import java.util.List;


public class Director extends Manager {

    String department;
    double originalGrossSalary;
    // Constructor
    public Director(String ID, String name, double grossSalary, String degree, String department) throws Exception {
        super(ID, name, grossSalary, degree);
        this.department = department.trim().toLowerCase();
        if (!List.of("human resources", "technical", "business").contains(this.department)) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
        this.grossSalary = calculateGrossSalaryWithDepartmentBonus(grossSalary);
        System.out.printf("Director %s was registered successfully%n", ID);
    }

    public double calculateGrossSalaryWithDepartmentBonus(double baseSalary) throws Exception {
        double departmentBonus = 5000.0;
        return baseSalary * (1 + this.getBonus()) + departmentBonus;
    }

    @Override
    public double getTax(){
        if (this.grossSalary < 30000) {
            return 0.10;
        } else if (this.grossSalary <= 50000) {
            return 0.20;
        } else {
            return 0.30;
        }
    }

    @Override
    public String getEmployeesInfo() {
        String degreeFormatted = this.degree.equalsIgnoreCase("phd") ? "PhD" :
                this.degree.equalsIgnoreCase("msc") ? "MSc" : "BSc";
        String departmentFormatted = this.department.equalsIgnoreCase("human resources") ? "Human Resources" :
                this.department.equalsIgnoreCase("technical") ? "Technical" : "Business";

        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s",
                degreeFormatted, this.name, this.grossSalary, departmentFormatted);
    }

    @Override
    public double getNetSalary() {
        double totalTax;
        double netSalary;

        if (this.grossSalary <= 50000) {
            totalTax = this.grossSalary * this.getTax();
        } else {
            double firstPartTax = 30000 * 0.20;
            double secondPartTax = (this.grossSalary - 30000) * 0.40;

            totalTax = firstPartTax + secondPartTax;
        }

        netSalary = this.grossSalary - totalTax;
        return DoubleFormat.round(netSalary);
    }

    public void setDepartment(String department) throws Exception{
        this.department = department;
    }
}
