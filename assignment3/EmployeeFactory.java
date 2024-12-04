package assignment3;
public class EmployeeFactory {


    public Manager createEmployee(String id, String name, double grossSalary, String degree)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        Manager manager = new Manager(name, id, grossSalary, degree);
        return manager;
       
        
    }

    public static Director createEmployee(String id, String name, double grossSalary, String degree, String department)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        if (department == null || department.isEmpty()) {
            throw new InvalidEmployeeDataException(department);
        }
        Director director = new Director(id, name, grossSalary, degree, department);
        return director;
    }

    public Intern createEmployee(String id, String name, double grossSalary, int gpa) throws ValidationException{
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        if (gpa < 0 || gpa > 10) {
            throw new InvalidGpaException(gpa);
        }
        Intern intern = new Intern(name, id, grossSalary, gpa);
        return intern;
    }

    public Employee createEmployee(String id, String name, double grossSalary)throws ValidationException {
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
