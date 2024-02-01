import java.util.Arrays;

public class NumberConverter {
    int[] digits;
    String[] hexDigits;
    int base;
    int val = 0;

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

    //Use only this constructor: in decimal format method deal with it. Use decimal value as 'base' value in all other
    //methods by updating the val instance variable. Research if radix actually works!
    public NumberConverter(String number, int base)
    {
        //second constructor because the number could include letters
        hexDigits = new String[number.length()];
        for (int i = 0; i < number.length(); i++)
        {
            hexDigits[i] = number.charAt(i) + "";
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

    public String displayOriginalHexNumber()
    {
        String o = "";
        for (int i = 0; i < hexDigits.length; i++) {
            o = o + hexDigits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public String[] getHexDigits()
    {
        return hexDigits;
    }

    public int[] convertToDecimal() {
        for (int i = 0; i < digits.length; i++)
        {
            val += digits[i] * Math.pow(base, digits.length - 1 - i);
        }
        String str = Integer.toString(val);
        int[] decArray = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
        {
            decArray[i] = Character.getNumericValue(str.charAt(i));
        }
//        if (base == 16)
//        {
//            String stringNum = convertArrayToString(hexDigits);
//            //i just found out that radix means the base of a number system so this is a lot less work than
//            //checking for letters and assigning their values based on what letter it is
//            val = Integer.parseInt(stringNum, 16);
//        }
//        else
//        {
//            int pow = 0;
//            for (int i = digits.length - 1; i >= 0; i--)
//            {
//                //converting each digit to its decimal value by raising it to the power of the base it's
//                //associated with (based on place value)
//                val += digits[i] * Math.pow(base, pow);
//                pow++;
//            }
//        }
//        String decVal = Integer.toString(val);
//        //converting to array
//        int[] decArray = new int[decVal.length()];
//        for (int i = 0; i < decArray.length; i++)
//        {
//            decArray[i] = Character.getNumericValue(decVal.charAt(i));
//        }
        return decArray;
    }

    public int[] convertToBinary() {
//        int[] temp = convertToDecimal();
        int decNum = val;
        String binary = "";
        if (decNum == 0) {
            return new int[]{0};
        }
        //creating backwards binary string
        while (decNum > 0)
        {
            int r = decNum % 2;
            decNum /= 2;
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
//        int[] temp = convertToDecimal();
        int decNum = val;
        if (decNum == 0) {
            return new int[]{0};
        }
        //determine length by finding how many times 8 can go into the number
        int length = 0;
        int tempNum = decNum;
        while (tempNum > 0) {
            tempNum /= 8;
            length++;
        }
        //assign to array backwards using octal implementation
        int[] octalArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            octalArray[i] = decNum % 8; //using remainder
            decNum /= 8;
        }
        return octalArray;
    }

    public String[] convertToHex(){
//        int[] temp = convertToDecimal();
        int decNum = val;
        if (decNum == 0) {
            return new String[]{"0"};
        }
        int length = 0;
        int tempNum = decNum;
        while (tempNum > 0) {
            tempNum /= 16;
            length++;
        }
        String[] hexArray = new String[length];
        for (int i = length - 1; i >= 0; i--) {
            int remainder = decNum % 16;
            //assigning letters based on remainders
            if (remainder == 10)
            {
                hexArray[i] = "A";
            }
            else if (remainder == 11)
            {
                hexArray[i] = "B";
            }
            else if (remainder == 12)
            {
                hexArray[i] = "C";
            }
            else if (remainder == 13)
            {
                hexArray[i] = "D";
            }
            else if (remainder == 14)
            {
                hexArray[i] = "E";
            }
            else if (remainder == 15)
            {
                hexArray[i] = "F";
            }
            else
            {
                hexArray[i] = Integer.toString(remainder);
            }
            decNum /= 16;
        }
        return hexArray;
    }

    public String[] customBase(int num, int chosenBase)
    {
        String characters = "01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        String number = "";
        if (chosenBase == 1)
        {
            for (int i = 0; i< num; i++)
            {
                number += "1";
            }
        }

        else
        {
            int r = num % chosenBase;
            number = characters.charAt(r) + number;
        }

        String[] customBaseDigits = new String[number.length()];
        for (int i = 0; i < customBaseDigits.length; i++)
        {
            customBaseDigits[i] = number.charAt(i) + "";
        }
        return customBaseDigits;
    }

    public int convertArrayToNum(int[] digits)
    {
        int num = 0;
        for (int digit: digits)
        {
            num = num * 10 + digit;
        }
        return num;
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


