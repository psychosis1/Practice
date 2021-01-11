package org.company.util;

import javax.swing.*;
import java.awt.*;

public abstract class BaseForm extends JFrame {
    public BaseForm() {
        setTitle(getTitle());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight() / 2
        );
    }

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract String getTitle();
}
