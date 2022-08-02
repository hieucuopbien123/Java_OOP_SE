package dev.lhpnd.graphflow.ui;

import dev.lhpnd.graphflow.ui.common.StyledButton;
import dev.lhpnd.graphflow.ui.common.StyledLabel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class SideBar extends JPanel {
    private final JTextField fromField;
    private final JTextArea history;
    private final JTextField toField;

    public SideBar() {
        super();
        setPreferredSize(new Dimension(250, 500));

        JLabel fromLabel = new StyledLabel("From");
        JLabel toLabel = new StyledLabel("To  ");

        fromField = new JTextField();
        toField = new JTextField();

        JButton findButton = new StyledButton("Find");
        JButton clearButton = new StyledButton("Clear");
        JButton backButton = new StyledButton("Back");
        JButton resetButton = new StyledButton("Reset");
        JButton autoButton = new StyledButton("Auto");

        history = new JTextArea();
        history.setText("History\n");
        history.setEditable(false);

        findButton.addActionListener(actionEvent -> {
            getApplicationContext().startSimulation(fromField.getText().trim(), toField.getText().trim());
            setHistory();
        });

        clearButton.addActionListener(actionEvent -> {
            getApplicationContext().clearSimulation();
            init();
        });

        backButton.addActionListener(actionEvent -> {
            getApplicationContext().undoPath();
            setHistory();
        });

        resetButton.addActionListener(actionEvent -> {
            getApplicationContext().resetPath();
            setHistory();
        });

        autoButton.addActionListener(actionEvent -> getApplicationContext().autoPath());


        setLayout(new GridLayout(2, 1));
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
        inputPanel.setLayout(new GridLayout(4, 1, 50, 0));

        JPanel fromInputPanel = new JPanel();
        fromInputPanel.setLayout(new FlowLayout());
        fromInputPanel.add(fromLabel);
        fromField.setPreferredSize(new Dimension(100, 25));
        fromInputPanel.add(fromField);

        JPanel toInputPanel = new JPanel();
        toInputPanel.setLayout(new FlowLayout());
        toInputPanel.add(toLabel);
        toField.setPreferredSize(new Dimension(100, 25));
        toInputPanel.add(toField);

        JPanel buttonInputPanel = new JPanel();
        buttonInputPanel.setLayout(new FlowLayout());
        buttonInputPanel.add(findButton);
        buttonInputPanel.add(clearButton);

        JPanel navigationPanel = new JPanel();
//        navigationPanel.setBackground(Color.GRAY);
        navigationPanel.setLayout(new FlowLayout());
        navigationPanel.add(backButton);
        navigationPanel.add(resetButton);
        navigationPanel.add(autoButton);

        inputPanel.add(fromInputPanel);
        inputPanel.add(toInputPanel);
        inputPanel.add(buttonInputPanel);
        inputPanel.add(navigationPanel);

        add(inputPanel);
        JScrollPane scrollPane = new JScrollPane(history);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

    }

    private ApplicationContext getApplicationContext() {
        return (ApplicationContext) SwingUtilities.getWindowAncestor(this);
    }

    public void setHistory() {
        List<String> path = getApplicationContext().getHistoryPath();
        if(path.size() == 0) {
            history.setText("Oops!! No path found....");
            return;
        }
        StringBuilder pathStr = new StringBuilder("History\n");
        for(int i = 1; i < path.size(); i++) {
            pathStr.append("\n").append(path.get(i - 1)).append("-->").append(path.get(i));
        }
        history.setText(pathStr.toString());
    }

    public void init() {
        toField.setText("");
        fromField.setText("");
        history.setText("History\n");
    }


}
