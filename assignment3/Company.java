package assignment3;
import java.util.*;

public class Company {
    static EmployeeFactory factory;
    private LinkedHashMap<String, Employee> dictEmployees = new LinkedHashMap<>();


    public Company() {
        Company.factory = new EmployeeFactory();
    }


    // creation of employees with overloading: 
    public  String createEmployee(String id, String name, double grossSalary, String degree) throws Exception{
        if (dictEmployees.containsKey(id)) {
            String errorMessage = String.format("Cannot register. ID %s is already registered.", id);
            throw new Exception(errorMessage);
        } else if (id.isBlank()) {
            String errorMessage = "ID cannot be blank.";
            throw new Exception(errorMessage);
        } else if (name.isBlank()) {
            String errorMessage = "Name cannot be blank.";
            throw new Exception(errorMessage);
        } else if (grossSalary <= 0) {
            String errorMessage = "Salary must be greater than zero.";
            throw new Exception(errorMessage);
        } else {
            Employee employee = factory.createEmployee(id, name, grossSalary, degree);
            dictEmployees.put(id, employee);
            return String.format("Employee %s was registered successfully.", id);
        }
    }


    public  String createEmployee(String id, String name, double grossSalary, String degree, String department) throws Exception {
        if (dictEmployees.containsKey(id)) {
            String errorMessage = String.format("Cannot register. ID %s is already registered.", id);
            throw new Exception(errorMessage);
        } else if (id.isBlank()) {
            String errorMessage = "ID cannot be blank.";
            throw new Exception(errorMessage);
        } else if (name.isBlank()) {
            String errorMessage = "Name cannot be blank.";
            throw new Exception(errorMessage);
        } else if (grossSalary <= 0) {
            String errorMessage = "Salary must be greater than zero.";
            throw new Exception(errorMessage);
        } else {
            Employee employee = factory.createEmployee(id, name, grossSalary, degree, department);
            dictEmployees.put(id, employee);
            return String.format("Employee %s was registered successfully.", id);
        }
    }

    public  String createEmployee(String id, String name, double grossSalary, int gpa) throws Exception{
        if (dictEmployees.containsKey(id)) {
            String errorMessage = String.format("Cannot register. ID %s is already registered.", id);
            throw new Exception(errorMessage);
        } else if (id.isBlank()) {
            String errorMessage = "ID cannot be blank.";
            throw new Exception(errorMessage);
        } else if (name.isBlank()) {
            String errorMessage = "Name cannot be blank.";
            throw new Exception(errorMessage);
        } else if (grossSalary <= 0) {
            String errorMessage = "Salary must be greater than zero.";
            throw new Exception(errorMessage);
        } else if (gpa < 0 && gpa > 10) {
            String errorMessage = String.format("%d outside range. Must be between 0-10.", gpa);
            throw new Exception(errorMessage);
        } else {
            Employee employee = factory.createEmployee(id, name, grossSalary, gpa);
            dictEmployees.put(id, employee);
            return String.format("Employee %s was registered successfully.", id);
        }
    }

    public  String createEmployee(String id, String name, double grossSalary) throws Exception {
        if (dictEmployees.containsKey(id)) {
            String errorMessage = String.format("Cannot register. ID %s is already registered.", id);
            throw new Exception(errorMessage);
        } else if (id.isBlank()) {
            String errorMessage = "ID cannot be blank.";
            throw new Exception(errorMessage);
        } else if (name.isBlank()) {
            String errorMessage = "Name cannot be blank.";
            throw new Exception(errorMessage);
        } else if (grossSalary <= 0) {
            String errorMessage = "Salary must be greater than zero.";
            throw new Exception(errorMessage);
        } else {
            Employee employee = factory.createEmployee(id, name, grossSalary);
            dictEmployees.put(id, employee);
            return String.format("Employee %s was registered successfully.", id);
        }
    }

    


    public String removeEmployee(String id) throws Exception {
        if (dictEmployees.containsKey(id)) {
            dictEmployees.remove(id);
            return ("Employee " + id + " was successfully removed.");
        } else {
            throw new Exception("Employee " + id + " was not registered yet.");
        }
    }

