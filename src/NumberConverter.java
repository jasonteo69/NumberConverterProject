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
        int[] inDecimal = convertToDecimal();
        int baseline = decimalNumber();
        int size = 0;

        int divideEach = baseline;
        int modded = baseline;
        for (int i = baseline; i != 0; i /= 2) {
            size++;
        }
        int [] binaryValue = new int[size];

        for (int i = binaryValue.length - 1; i < 0 ; i--) {

            divideEach /= 2;
            modded %= 2;

            if (modded == 1) {
                binaryValue[i] = 1;
            } else if (modded == 0) {
                binaryValue[i] = 0;
            }
            modded = divideEach;
        }
        return binaryValue;
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

