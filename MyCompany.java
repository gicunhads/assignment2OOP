import java.util.*;
import java.util.stream.Collectors;

public class MyCompany extends Company {
    public MyCompany() {
        this.dictEmployees = new HashMap<>();
    }

    @Override
    public void addEmployee(Employee employee){
        if (dictEmployees.containsKey(employee.getID())) {
            throw new IllegalArgumentException("Employee " + employee.getID() + " is already registered.");
        }
        dictEmployees.put(employee.getID(), employee);
        
        System.out.println(String.format("Employee %s was registered successfully.", employee.getID()));
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
        int totalNetSalary = 0;
        for (Employee employee : dictEmployees.values()){
            totalNetSalary += employee.getNetSalary();
    }
    return totalNetSalary;

}

    @Override
    public String employeeDegreeDetails() { 

        for (Employee employee : dictEmployees.values()){
            if (employee instanceof Manager || employee instanceof Director){
                // code
            }
    }

    @Override
    public String allEmployeeDetails() { 
        String allEmployees = "";
        for (Employee employee : dictEmployees.values()){
            allEmployees = employee.getEmployeesInfo() + " ";
        }
        return allEmployees;
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

