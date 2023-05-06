package org.example;

import java.sql.*;

import static org.example.Main.*;

public class Read {

    public static void main(String[] args) {

        try {
            Connection connection = getConnection("develop", "root", "root");

            String scriptSQL = "select * from cliente where ciudad = 'Lima'";
            ResultSet resultSet = statement(connection, scriptSQL);

            // todo lista de clientes de Lima
            String msg = "-- LISTA DE CLIENTES DE LIMA --";
            Message(msg);

            Console(resultSet);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("No se puede conectar a la BD", e);
        }
    }
}
