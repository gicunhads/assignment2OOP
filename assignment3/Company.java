package assignment3;
import java.util.*;

public class Company {
    static EmployeeFactory factory;
    private LinkedHashMap<String, Employee> dictEmployees = new LinkedHashMap<>();


    public Company() {
        Company.factory = new EmployeeFactory();
    }



    public  String createEmployee(String id, String name, double grossSalary, String degree) throws ValidationException{
        Employee employee = factory.createEmployee(id, name, grossSalary, degree);
        dictEmployees.put(id, employee);
        return String.format("Employee %s was registered successfully.", id);
    }

    public  String createEmployee(String id, String name, double grossSalary, String degree, String department) throws ValidationException {
        Employee employee = factory.createEmployee(id, name, grossSalary, degree, department);
        dictEmployees.put(id, employee);
        return String.format("Employee %s was registered successfully.", id);
    }

    public  String createEmployee(String id, String name, double grossSalary, int gpa) throws ValidationException{
        Employee employee = factory.createEmployee(id, name, grossSalary, gpa);
        dictEmployees.put(id, employee);
        return String.format("Employee %s was registered successfully.", id);
    }

    public  String createEmployee(String id, String name, double grossSalary) throws ValidationException {
        Employee employee = factory.createEmployee(id, name,  grossSalary);
        dictEmployees.put(id, employee);
        return String.format("Employee %s was registered successfully.", id);
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


    public String printEmployee(String id) {
        if (dictEmployees.containsKey(id)) {
            Employee emp = dictEmployees.get(id);
            return emp.getEmployeesInfo();
        } else {
            throw new IllegalArgumentException("Employee " + id + " was not registered yet.");
        }
    }


    public double getTotalNetSalary() {
        double totalNetSalary = 0;
        for (Employee employee : dictEmployees.values()){
            
            totalNetSalary += DoubleFormat.round(employee.getNetSalary());
        }
        return DoubleFormat.round(totalNetSalary);

    }


    public Map<String, Integer> mapEachDegree() {
        
        int bsc = 0;
        int msc = 0;
        int phd = 0;
        
       
        Map<String, Integer> employeeDegreeDetails = new HashMap<>();
        
        
        for (Employee employee : dictEmployees.values()) {
            if (employee instanceof Manager manager) {
                String degree = manager.getDegree();
                if (degree.equalsIgnoreCase("bsc")) {
                    bsc += 1;
                } else if (degree.equalsIgnoreCase("msc")) {
                    msc += 1;
                }
            } else if (employee instanceof Director director) {
                String degree = director.getDegree();
                if (degree.equalsIgnoreCase("bsc")) {
                    bsc += 1;
                } else if (degree.equalsIgnoreCase("msc")) {
                    msc += 1;
                } else if (degree.equalsIgnoreCase("phd")) {
                    phd += 1;
                }
            }
        }
        
        
        if (bsc > 0) {
            employeeDegreeDetails.put("BSc", bsc);
        } else {
            
            employeeDegreeDetails.put("BSc", null);  
        }
    
        if (msc > 0) {
            employeeDegreeDetails.put("MSc", msc);
        } else {
            
            employeeDegreeDetails.put("MSc", null);  
        }
    
        if (phd > 0) {
            employeeDegreeDetails.put("PhD", phd);
        } else {
            
            employeeDegreeDetails.put("PhD", null);  
        }
    
       
        return employeeDegreeDetails;
    }
    


    public String printAllEmployees() {
        StringBuilder allEmployees = new StringBuilder("All registered employees:\n");

        boolean first = true; // Flag to manage spacing between employees
        for (Employee employee : dictEmployees.values()) {
            if (!first) {
                allEmployees.append("\n"); 
            }
            allEmployees.append(employee.getEmployeesInfo()); 
            first = false;
        }
    
        
        return allEmployees.toString() + "\n";
    }



    public String updateGrossSalary(String id, double newSalary) {
        Employee emp = findEmployeeByID(id);
        emp.updateSalary(newSalary);
        return ("Employee " + id + " was updated successfully");
    }


    public String updateEmployeeName(String id, String newName) {
        Employee emp = findEmployeeByID(id);
        emp.updateName(newName);
        return ("Employee " + id + " was updated successfully");
    }


    public void addEmployee(String employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public  Employee findEmployeeByID(String id) {
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

    public  double getNetSalary(String empID){
        Employee emp = findEmployeeByID(empID);
        return DoubleFormat.round(emp.getNetSalary());

    }

    public String promoteToDirector(String empID, String degree, String department){
        Employee emp = findEmployeeByID(empID);
    
    if (emp instanceof Manager) {
        
        Director director = new Director(empID, emp.getName(), emp.getGrossSalary(), degree, department);  
        
        dictEmployees.put(empID, director);  
        
        return "Employee " + empID + " was updated successfully";
    } else {
        return "Employee " + empID + " is not eligible for promotion to Director";
    }

    }
    public String promoteToManager(String empID, String degree){

        Employee emp = findEmployeeByID(empID);
    
        if (emp instanceof Employee) {

            if (!degree.equalsIgnoreCase("PhD") && !degree.equalsIgnoreCase("MSc") && !degree.equalsIgnoreCase("BSc")) {
                throw new IllegalArgumentException("Invalid degree type");
            }
            
       
        Manager manager = new Manager(empID, emp.getName(), emp.getGrossSalary(), degree);  
        dictEmployees.put(empID, manager);

        return ("Employee " + empID + " was updated successfully");
    }    
        return "Employee " + empID + " is not eligible for promotion to Manager";
    }


    public String promoteToIntern(String empID, int GPA){
        Employee emp = findEmployeeByID(empID);
    
    if (emp instanceof Employee) {
       
        Intern intern = new Intern(empID, emp.getName(), emp.getGrossSalary(), GPA);  
        
        
        dictEmployees.put(empID, intern);  
        
        return ("Employee " + empID + " was updated successfully");
    } else 
        return  ("Employee " + empID + " is not eligible for promotion to Intern");

    }





    public String updateInternGPA(String empID, int GPA){
        Employee emp = findEmployeeByID(empID);
        if (emp instanceof Intern) {
            Intern intern = (Intern) emp;
            intern.updateGPA(GPA);
           
            intern.OriginalSalary = emp.getGrossSalary();
            

            if (0 <= GPA && GPA <= 5) {
                emp.updateSalary(0);  // No salary for GPA < 5
            } else if (5 < GPA && GPA <= 8) {
                 emp.updateSalary(intern.OriginalSalary );
            } else if (8 < GPA && GPA <= 10) {
                emp.updateSalary(intern.OriginalSalary  + 1000); // Bonus for high GPA case
            } else {
                System.out.println("Invalid GPA value. Please enter a value between 0 and 10");
            }
  
        }
        return ("Employee " + empID + " was updated successfully");
    }




    public String updateManagerDegree(String empID, String degree){
        Employee emp = findEmployeeByID(empID);
    
        if (emp instanceof Manager) {
            Manager manager = (Manager) emp; 
            double initialSalary = emp.getGrossSalary();  
            
            
            String normalizedDegree = degree.trim().toLowerCase();
            if (!List.of("bsc", "msc", "phd").contains(normalizedDegree)) {
            return "Invalid degree type";
        } 
        manager.setDegree(degree);
    
            
            if (degree.equals("BSc")) {
                manager.updateSalary(initialSalary * 1.10);  
            } else if (degree.equals("MSc")) {
                manager.updateSalary(initialSalary * 1.20);  
            } else if (degree.equals("PhD")) {
                manager.updateSalary(initialSalary * 1.35);  
            }
        }
        if (!degree.equalsIgnoreCase("PhD") && !degree.equalsIgnoreCase("MSc") && !degree.equalsIgnoreCase("BSc")) {
            throw new IllegalArgumentException("Invalid degree type");
        }
        
        
        
        return "Employee " + empID + " was updated successfully";}


    public String updateDirectorDept(String empID, String department){
        Employee emp = findEmployeeByID(empID);
    
        
        if (emp instanceof Director) {
        Director director = (Director) emp;
        
        director.setDepartment(department);  

        double initialSalary = emp.getGrossSalary();  
        double departmentBonus = 5000.00;
        
        director.updateSalary(initialSalary + departmentBonus);  

       
        double totalSalary = emp.getGrossSalary();  
        double tax = 0.0;
        
        if (totalSalary < 30000) {
            tax = totalSalary * 0.10;
        } else if (totalSalary <= 50000) {
            tax = totalSalary * 0.20;
        } else {
            tax = (30000 * 0.20) + ((totalSalary - 30000) * 0.40);
        }

    
            director.updateSalary(totalSalary - tax);
        }
    
        return "Employee " + empID + " was updated successfully";}
    
    
}
