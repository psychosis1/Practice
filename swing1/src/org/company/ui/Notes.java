package org.company.ui;

import org.company.Application;
import org.company.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;

public class Notes extends BaseSubForm<Show> {
    private JPanel panel;
    private JTextArea note;
    private JButton cancel;
    private JButton save;

    private Show show;

    Notes(Show show) {
        super(show);
        this.show = show;

        setContentPane(panel);
        buttons();
        fields();
        setVisible(true);
    }

    void fields() {
        note.setText(show.getUser().getNote());
    }

    void buttons() {
        cancel.addActionListener(e -> {
            closeSubForm();
        });

        save.addActionListener(e -> {
            try {
                show.getUser().setNote(note.getText());
                Application.getApplication().getUserTable().updateNote(show.getUser());
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(panel, throwables.getMessage());
            }
            show.fields();
            closeSubForm();
        });
    }

    @Override
    public int getWidth() {
        return 400;
    }

    @Override
    public int getHeight() {
        return 400;
    }

    @Override
    public String getTitle() {
        return "Заметки";
    }
}
