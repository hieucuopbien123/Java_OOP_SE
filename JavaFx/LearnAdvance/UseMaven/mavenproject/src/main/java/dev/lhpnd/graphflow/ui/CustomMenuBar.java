package dev.lhpnd.graphflow.ui;

import javax.swing.*;

public class CustomMenuBar extends JMenuBar {
    public CustomMenuBar() {
        super();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveImageMenuItem = new JMenuItem("Save");
        JMenuItem saveAndSendImageMenuItem = new JMenuItem("Save & Send to email");

        openMenuItem.addActionListener(actionEvent -> getApplication().readFile());
        saveImageMenuItem.addActionListener(actionEvent -> getApplication().saveGraphImage());
        saveAndSendImageMenuItem.addActionListener(actionEvent -> getApplication().saveAndSendImage());

        fileMenu.add(openMenuItem);
        fileMenu.add(saveImageMenuItem);
        fileMenu.add(saveAndSendImageMenuItem);

        add(fileMenu);
        add(helpMenu);
    }

    private ApplicationContext getApplication() {
        return (ApplicationContext) SwingUtilities.getWindowAncestor(this);
    }
}
