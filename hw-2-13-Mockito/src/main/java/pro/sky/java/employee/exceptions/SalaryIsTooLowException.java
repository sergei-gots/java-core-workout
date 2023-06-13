package pro.sky.java.employee.exceptions;

public class SalaryIsTooLowException extends EmployeeException {
    @Override
    public String getMessage() {
        return "Employee's labour is undervalued.";
    }
}
