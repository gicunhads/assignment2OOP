// here we will make the main
// i am testing 
public class Main {

    public static void main(String[] args) {

        Employee gigi = new Director("ididid", "gigi", 64532, "MSc", "Human Resources");
        Employee tyra = new Manager("ididi2", "tyra", 50983, "BSc");
        Employee leo = new Intern("ididid3", "leo", 15000, 7);

        gigi.getEmployeesInfo();
        tyra.getEmployeesInfo();
        leo.getEmployeesInfo();
        
        gigi.updateSalary(66666);
        gigi.getEmployeesInfo();
        leo.getGrossSalary();
        leo.getGrossSalary();
        leo.getEmployeesInfo();
        System.out.println(tyra.getNetSalary());
        System.out.println(tyra.getTax());
        System.out.println(gigi.getTax());


    }
}