import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);
        if (base == 2)
            System.out.println("Make sure your number is in ones and zeros\n");
        else if (base == 8) {
            System.out.println("Make sure your number does not contain a digit higher than 7\n");
        }

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

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
        } else if (base == 8) {
            System.out.println("Decimal Number: " + nc.decimalNumber());
            System.out.println("Binary Number: " + nc.binaryNumber());
        } else {
            System.out.println("Binary Number: " + nc.binaryNumber());
            System.out.println("Octal Number: " + nc.octalNumber());
        }
    }
}

