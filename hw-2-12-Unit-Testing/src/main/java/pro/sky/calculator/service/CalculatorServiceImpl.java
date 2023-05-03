package pro.sky.calculator.service;

import org.springframework.stereotype.Service;
import pro.sky.calculator.exception.DivideByZeroException;

@Service
public class CalculatorServiceImpl implements CalculatorService {


    @Override
    public Number plus(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Number minus(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Number multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Number divide(Integer a, Integer b) {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a.doubleValue() / b;
    }

}
