import java.util.Arrays;
public class NumberConverter {
    private int base;
    private String[] digits;
    private int decVal = 0;
    
    public NumberConverter(String number, int base)
    {
        digits = new String[number.length()];
        for (int i = 0; i < number.length(); i++)
        {
            digits[i] = number.charAt(i) + "";
        }
        this.base = base;
    }

    public int getDecVal()
    {
        return decVal;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }
    public String[] getDigits() {
        return digits;
    }
    
    public int[] convertToDecimal() {
        if (base == 16) {
            String num = "";
            for (int i = 0; i < digits.length; i++)
            {
                num += digits[i] + "";
            }
            decVal = Integer.parseInt(num, 16);
        }
        else
        {
            for (int i = 0; i < digits.length; i++)
            {
                int digit = Integer.parseInt(digits[i]);
                decVal += digit * Math.pow(base, digits.length - 1 - i);
            }
        }
        String decVal = Integer.toString(getDecVal());
        //converting to array
        int[] decArray = new int[decVal.length()];
        for (int i = 0; i < decArray.length; i++)
        {
            decArray[i] = Character.getNumericValue(decVal.charAt(i));
        }
        return decArray;
    }

    public int[] convertToBinary() {
        int tempDecVal = decVal;
        String binary = "";
        if (tempDecVal == 0) {
            return new int[]{0};
        }
        //creating backwards binary string
        while (tempDecVal > 0)
        {
            int r = tempDecVal % 2;
            tempDecVal /= 2;
            binary += Integer.toString(r);
        }
        int[] binaryArray = new int[binary.length()];
        int stringIdx = 0;
        //create array from MSB to LSB
        for (int i = binaryArray.length - 1; i >= 0 ; i--)
        {
            binaryArray[i] = Character.getNumericValue(binary.charAt(stringIdx));
            stringIdx++;
        }
        return binaryArray;
    }

    public int[] convertToOctal() {
        int lengthVal = decVal;
        if (lengthVal == 0) {
            return new int[]{0};
        }
        //determine length by finding how many times 8 can go into the number
        int length = 0;
        while (lengthVal > 0) {
            lengthVal /= 8;
            length++;
        }
        //assign to array backwards using octal implementation
        int tempDecVal = decVal;
        int[] octalArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            octalArray[i] = tempDecVal % 8; //using remainder
            tempDecVal /= 8;
        }
        return octalArray;
    }

    public String[] convertToHex() {
        int lengthVal = decVal;
        if (decVal == 0) {
            return new String[]{"0"};
        }
        int length = 0;
        while (lengthVal > 0) {
            lengthVal /= 16;
            length++;
        }
        String[] hexArray = new String[length];
        int tempDecVal = decVal;

        for (int i = length - 1; i >= 0; i--) {
            int remainder = tempDecVal % 16;
            if (remainder >= 10) {
                String characters = "ABCDEF";
                hexArray[i] = characters.charAt(remainder - 10) + "";
            }
            else {
                hexArray[i] = Integer.toString(remainder);
            }
            tempDecVal /= 16;
        }
        return hexArray;
    }

    public String[] customBase(int num, int chosenBase) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        String number = "";
        // base 1 conversion
        if (chosenBase == 1) {
            for (int i = 0; i < num; i++) {
                number += "1";
            }
        }
        else {
            while (num > 0) {
                int r = num % chosenBase;
                num /= chosenBase;
                // using characters String to map which character for each remainder
                number = characters.charAt(r) + number;
            }
        }
        String[] customBaseDigits = new String[number.length()];
        for (int i = 0; i < customBaseDigits.length; i++) {
            customBaseDigits[i] = number.charAt(i) + "";
        }
        return customBaseDigits;
    }

    public String convertArrayToString(String[] array)
    {
        String string = "";
        for (String str: array)
        {
            string += str;
        }
        return string;
    }
    public String convertArrayToString(int[] array)
    {
        String string = "";
        for (int num: array)
        {
            string += num;
        }
        return string;
    }
}


