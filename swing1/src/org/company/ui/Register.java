package org.company.ui;

import org.company.Application;
import org.company.data.SexEnum;
import org.company.data.entity.User;
import org.company.util.BaseForm;
import org.company.util.Check;

import javax.swing.*;
import java.sql.SQLException;

public class Register extends BaseForm {
    private JPanel panel;
    private JLabel label;
    private JTextField login;
    private JPasswordField password;
    private JComboBox<SexEnum> sex;
    private JTextField age;
    private JTextField job;
    private JButton back;
    private JButton next;

    Register() {
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

        next.addActionListener(e -> {
            int value = Check.integerPositiveValue(age.getText());
            if (value == -1) {
                JOptionPane.showMessageDialog(panel, "Введен неправильный возраст.");
                return;
            }
/*            if (Check.passwordValue(new String(password.getPassword())) == -1) {
                JOptionPane.showMessageDialog(panel, "Введен несоответствующий пароль.");
                return;
            }*/


            try {
                User user = Application.getApplication().getUserTable().add(new User(login.getText(),
                        new String(password.getPassword()),
                        (SexEnum) sex.getSelectedItem(),
                        value,
                        job.getText()
                ));
                dispose();
                new Show(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        });
    }

    void fields() {
        sex.addItem(SexEnum.MALE);
        sex.addItem(SexEnum.FEMALE);
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
        return "Регистрация";
    }
}
