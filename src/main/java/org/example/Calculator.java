package org.example;

import java.util.Scanner;

/**
 * Калькулятор
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double operand1 = scanner.nextDouble();

        System.out.println("Введите операцию (+, -, *, /):");
        char operation = scanner.next().charAt(0);

        System.out.println("Введите второе число:");
        double operand2 = scanner.nextDouble();

        try {
            double result = calculate(operand1, operation, operand2);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    /**
     * Метод для выполнения вычислений
     *
     * @param operand1  Первый операнд
     * @param operation Операция
     * @param operand2  Второй операнд
     * @return Результат вычислений
     * @throws IllegalArgumentException Если операция неизвестна или деление на ноль
     */
    public static double calculate(double operand1, char operation, double operand2) {
        switch (operation) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно!");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Неизвестная операция: " + operation);
        }
    }


}
