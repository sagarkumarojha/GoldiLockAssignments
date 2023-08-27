

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class problem_4 {
    /**Write a program to call a HTTP URL and print the output
a. URL is http://127.0.0.1:8999/test?value=p */
    public static void main(String[] args) {
        String urlStr = "http://127.0.0.1:8999/test?value=p";

        try {
            String response = callHTTPUrl(urlStr);
            System.out.println("HTTP Response:");
            System.out.println(response);
        } catch (IOException e) {
            System.out.println("An error occurred while calling the HTTP URL: " + e.getMessage());
        }
    }

    public static String callHTTPUrl(String urlStr) throws IOException {
        URL url = new URL(urlStr);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }

            return response.toString();
        }
    }
}
// Time-Taken ---> about 10-15 minutes