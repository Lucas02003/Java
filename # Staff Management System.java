# Staff Management System

import java.sql.*;
import java.util.Scanner;

public class StaffManagement {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String choice;

            do {
                System.out.println("Choose an option: View (V), Insert (I), Update (U), Exit (E)");
                choice = scanner.nextLine().toUpperCase();

                switch (choice) {
                    case "V":
                        viewStaff(connection, scanner);
                        break;
                    case "I":
                        insertStaff(connection, scanner);
                        break;
                    case "U":
                        updateStaff(connection, scanner);
                        break;
                }
            } while (!choice.equals("E"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void viewStaff(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Staff ID to view: ");
        String id = scanner.nextLine();
        String query = "SELECT * FROM Staff WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("ID: " + resultSet.getString("id"));
            System.out.println("Last Name: " + resultSet.getString("lastName"));
            System.out.println("First Name: " + resultSet.getString("firstName"));
            System.out.println("MI: " + resultSet.getString("mi"));
            System.out.println("Address: " + resultSet.getString("address"));
            System.out.println("City: " + resultSet.getString("city"));
            System.out.println("State: " + resultSet.getString("state"));
            System.out.println("Telephone: " + resultSet.getString("telephone"));
            System.out.println("Email: " + resultSet.getString("email"));
        } else {
            System.out.println("No record found for ID: " + id);
        }
    }

    private static void insertStaff(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Staff ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter MI: ");
        String mi = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter State: ");
        String state = scanner.nextLine();
        System.out.print("Enter Telephone: ");
        String telephone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        String query = "INSERT INTO Staff (id, lastName, firstName, mi, address, city, state, telephone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, lastName);
        preparedStatement.setString(3, firstName);
        preparedStatement.setString(4, mi);
        preparedStatement.setString(5, address);
        preparedStatement.setString(6, city);
        preparedStatement.setString(7, state);
        preparedStatement.setString(8, telephone);
        preparedStatement.setString(9, email);
        preparedStatement.executeUpdate();

        System.out.println("Record inserted successfully.");
    }

    private static void updateStaff(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Staff ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter new First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter new MI: ");
        String mi = scanner.nextLine();
        System.out.print("Enter new Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new City: ");
        String city = scanner.nextLine();
        System.out.print("Enter new State: ");
        String state = scanner.nextLine();
        System.out.print("Enter new Telephone: ");
        String telephone = scanner.nextLine();
        System.out.print("Enter new Email: ");
        String email = scanner.nextLine();

        String query = "UPDATE Staff SET lastName = ?, firstName = ?, mi = ?, address = ?, city = ?, state = ?, telephone = ?, email = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, lastName);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, mi);
        preparedStatement.setString(4, address);
        preparedStatement.setString(5, city);
        preparedStatement.setString(6, state);
        preparedStatement.setString(7, telephone);
        preparedStatement.setString(8, email);
        preparedStatement.setString(9, id);
        preparedStatement.executeUpdate();

        System.out.println("Record updated successfully.");
    }
}
