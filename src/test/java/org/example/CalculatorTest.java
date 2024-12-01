package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(5.0, Calculator.calculate(2.0, '+', 3.0), "Ошибка в сложении");
    }

    @Test
    void testSubtraction() {
        assertEquals(2.0, Calculator.calculate(5.0, '-', 3.0), "Ошибка в вычитании");
    }

    @Test
    void testMultiplication() {
        assertEquals(10.0, Calculator.calculate(4.0, '*', 2.5), "Ошибка в умножении");
    }

    @Test
    void testDivision() {
        assertEquals(5.0, Calculator.calculate(10.0, '/', 2.0), "Ошибка в делении");
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate(10.0, '/', 0.0)
        );
        assertEquals("Деление на ноль невозможно!", exception.getMessage());
    }

    @Test
    void testUnknownOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculate(10.0, '^', 2.0)
        );
        assertEquals("Неизвестная операция: ^", exception.getMessage());
    }
}
