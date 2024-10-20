import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TestConnectDb {
     
    private static final String DB_URL = "jdbc:sqlserver://DESKTOP-G39PQNG\\SQLEXPRESS:1433;encrypt=true;trustServerCertificate=true;databaseName=MockProject";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Kết nối với cơ sở dữ liệu
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Kết nối thành công với SQL Server!");

            // Tạo Statement và thực hiện truy vấn
            String query = "SELECT * FROM Role";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Duyệt qua kết quả
            while (resultSet.next()) {
                int orderId = resultSet.getInt("role_id");
                String totalAmount = resultSet.getString("roleName");
                System.out.println("Order ID: " + orderId + ", Total Amount: " + totalAmount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            
        }
    }
}
