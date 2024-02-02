import java.util.Arrays;
import java.util.Scanner;

class  ConverterRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Would you like to convert a decimal to a custom base (1-64)? y for yes and n for no: ");
        boolean cont = true;
        if ((s.nextLine()).equals("y"))
        {
            System.out.print("Enter your number in base 10: ");
            String number = s.nextLine();
            for (int i = 0; i < number.length(); i++)
            {
                char curr = number.charAt(i);
                if (curr < '0' || curr > '9')
                {
                    cont = false;
                }
            }
            if (!cont)
            {
                System.out.println("Please restart and input a valid base10 number!");
            }
            else if (cont)
            {
                System.out.println("Enter the base you would like to convert to (1-64): ");
                int base = Integer.parseInt(s.nextLine());
                NumberConverter nc = new NumberConverter(number, base);
                if (base > 0 && base < 65)
                {
                    System.out.println("Original Number: " + nc.displayOriginalNumber());
                    System.out.println("Number in " + base + " base: " + nc.convertArrayToString(nc.customBase(Integer.parseInt(number), base)));
                }
                else
                {
                    System.out.println("Please restart and choose a valid base!");
                }
            }
        }
        else
        {
            System.out.print("Enter the base of your number (2, 8, 10, 16): ");
            String choice = s.nextLine();
            int base = Integer.parseInt(choice);
            //CHECKING VALID BASES
            System.out.print("Enter your number: ");
            String number = s.nextLine();
            if (!(base == 2 || base == 8 || base == 10 || base == 16))
            {
                cont = false;
            }
            else if (base == 2 && cont) {
                for (int i = 0; i < number.length(); i++) {
                    char curr = number.charAt(i);
                    if (!((curr == '0') || (curr == '1'))) {
                        cont = false;
                    }
                }
            }
            else if (base == 8 && cont) {
                for (int i = 0; i < number.length(); i++) {
                    char curr = number.charAt(i);
                    if (curr < '0' || curr > '7') {
                        cont = false;
                    }
                }
            }
            else if (base == 10 && cont) {
                for (int i = 0; i < number.length(); i++) {
                    char curr = number.charAt(i);
                    if (curr < '0' || curr > '9') {
                        cont = false;
                    }
                }
            }
            else if (base == 16 && cont) {
                for (int i = 0; i < number.length(); i++) {
                    char x = number.charAt(i);
                    if (!((number.charAt(i) >= '0' && number.charAt(i) <= '9') || (x == 'A' || x == 'B' || x == 'C' || x == 'D' || x == 'E'))) {
                        cont = false;
                    }
                }
            }
            if (!cont) {
                System.out.println("Please restart and input a valid number/base!");
            }

            else {
                NumberConverter nc = new NumberConverter(number, base);
                System.out.println("Decimal Val: " + nc.convertArrayToString(nc.convertToDecimal()));
                System.out.println("Binary Val: " + nc.convertArrayToString(nc.convertToBinary()));
                System.out.println("Octal Val: " + nc.convertArrayToString(nc.convertToOctal()));
                System.out.println("Hex Val: " + nc.convertArrayToString(nc.convertToHex()));
            }
        }
    }
}


