package Calculator;

import java.util.Scanner;

import static Calculator.Convert.convert;
import static Calculator.Convert.convertToRoman;


public class Main {
    static char operator; // Инициализация переменных с 11 - 14 строки
    static int firstNumber;
    static int secondNumber;
    static boolean firstRomanNumber = false, secondRomanNumber = false;

    // Точка входа в программу,выбрасывает исключения (в данном случае обработка ошибок)

    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in); // инициализируется объект типа сканер,объявляется с помощью слова new
        System.out.print("Введите число1 математический оператор(+-/*) число2 ");
        String input = scan.nextLine(); // Метод сканирует введенные строки

        convert(input); // вызываем метод конвертер,на вход ему идет переменная инпат,результат сканирования строки
        Integer result = calculate(); // записывается результат выполнения метода калькулятор

        // если результат выполнения не равен нулю,то выполняется следующая логика
        if (result != null) {
            if (firstRomanNumber == true & secondRomanNumber == true) {
                System.out.println("Ответ: " + convertToRoman(result));
            } else {
                System.out.println("Ответ: " + result);
            }
        }
    }

    public static Integer calculate() throws Exception {
        Integer result = null; // Инициализируется объект типа Int,целочисленного значения

        if (firstRomanNumber == secondRomanNumber) {
            if (firstNumber < 0 || firstNumber > 10) {
                throw new Exception("Первое число должно быть от 0-10 римскими,либо целочисленными");
            }

            if (secondNumber < 0 || secondNumber > 10) {
                throw new Exception("Второе число должно быть от 0-10 римскими,либо целочисленными");
            }

            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;

                case '-':
                    result = firstNumber - secondNumber;
                    break;

                case '*':
                    result = firstNumber * secondNumber;
                    break;

                case '/':
                    result = firstNumber / secondNumber;
                    break;

                default: // случай по умолчанию
                    throw new Exception("неправильный математический оператор");
            }

            return result; // возврат значения из метода
        } else {
            throw new Exception("Оба числа должны быть римскими,либо целочисленными");
        }
    }
}