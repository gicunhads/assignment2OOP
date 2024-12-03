package assignment3;
public class EmployeeFactory {


    public static Manager createEmployee(String name, String id, double grossSalary, String degree)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        Manager manager = new Manager(name, id, grossSalary, degree);
        return manager;
       
        
    }

    public static Director createEmployee(String name, String id, double grossSalary, String degree, String department)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        if (department == null || department.isEmpty()) {
            throw new InvalidEmployeeDataException(department);
        }
        Director director = new Director(name, id, grossSalary, degree, department);
        return director;
    }

    public static Intern createEmployee(String name, String id, double grossSalary, int gpa) throws ValidationException{
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        if (gpa < 0 || gpa > 4) {
            throw new InvalidGpaException(gpa);
        }
        Intern intern = new Intern(name, id, grossSalary, gpa);
        return intern;
    }

    public static Employee createEmployee(String name, String id, double grossSalary)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        Employee employee = new Employee(name, id, grossSalary);
        return employee;
    }
}
