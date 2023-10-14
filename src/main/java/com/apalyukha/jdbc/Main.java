package com.apalyukha.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:");
        Statement statement = connection.createStatement();

        statement.execute("CREATE TABLE foo(val INT, name VARCHAR(100))");
        statement.execute("INSERT INTO foo(val, name) VALUES (1, 'test')");

        ResultSet resultSet = statement.executeQuery("SELECT val, name FROM foo");
        while (resultSet.next()) {
            int val = resultSet.getInt(1);
            int val2 = resultSet.getInt("val");
            String name = resultSet.getString("name");
            System.out.printf("val=%d, val2=%d, name=%s%n", val, val2, name);
        }
    }
}
