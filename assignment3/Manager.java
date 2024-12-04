package assignment3;
import java.util.List;

public class Manager extends Employee {

    String degree;
    double originalGrossSalary;

    //constructor 
    public Manager(String ID, String name, double grossSalary, String degree){
        super(ID, name, grossSalary);
        this.degree = degree.trim().toLowerCase();
        if (!List.of("bsc", "msc", "phd").contains(this.degree)) {
            throw new IllegalArgumentException("Invalid degree.");
        }
        this.tax = 0.1;
        this.originalGrossSalary = grossSalary;
        this.grossSalary = grossSalary  * (1 + this.getBonus());

        System.out.println(String.format("Manager %s was registered successfully", ID));
    }

    public String getDegree(){
        return this.degree;
    }

    public double getBonus(){
        switch (this.getDegree()){
            case "bsc" -> {return 0.10;}

            case "msc" ->  {return 0.20;}

            case "phd" -> {return 0.35;}

            default -> throw new IllegalArgumentException("Invalid degree type");

        }
    }


    @Override
    public String getEmployeesInfo(){
        String degreeFormatted = "";
        
        if (this.degree.equalsIgnoreCase("phd")) {
            degreeFormatted = "PhD";
        } else if (this.degree.equalsIgnoreCase("msc")) {
            degreeFormatted = "MSc";
        } else if (this.degree.equalsIgnoreCase("bsc")) {
            degreeFormatted = "BSc";
        }
        return (String.format("%s %s's gross salary is %.2f SEK per month.", degreeFormatted, this.name, getGrossSalary())); // be sure it is with bonus
    }

}