
import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, or 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base  = 0;

        //Avoiding errors
        try {
        base = Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println("Is it so hard to listen?");
            System.exit(1);
        }

        int newBase = 0;

        //Challenge Part 2: conversion to base 1-63
        String yesNo = "";


        if (base == 2) {
            System.out.println("Make sure your number is in ones and zeros\n");
        } 
        else if (base == 8) {
            System.out.println("Make sure your number does not contain a digit higher than 7\n");
        } 
        else if (base == 16) {
            System.out.println("The letters you can use are A, B, C, D, E, and F alongside any number\n");
        } 
        else if (base == 10) {
            System.out.println("Would you like to convert to a certain base? (y or n)");
            yesNo = s.nextLine();

            if (yesNo.equals("y")) {
            System.out.println("What base do you want to convert to? (1 - 63)");
            try {
                newBase = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("no");
                System.exit(1);
            } 
        } else if (yesNo.equals("n")) {
                //Do Nothing, avoids unnecessary program termination
            }
        } else {
                System.out.println("Nice try buddy, but learn to read before typing");
                System.exit(1);
            }

            System.out.print("Enter your number: ");
            String number = s.nextLine();
            number.toUpperCase();
            int n = 0;
            try {
                if (base == 16) {
                    NumberConverter change = new NumberConverter(Integer.parseInt(number, 16), 10);
                    System.out.println("Decimal Number: " + change.decimalNumber());
                    System.out.println("Binary Number: " + change.binaryNumber());
                    System.out.println("Octal Number: " + change.octalNumber());
                    System.exit(1);
                } else {
                    n = Integer.parseInt(number);
                }
                if (base == 10 && yesNo.equals("y")) {
                    if (newBase == 1) {
                        String asBaseOne = "";
                        for (int i = 0; i < n; i++) {
                            asBaseOne += "1";
                        }
                        System.out.println(asBaseOne);
                        System.exit(1);
                    }
                    NumberConverter change = new NumberConverter(n, newBase);
                    String[] cool = change.convertToAnyBase(n);
                    String each = "";
                    for (int i = 0; i < cool.length; i++) {
                        each += cool[i];
                    }
                    System.out.println("Your Number in Base " + newBase + " is: " + each);
                    System.exit(1);
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

                //Display data based on base
                if (base == 2) {
                    System.out.println("Decimal Number: " + nc.decimalNumber());
                    System.out.println("Octal Number: " + nc.octalNumber());
                    System.out.println("Hexadecimal Number: " + nc.hexNumber());
                } else if (base == 8) {
                    System.out.println("Decimal Number: " + nc.decimalNumber());
                    System.out.println("Binary Number: " + nc.binaryNumber());
                    System.out.println("Hexadecimal Number: " + nc.hexNumber());
                } else {
                    System.out.println("Binary Number: " + nc.binaryNumber());
                    System.out.println("Octal Number: " + nc.octalNumber());
                    System.out.println("Hexadecimal Number: " + nc.hexNumber());
                }
                System.out.println();
                s.close();
            }
            //Error Evasion
            catch (NumberFormatException e) {
                System.out.println("no");
            }
        }
    }

