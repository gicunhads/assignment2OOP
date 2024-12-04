package assignment3;
import java.util.*;

public class Company {
    static EmployeeFactory factory;
         static HashMap<String, Employee> dictEmployees;
                         
                         
                         public Company() {
                             this.dictEmployees = new HashMap<>();
                             Company.factory = new EmployeeFactory();
                         }
                     
                     
                     
                         public static String createEmployee(String id, String name, double grossSalary, String degree) throws ValidationException{
                              Employee employee = factory.createEmployee(name, id, grossSalary, degree);
                              dictEmployees.put(id, employee); 
                     return printEmployee(id);
                             }
                             
                             public static String createEmployee(String id, String name, double grossSalary, String degree, String department) throws ValidationException {
                                Employee employee = factory.createEmployee(name, id, grossSalary, degree, department);
                                   dictEmployees.put(id, employee); 
                                  return printEmployee(id);
                             }
                         
                             public static String createEmployee(String id, String name, double grossSalary, int gpa) throws ValidationException{
                                Employee employee = factory.createEmployee(name, id, grossSalary, gpa);
                                  dictEmployees.put(id, employee); 
                                  return printEmployee(id);
                         }
                     
                         public static String createEmployee(String id, String name, double grossSalary) throws ValidationException {
                            Employee employee = factory.createEmployee(name, id, grossSalary);
                            dictEmployees.put(id, employee); 
                            return "Employee " + id + " was registered successfully.";
                        }
                        
                         }
                     
                         public void addEmployee(Employee employee){
                             if (dictEmployees.containsKey(employee.getID())) {
                                 throw new IllegalArgumentException("Employee " + employee.getID() + " is already registered.");
                             }
                             dictEmployees.put(employee.getID(), employee);
                             
                             System.out.println(String.format("Employee %s was registered successfully.", employee.getID()));
                         }
                     
                         
                         public String removeEmployee(String id) {
                             if (dictEmployees.containsKey(id)) {
                                 dictEmployees.remove(id);
                                 return ("Employee " + id + " was successfully removed.");
                             } else {
                                 throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
                             }
                         }
                     
                     
                         public static String printEmployee(String id) {
                if (dictEmployees.containsKey(id)) {
            Employee emp = dictEmployees.get(id);
           return emp.getEmployeesInfo();
        } else {
            throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
        }
    }


    public int getTotalNetSalary() {
        int totalNetSalary = 0;
        for (Employee employee : dictEmployees.values()){
            totalNetSalary += employee.getNetSalary();
    }
    return totalNetSalary;

}


    public Map<String, Integer> mapEachDegree() { 
        int bsc = 0;
        int msc = 0;
        int phd = 0;
        Map<String, Integer> employeeDegreeDetails = new HashMap<>();
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
        employeeDegreeDetails.put("BSc", bsc);
        employeeDegreeDetails.put("MSc", msc);
        employeeDegreeDetails.put("PhD", phd);
        return employeeDegreeDetails;
        
    }


    public String printAllEmployees() { 
        String allEmployees = "";
        for (Employee employee : dictEmployees.values()){
            allEmployees = employee.getEmployeesInfo() + " ";
        }
        return ("All registered employees:\n" + allEmployees);
    }


    public String updateGrossSalary(String id, double newSalary) {
        Employee emp = findEmployeeByID(id);
        emp.updateSalary(newSalary);
        return ("Employee " + id + " was updated successfully.");
    }


    public String updateEmployeeName(String id, String newName) {
        Employee emp = findEmployeeByID(id);
        emp.updateName(newName);
        return ("Employee " + id + " was updated successfully.");
    }


    public void addEmployee(String employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public static Employee findEmployeeByID(String id) {
            if (!dictEmployees.containsKey(id)) {
                throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
            }
            return dictEmployees.get(id);
        }
    
        public String printSortedEmployees(){
            String sortedEmployees = "Employees sorted by gross salary (ascending order):\n";
            List<Employee> sortedEmployeesList = new ArrayList<>(dictEmployees.values());
            sortedEmployeesList.sort(Comparator.comparingDouble(Employee::getGrossSalary));
    
            for (Employee employee : sortedEmployeesList) {
                sortedEmployees += employee.getEmployeesInfo() + "\n"; 
            }
            return sortedEmployees;
        }
    
        public static double getNetSalary(String empID){
            Employee emp = findEmployeeByID(empID);
            return emp.getNetSalary();

    }

    public String promoteToDirector(String empID, String degree, String department){
        String s = "";
        return s;
        
    }
    public String promoteToManager(String empID, String degree){
        String s = "";
        return s;
    }
    public String promoteToIntern(String empID, int GPA){
        String s = "";
        return s;
    }
    public String updateInternGPA(String empID, int GPA){
        String s = "";
        return s;
    }
    public String updateManagerDegree(String empID, String degree){
        String s = "";
        return s;
    }
    public String updateDirectorDept(String empID, String department){
        String s = "";
        return s;
    }
    
    }


