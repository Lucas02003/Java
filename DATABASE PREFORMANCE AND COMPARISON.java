# Database Performance Comparison with Batch Updates

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePerformance {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            insertRecordsWithoutBatch(connection);
            insertRecordsWithBatch(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertRecordsWithoutBatch(Connection connection) throws SQLException {
        long startTime = System.currentTimeMillis();
        String sql = "INSERT INTO Temp(num1, num2, num3) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 1000; i++) {
            preparedStatement.setDouble(1, Math.random());
            preparedStatement.setDouble(2, Math.random());
            preparedStatement.setDouble(3, Math.random());
            preparedStatement.executeUpdate();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken without batch: " + (endTime - startTime) + " ms");
        preparedStatement.close();
    }

    private static void insertRecordsWithBatch(Connection connection) throws SQLException {
        long startTime = System.currentTimeMillis();
        String sql = "INSERT INTO Temp(num1, num2, num3) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 1000; i++) {
            preparedStatement.setDouble(1, Math.random());
            preparedStatement.setDouble(2, Math.random());
            preparedStatement.setDouble(3, Math.random());
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with batch: " + (endTime - startTime) + " ms");
        preparedStatement.close();
    }
}