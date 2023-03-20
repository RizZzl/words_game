import java.sql.*;

public class Main {
    private static String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false";
    private static String user = "root";
    private static String pass = "testtest";

    public static void main(String[] args) throws Exception {
        Connection connection1 = DriverManager.getConnection(url, user, pass);
        Statement statement1 = connection1.createStatement();
        ResultSet resultSet2 = statement1.executeQuery("SELECT course_name, COUNT(course_name)/((MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date))) + 1) AS Coefficient FROM PurchaseList GROUP BY course_name");
        while (resultSet2.next()) {
            String result = resultSet2.getString("course_name") + " - " + resultSet2.getString("Coefficient");
            System.out.println(result);
        }
        resultSet2.close();
        statement1.close();
        connection1.close();
    }
}
