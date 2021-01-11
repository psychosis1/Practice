package org.company.ui;

import org.company.util.BaseForm;

import javax.swing.*;

public class Start extends BaseForm {
    private JPanel panel;
    private JButton register;
    private JButton enter;

    public Start() {
        setContentPane(panel);
        buttons();
        pack();
        setVisible(true);
    }

    void buttons() {
        register.addActionListener(e -> {dispose(); new Register();});
        enter.addActionListener(e -> {dispose(); new Enter();});
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
        return "Начало";
    }
}
