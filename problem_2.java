import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class problem_2 {
    /**
     * Write a program to read a CSV file and print the same in the output file. 
     * This csv file contains three columns having numeric value. 
     * The output file should additionally contain the sum of these numeric values. */

    public static void main(String[] args) {
        String inputFileName = "input.csv";
        String outputFileName = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))){

            processCSVFile(reader, writer);
            System.out.println("CSV file has been read and data is written to the output file.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O exception occurred.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    public static void processCSVFile(BufferedReader reader,BufferedWriter writer) throws IOException {
            double sum = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                double lineSum = processCSVLine(line, writer);
                sum += lineSum;
            }
            
            writer.write("Sum of numeric values: " + sum);
    }

    public static double processCSVLine(String line, BufferedWriter writer) throws IOException {
        String[] columns = line.split(",");
        double lineSum = 0;

        if (columns.length == 3) {
            try {
                double numericValue1 = Double.parseDouble(columns[0]);
                double numericValue2 = Double.parseDouble(columns[1]);
                double numericValue3 = Double.parseDouble(columns[2]);
                
                lineSum = numericValue1 + numericValue2 + numericValue3;
                writer.write(line + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid numeric value found in the CSV.");
            }
        } else {
            System.out.println("Error: Invalid format in CSV line. Skipping line: " + line);
        }

        return lineSum;
    }
}

// Time-Taken ---> about 15-20 minutes
