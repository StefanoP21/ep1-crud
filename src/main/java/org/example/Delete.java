package org.example;

import java.sql.*;
import java.util.Scanner;

import static org.example.Main.*;

public class Delete {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        String id = scanner.nextLine();

        scanner.close();

        try {
            Connection connection = getConnection("develop", "root", "root");

            // todo datos del cliente antes de la ejecución del delete
            String msg = "-- DATOS ANTES DE LA EJECUCIÓN DEL DELETE --";
            Message(msg);

            String sql = "select * from cliente c where id=?";
            ResultSet resultSetBefore = fetchData(connection, sql, id);
            Console(resultSetBefore);

            // todo ejecución del delete
            String scriptSQL = "delete from cliente where id=?";
            delete(connection, scriptSQL, id);

            // todo datos del cliente después de la ejecución del delete
            msg = "-- CLIENTE ELIMINADO --";
            Message(msg);

            String sql2 = "select * from cliente c";
            ResultSet resultSetAfter = statement(connection, sql2);
            Console(resultSetAfter);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("No se puede conectar a la BD", e);
        }
    }
}
