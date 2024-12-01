
public class EmployeeFactory {
    public static Employee createEmployee(String employeeType, String name, String id, double grossSalary, String degree) {
        if (employeeType.toLowerCase() == "manager") {
            return new Manager(name, id, grossSalary, degree);
        } else {
            throw new IllegalArgumentException("Invalid employee type or missing arguments.");
        }
    }

    public static Employee createEmployee(String employeeType, String name, String id, double grossSalary, String degree, String department) {
        if (employeeType.toLowerCase() == "director") {
            return new Director(name, id, grossSalary, degree, department);
        } else {
            throw new IllegalArgumentException("Invalid employee type or missing arguments.");
        }
    }

    public static Employee createEmployee(String employeeType, String name, String id, double grossSalary, int gpa) {
        if (employeeType.toLowerCase() == "intern") {
            return new Intern(name, id, grossSalary, gpa);
        } else {
            throw new IllegalArgumentException("Invalid employee type or missing arguments.");
        }
    }
}
