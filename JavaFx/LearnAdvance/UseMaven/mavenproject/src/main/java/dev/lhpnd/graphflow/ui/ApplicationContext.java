package dev.lhpnd.graphflow.ui;

import dev.lhpnd.graphflow.graph.ExtendedGraph;
import dev.lhpnd.graphflow.util.MailUtils;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext extends JFrame {
    private ExtendedGraph graph;
    private JPanel graphPanel;
    private final SideBar sideBar;

    public static void run() {
        SwingUtilities.invokeLater(ApplicationContext::new);
    }

    private ApplicationContext() {
        super("Graph flow");

        graph = new ExtendedGraph("Graph flow control");
        graphPanel = graph.getView();
        sideBar = new SideBar();
        JMenuBar menuBar = new CustomMenuBar();

        setLayout(new FlowLayout());

        graphPanel.setPreferredSize(new Dimension(700, 500));
        add(sideBar);
        add(graphPanel);
        setJMenuBar(menuBar);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void startSimulation(String src, String des) {
        graph.startSimulation(src, des);
    }

    public void clearSimulation() {
        graph.clearSimulation();
    }

    public void undoPath() {
        graph.changeBackNode();
    }

    public void resetPath() {
        graph.resetSimulation();
    }

    public void autoPath() {
        graph.autoNextPath();
    }

    public List<String> getHistoryPath() {
        return graph.getHistory();
    }

    public void notifyChangeCurrentNode() {
        sideBar.setHistory();
    }

    public void saveGraphImage() {
        graph.saveImage();
    }

    public void saveAndSendImage() {
        String fileName =  graph.saveImage();
        String recipient = null;
        if (fileName != null)
            recipient = CustomDialog.getEmail(this);
        if (recipient != null && recipient.length() > 0)
            MailUtils.sendMailImage(recipient, fileName);
    }

    public void readFile() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.showOpenDialog(this);
        File file = fileDialog.getSelectedFile();
        if (file == null) {
            return;
        }
        List<String> edges = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                edges.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Can not load data!");
        }

        sideBar.init();
        graph = new ExtendedGraph("Graph Flow", edges);
        remove(graphPanel);
        graphPanel = graph.getView();

        graphPanel.setPreferredSize(new Dimension(700, 500));
        add(graphPanel);
        graphPanel.updateUI();
    }

}
