import java.util.*;
import java.util.stream.Collectors;

public class MyCompany extends Company {
    public MyCompany() {
        this.dictEmployees = new HashMap<>();
    }

    @Override
    public void addEmployee(String id){
        
        // code logic
        System.out.println(String.format("Employee %s was registered successfully.", id));
    };

    @Override
    public void removeEmployee(String id) {
        if (dictEmployees.containsKey(id)) {
            dictEmployees.remove(id);
            System.out.println("Employee " + id + " was successfully removed.");
        } else {
            throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
        }
    }

    @Override
    public void retriveEmployee(String id) {
        if (dictEmployees.containsKey(id)) {
            Employee emp = dictEmployees.get(id);
            emp.getEmployeesInfo();
        } else {
            throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
        }
    }

    @Override
    public int totalNetValue() {
     //code
    }

    @Override
    public String employeeDegreeDetails() { 
        //code
    }

    @Override
    public String allEmployeeDetails() { 
        //code 
    }

    @Override
    public void updateSalary(String id, double newSalary) {
        Employee emp = findEmployeeByID(id);
        emp.updateSalary(newSalary);
        System.out.println("Employee " + id + " was updated successfully.");
    }

    @Override
    public void updateName(String id, String newName) {
        Employee emp = findEmployeeByID(id);
        emp.updateName(newName);
        System.out.println("Employee " + id + " was updated successfully.");
    }

    private Employee findEmployeeByID(String id) {
        if (!dictEmployees.containsKey(id)) {
            throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
        }
        return dictEmployees.get(id);
    }
}

