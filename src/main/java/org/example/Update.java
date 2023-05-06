package org.example;

import java.sql.*;
import java.util.Scanner;

import static org.example.Main.*;

public class Update {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el correo actualizado: ");
        String email = scanner.nextLine();

        scanner.close();

        try {
            Connection connection = getConnection("develop", "root", "root");

            // todo datos del cliente antes de la ejecución del update
            String msg = "-- DATOS ANTES DE LA EJECUCIÓN DEL UPDATE --";
            Message(msg);

            String sql = "select * from cliente c where id = ?";
            ResultSet resultSetBefore = fetchData(connection, sql, id);
            Console(resultSetBefore);

            // todo ejecución del update
            String scriptSQL = "update cliente set correo=? where id=?";
            update(connection, scriptSQL, email, id);

            // todo datos del cliente después de la ejecución del update
            msg = "-- DATOS DESPUÉS DE LA EJECUCIÓN DEL UPDATE --";
            Message(msg);

            ResultSet resultSetAfter = fetchData(connection, sql, id);
            Console(resultSetAfter);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("No se puede conectar a la BD", e);
        }
    }
}
