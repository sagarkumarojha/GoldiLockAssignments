import java.util.Scanner;
/**Write a function to convert a decimal number string into binary string. 
 * For example, string A contains “123” which is decimal value 123. 
 * Convert this string into binary string. */
public class problem_1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a decimal number: ");
            String decimalString = scanner.nextLine();
            int decimalValue = Integer.parseInt(decimalString);
            String binaryString = binaryConverter(decimalValue);
            System.out.println("Binary representation: " + binaryString);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter a valid decimal number.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); 
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    public static String binaryConverter(int decimalValue) {
        if (decimalValue < 0) {
            throw new ArithmeticException("Error: Invalid input. Please enter a valid non-negative decimal number.");
        }
        if (decimalValue == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        while (decimalValue > 0) {
            int remainder = decimalValue % 2;
            binary.insert(0, remainder);
            decimalValue /= 2;
        }

        return binary.toString();
    }
}

// Time-Taken --->  15-20 minutes