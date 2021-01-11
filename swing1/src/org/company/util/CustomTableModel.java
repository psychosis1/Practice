package org.company.util;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

public class CustomTableModel<T> extends AbstractTableModel {

    private final Class<T> tClass;

    private final List<String> columnNames;

    private List<T> values;

    public CustomTableModel(Class<T> tClass, List<String> columnNames, List<T> values) {
        this.tClass = tClass;
        this.columnNames = columnNames;
        this.values = values;
    }

    @Override
    public int getRowCount() {
        return values.size();
    }

    @Override
    public int getColumnCount() {
        return tClass.getDeclaredFields().length;
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return tClass.getDeclaredFields()[column].getType();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Field field = tClass.getDeclaredFields()[columnIndex];

        field.setAccessible(true);

        try {
            return field.get(values.get(rowIndex));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<T> getValues() {
        return values;
    }

    public CustomTableModel<T> setValues(List<T> values) {
        this.values = values;
        return this;
    }
}
