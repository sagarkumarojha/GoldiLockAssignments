import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class problem_3 {
    /**Write a program to read value from the DB. The SB scheme is as follows:
a. Username: root
b. Password: root
c. Table name: test
d. Schema
i. Emp name varchar 200
ii. Emp age int 10
 */
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT emp_name, emp_age FROM test";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    String empName = resultSet.getString("emp_name");
                    int empAge = resultSet.getInt("emp_age");

                    System.out.println("Employee Name: " + empName + ", Employee Age: " + empAge);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Time-Taken ---> about 10-15 minutes