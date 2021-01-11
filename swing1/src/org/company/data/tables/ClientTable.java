package org.company.data.tables;

import org.company.data.entity.Client;
import org.company.util.MySQLDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientTable {
    private MySQLDatabase mySQLDatabase;

    public ClientTable(MySQLDatabase mySQLDatabase) {
        this.mySQLDatabase = mySQLDatabase;
    }


    public List<Client> getAll() throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "SELECT * FROM Client";
            Statement statement = c.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            List<Client> clients = new ArrayList<>();
            while (resultSet.next()) {
                clients.add(new Client(
                                resultSet.getInt("ID"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Patronymic"),
                                resultSet.getTimestamp("Birthday"),
                                resultSet.getTimestamp("RegistrationDate"),
                                resultSet.getString("Email"),
                                resultSet.getString("Phone"),
                                resultSet.getString("GenderCode").charAt(0),
                                resultSet.getString("PhotoPath")
                        )
                );
            }
            return clients;
        }
    }
}
