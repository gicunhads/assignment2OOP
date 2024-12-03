
public class Employee {
    
    final private String ID;
    String name;
    double grossSalary;
    double tax;
    

    // constructor
    public Employee(String ID, String name, double grossSalary){
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.tax = 0.1;
        
        System.out.println(String.format("Employee %s was registered successfully", this.ID)); }


    public String getName(){
        return this.name;
    }
    
    public double getTax(){
        return this.tax;
    }

    public String getID(){
        return this.ID;
    }

    public double getGrossSalary() {
        return DoubleFormat.doubleFormater(this.grossSalary); // to return with a "." instead of ","
    }

    public double getNetSalary(){
        double netSalary = this.grossSalary - (this.grossSalary * this.getTax());
        return DoubleFormat.doubleFormater(netSalary);
    }

    public String getEmployeesInfo(){
        return (String.format("%s's gross salary is %.2f SEK per month.", this.name, this.grossSalary));
    }

    public void updateName(String name){
        this.name = name;
    }

    public void updateSalary(double salary){
        this.grossSalary = salary;
    }

}
