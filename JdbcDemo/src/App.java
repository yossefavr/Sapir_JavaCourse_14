import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Console console = System.console();

        if (console == null) {
            System.err.println("Run this program from CMD.");
            return;
        }

        char[] passwordChars = console.readPassword("MySQL password: ");

        if (passwordChars == null) {
            return;
        }

        String password = new String(passwordChars);
        Arrays.fill(passwordChars, '\0');

        String url = "jdbc:mysql://localhost:3306/sapir_java_course_demo";
        String username = "root";
        String sql = "SELECT id, name, hours FROM courses ORDER BY id";

        try (
            Connection connection =
                DriverManager.getConnection(url, username, password);

            PreparedStatement statement =
                connection.prepareStatement(sql);

            ResultSet results = statement.executeQuery()
        ) {
            System.out.printf("%-5s %-25s %s%n", "ID", "Course", "Hours");

            while (results.next()) {
                int id = results.getInt("id");
                String name = results.getString("name");
                int hours = results.getInt("hours");

                System.out.printf("%-5d %-25s %d%n", id, name, hours);
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}