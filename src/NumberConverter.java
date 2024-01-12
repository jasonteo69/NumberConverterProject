public class NumberConverter {
    int[] digits;
    int base;

    public NumberConverter(int number, int base) {

        String numberAsString = Integer.toString(number);

        digits = new int[numberAsString.length()];

        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {
        int[] digitValues = new int[digits.length];
        int power = digits.length - 1;

        for (int i = 0; i < digits.length; i++) {
            digitValues[i] = (int) (digits[i] * Math.pow(base, power));
            power--;
        }
        return digitValues;
    }

    public int[] convertToBinary() {
        int size = 0;
        for (int i = decimalNumber(); i != 0; i /= 2) {
            size++;
        }

        int [] binaryValue = new int[size];
        int remainder = decimalNumber();
        int quotient = decimalNumber();
        for (int i = size - 1; i >= 0; i--) {
            quotient /= 2;
            remainder %= 2;
            if (remainder == 1) {
                binaryValue[i] = 1;
            }
            remainder = quotient;
        }
        return binaryValue;
    }

    public int[] convertToOctal() {
        int size = 0;
        for (int i = decimalNumber(); i != 0; i /= 8) {
            size++;
        }

        int [] octalValue = new int[size];
        int remainder = decimalNumber();
        int quotient = decimalNumber();

        for (int i = octalValue.length - 1; i >= 0; i--) {
            quotient /= 8;
            remainder %= 8;
            octalValue[i] = remainder;
            remainder = quotient;
        }
        return octalValue;
    }
    public String[] convertToHex() {
        int size = 0;
        for (int i = decimalNumber(); i != 0; i /= 16) {
            size++;
        }

        int [] rawHexVal = new int[size];
        int remainder = decimalNumber();
        int quotient = decimalNumber();

        for (int i = rawHexVal.length - 1; i >= 0; i--) {
            quotient /= 16;
            remainder %= 16;
            rawHexVal[i] = remainder;
            remainder = quotient;
        }
        String [] hexVal = new String[size];
        for (int i = 0; i <= rawHexVal.length - 1; i++) {
            hexVal[i] = String.valueOf(rawHexVal[i]);
            if (rawHexVal[i] == 10) {
                hexVal[i] = "A";
            } else if (rawHexVal[i] == 11) {
                hexVal[i] = "B";
            } else if (rawHexVal[i] == 12) {
                hexVal[i] = "C";
            } else if (rawHexVal[i] == 13) {
                hexVal[i] = "D";
            } else if (rawHexVal[i] == 14) {
                hexVal[i] = "E";
            } else if (rawHexVal[i] == 15) {
                hexVal[i] = "F";
            }
        }
        return hexVal;
    }
    public int decimalNumber() {
        int num = 0;
        for (int i = 0; i < convertToDecimal().length; i++) {
            num += convertToDecimal()[i];
        }
        return num;
    }
    public String binaryNumber() {
        String binary = "";
        for (int each : convertToBinary()) {
            binary += Integer.toString(each);
        }
        return binary;
    }
    public int octalNumber() {
        String octal = "";
        for (int each : convertToOctal()) {
            octal += Integer.toString(each);
        }
        int octalVal = Integer.parseInt(octal);
        return octalVal;
    }
}

