import java.util.Scanner;

public class calc1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение в формате: ");
        System.out.print("'a' 'операция' 'b', важно поставить между числами и операцией пробел : ");
        String inp = scanner.nextLine();

        // Разделение строки на операнды и операцию
        String[] parts = inp.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неправильный формат выражения");
        }


        String x = parts[0];
        String y = parts[2];
        String op = parts[1];

        solve(x, y, op);
    }


    // Корневой метод для решения

    public static void solve(String x, String y, String op){
        if(ifShort(x, y)){
            if(ifLegal (Integer.parseInt(x), Integer.parseInt(y))){
                System.out.println(ariphmetic(Integer.parseInt(x), Integer.parseInt(y), op));
            }
        }
        else{
            // метод на проверку римских цифр + метод на арифметику с исключениями + метод на конвертацию в римские числа
            boolean isRoman = isRomanNumeral(x) && isRomanNumeral(y);
            if(isRoman){
            int a = Roman.convertToArabic(x);
            int b = Roman.convertToArabic(y);
            int result = ariphmetic(a, b, op);
            if(result <= 0){
                throw new IllegalArgumentException("Римские цифры не могут быть меньше 1");
            }
            else{
                convertToRoman(result);

            }

            }
        }

    }

    // Метод для проверки на содержание чисел
    public static boolean ifShort(String x, String y){
        return x.matches("\\d+") && y.matches("\\d+");
    }

    // Метод на принадлежность к enum

      private static boolean isRomanNumeral(String input) {
        try {
            Roman.valueOf(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static int ariphmetic (int x, int y,String op){
        int result;
        switch (op) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                if (y == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо");
                }
                result = x / y;
                break;
            default: // default срабатывает если ни одно из условий не выполнено
                throw new IllegalArgumentException("Неправильная операция");
        }
        return result;
    }

    public static boolean ifLegal (int x, int y){
        int[] num = {x, y};
        for (int number : num) {
            if (number < 1 || number > 10) {
                System.out.println("Число " + number + " не входит в диапазон от 1 до 10");
                System.exit(0);
            }
        }
        return true;
    }
    public static void convertToRoman(int result){
        int a1;
        int a2;
        int a3;

        a1 = result / 100;
        if(a1 == 1){
            System.out.println("C");
        }
        else {
            a2 = result / 10;
            a3 = result % 10;
          con(a2, a3, result);
        }

    }

    public static void con (int a2, int a3, int result){
        String a22;
        String a33;
        a2 = result / 10;
        a3 = result % 10;
        switch (a2){
            case 1:
                a22 = "X";
                break;
            case 2:
                a22 = "XX";
                break;
            case 3:
                a22 = "XXX";
                break;
            case 4:
                a22 = "XL";
                break;
            case 5:
                a22 = "L";
                break;
            case 6:
                a22 = "LX";
                break;
            case 7:
                a22 = "LXX";
                break;
            case 8:
                a22 = "LXXX";
                break;
            case 9:
                a22 = "XC";
                break;
            default: // default срабатывает если ни одно из условий не выполнено
                a22 = "";

        }
        switch (a3){
            case 1:
                a33 = "I";
                break;
            case 2:
                a33 = "II";
                break;
            case 3:
                a33 = "III";
                break;
            case 4:
                a33 = "IV";
                break;
            case 5:
                a33 = "V";
                break;
            case 6:
                a33 = "VI";
                break;
            case 7:
                a33 = "VII";
                break;
            case 8:
                a33 = "VIII";
                break;
            case 9:
                a33 = "IX";
                break;
            default: // default срабатывает если ни одно из условий не выполнено
                a33 = "";

        }
        System.out.println("" + a22 + a33);
    }
}