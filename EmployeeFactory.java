public class EmployeeFactory {

    public static Manager createManager(String name, String id, double grossSalary, String degree) {
        return new Manager(name, id, grossSalary, degree);
    }

    public static Director createDirector(String name, String id, double grossSalary, String degree, String department) {
        return new Director(name, id, grossSalary, degree, department);
    }

    public static Intern createIntern(String name, String id, double grossSalary, int gpa) {
        return new Intern(name, id, grossSalary, gpa);
    }

    public static Employee createRegularEmployee(String name, String id, double grossSalary) {
        return new Employee(name, id, grossSalary);
    }
}
