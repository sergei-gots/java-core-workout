package pro.sky.java.employee.exceptions;

public class EmployeeStorageIsFullException extends EmployeeException {
    public EmployeeStorageIsFullException() { super();   }

    @Override
    public String getMessage() {
        return "There are no vacancies in company and no possibilities to add a new employee at the time... Try do it later";
    }
}
