package org.company.ui.customTable;

import org.company.Application;
import org.company.data.entity.Client;
import org.company.util.BaseForm;
import org.company.util.CustomTableModel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Arrays;

public class Table extends BaseForm {
    private JPanel panel;
    private JTable table;
    private JButton dateRegisterSort;
    private JComboBox emailBox;

    private boolean dateRegister = false;

    private CustomTableModel<Client> customTableModel;

    public Table() {
        setContentPane(panel);

        table();

        sorts();

        setVisible(true);
    }


    private void table() {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            customTableModel = new CustomTableModel<>(Client.class, Arrays.asList("ID", "Имя", "Фамилия", "Отчество", "День рождения", "Дата регистрации", "Email", "Телефон", "Гендер", "Путь до фото"),
                    Application.getApplication().getClientTable().getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        table.setModel(customTableModel);

    }


    private void sorts() {
        dateRegisterSort.addActionListener(e -> {
            customTableModel.getValues().sort((o1, o2) -> {
                if (dateRegister)
                    return o2.getRegistrationDate().compareTo(o1.getRegistrationDate());
                else
                    return o1.getRegistrationDate().compareTo(o2.getRegistrationDate());

            });
            dateRegister = !dateRegister;
            customTableModel.fireTableDataChanged();
        });

        
    }

    @Override
    public int getWidth() {
        return 900;
    }

    @Override
    public int getHeight() {
        return 600;
    }

    @Override
    public String getTitle() {
        return "Клиенты";
    }
}
