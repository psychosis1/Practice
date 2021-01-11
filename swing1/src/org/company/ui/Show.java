package org.company.ui;

import org.company.Application;
import org.company.data.SexEnum;
import org.company.data.entity.User;
import org.company.util.BaseForm;
import org.company.util.Check;

import javax.swing.*;
import java.sql.SQLException;

public class Show extends BaseForm {
    private User user;
    private JPanel panel;
    private JLabel label;
    private JTextField login;
    private JTextField password;
    private JTextField age;
    private JComboBox<SexEnum> sex;
    private JButton back;
    private JTextField job;
    private JButton update;
    private JButton addNotes;
    private JTextArea note;

    Show(User user) {
        this.user = user;
        setContentPane(panel);
        buttons();
        fields();
        setVisible(true);
    }

    void buttons() {
        back.addActionListener(e -> {
            dispose();
            new ServiceTable();
        });
        update.addActionListener(e -> {
            int value = Check.integerPositiveValue(age.getText());
            if (value == -1) {
                JOptionPane.showMessageDialog(panel, "Введен неправильный возраст.");
                return;
            }

            user.setAge(value);
            user.setJob(job.getText());
            user.setLogin(login.getText());
            user.setPassword(password.getText());
            user.setSexEnum( (SexEnum)sex.getSelectedItem());
            try {
                Application.getApplication().getUserTable().update(user);
                JOptionPane.showMessageDialog(panel, "Пользователь успешно изменен");
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(panel, throwables.getMessage());
            }
        });

        addNotes.addActionListener(e -> {
            new Notes(this);
        });
    }

    void fields() {
        note.setEditable(false);
        sex.addItem(SexEnum.MALE);
        sex.addItem(SexEnum.FEMALE);

        login.setText(user.getLogin());
        password.setText(user.getPassword());
        sex.setSelectedItem(user.getSexEnum());
        age.setText(Integer.toString(user.getAge()));
        job.setText(user.getJob());
        note.setText(user.getNote());
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
        return "Текущий пользователь";
    }

    public User getUser() {
        return user;
    }
}
