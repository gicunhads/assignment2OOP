package assignment3;
import java.util.List;

public class Manager extends Employee {
    String degree;
    double originalGrossSalary;
    // Constructor
    public Manager(String ID, String name, double grossSalary, String degree) throws Exception{
        super(ID, name, grossSalary);
        this.degree = degree.trim().toLowerCase();
        if (!List.of("bsc", "msc", "phd").contains(this.degree)) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
        this.tax = 0.1;

        this.grossSalary = calculateGrossSalary(grossSalary);
        this.originalGrossSalary = grossSalary;
        System.out.println(String.format("Manager %s was registered successfully", ID));
    }

    public double calculateGrossSalary(double baseSalary) throws Exception {
        return DoubleFormat.truncate(baseSalary * (1 + this.getBonus()));
    }

    public String getDegree(){
        return this.degree;
    }

    public double getBonus() throws Exception{
        switch (this.getDegree().toLowerCase()){
            case "bsc" -> { return 0.10; }
            case "msc" -> { return 0.20; }
            case "phd" -> { return 0.35; }
            default -> throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
    }

    @Override
    public String getEmployeesInfo(){
        String degreeFormatted = this.degree.equalsIgnoreCase("phd") ? "PhD" :
                this.degree.equalsIgnoreCase("msc") ? "MSc" : "BSc";
        return String.format("%s %s's gross salary is %.2f SEK per month.", degreeFormatted, this.name, getGrossSalary());
    }

    public void setDegree(String degree) throws Exception{
        this.degree = degree;
        this.grossSalary = calculateGrossSalary(this.originalGrossSalary); // Update salary after degree change
    }
}
