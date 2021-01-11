package org.company.ui;

import org.company.Application;
import org.company.data.entity.Service;
import org.company.util.BaseForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ServiceTable extends BaseForm {
    private JPanel panel;
    private JTable table;
    private JButton addService;

    private DefaultTableModel model;

    public ServiceTable() {
        setContentPane(panel);
        buttons();
        table();
        tableClick();

        setVisible(true);
    }

    void buttons() {
//        addService.addActionListener(e -> {
//            new Add(this);
//        });
    }

    void table() {
        table.getTableHeader().setReorderingAllowed(false);

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setModel(model);

        List<String> list = Arrays.asList("ID","Название", "Цена", "Время", "Описание", "Скидка", "Путь");

        for (String item : list)
            model.addColumn(item);
        try {
            List<Service> services = Application.getApplication().getServiceTable().getAll();
            services.forEach(service -> {
                model.addRow(new Object[]{
                        service.getId(),
                        service.getTitle(),
                        service.getCost(),
                        service.getDurationInSeconds(),
                        service.getDescription(),
                        service.getDiscount(),
                        service.getMainImagePath()
                });
            });
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    void tableClick() {
        table.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table = (JTable)mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
                {
                    Object[] objects = new Object[table.getColumnCount()];
                    for (int i = 0; i < objects.length; i++) {
                        objects[i] = table.getValueAt(row, i);
                    }

              /*      new Edit(ServiceTable.this,
                            new Service(
                            (int) objects[0],
                            (String) objects[1],
                            (double) objects[2],
                            (int) objects[3],
                            (String) objects[4],
                            (double) objects[5],
                            (String) objects[6]
                    ),row);*/
                }
            }
        });
    }

    public DefaultTableModel getModel() {
        return model;
    }

    @Override
    public int getWidth() {
        return 600;
    }

    @Override
    public int getHeight() {
        return 400;
    }

    @Override
    public String getTitle() {
        return "Главное окно";
    }
}
