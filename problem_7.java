public class problem_7 {
    /**Write a program that take the command line input and print all received inputs */
    public static void main(String[] args) {
        System.out.println("Received command-line inputs:");
        
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}

// Time-Taken ---> about less than 5 minutes