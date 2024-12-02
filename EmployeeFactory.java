public class EmployeeFactory {

    public static Manager createManager(String name, String id, double grossSalary, String degree)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        return new Manager(name, id, grossSalary, degree);
       
        
    }

    public static Director createDirector(String name, String id, double grossSalary, String degree, String department)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        if (department == null || department.isEmpty()) {
            throw new InvalidEmployeeDataException(department);
        }
        return new Director(name, id, grossSalary, degree, department);
    }

    public static Intern createIntern(String name, String id, double grossSalary, int gpa) throws ValidationException{
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        if (gpa < 0 || gpa > 4) {
            throw new InvalidGpaException(gpa);
        }
        return new Intern(name, id, grossSalary, gpa);
    }

    public static Employee createRegularEmployee(String name, String id, double grossSalary)throws ValidationException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeDataException(name);
        }
        if (grossSalary < 0) {
            throw new InvalidSalaryException(grossSalary);
        }
        return new Employee(name, id, grossSalary);
    }
}
