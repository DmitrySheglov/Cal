import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения ");
        System.out.println("и деления с двумя числами: a+b, a-b, a*b, a/b.");
        System.out.println("Калькулятор умеет работать одной из Систем счисления Арабское и Римское");
        System.out.println("Результатом работы калькулятора с римскими числами могут быть только положительные числа");

        Scanner s = new Scanner(System.in);
        System.out.println("Введите значения:");
        String vvod = s.nextLine();
        System.out.print("Результат : " + vvod);

        String operStr = " ";
        char[] symbol = new char[10];
        char oper = '+';
        for (int i=1; i < vvod.length(); i++) {
            symbol[i] = vvod.charAt(i);
            if ( symbol[i] == '+'){
                oper = '+'; operStr = "\\+";
            }
            if ( symbol[i] == '-'){
                oper = '-'; operStr = "-";
            }
            if ( symbol[i] == '*'){
                oper = '*'; operStr = "\\*";
            }
            if ( symbol[i] == '/'){
                oper = '/'; operStr = "/";
            }
        }

        int num1 = 0;
        int num2 = 0;
        int result = 0;
        int resultArab = 0;
        String[] numbers = vvod.split(operStr);
        if (numbers.length > 2) {
            System.out.println("=? \nthrows Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(0);
        }
        try{
            num1 = romanNumeral(numbers[0]);
            num2 = romanNumeral(numbers[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("=? \nthrows Exception //т.к. строка не является математической операцией");
            System.exit(0);
        }
        if (num1 == 0 | num2 == 0) {
            result = 0;
            try {
                num1 = Integer.parseInt(numbers[0]);
                num2 = Integer.parseInt(numbers[1]);
                if (num1 > 10 | num2 > 10 | num1 < 0 | num2 <0) {
                    System.out.println("=? \nthrows Exception //т.к. используются одновременно разные системы счисления");
                    System.exit(0);
                }
                resultArab = calculate(num1, num2, oper);
                System.out.println("=" + resultArab);
            } catch (NumberFormatException e) {
                System.out.println("=? \nthrows Exception //т.к. используются одновременно разные системы счисления");
            } catch (ArithmeticException e) {
                System.out.println("=? \nНа ноль делить нельзя!");
            }
        } else {
            try {
                result = calculate(num1, num2, oper);
                if (result == 0) {
                    System.out.println("=? \nthrows Exception //т.к. в римской системе нет отрицательных чисел");
                    System.exit(0);
                }
                String resultRom = romanSolution(result);
                System.out.println("=" + resultRom + " (" + result + ")");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("=? \nthrows Exception //т.к. в римской системе нет отрицательных чисел");
            }
        }
    }

    public static int calculate(int x1, int x2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = x1 + x2;
                break;
            case '-':
                result = x1 - x2;
                break;
            case '*':
                result = x1 * x2;
                break;
            case '/':
                result = x1 / x2;
                break;
            default:
                break;
        }
        return result;
    }

    public static int romanNumeral(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return 0;
        }
    }

    public static String romanSolution(int arabNumeral) {
        String[] romanAll = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII",
                "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String q = romanAll[arabNumeral];
        return q;

    }
}

