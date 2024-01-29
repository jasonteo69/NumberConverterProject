import java.util.HashMap;

public class NumberConverter {
    int[] digits;
    int base;
    private static HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

    public NumberConverter(int number, int base) {

        String numberAsString = Integer.toString(number);

        digits = new int[numberAsString.length()];

        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
        hash_map.put(10, "A");
        hash_map.put(11, "B");
        hash_map.put(12, "C");
        hash_map.put(13, "D");
        hash_map.put(14, "E");
        hash_map.put(15, "F");
        hash_map.put(16, "G");
        hash_map.put(17, "H");
        hash_map.put(18, "I");
        hash_map.put(19, "J");
        hash_map.put(20, "K");
        hash_map.put(21, "L");
        hash_map.put(22, "M");
        hash_map.put(23, "N");
        hash_map.put(24, "O");
        hash_map.put(25, "P");
        hash_map.put(26, "Q");
        hash_map.put(27, "R");
        hash_map.put(28, "S");
        hash_map.put(29, "T");
        hash_map.put(30, "U");
        hash_map.put(31, "V");
        hash_map.put(32, "W");
        hash_map.put(33, "X");
        hash_map.put(34, "Y");
        hash_map.put(35, "Z");
        hash_map.put(36, "a");
        hash_map.put(37, "b");
        hash_map.put(38, "c");
        hash_map.put(39, "d");
        hash_map.put(40, "e");
        hash_map.put(41, "f");
        hash_map.put(42, "g");
        hash_map.put(43, "h");
        hash_map.put(44, "i");
        hash_map.put(45, "j");
        hash_map.put(46, "k");
        hash_map.put(47, "l");
        hash_map.put(48, "m");
        hash_map.put(49, "n");
        hash_map.put(50, "o");
        hash_map.put(51, "p");
        hash_map.put(52, "q");
        hash_map.put(53, "r");
        hash_map.put(54, "s");
        hash_map.put(55, "t");
        hash_map.put(56, "u");
        hash_map.put(57, "v");
        hash_map.put(58, "w");
        hash_map.put(59, "x");
        hash_map.put(60, "y");
        hash_map.put(61, "z");
        hash_map.put(62, "+");
        hash_map.put(63, "/");
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

    public String[] convertToAnyBase(int num) {
        int size = 0;
        for (int i = num; i != 0; i /= base) {
            size++;
        }
        int [] baseChange = new int[size];
        int remainder = num;
        int quotient = num;

        for (int i = baseChange.length - 1; i >= 0; i--) {
            quotient /= base;
            remainder %= base;
            baseChange[i] = remainder;
            remainder = quotient;
        }

        String[] inStr = new String[baseChange.length];
        for (int k = 0; k < baseChange.length; k++) {
            inStr[k] = String.valueOf(baseChange[k]);
        }

        for (int j = 0; j < baseChange.length; j++) {
            int val = baseChange[j];
            if (hash_map.containsKey(val)) {
                inStr[j] = hash_map.get(val);
            }
        }

        return inStr;
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
    public String hexNumber() {
        String hex = "";
        for (String each : convertToHex()) {
            hex += each;
        }
        return hex;
    }
}