    public  Employee findEmployeeByID(String id) throws Exception {
        if (!dictEmployees.containsKey(id)) {
            throw new Exception("Employee " + id + " was not registered yet.");

        }
        return dictEmployees.get(id);
    }
    
    
    public String printEmployee(String id) throws Exception {
        if (dictEmployees.containsKey(id)) {
            Employee emp = dictEmployees.get(id);
            return emp.getEmployeesInfo();
        } else {
            throw new Exception("Employee " + id + " was not registered yet.");
        }
    }
    

    public String printAllEmployees() throws Exception {


        if (dictEmployees.isEmpty()){
            String errorMessage = String.format("No employees registered yet.");
            throw new Exception(errorMessage);
        } else


        {
            StringBuilder allEmployees = new StringBuilder("All registered employees:\n");

            boolean first = true; // Flag to manage spacing between employees, matching printing in codegrade
            for (Employee employee : dictEmployees.values()) {
                if (!first) {
                    allEmployees.append("\n");
                }
                allEmployees.append(employee.getEmployeesInfo());
                first = false;
            }
            return allEmployees.toString() + "\n";
        }
    }

    public String printSortedEmployees() throws Exception {


        if (dictEmployees.isEmpty()){
            String errorMessage = "No employees registered yet.";
            throw new Exception(errorMessage);
        } else


        {
            String sortedEmployees = "Employees sorted by gross salary (ascending order):\n";
            List<Employee> sortedEmployeesList = new ArrayList<>(dictEmployees.values());
            sortedEmployeesList.sort(Comparator.comparingDouble(Employee::getGrossSalary)); // comparing gross Salaries of employees

            for (Employee employee : sortedEmployeesList) {
                sortedEmployees += employee.getEmployeesInfo() + "\n";
            }
            return sortedEmployees;
        }
    }


    // salaries
    public  double getNetSalary(String empID) throws Exception{
        Employee emp = findEmployeeByID(empID);
        return DoubleFormat.round(emp.getNetSalary());

    }

    public double getTotalNetSalary() throws Exception {
        if (dictEmployees.isEmpty()){
            String errorMessage = "No employees registered yet.";
            throw new Exception(errorMessage);
        } else {
            double totalNetSalary = 0;
            for (Employee employee : dictEmployees.values()) {

                totalNetSalary += DoubleFormat.round(employee.getNetSalary());
            }
            return DoubleFormat.round(totalNetSalary);
        }
    }



    // update methods

    public String updateGrossSalary(String id, double newSalary) throws Exception {
        if (newSalary <= 0) {
            throw new Exception("Salary must be greater than zero.");
        } else {
            Employee emp = findEmployeeByID(id);
            emp.updateSalary(newSalary);
            return ("Employee " + id + " was updated successfully");
        }
    }


    public String updateEmployeeName(String id, String newName) throws Exception {
        if (newName.isBlank()) {
            String errorMessage = "Name cannot be blank.";
            throw new Exception(errorMessage);
        } else {
            Employee emp = findEmployeeByID(id);
            emp.updateName(newName);
            return ("Employee " + id + " was updated successfully");
        }
    }


    public String updateInternGPA(String empID, int GPA) throws Exception{
        Employee emp = findEmployeeByID(empID);
        if (emp instanceof Intern intern) {
            intern.updateGPA(GPA);

            double salary = intern.OriginalSalary;


            if (0 <= GPA && GPA <= 5) {
                emp.updateSalary(0);  // No salary for GPA < 5
            } else if (5 < GPA && GPA <= 8) {
                emp.updateSalary(salary );
            } else if (8 < GPA && GPA <= 10) {
                emp.updateSalary(salary  + 1000); // Bonus for high GPA case
            } else {
                String errorMessage = String.format("%d outside range. Must be between 0-10.", GPA);
                throw new Exception(errorMessage);
            }

        }
        return ("Employee " + empID + " was updated successfully");
    }



