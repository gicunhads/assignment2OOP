package assignment3;
public class EmployeeFactory {


    public Manager createEmployee(String id, String name, double grossSalary, String degree)throws Exception {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        return new Manager(id, name, grossSalary, degree);


    }

    public  Director createEmployee(String id, String name, double grossSalary, String degree, String department)throws Exception {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        if (department == null || department.isEmpty()) {
            throw new InvalidEmployeeDataException(department);
        }
        return new Director(id, name, grossSalary, degree, department);
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
        return new Intern(id, name, grossSalary, gpa);
    }

    public Employee createEmployee(String id, String name, double grossSalary)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        return new Employee(id, name, grossSalary);
    }
}
