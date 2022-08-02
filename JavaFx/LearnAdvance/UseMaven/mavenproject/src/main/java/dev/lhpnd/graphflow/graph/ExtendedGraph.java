package dev.lhpnd.graphflow.graph;

import dev.lhpnd.graphflow.ui.ApplicationContext;
import org.graphstream.algorithm.APSP;
import org.graphstream.algorithm.APSP.APSPInfo;
import org.graphstream.graph.Element;
import org.graphstream.graph.Node;
import org.graphstream.graph.Path;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.images.Resolutions;
import org.graphstream.ui.swing.util.SwingFileSinkImages;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.camera.Camera;
import org.graphstream.ui.view.util.InteractiveElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class ExtendedGraph extends SingleGraph {
    private JPanel view;
    private Node destinationNode;
    private Node sourceNode;
    private final List<Node> usedPath = new ArrayList<>();
    private Timer timer;

    public ExtendedGraph(String graphName) {
        this(graphName, null);
    }

    public ExtendedGraph(String graphName, List<String> edges) {
        super(graphName);
        setAttribute("ui.quality");
        setAttribute("ui.antialias");
        setStrict(false);
        setAutoCreate(true);

        String style = "node {" +
                "fill-color: white;" +
                "stroke-mode: plain;" +
                "size: 32px;" +
                "}" +
                "node.unmarked {" +
                "fill-color: white;" +
                "}" +
                "node.src {" +
                "fill-color: blue;" +
                "}" +
                "node.des {" +
                "fill-color: red;" +
                "}" +
                "node.next {" +
                "fill-color: green;" +
                "}" +
                "node.past {" +
                "fill-color: gray;" +
                "}" +
                "edge {" +
                "}" +
                "edge.unmarked {" +
                "fill-color: black;" +
                "}" +
                "edge.past {" +
                "fill-color: gray;" +
                "}" +
                "edge.next {" +
                "fill-color: green;" +
                "}";

        setAttribute("ui.stylesheet", style);

        if(edges == null) {
            edges = Arrays.asList("1 2", "1 3", "2 3", "3 1", "3 4", "4 3", "4 5", "2 5");
        }
        edges.stream()
                .map(edge -> edge.split("\\s+"))
                .forEach(edge -> addEdge(edge[0] + "?!?" + edge[1], edge[0], edge[1], true));

        this.forEach(node -> node.setAttribute("ui.label", node.getId()));
        this.edges().forEach(edge -> edge.setAttribute("weight", 1));

        APSP apsp = new APSP();
        apsp.init(this);
        apsp.setDirected(true);
        apsp.setWeightAttributeName("weight");
        apsp.compute();
    }

    public JPanel getView() {
        if(view == null) {
            SwingViewer viewer = new SwingViewer(this, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
            viewer.enableAutoLayout();
            viewer.addDefaultView(false);

            Camera camera = viewer.getDefaultView().getCamera();
            view = (JPanel) viewer.getDefaultView();

            view.removeMouseListener(view.getMouseListeners()[0]);
            view.addMouseMotionListener(new MouseMotionListener() {

                private int preX = -1;
                private int preY = -1;

                @Override
                public void mouseDragged(MouseEvent mouseEvent) {
                    int currentX = mouseEvent.getX();
                    int currentY = mouseEvent.getY();

                    camera.setAutoFitView(false);
                    var pointView = camera.getViewCenter();

                    if (preX != -1 && preY != -1) {
                        if (preX < currentX) {
                            pointView.x -= 0.01;
                        }
                        else if (preX > currentX) {
                            pointView.x += 0.01;
                        }

                        if (preY < currentY) {
                            pointView.y += 0.01;
                        }
                        else if (preY > currentY) {
                            pointView.y -= 0.01;
                        }
                    }
                    camera.setViewCenter(pointView.x, pointView.y, pointView.z);

                    preX = currentX;
                    preY = currentY;
                }

                @Override
                public void mouseMoved(MouseEvent mouseEvent) {
                    Node currentNode = getCurrentNode();
                    if(currentNode == null) {
                        view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        return;
                    }
                    var node = ((View) view).findGraphicElementAt(EnumSet.of(InteractiveElement.NODE), mouseEvent.getX(), mouseEvent.getY());
                    if (node != null && currentNode.hasEdgeToward(node.getId())) {
                        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }
                    else {
                        view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            });
            view.addMouseWheelListener(mouseWheelEvent -> {
                if (mouseWheelEvent.getWheelRotation() < 0) {
                    camera.setViewPercent(camera.getViewPercent() * 0.95);
                }
                else {
                    camera.setViewPercent(camera.getViewPercent() * 1.05);
                }
            });
            view.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    Node currentNode = getCurrentNode();
                    if(currentNode == null) {
                        return;
                    }
                    var node = ((View) view).findGraphicElementAt(EnumSet.of(InteractiveElement.NODE), mouseEvent.getX(), mouseEvent.getY());
                    if (node != null && currentNode.hasEdgeToward(node.getId())) {
                        changeNextNode(node.getId());
                        getApplicationContext().notifyChangeCurrentNode();
                    }
                }
                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
        }
        return view;
    }

    public void startSimulation(String src, String des) {
        clearSimulation();
        destinationNode = getNode(des);
        sourceNode = getNode(src);
        if(destinationNode == null || sourceNode == null) {
            JOptionPane.showMessageDialog(null,
                    "No path found!!!");
            return;
        }

        usedPath.add(sourceNode);
        updateCurrentNode(false);
    }

    public void clearSimulation() {
        sourceNode = null;
        destinationNode = null;
        usedPath.clear();
        if(timer != null) {
            timer.stop();
        }
        unHighlightPath();
    }

    public void resetSimulation() {
        if(sourceNode == null || destinationNode == null) {
            return;
        }
        startSimulation(sourceNode.getId(), destinationNode.getId());
    }

    public void changeNextNode(String nextNode) {
        if (usedPath.size() == 0) {
            return;
        }
        usedPath.add(getNode(nextNode));
        updateCurrentNode(false);
    }

    public void changeBackNode() {
        if (usedPath.size() <= 1) {
            return;
        }

        usedPath.remove(usedPath.size() - 1);
        updateCurrentNode(false);
    }

    public void autoNextPath() {
        timer = new Timer(1000, actionEvent -> {
            Node currentNode = getCurrentNode();

            if (currentNode == null) {
                ((Timer) actionEvent.getSource()).stop();
                JOptionPane.showMessageDialog(null, "No path found!!!");
                return;
            }

            if(currentNode == destinationNode) {
                ((Timer) actionEvent.getSource()).stop();
                JOptionPane.showMessageDialog(null, "You have reached your destination!!!");
                return;
            }

            updateCurrentNode(true);
            ((ApplicationContext) SwingUtilities.getWindowAncestor(view)).notifyChangeCurrentNode();
        });
        timer.start();
    }

    public List<String> getHistory() {
        return usedPath.stream().map(Element::getId).collect(Collectors.toList());
    }

    private void unHighlightPath() {
        this.forEach(node -> node.setAttribute("ui.class", "unmarked"));
        this.edges().forEach(edge -> edge.setAttribute("ui.class", "unmarked"));
    }

    private void updateCurrentNode(boolean isAuto) {
        unHighlightPath();

        Node currentNode = getCurrentNode();
        if(currentNode == null) {
            JOptionPane.showMessageDialog(null, "No path found!!");
            return;
        }

        if(!isAuto && timer != null) {
            timer.stop();
        }

        List<Node> nextPath = new ArrayList<>();

        if(!currentNode.equals(destinationNode)) {
            APSPInfo info = (APSPInfo) currentNode.getAttribute(APSPInfo.ATTRIBUTE_NAME);
            Path path = info.getShortestPathTo(destinationNode.getId());
            if(path == null) {
                clearSimulation();
                JOptionPane.showMessageDialog(null, "No path found!!");
                return;
            }
            nextPath = path.getNodePath();
        }

        if(isAuto) {
            currentNode = nextPath.get(1);
            usedPath.add(currentNode);
            nextPath.remove(0);
        }

        for(Node node: usedPath) {
            node.setAttribute("ui.class", "past");
        }
        for(int i = 1; i < usedPath.size(); i ++) {
            usedPath.get(i - 1).getEdgeToward(usedPath.get(i)).setAttribute("ui.class", "past");
        }

        for(Node node: nextPath) {
            node.setAttribute("ui.class", "next");
        }
        for(int i = 1; i < nextPath.size(); i ++) {
            nextPath.get(i - 1).getEdgeToward(nextPath.get(i)).setAttribute("ui.class", "next");
        }

        destinationNode.setAttribute("ui.class", "des");
        currentNode.setAttribute("ui.class", "src");
    }

    private Node getCurrentNode() {
        if(usedPath.size() == 0) {
            return null;
        }
        return usedPath.get(usedPath.size() - 1);
    }

    public String saveImage() {
        SwingFileSinkImages sfsi = new SwingFileSinkImages(FileSinkImages.OutputType.PNG, Resolutions.HD720);

        sfsi.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);
        try {
            String fileName = Instant.now().toString().replace(':', '-') + ".png";
            sfsi.writeAll(this, fileName);
            JOptionPane.showMessageDialog(null,
                    "Save image success");
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Error! Can not save image!!");
            return null;  
        } 
    }

    private ApplicationContext getApplicationContext() {
        return ((ApplicationContext) SwingUtilities.getWindowAncestor(view));
    }
}
