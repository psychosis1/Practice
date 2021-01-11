package org.company.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLDatabase {
    private final String address;
    private final int port;
    private final String db;
    private final String user;
    private final String password;

    private MysqlDataSource source;

    public MySQLDatabase(String address, int port, String db, String user, String pass) {
        this.address = address;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = pass;
    }

    public MySQLDatabase(String address, String db, String user, String password) {
        this(address, 3306, db, user, password);
    }

    public Connection getConnection() throws SQLException {
        if (source == null) {
            source = new MysqlDataSource();

            source.setServerName(address);
            source.setDatabaseName(db);
            source.setPort(port);
            source.setUser(user);
            source.setPassword(password);

            source.setServerTimezone("Europe/Moscow");
        }

        return source.getConnection();
    }
}
