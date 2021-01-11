package org.company.ui;

import org.company.Application;
import org.company.data.entity.Service;
import org.company.util.BaseSubForm;

import org.company.ui.customTable.ServiceTable;

import javax.swing.*;
import java.sql.SQLException;

public class Edit extends BaseSubForm<ServiceTable> {
    private JPanel panel;
    private JTextField title;
    private JTextField cost;
    private JTextField durationInSeconds;
    private JTextField description;
    private JTextField discount;
    private JButton edit;
    private JTextField mainImagePath;

    private int row;
    private Service service;
    private ServiceTable main;

    public Edit(ServiceTable main, Service service, int row) {
        super(main);
        this.service = service;
        this.row = row;

        setContentPane(panel);
        buttons();
        fields();
        setVisible(true);
    }

    void buttons() {
        edit.addActionListener(e -> {

            service.setTitle(title.getText());
            service.setCost(Double.parseDouble(cost.getText()));
            service.setDurationInSeconds(Integer.parseInt(durationInSeconds.getText()));
            service.setDescription(description.getText());
            service.setDiscount(Double.parseDouble(discount.getText()));
            service.setMainImagePath(mainImagePath.getText());

            try {
                Service serviceUpdated = Application.getApplication().getServiceTable().update(service);
                JOptionPane.showMessageDialog(panel, "Услуга успешно изменена");

                mainForm.getCustomTableModel().getValues().set(row,serviceUpdated);

                mainForm.getCustomTableModel().fireTableDataChanged();

                closeSubForm();
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(panel, throwables.getMessage());
            }
        });


    }

    void fields() {

        title.setText(service.getTitle());
        cost.setText(Double.toString(service.getCost()));
        durationInSeconds.setText(Integer.toString(service.getDurationInSeconds()));
        description.setText(service.getDescription());
        discount.setText(Double.toString(service.getDiscount()));
        mainImagePath.setText(service.getMainImagePath());
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
        return "Текущая услуга";
    }
}
