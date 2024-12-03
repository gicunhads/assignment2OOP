package assignment3;
import java.util.HashMap;

public abstract class AbstractCompany {
    HashMap<String, Employee> dictEmployees; 
    EmployeeFactory employeeFactory = new EmployeeFactory(); // employee factory
    
    public abstract void addEmployee(Employee employee);

    public abstract void removeEmployee(String id); 

    public abstract void printEmployee(String id);

    public abstract int getTotalNetSalary();

    public abstract String mapEachDegree();

    public abstract String printAllEmployees();

    public abstract void updateGrossSalary(String id, double newSalary); 

    public abstract void updateEmployeeName(String id, String newName);

    public abstract void addEmployee(String employee);

    public abstract String printSortedEmployees();

    public abstract Employee findEmployeeByID(String id);

}












