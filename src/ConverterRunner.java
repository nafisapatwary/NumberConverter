import java.util.Scanner;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8, 10, 16): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        boolean cont = true;
        String number = s.nextLine();
        if (base == 2 && cont)
        {
            for (int i = 0; i < number.length(); i++)
            {
                if (!((number.charAt(i) == '0') || (number.charAt(i) == '1')))
                {
                    cont = false;
                }
            }
        }
        else if (base == 8 && cont)
        {
            for (int i = 0; i < number.length(); i++)
            {
                char x = number.charAt(i);
                if (!((number.charAt(i) >= '0' && number.charAt(i) < '8')))
                {
                    cont = false;
                }

            }
        }
        else if (base == 16 && cont)
        {
            for (int i = 0; i < number.length(); i++)
            {
                char x = number.charAt(i);
                if (!((number.charAt(i) >= '0' && number.charAt(i) <= '9') || (x == 'A' || x == 'B' || x == 'C' || x == 'D' || x == 'E')))
                {
                    cont = false;
                }
            }
        }
        if (!cont)
        {
            System.out.println("Please restart and input a valid number for your chosen base!");
        }

        else {
            NumberConverter nc = null;
            if (base == 16)
            {
                nc = new NumberConverter(number, base);
                System.out.println("Original Number: " + nc.displayOriginalHexNumber());
            }
            else
            {
                int n = Integer.parseInt(number);
                nc = new NumberConverter(n, base);
                System.out.println("Original Number: " + nc.displayOriginalNumber());
            }
            s.close();
            System.out.println("Decimal Val: " + nc.convertArrayToString(nc.convertToDecimal()));
            System.out.println("Binary Val: " + nc.convertArrayToString(nc.convertToBinary()));
            System.out.println("Octal Val: " + nc.convertArrayToString(nc.convertToOctal()));
            System.out.println("Hex Val: " + nc.convertArrayToString(nc.convertToHex()));
        }
    }
}


