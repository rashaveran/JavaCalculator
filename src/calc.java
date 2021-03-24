import java.util.Scanner;
import java.lang.*;

public class calc {
    public static void main(String[] args) {
        try {
            System.out.println("Введите выражение в виде '5 + 3'. Допустимо использовать либо арабские, либо латинские цифры.");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            int index1 = str.indexOf(' ');
            int index2 = str.lastIndexOf(' ');
            String substr1 = str.substring(0, index1);
            String substr2 = str.substring(index2 + 1);
            if (contains(substr1) && contains(substr2)) {
                int x = Roman.valueOf(substr1).ordinal() + 1;
                int y = Roman.valueOf(substr2).ordinal() + 1;
                if (x > 10 || y > 10 || x < 1 || y < 1) {
                    System.out.println("Значения чисел вне допустимых значений");
                    return;
                }
                char operator1 = str.charAt(index1 + 1);
                String operator = Character.toString(operator1);
                switch (operator) {
                    case "+":
                        System.out.println(toRoman(sum(x, y)));
                        break;
                    case "-":
                        System.out.println(toRoman(minus(x, y)));
                        break;
                    case ":":
                        System.out.println(toRoman(divide(x, y)));
                        break;
                    case "*":
                        System.out.println(toRoman(multiply(x, y)));
                        break;
                    case "/":
                        System.out.println(toRoman(divide(x, y)));
                        break;
                }
            } else if (contains(substr1) == false && contains(substr2) == false) {
                int x = Integer.parseInt(substr1);
                int y = Integer.parseInt(substr2);
                if (x > 10 || y > 10 || x < 1 || y < 1) {
                    System.out.println("Значения чисел вне допустимых значений");
                    return;
                }
                char operator1 = str.charAt(index1 + 1);
                String operator = Character.toString(operator1);
                switch (operator) {
                    case "+":
                        System.out.println(sum(x, y));
                        break;
                    case "-":
                        System.out.println(minus(x, y));
                        break;
                    case ":":
                        System.out.println(divide(x, y));
                        break;
                    case "*":
                        System.out.println(multiply(x, y));
                        break;
                    case "/":
                        System.out.println(divide(x, y));
                        break;
                }
            } else System.out.println("Неправильная запись выражения");
        } catch (StringIndexOutOfBoundsException | NumberFormatException ex) {
            System.out.println("Неверная запись");
        }
    }

    static int sum(int x, int y) {
        return x + y;
    }

    static int minus(int x, int y) {
        return x - y;
    }

    static int multiply(int x, int y) {

        return x * y;
    }

    static int divide(int x, int y) {
        return x / y;
    }

    public enum Roman {

        I("1"), II("2"), III("3"), IV("4"), V("5"),
        VI("6"), VII("7"), VIII("8"), IX("9"),
        X("10"),
        XL("40"), L("50"), XC("90"), C("100");

        private int value;

        private String title;

        Roman(String title) {
            this.title = title;
        }

        public int getValue() {
            return value;
        }

    }

    public static boolean contains(String test) {

        for (Roman c : Roman.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }

        return false;
    }

    public static String romanDigit(int n, String one, String five, String ten) {

        if (n >= 1) {
            if (n == 1) {
                return one;
            } else if (n == 2) {
                return one + one;
            } else if (n == 3) {
                return one + one + one;
            } else if (n == 4) {
                return one + five;
            } else if (n == 5) {
                return five;
            } else if (n == 6) {
                return five + one;
            } else if (n == 7) {
                return five + one + one;
            } else if (n == 8) {
                return five + one + one + one;
            } else if (n == 9) {
                return one + ten;
            }

        }
        return "";
    }

    public static String toRoman(int number) {

        if (number > 0) {

            String romanOnes = romanDigit(number % 10, "I", "V", "X");
            number /= 10;

            String romanTens = romanDigit(number % 10, "X", "L", "C");
            number /= 10;

            String romanHundreds = romanDigit(number % 10, "C", "D", "M");
            number /= 10;

            String result = romanHundreds + romanTens + romanOnes;
            return result;
        }
        else return "Решение для римских цифр должно быть положительным.";
    }
}

