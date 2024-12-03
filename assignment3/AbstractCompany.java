package assignment3;
import java.util.HashMap;

public abstract class AbstractCompany {
    HashMap<String, Employee> dictEmployees; 
    EmployeeFactory employeeFactory = new EmployeeFactory(); // employee factory
    
    public abstract void addEmployee(Employee employee);

    public abstract void removeEmployee(String id); 

    public abstract void retrieveEmployee(String id);

    public abstract int totalNetValue();

    public abstract String employeeDegreeDetails();

    public abstract String allEmployeeDetails();

    public abstract void updateSalary(String id, double newSalary); 

    public abstract void updateName(String id, String newName);

    public abstract void addEmployee(String employee);

    public abstract String getEmployeesSorted();

    public abstract Employee findEmployeeByID(String id);

}












