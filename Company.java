/*The company begins with no Employee registered and should: i) register, 
ii) remove, iii) retrieve, iv) update its employees, calculate the total expenses by paying 
v) gross salaries and vi) net salaries, and, finally, vii) inform the total number of employees registered. 
In addition, be aware of the following cases: 

When registering an employee, the company receives his/her ID, name and gross salary.
To find an Employee in your company, you should specify his/her ID. 
This search should be reusable when trying to remove an employee or updating his/her information. 
In other words, the Company should operate on Employees based on their IDs.
Remember to provide the most modular way of updating an employee’s information, 
since two pieces of information can be updated: salary (with a double) and name (with a String). 
In both situations, the program receives the Employee’s ID to search the employee. For example:

company.updateName(String id, String newName);
company.updateSalary(String id, double newSalary);
Creating different types of employees

Remove employees to keep my payroll updated (1.4)
To remove an employee, the user must specify the ID of the employee that should be removed.
 When trying to remove you should check whether the system contains the specified employee ID in 
 its collection of registered employees. 

If the employee was successfully removed, print the message: "Employee <ID> was successfully removed.".

See an overview of all employees’ information (1.5 and 1.6)
You should create a string with one employee per line, following the template below. 
You should replace the <employee_string> to the specific string for each type of employee specified above.

All registered employees:
<employee_string>
<employee_string>
<employee_string>
<employee_string>
To retrieve a string of an employee, The customer then needs to specify the ID
 of the employee that it wants to get the string from. The program should then retrieve the employee as
  specified in their respective description (above)!!

Total paid in net salaries to see my expenses with employees
Your system should print the sum of all net salaries for all employees. Similarly to all salaries, 
the system should truncate the result of this operation in two decimal values.

Retrieve employees sorted by gross salary
We want to print a sorted list of employees by gross salary to see which employees are paid more and less than others.
 Your system should print a list of employees in ascending order based on their gross salary. Note that this should be 
 sorted based on the value of the gross salary after any bonuses. The list should follow the template below:

Employees sorted by gross salary (ascending order):
<employee_string>
<employee_string>
<employee_string>
<employee_string>
Change information of employees so we can keep their personal information updated (1.9)
Your program should allow updates on different information of the Employee. Since each employee has 
specific information, we listed below the options that can be changed:

Regular employees (applicable to all): Can change name and gross salary.
Manager: Can change his/her degree.
Director: Can change his/her degree and department.
Intern: Can change his/her GPA.
When the update is successful, the system should print the message: “Employee <ID> was updated successfully”

Show the number of employees per degree (1.10)
Goal: print the number of employees for each degree to get an overview of the academic background of 
my managers and directors. Your system should retrieve a string summarising the number of employees 
registered that have: BSc., MSc and PhD. Note that this is only applicable to Managers and Directors.
 The program should print following the same template where <number> is the number of employees with the corresponding degree.

Academic background of employees:
BSc: => <number>
MSc: => <number>
PhD: => <number>
If there are no employees registered with a specific degree, the corresponding row is simply not printed.

Specific employee not found or not registered yet (2.1)
You are expected to use and handle Exceptions in your code. For instance, there are multiple cases in which 
an employee may not be found during the operation (e.g., during removal, printing, promotion, etc.). 
To handle those cases in which a desired employee ID is not found in our system, you should create and handle an
 Exception with the following message: "Employee <ID> was not registered yet." 

You must also handle errors when trying to register an employee with an ID that was already registered. 
In those cases, you should create and handle an Exception with the message: "Cannot register. ID <id> is already registered."*/

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public abstract class Company {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Employee> dictEmployees = new HashMap<>(); 
    EmployeeFactory employeeFactory = new EmployeeFactory(); // employee factory
    
    public abstract void removeEmployee(String id, String newName); // to get employee's id use the method this.ID();

    public abstract void retriveEmployee(String id, String newName);

    public abstract int totalNetValue();

    public abstract String employeeDegreeDetails();

    public abstract String allEmployeeDetails();

    public abstract void updateSalary(String id, String newName); 

    public abstract void updateName(String id, String newName);
}












