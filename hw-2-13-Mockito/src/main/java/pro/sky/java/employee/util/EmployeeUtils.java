package pro.sky.java.employee.util;

import java.math.BigDecimal;
import java.util.Random;

public final class EmployeeUtils {

    private static final Random random = new Random();
    static BigDecimal generateRandomSalary() {
        return new BigDecimal(240_000 + 8_000 * random.nextInt(30));
    }

    static int generateRandomDepartmentId() {
        return random.nextInt(EmployeeConstants.DEPARTMENT_COUNT) + 1;
    }

}
