package org.company.data.tables;

import org.company.data.SexEnum;
import org.company.data.entity.Service;
import org.company.data.entity.User;
import org.company.util.MySQLDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTable {

    private MySQLDatabase mySQLDatabase;

    public ServiceTable(MySQLDatabase mySQLDatabase) {
        this.mySQLDatabase = mySQLDatabase;
    }

    public Service add(Service service) throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "INSERT INTO Service(Title,Cost,DurationInSeconds,Description,Discount,MainImagePath) values(?,?,?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, service.getTitle());
            s.setDouble(2, service.getCost());
            s.setInt(3, service.getDurationInSeconds());
            s.setString(4, service.getDescription());
            s.setDouble(5, service.getDiscount());
            s.setString(6, service.getMainImagePath());
            s.executeUpdate();

            ResultSet keys = s.getGeneratedKeys();
            if (keys.next()) {
                service.setId(keys.getInt(1));
                return service;
            }
            throw new SQLException("Сервис не добавлен");
        }
    }

    public List<Service> getAll() throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "SELECT * FROM Service";
            Statement statement = c.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            List<Service> services = new ArrayList<>();
            while(resultSet.next()) {
                services.add(new Service(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getDouble("Cost"),
                        resultSet.getInt("DurationInSeconds"),
                        resultSet.getString("Description"),
                        resultSet.getDouble("Discount"),
                        resultSet.getString("MainImagePath")
                        )
                );
            }
            return services;
        }
    }

    public Service update(Service service) throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "UPDATE Service SET title=?, cost=?, durationInSeconds=?, description=?, discount = ?, mainImagePath = ? WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);

            s.setString(1, service.getTitle());
            s.setDouble(2, service.getCost());
            s.setInt(3, service.getDurationInSeconds());
            s.setString(4, service.getDescription());
            s.setDouble(5, service.getDiscount());
            s.setString(6, service.getMainImagePath());
            s.setInt(7, service.getId());

            s.executeUpdate();
            return service;
        }
    }

    public void remove(Service service) throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "DELETE FROM Service WHERE id=?";
            PreparedStatement s = c.prepareStatement(sql);

            s.setInt(1, service.getId());

            s.executeUpdate();
        }
    }
}
