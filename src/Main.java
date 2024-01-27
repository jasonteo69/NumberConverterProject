import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        int newBase = 0;
        if (base == 2)
            System.out.println("Make sure your number is in ones and zeros\n");
        else if (base == 8) {
            System.out.println("Make sure your number does not contain a digit higher than 7\n");
        } else if (base == 16) {
            System.out.println("The letters you can use are A, B, C, D, E, and F alongside any number\n");
        } else {
            System.out.println("Would you like to convert to a certain base? (y or n)");
            String yesNo = s.nextLine();
            if (yesNo.equals("y")) {
                System.out.println("What base do you want to convert to? (1 - 63)");
                newBase = Integer.parseInt(s.nextLine());
            }
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        number.toUpperCase();
        int n = 0;
        if (base == 16) {
            NumberConverter change = new NumberConverter(Integer.parseInt(number, 16), 10);
            System.out.println("Decimal Number: " + change.decimalNumber());
            System.out.println("Binary Number: " + change.binaryNumber());
            System.out.println("Octal Number: " + change.octalNumber());
            System.exit(1);
        } else {
            n = Integer.parseInt(number);
        }
        if (base == 10) {
            if (base == 10) {
                NumberConverter change = new NumberConverter(n, newBase);
                System.out.println(Arrays.toString(change.convertToAnyBase()));
                System.exit(1);
            }
        }

        if (base == 2) {
            for (int i = 2; i <= 9; i++) {
                if (String.valueOf(n).contains(String.valueOf(i))) {
                    System.out.println("Follow instructions next time");
                    System.exit(1);
                }
            }
        }
        if (base == 8) {
            for (int i = 8; i <= 9; i++) {
                if (String.valueOf(n).contains(String.valueOf(i))) {
                    System.out.println("Follow instructions next time");
                    System.exit(1);
                }
            }
        }


        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();

        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());

        if (base == 2) {
            System.out.println("Decimal Number: " + nc.decimalNumber());
            System.out.println("Octal Number: " + nc.octalNumber());
        }
         else if (base == 8) {
            System.out.println("Decimal Number: " + nc.decimalNumber());
            System.out.println("Binary Number: " + nc.binaryNumber());
        }
         else {
            System.out.println("Binary Number: " + nc.binaryNumber());
            System.out.println("Octal Number: " + nc.octalNumber());
        }
        System.out.println(Arrays.toString(nc.convertToHex()));
        System.out.println();
        s.close();
    }
}

