/*The manager is an employee hired by his/her academic performance: 
she / he has a degree can be a BSc., MSc. and PhD. Each of those values yield a bonus of, respectively, 
10%, 20% and 35% to his/her gross salary. 

Note that the degree of a Manager is defined when creating the
 Manager and can be updated, thus automatically adjusting his/her gross salary.
  Be careful not to lose the original gross salary established in the Employee’s creation, 
  since the bonus is not cumulative!! 
  
  For instance: Mary has a gross salary of 10,000 SEK. With a BSc. 
  her gross salary will receive a bonus of 10% (1,000 SEK). When Mary gets a MSc., her bonus will be 20% of her 
  initial gross salary, hence 2,000 SEK. 

String representation for Managers:

<degree> <name>’s gross salary is <gross_salary> SEK per month. */

import java.util.List;

public class Manager extends Employee {    

    String degree;
    double originalGrossSalary; // storing the original gross salary
    
    //constructor 
    public Manager(String ID, String name, double grossSalary, String degree){
        super(ID, name, grossSalary);     
        this.degree = degree.trim().toLowerCase(); 
        if (!List.of("bsc", "msc", "phd").contains(degree)) {
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
            case "Bsc" -> {return 0.10;}
            
            case "Msc" ->  {return 0.20;}

            case "PhD" -> {return 0.35;}

            default -> throw new IllegalArgumentException("Invalid degree type");

        }
    }


    @Override
    public void getEmployeesInfo(){
        System.out.println(String.format("%s %s's gross salary is %.2f SEK per month.", this.degree, this.name, grossSalary)); // be sure it is with bonus
    }

    }
    



