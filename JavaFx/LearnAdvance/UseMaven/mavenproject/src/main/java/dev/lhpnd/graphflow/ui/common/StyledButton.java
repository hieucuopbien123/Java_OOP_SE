package dev.lhpnd.graphflow.ui.common;

import javax.swing.*;
import java.awt.*;

public class StyledButton extends JButton {
    public StyledButton(String label) {
        super(label);
        setBackground(Color.WHITE);
        setFont(new StyledFont());

    }
}
