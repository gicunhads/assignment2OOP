
public class Main {

    public static void main(String[] args) throws ValidationException {
        MyCompany company = new MyCompany();
        Employee katherine = EmployeeFactory.createRegularEmployee("Katherine Johnson", "IDa", 50000.00);
        company.addEmployee("IDa");


    }
}