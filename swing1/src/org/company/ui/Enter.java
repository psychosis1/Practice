package org.company.ui;

import org.company.Application;
import org.company.data.SexEnum;
import org.company.data.entity.User;
import org.company.util.BaseForm;
import org.company.util.Check;

import javax.swing.*;
import java.sql.SQLException;

public class Enter extends BaseForm {
    private JTextField login;
    private JPanel panel;
    private JButton back;
    private JButton next;
    private JPasswordField password;

    Enter() {
        setContentPane(panel);
        buttons();
        setVisible(true);
    }

    void buttons() {
        back.addActionListener(e -> {
            dispose();
            new Start();
        });

        next.addActionListener(e -> {
            try {
                User user = Application.getApplication().getUserTable().getByLoginAndPass(
                        login.getText(),
                        new String(password.getPassword()));

                dispose();
                new Show(user);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(panel, ex.getMessage());
            }




        });
    }

    @Override
    public int getWidth() {
        return 300;
    }

    @Override
    public int getHeight() {
        return 300;
    }

    @Override
    public String getTitle() {
        return "Вход";
    }
}
