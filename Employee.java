/*Each employee has an ID (String), a name and a gross salary specified during the Employee’s creation, 
and can be later retrieved. 
The name and salary of an employee can be changed, but their ID cannot change. 
Two employees are equals if they have the same ID. 

Employees should be represented as the following String:
<name>’s gross salary is <gross_salary> SEK per month.

Your employee also has a net salary that has a distinct calculation depending on a specific type of employee. 

The regular Employee has a net income by paying 10% of taxes in his/her gross salary.

netSalary = grossSalary - (grossSalary * 0.1)
The salaries of your employee (both gross and net salary values), must be truncated after two decimal values. 
This also applies to all specific types of employees (see below). 

You should truncate when creating the gross salary, 
and after the result of any calculation with salary values.

When the employee is created successfully, the company should return the message:

"Employee <ID> was registered successfully." 
*/

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

    public double getGrossSalary() {
        return DoubleFormat.doubleFormater(this.grossSalary); // to return with a "." instead of ","
    }

    public double getNetSalary(){
        double netSalary = this.grossSalary - (this.grossSalary * this.getTax());
        return DoubleFormat.doubleFormater(netSalary);
    }

    public void getEmployeesInfo(){
        System.out.println(String.format("%s's gross salary is %.2f SEK per month.", this.name, this.grossSalary));
    }

    public void updateName(String name){
        this.name = name;
    }

    public void updateSalary(double salary){
        this.grossSalary = salary;
    }

}
