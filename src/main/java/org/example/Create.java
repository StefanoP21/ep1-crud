package org.example;

import java.sql.*;
import java.util.Scanner;

import static org.example.Main.*;

public class Create {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido paterno del cliente: ");
        String apellidoPaterno = scanner.nextLine();

        System.out.print("Ingrese el apellido materno del cliente: ");
        String apellidoMaterno = scanner.nextLine();

        System.out.print("Ingrese la fecha de nacimiento (yyyy-mm-dd) del cliente: ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese el correo del cliente: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese la ciudad del cliente: ");
        String ciudad = scanner.nextLine();

        scanner.close();

        try {
            Connection connection = getConnection("develop", "root", "root");

            // todo ejecución del insert
            String scriptSQL = "INSERT INTO cliente (nombres, apellido_paterno, apellido_materno, fecha_nacimiento, correo, ciudad)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            insert(connection, scriptSQL, nombre, apellidoPaterno, apellidoMaterno, fecha, correo, ciudad);

            // todo mostrar datos del cliente ingresado
            String msg = "-- DATOS DEL CLIENTE INGRESADOS --";
            Message(msg);

            String sql = "select * from cliente c where apellido_paterno=?";
            ResultSet resultSet = fetchData(connection, sql, apellidoPaterno);
            Console(resultSet);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("No se puede conectar a la BD", e);
        }
    }
}
