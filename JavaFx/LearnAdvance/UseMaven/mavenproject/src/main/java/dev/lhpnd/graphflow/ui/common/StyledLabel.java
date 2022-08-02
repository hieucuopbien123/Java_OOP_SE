package dev.lhpnd.graphflow.ui.common;

import javax.swing.*;

public class StyledLabel extends JLabel {
    public StyledLabel(String title) {
        super(title);
        setFont(new StyledFont());
    }
}