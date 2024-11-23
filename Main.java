// here we will make the main
// i am testing 
public class Main {

    public static void main(String[] args) {

        Employee gigi = new Director("ididid", "gigi", 64532, "MSc", "Human Resources");
        Employee tyra = new Manager("ididi2", "tyra", 50983, "BSc");

        gigi.getEmployeesInfo();
        tyra.getEmployeesInfo();
        
        gigi.updateSalary(66666);
        gigi.getEmployeesInfo();
        System.out.println(tyra.getNetSalary());
        System.out.println(tyra.getTax());
        System.out.println(gigi.getTax());


    }
}