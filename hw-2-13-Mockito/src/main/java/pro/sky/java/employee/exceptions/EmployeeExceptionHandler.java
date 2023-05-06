package pro.sky.java.employee.exceptions;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundExceptionHandler(@NotNull EmployeeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());


    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<String> employeeAlreadyAddedException(@NotNull EmployeeAlreadyAddedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(IncorrectNameException.class)
    public ResponseEntity<String> illegalNameExceptionHandler(@NotNull IncorrectNameException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());


    }

}
