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
        String numberAsString = "";
        for (int y = 0; y < digits.length; y++) {
            numberAsString += digits[y];
        }

        int baseline = Integer.parseInt(numberAsString);

        int size = 0;
        for (int k = 1; k < baseline; k++) {
            k *= Math.pow(base, k);
            size++;
        }
        int [] inBinary = new int[size];
        int [] binaryValue = new int[size];
        int power = digits.length - 1;
        for (int j = 0; j < inBinary.length; j++) {
            inBinary[j] = 0;
            binaryValue[j] = (int) Math.pow(2, power);
            power--;
        }

        for (int i = 0; i < binaryValue.length; i++) {
            if (baseline >= binaryValue[i]) {
                baseline = baseline - binaryValue[i];
                inBinary[i] = 1;
            }
        }
        return inBinary;
    }

    public int[] convertToOctal() {
        return null;
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
        for (int i = 0; i < convertToBinary().length; i++) {
            binary += Integer.toString(convertToBinary()[i]);
        }
        return binary;
    }
}

