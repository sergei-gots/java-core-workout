package pro.sky.calculator.service;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import pro.sky.calculator.exception.DivideByZeroException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorServiceImplTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    public void plusTesT() {
        assertThat(calculatorService.plus(3,5)).isEqualTo(8);
        assertThat(calculatorService.plus(-2,2)).isEqualTo(0);
    }
    @Test
    public void plusTest() {
        assertThat(calculatorService.plus(3,5)).isEqualTo(8);
        assertThat(calculatorService.plus(-2,2)).isEqualTo(0);
    }
    @Test
    public void minusTest() {
        assertThat(calculatorService.minus(10,20)).isEqualTo(-10);
        assertThat(calculatorService.minus(8,2)).isEqualTo(6);
    }
    @Test
    public void multiplyTest() {
        assertThat(calculatorService.multiply(3,5)).isEqualTo(15);
        assertThat(calculatorService.multiply(-2,-2)).isEqualTo(4);
    }
    @Test
    public void divideTest() {
        assertThat(calculatorService.divide(3,5))
                .isEqualTo(0.6);
        assertThat(calculatorService.divide(-2,3).doubleValue())
                .isCloseTo(-0.66, Offset.offset(0.01));
    }

    @Test
    public void divideNegativeTest() {
        assertThatThrownBy(()->calculatorService.divide(3,0))
                .isExactlyInstanceOf(DivideByZeroException.class)
                .hasMessage("Division by 0  is not allowed.");
        assertThatThrownBy(()->calculatorService.divide(-2,0))
                .isExactlyInstanceOf(DivideByZeroException.class)
                .hasMessage("Division by 0  is not allowed.");
    }
}
