package pro.sky.calculator.service;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.exception.DivideByZeroException;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorServiceImplParameterizedTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(3, 5, 8),
                Arguments.of(23, 35, 58),
                Arguments.of(200, -1005, -805),
                Arguments.of(3, 0, 3)
        );

    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(3, 5, -2),
                Arguments.of(323, 35, 288),
                Arguments.of(200, -1005, 1205),
                Arguments.of(30_000, 2, 29_998)
        );

    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(3, 5, 15),
                Arguments.of(323, 35, 11_305),
                Arguments.of(200, -1005, -201_000),
                Arguments.of(30_000, 2, 60_000)
        );
    }

    public static Stream<Arguments> divideEqualToTestParams() {
        return Stream.of(
                Arguments.of(3, 5, 0.6),
                Arguments.of(9, 3, 3.0),
                Arguments.of(200, -1000, -0.2),
                Arguments.of(30_000, 20_000, 1.5)
        );
    }

    public static Stream<Arguments> divideCloseToTestParams() {
        return Stream.of(
                Arguments.of(3, 7, 0.4, Offset.offset(0.03)),
                Arguments.of(2, 3, 0.66, Offset.offset(0.01)),
                Arguments.of(200, -1005, -0.2, Offset.offset(0.01)),
                Arguments.of(30_000, 20_001, 1.5, Offset.offset(0.0001))
        );
    }

    public static Stream<Arguments> divideNegativeTestParams() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(2, 0),
                Arguments.of(200, 0),
                Arguments.of(30_000, 0)
        );

    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(Integer a, Integer b, Number expected) {
        assertThat(calculatorService.plus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(Integer a, Integer b, Number expected) {
        assertThat(calculatorService.minus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(Integer a, Integer b, Number expected) {
        assertThat(calculatorService.multiply(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideEqualToTestParams")
    public void divideEqualToTest(Integer a, Integer b, Double expected) {
        assertThat(calculatorService.divide(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideCloseToTestParams")
    public void divideCloseToTest(Integer a, Integer b, Double expected, Offset<Double> offset) {
        assertThat(calculatorService.divide(a, b).doubleValue())
                .isCloseTo(expected, offset);
    }

    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideNegativeTest(Integer a, Integer b) {
        assertThatThrownBy(() -> calculatorService.divide(a, b))
                .isExactlyInstanceOf(DivideByZeroException.class)
                .hasMessage("Division by 0  is not allowed.");
    }
}
