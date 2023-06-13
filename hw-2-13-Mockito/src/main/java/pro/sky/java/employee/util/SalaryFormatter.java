package pro.sky.java.employee.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryFormatter {
    /**
     * @param salary to be formatted
     * @return salary formatted like 'XXX XXX ... XXX.YY руб.'
     * @throws IllegalArgumentException in case of negative salary's value
     */
    public static String format(BigDecimal salary) {
        if(salary.signum() < 0 ) {
            throw new IllegalArgumentException("Negative salary is not supposed to be accepted.");
        }
        String str =  salary.setScale(2, RoundingMode.HALF_EVEN)
                .toPlainString();

        int index = (str.length() % 3 != 0 )? str.length() % 3: 3;
        StringBuilder sb = new StringBuilder(str.substring(0, index));
        while(index <= str.length()-6) {
            sb.append(' ');
            sb.append(str.charAt(index++));
            sb.append(str.charAt(index++));
            sb.append(str.charAt(index++));
        }
        sb.append(str.substring(index));
        sb.append(" руб.");
        return sb.toString();
    }
}
