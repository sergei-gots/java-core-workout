package pro.sky.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorServiceInterface{
    @Override
    public String welcome() {
        return "Welcome to Calculator Web App!:)";
    }

    @Override
    public String plus(int a,  int b) {
        return "" + a + " + " +  b + " = " + (a + b);
    }

    @Override
    public String minus(int a, int b) {
        return "" + a + " - " +  b + " = " + (a - b);
    }

    @Override
    public String multiply(int a, int b)  {
        return "" + a + " * " +  b + " = " + (a * b);
    }

    @Override
    public String divide(int a, int b) {
        String exp = "" + a + " / " +  b;
        if (b == 0 ) {
            return "Division by 0 (your input is <b>" + exp + "</b>) is not allowed.";
        }
        return exp + " = " + (a / b);
    }

}
