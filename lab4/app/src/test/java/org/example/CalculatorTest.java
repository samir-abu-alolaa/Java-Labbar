package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();
    @Test 
    void followRegex() {
        assertTrue(calculator.validExpression("5 + 2 - 4"));
        assertFalse(calculator.validExpression("+2-4+5"));
    }

    @Test 
    void ConvertStrToArray(){
        String[] expected = {"3", "+", "2"};
        assertArrayEquals(expected, calculator.stringToArray("3 + 2"));
    }
    @Test void checkSum(){
        double expected = 3 +2;
        assertEquals(calculator.add(3, 2), expected);
    }
    @Test void checkSubstract(){
        double expected = 3 -2 ;
        assertEquals(calculator.subtract(3, 2), expected);
    }
    @Test void checkMultiplay(){
        double expected = 3 *2;
        assertEquals(calculator.multiply(3, 2), expected);
    }
    @Test void checkDivid(){
        double expected = 1.5;
        double result = calculator.division(3, 2);
        assertEquals(result, expected);
    }
    @Test void checkDividWithZero(){
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divisionWithException(10.0, 0.0);
        });
        double expected = 1.5;
        assertEquals(expected, calculator.divisionWithException(3, 2));
        assertEquals("Division by zero not allowed.", exception.getMessage());
    }

    @Test 
    void checkCalculateSum() {
        // Mock user input and test the calculateSum method.
        // This requires overriding getInput() for test purposes.
        String input = "3 + 2";
        double expected = 5;

        Calculator calculator = new Calculator() {
            @Override
            public String getInput() {
                // Override getInput() for testing purposes to return the predefined expression
                return input;
            }
        };

        double result = calculator.calculateSum();
        assertEquals(expected, result);
    }
    @Test 
    void checkCalculateComplexExpression() {
        // Test with a more complex expression
        String input = "5 + 3 * 2 - 4 / 2";
        double expected = 6.0;

        Calculator calculator = new Calculator() {
            @Override
            public String getInput() {
                return input;
            }
        };

        double result = calculator.calculateSum();
        assertEquals(expected, result);
    }

    @Test
    void checkNan(){
        String input = "5+2";

        Calculator calculator = new Calculator(){
        @Override
        public String getInput(){
            return input;
        }
    };
    double result = calculator.calculateSum();
    assertTrue(Double.isNaN(result));
}

}

