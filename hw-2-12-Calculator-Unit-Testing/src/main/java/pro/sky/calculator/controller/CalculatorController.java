package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorServiceInterface;

@RestController
@RequestMapping(path = "/calculator")
public class CalculatorController {
    private final CalculatorServiceInterface service;

    private final String WELCOME_STRING = "Welcome to Calculator Web App!:)";
    public CalculatorController(CalculatorServiceInterface calculatorService) {
        this.service = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return WELCOME_STRING;
    }

    @GetMapping("/plus")
    public Number plus(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return service.plus(a, b);
    }

    @GetMapping("/minus")
    public Number minus(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return service.minus(a, b);
    }

    @GetMapping("/multiply")
    public Number multiply(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return service.multiply(a, b);
    }

    @GetMapping("/divide")
    public Number divide(@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return service.divide(a, b);
    }

}
