import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class problem_6 {
    /**Write a HTTP server program that take the print the received value read from the DB as per Q3 */
    public static void main(String[] args) throws IOException {
        int port = 8000; // Choose a port number
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/getEmployee", new EmployeeHandler());
        server.start();

        System.out.println("Server started on port " + port);
    }

    static class EmployeeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = fetchEmployeeDataFromDB();

            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private String fetchEmployeeDataFromDB() {
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "root";

            StringBuilder response = new StringBuilder();

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 Statement statement = connection.createStatement()) {

                String query = "SELECT emp_name, emp_age FROM test";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String empName = resultSet.getString("emp_name");
                    int empAge = resultSet.getInt("emp_age");
                    response.append("Employee Name: ").append(empName).append(", Age: ").append(empAge).append("\n");
                }
            } catch (Exception e) {
                response.append("An error occurred: ").append(e.getMessage());
            }

            return response.toString();
        }
    }
}

// Time-Taken ---> about 20-30 minutes