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
    
}
