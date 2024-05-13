package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(30, calculator.add(10, 20), "10 + 20 should equal 30");
        assertEquals(0, calculator.add(-1, 1), "-1 + 1 should equal 0");
    }

    @Test
    void testMultiply() {
        assertEquals(50, calculator.multiply(10, 5), "10 * 5 should equal 50");
        assertEquals(-6, calculator.multiply(-2, 3), "-2 * 3 should equal -6");
    }

    @Test
    void testAddPositiveNumbersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(-1, 10);
        }, "Should throw IllegalArgumentException when the first argument is negative");
    }

    @Test
    void testAddPositiveNumbers() {
        assertEquals(30, calculator.addPositiveNumbers(10, 20), "10 + 20 should equal 30");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.addPositiveNumbers(0, 20);
        }, "Should throw IllegalArgumentException when the first argument is zero");
    }
}
