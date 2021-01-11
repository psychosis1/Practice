package org.company.ui.customTable;

import org.company.Application;
import org.company.data.entity.Client;
import org.company.data.entity.Service;
import org.company.ui.Add;
import org.company.ui.Edit;
import org.company.util.BaseForm;
import org.company.util.CustomTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ServiceTable extends BaseForm {
    private JPanel panel;
    private JTable table;
    private JButton add;
    private JComboBox comboBox;
    private JLabel count;

    private CustomTableModel<Service> customTableModel;

    public ServiceTable() {
        setContentPane(panel);

        table();

        sorts();

        buttons();

        setVisible(true);
    }


    private void table() {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            customTableModel = new CustomTableModel<>(Service.class, Arrays.asList("ID", "Название", "Цена", "Время", "Описание", "Скидка", "Путь"),
                    Application.getApplication().getServiceTable().getAll());

            updateRowCountLabel(customTableModel.getValues().size());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        table.setModel(customTableModel);


        table.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table = (JTable)mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
                {
                    new Edit(ServiceTable.this,customTableModel.getValues().get(row),row);
                }
            }
        });


        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    try {
                        Application.getApplication().getServiceTable().remove(customTableModel.getValues().remove(row));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    customTableModel.fireTableDataChanged();
                    updateRowCountLabel(customTableModel.getValues().size());
                }
            }
        });

    }

    private void buttons() {
        add.addActionListener(e -> {
            new Add(this);
        });
    }


    private void sorts() {

        comboBox.addItem("Все");
        comboBox.addItem("0%-5%");
        comboBox.addItem("5%-15%");
        comboBox.addItem("15%-30%");
        comboBox.addItem("30%-70%");
        comboBox.addItem("70%-100%");

        comboBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                filter();
            }
        });

    }

    private void filter() {
        try {
            List<Service> services = Application.getApplication().getServiceTable().getAll();
            int max = services.size();

            if(comboBox.getSelectedIndex() == 1) {
                services.removeIf(service -> !(service.getDiscount()>=0 && service.getDiscount()<5));
            } else if(comboBox.getSelectedIndex() == 2) {
                services.removeIf(service -> !(service.getDiscount()>=5 && service.getDiscount()<15));
            }else if(comboBox.getSelectedIndex() == 3) {
                services.removeIf(service -> !(service.getDiscount()>=15 && service.getDiscount()<30));
            }else if(comboBox.getSelectedIndex() == 4) {
                services.removeIf(service -> !(service.getDiscount()>=30 && service.getDiscount()<70));
            }else if(comboBox.getSelectedIndex() == 5) {
                services.removeIf(service -> !(service.getDiscount()>=70 && service.getDiscount()<=100));
            }

            customTableModel.setValues(services);
            customTableModel.fireTableDataChanged();
            updateRowCountLabel(max);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateRowCountLabel(int newMax)
    {
        count.setText("( " + customTableModel.getValues().size() + " / " + newMax + " )");
    }

    public CustomTableModel<Service> getCustomTableModel() {
        return customTableModel;
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
        return "Список услуг";
    }
}
