package org.example;

import java.sql.*;
public class Main {

    public static Connection getConnection(String db, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/"+db+"?user="+user+"&password="+password;

        return DriverManager.getConnection(url);
    }

    public static ResultSet statement(Connection connection, String sql) throws SQLException {
        Statement statement = connection.createStatement();

        return statement.executeQuery(sql);
    }

    public static ResultSet fetchData(Connection connection, String sql, String p1) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,p1);

        return preparedStatement.executeQuery();
    }

    public static void delete(Connection connection, String sql, String p1) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,p1);

        preparedStatement.executeUpdate();
    }

    public static void update(Connection connection, String sql, String p1, String p2) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,p1);
        preparedStatement.setString(2,p2);

        preparedStatement.executeUpdate();
    }

    public static void insert(Connection connection, String sql, String p1, String p2, String p3, String p4, String p5, String p6) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,p1);
        preparedStatement.setString(2,p2);
        preparedStatement.setString(3,p3);
        preparedStatement.setString(4,p4);
        preparedStatement.setString(5,p5);
        preparedStatement.setString(6,p6);

        preparedStatement.executeUpdate();
    }

    public static void Console(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String[] colum = new String[7];
            colum[0] = resultSet.getString("id");
            colum[1] = resultSet.getString("nombres");
            colum[2] = resultSet.getString("apellido_paterno");
            colum[3] = resultSet.getString("apellido_materno");
            colum[4] = resultSet.getString("fecha_nacimiento");
            colum[5] = resultSet.getString("correo");
            colum[6] = resultSet.getString("ciudad");

            System.out.println(colum[0] + " | " + colum[1] + " | " + colum[2] + " | " + colum[3] + " | " + colum[4] + " | " + colum[5] + " | " + colum[6]);
        }
    }

    public static void Message(String msg) {
        System.out.println(msg);
    }
}