    public String updateManagerDegree(String empID, String degree) throws Exception{
        Employee emp = findEmployeeByID(empID);

        if (emp instanceof Manager manager) {
            double initialSalary = emp.getGrossSalary();


            String normalizedDegree = degree.trim().toLowerCase();
            if (!List.of("bsc", "msc", "phd").contains(normalizedDegree)) {
                throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
            }
            manager.setDegree(normalizedDegree);

            if (!(emp instanceof Director)) {

                switch (normalizedDegree) {
                    case "bsc" -> manager.updateSalary(initialSalary * 1.10);
                    case "msc" -> manager.updateSalary(initialSalary * 1.20);
                    case "phd" -> manager.updateSalary(initialSalary * 1.35);
                }
            }
        }
        if (!degree.equalsIgnoreCase("PhD") && !degree.equalsIgnoreCase("MSc") && !degree.equalsIgnoreCase("BSc")) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }



        return "Employee " + empID + " was updated successfully";}


    public String updateDirectorDept(String empID, String department) throws Exception{
        Employee emp = findEmployeeByID(empID);


        if (emp instanceof Director director) {


            director.setDepartment(department);


            double totalSalary = emp.getGrossSalary();

            director.updateSalary(totalSalary + 5000);
        }

        if (!department.equalsIgnoreCase("Business") && !department.equalsIgnoreCase("Human Resources") && !department.equalsIgnoreCase("Technical")) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }

        return "Employee " + empID + " was updated successfully";}


    // promote methods

    public String promoteToDirector(String empID, String degree, String department) throws Exception{
        Employee emp = findEmployeeByID(empID);

        if (emp instanceof Manager) {

            Director director = new Director(empID, emp.getName(), emp.getGrossSalary(), degree, department);

            dictEmployees.put(empID, director);

            return "Employee " + empID + " was updated successfully";
        } else {
            return "Employee " + empID + " is not eligible for promotion to Director";
        }

    }
    public String promoteToManager(String empID, String degree) throws Exception{

        Employee emp = findEmployeeByID(empID);

        if (emp != null) {

            if (!degree.equalsIgnoreCase("PhD") && !degree.equalsIgnoreCase("MSc") && !degree.equalsIgnoreCase("BSc")) {
                throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
            }


            Manager manager = new Manager(empID, emp.getName(), emp.getGrossSalary(), degree);
            dictEmployees.put(empID, manager);

            return ("Employee " + empID + " was updated successfully");
        }
        return "Employee " + empID + " is not eligible for promotion to Manager";
    }


    public String promoteToIntern(String empID, int GPA) throws Exception{
        Employee emp = findEmployeeByID(empID);

        if (emp != null) {

            Intern intern = new Intern(empID, emp.getName(), emp.getGrossSalary(), GPA);


            dictEmployees.put(empID, intern);

            return ("Employee " + empID + " was updated successfully");
        } else
            return  ("Employee " + empID + " is not eligible for promotion to Intern");

    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        if (dictEmployees.isEmpty()) {
            throw new Exception("No employees registered yet.");
        }

        int bsc = 0;
        int msc = 0;
        int phd = 0;

        Map<String, Integer> employeeDegreeDetails = new HashMap<>();

        // Count degrees
        for (Employee employee : dictEmployees.values()) {
            if (employee instanceof Manager manager) {
                String degree = manager.getDegree();
                if (degree.equalsIgnoreCase("bsc")) {
                    bsc += 1;
                } else if (degree.equalsIgnoreCase("msc")) {
                    msc += 1;
                } else if (degree.equalsIgnoreCase("phd")) {
                    phd += 1;
                }
            }
        }

        // Add keys for degrees only if their count is > 0
        if (bsc > 0) {
            employeeDegreeDetails.put("BSc", bsc);
        }
        if (msc > 0) {
            employeeDegreeDetails.put("MSc", msc);
        }
        if (phd > 0) {
            employeeDegreeDetails.put("PhD", phd);
        }

        return employeeDegreeDetails;
    }




}
