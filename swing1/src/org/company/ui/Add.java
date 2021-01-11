package org.company.ui;

import org.company.Application;
import org.company.data.entity.Client;
import org.company.data.entity.Service;
import org.company.ui.customTable.ServiceTable;
import org.company.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;


public class Add extends BaseSubForm<ServiceTable> {
    private JPanel panel;
    private JLabel label;
    private JTextField title;
    private JTextField cost;
    private JTextField durationInSeconds;
    private JTextField description;
    private JTextField discount;
    private JTextField mainImagePath;
    private JButton back;
    private JButton next;


    private ServiceTable service;

    public Add(ServiceTable service) {
        super(service);
        this.service = service;


        setContentPane(panel);
        buttons();
        setVisible(true);
    }

    void buttons() {
        back.addActionListener(e -> {
            closeSubForm();
        });

        next.addActionListener(e -> {
            try {
                Service service = Application.getApplication().getServiceTable().add(new Service(
                        title.getText(),
                        Double.parseDouble(cost.getText()),
                        Integer.parseInt(durationInSeconds.getText()),
                        description.getText(),
                        Double.parseDouble(discount.getText()),
                        mainImagePath.getText()
                ));

                mainForm.getCustomTableModel().getValues().add(service);

                mainForm.getCustomTableModel().fireTableDataChanged();

                closeSubForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }

    @Override
    public int getWidth() {
        return 500;
    }

    @Override
    public int getHeight() {
        return 500;
    }

    @Override
    public String getTitle() {
        return "Добавление";
    }
}
