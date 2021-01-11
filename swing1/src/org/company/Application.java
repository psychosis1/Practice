package org.company;

import org.company.data.tables.ClientTable;
import org.company.data.tables.ServiceTable;
import org.company.data.tables.UserTable;
import org.company.ui.customTable.Table;
import org.company.util.FontUtil;
import org.company.util.MySQLDatabase;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class Application {
    Application () {
        application = this;

        initUI();

        new org.company.ui.customTable.ServiceTable();
    }
    public static Application application;
    private final MySQLDatabase database = new MySQLDatabase("localhost", "practice", "root", "1234");
    private final UserTable userTable = new UserTable(database);
    private final ServiceTable serviceTable = new ServiceTable(database);
    private final ClientTable clientTable = new ClientTable(database);

    public static void main(String[] args) {
        new Application();
    }

    public void initUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FontUtil.changeAllFonts(new FontUIResource("Tw Cen MT", Font.TRUETYPE_FONT, 16));
    }

    public MySQLDatabase getDatabase() {
        return database;
    }

    public UserTable getUserTable() {
        return userTable;
    }

    public ServiceTable getServiceTable() {
        return serviceTable;
    }

    public ClientTable getClientTable() {
        return clientTable;
    }

    public static Application getApplication() {
        return application;
    }
}
