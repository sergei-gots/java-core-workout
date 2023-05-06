package pro.sky.java.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() { super();   }

    @Override
    public String getMessage() {
        return "There are no vacancies in company and no possibilities to add a new employee at the time... Try do it later";
    }
}
