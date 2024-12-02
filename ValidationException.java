
abstract class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

class InvalidSalaryException extends ValidationException {
    public InvalidSalaryException(double salary) {
        super("Invalid salary: " + salary);
    }
}

// Specific exception for invalid employee data (like empty name)
class InvalidEmployeeDataException extends ValidationException {
    public InvalidEmployeeDataException(String name) {
        super("Invalid employee name: " + name);
    }
}

// Specific exception for invalid GPA (for Interns)
class InvalidGpaException extends ValidationException {
    public InvalidGpaException(int gpa) {
        super("Invalid GPA: " + gpa);
    }
}
