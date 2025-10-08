import java.sql.*;

public class RetrieveEmployeeData {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Change this
        String user = "root";   // Your MySQL username
        String password = "your_password"; // Your MySQL password

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ JDBC Driver Loaded Successfully.");

            // 2. Establish the Connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to the Database.");

            // 3. Create a Statement object
            stmt = conn.createStatement();

            // 4. Execute SQL SELECT query
            String sql = "SELECT EmpID, Name, Salary FROM Employee";
            rs = stmt.executeQuery(sql);

            // 5. Process and display the result
            System.out.println("\n--- Employee Records ---");
            System.out.printf("%-10s %-20s %-10s\n", "EmpID", "Name", "Salary");
            System.out.println("------------------------------------------");

            while (rs.next()) {
                int empID = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");

                System.out.printf("%-10d %-20s %-10.2f\n", empID, name, salary);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database error occurred!");
            e.printStackTrace();
        } finally {
            // 6. Close all resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("\n✅ Resources closed. Program finished.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
