package org.company.data.tables;

import org.company.data.SexEnum;
import org.company.data.entity.User;
import org.company.util.MySQLDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private MySQLDatabase mySQLDatabase;

    public UserTable(MySQLDatabase mySQLDatabase) {
        this.mySQLDatabase = mySQLDatabase;
    }

    public User add(User user) throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "INSERT INTO User(login, password, sex, age, job) values(?,?,?,?,?)";
            PreparedStatement s = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            s.setString(1, user.getLogin());
            s.setString(2, user.getPassword());
            s.setString(3, user.getSexEnum().toString());
            s.setInt(4, user.getAge());
            s.setString(5, user.getJob());
            s.executeUpdate();

            ResultSet keys = s.getGeneratedKeys();
            if (keys.next()) {
                user.setId(keys.getInt(1));
                return user;
            }
            throw new SQLException("Пользователь не добавлен");
        }
    }


    public User getByLoginAndPass(String login, String pass) throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "SELECT * FROM User WHERE login=? AND password=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, login);
            s.setString(2, pass);

            ResultSet resultSet = s.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("idUser"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        SexEnum.getEnum(resultSet.getString("sex")),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("note")
                );
            }
            throw new SQLException("Пользователь не найден");
        }
    }

    public List<User> getAll() throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "SELECT * FROM User";
            Statement statement = c.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while(resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("idUser"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        SexEnum.getEnum(resultSet.getString("sex")),
                        resultSet.getInt("age"),
                        resultSet.getString("job"),
                        resultSet.getString("note")
                ));
            }
            return users;
        }
    }

    public int update(User user) throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "UPDATE User SET login=?, password=?, sex=?, age=?, job=? WHERE idUser=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, user.getLogin());
            s.setString(2, user.getPassword());
            s.setString(3, user.getSexEnum().toString());
            s.setInt(4, user.getAge());
            s.setString(5, user.getJob());
            s.setInt(6, user.getId());

            return s.executeUpdate();
        }
    }

    public int updateNote(User user) throws SQLException {
        try (Connection c = mySQLDatabase.getConnection()) {
            String sql = "UPDATE User SET note=? WHERE idUser=?";
            PreparedStatement s = c.prepareStatement(sql);
            s.setString(1, user.getNote());
            s.setInt(2, user.getId());

            return s.executeUpdate();
        }
    }

}
