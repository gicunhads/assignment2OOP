/* The director is a manager that achieved professional merit and is hired to lead a specific Department that can be: 
Human Resources, Technical, and Business. The department is specified when creating the Director.
 To lead a department, a director receives an additional salary of 5,000 SEK that cannot be changed. 
 The director’s benefit is added to his/her gross salary for both the gross and net salary calculation 
 (on top of the degree bonus). Conversely, director’s have a specific way of calculating the net salary based on their
  total gross salary (including the benefit). If the gross salary (including all bonuses) calculated for a director is:

Less than 30,000 SEK: the director pays the same taxation as a regular employee (10%) on their final gross salary.
Between 30,000 and 50,000 SEK: the director will pay 20% taxes on their gross income.
Greater than 50,000 SEK: he/she will pay 20% of taxes for the 30,000 SEK and 40% taxes on the amount that is greater 
than 30,000. 

String representation for Directors (note: all in the same line):

<degree> <name>’s gross salary is <gross_salary> SEK per month. Dept: <department>
*/


public class Director extends Manager {
    
    String department;

    public Director(String ID, String name, double grossSalary, String degree, String department) {
        super(ID, name, grossSalary, degree);
        this.department = department;
        this.tax = this.getTax();
        this.grossSalary = this.getGrossSalary(); // does it considers the real tax? be careful
        
        System.out.println(String.format("Director %s was registered successfully", ID));
    }

    @Override
    public double getGrossSalary() {
        grossSalary = (super.grossSalary * (1 + this.getBonus())+ 5000);
        return Double.parseDouble(String.format("%.2f", grossSalary));
    }

    @Override
    public double getTax(){
        if (this.getGrossSalary() < 30000) {
            return 0.10;
        } else if (this.getGrossSalary() <= 50000) { 
            return 0.20;
        } else { 
            return 0.30;
        }
        }
    
    @Override
    public void getEmployeesInfo(){
            System.out.println(String.format("%s %s's gross salary is %.2f SEK per month. Dept: %s", this.degree, this.name, grossSalary, this.department)); // be sure it is with bonus
        }
   
    }


