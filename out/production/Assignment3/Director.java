
import java.util.List;

public class Director extends Manager {
    
    String department;
    double originalGrossSalary;

    public Director(String ID, String name, double grossSalary, String degree, String department) {
        super(ID, name, grossSalary, degree);
        this.department = department.trim().toLowerCase();
        if (!List.of("human resources", "technical", "business").contains(this.department)) {
            throw new IllegalArgumentException("Invalid department.");
            
        }
        this.originalGrossSalary = grossSalary;
        this.tax = this.getTax();
        this.grossSalary = (grossSalary * (1 + this.getBonus())+ 5000);

        
        System.out.println(String.format("Director %s was registered successfully", ID));
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
        String degreeFormatted = "";
        if (this.degree.equalsIgnoreCase("phd")) {
            degreeFormatted = "PhD";
        } else if (this.degree.equalsIgnoreCase("msc")) {
            degreeFormatted = "MSc";
        } else if (this.degree.equalsIgnoreCase("bsc")) {
            degreeFormatted = "BSc";
        }
        return String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s",
        degreeFormatted, this.name, this.grossSalary, this.department);
    }
   
    @Override
    public double getNetSalary() {
        double totalTax;
        double netSalary;
        
        if (this.grossSalary <= 50000) {
            totalTax = this.grossSalary * this.getTax();
        }
         else {
            double firstPartTax = 30000 * 0.20;
            double secondPartTax = (this.grossSalary - 30000) * 0.40;
            
            totalTax = firstPartTax + secondPartTax;
        }
        
        netSalary = DoubleFormat.doubleFormater(this.grossSalary - totalTax);

        return netSalary;
    }
}


