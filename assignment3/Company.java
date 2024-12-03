package assignment3;
import java.util.*;

public class Company extends AbstractCompany {
    public Company() {
        this.dictEmployees = new HashMap<>();
    }

    @Override
    public void addEmployee(Employee employee){
        if (dictEmployees.containsKey(employee.getID())) {
            throw new IllegalArgumentException("Employee " + employee.getID() + " is already registered.");
        }
        dictEmployees.put(employee.getID(), employee);
        
        System.out.println(String.format("Employee %s was registered successfully.", employee.getID()));
    }

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
    public void printEmployee(String id) {
        if (dictEmployees.containsKey(id)) {
            Employee emp = dictEmployees.get(id);
            emp.getEmployeesInfo();
        } else {
            throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
        }
    }

    @Override
    public int getTotalNetSalary() {
        int totalNetSalary = 0;
        for (Employee employee : dictEmployees.values()){
            totalNetSalary += employee.getNetSalary();
    }
    return totalNetSalary;

}

    @Override
    public String mapEachDegree() { 
        int bsc = 0;
        int msc = 0;
        int phd = 0;
        String employeeDegreeDetails = "";
        for (Employee employee : dictEmployees.values()) {
            if (employee instanceof Manager manager) {
                if (manager.getDegree().equalsIgnoreCase("bsc")) {
                    bsc += 1;
                } else if (manager.getDegree().equalsIgnoreCase("msc")) {
                    msc += 1;
                }
            } else if (employee instanceof Director director) {
                if (director.getDegree().equalsIgnoreCase("bsc")) {
                    bsc += 1;
                } else if (director.getDegree().equalsIgnoreCase("msc")) {
                    msc += 1;
                } else if (director.getDegree().equalsIgnoreCase("phd")) {
                    phd += 1;
                }
            }
        }
        employeeDegreeDetails = (String.format("\"Academic background of employees:\nBSc: => %d\nMSc: => %d\nPhD: => %d", bsc, msc, phd));
        return employeeDegreeDetails;
    }

    @Override
    public String printAllEmployees() { 
        String allEmployees = "";
        for (Employee employee : dictEmployees.values()){
            allEmployees = employee.getEmployeesInfo() + " ";
        }
        return ("All registered employees:\n" + allEmployees);
    }

    @Override
    public void updateGrossSalary(String id, double newSalary) {
        Employee emp = findEmployeeByID(id);
        emp.updateSalary(newSalary);
        System.out.println("Employee " + id + " was updated successfully.");
    }

    @Override
    public void updateEmployeeName(String id, String newName) {
        Employee emp = findEmployeeByID(id);
        emp.updateName(newName);
        System.out.println("Employee " + id + " was updated successfully.");
    }

    @Override
    public void addEmployee(String employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Employee findEmployeeByID(String id) {
        if (!dictEmployees.containsKey(id)) {
            throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
        }
        return dictEmployees.get(id);
    }
    
    @Override
    public String printSortedEmployees(){
        String sortedEmployees = "Employees sorted by gross salary (ascending order):\n";
        List<Employee> sortedEmployeesList = new ArrayList<>(dictEmployees.values());
        sortedEmployeesList.sort(Comparator.comparingDouble(Employee::getGrossSalary));

        for (Employee employee : sortedEmployeesList) {
            sortedEmployees += employee.getEmployeesInfo() + "\n"; 
        }
        return sortedEmployees;
    }


    }


