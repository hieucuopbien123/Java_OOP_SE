package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.brunomnsilva.smartgraph.containers.SmartGraphDemoContainer;
import com.brunomnsilva.smartgraph.graph.Graph;
import com.brunomnsilva.smartgraph.graph.GraphEdgeList;
import com.brunomnsilva.smartgraph.graph.Vertex;
import com.brunomnsilva.smartgraph.graphview.SmartCircularSortedPlacementStrategy;
import com.brunomnsilva.smartgraph.graphview.SmartGraphPanel;
import com.brunomnsilva.smartgraph.graphview.SmartPlacementStrategy;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class SceneMain implements Initializable {
	@FXML
	BorderPane outlinePane;
	
	SmartPlacementStrategy strategy = new SmartCircularSortedPlacementStrategy();
	private Graph<Integer, Integer> g = new GraphEdgeList<>();
	SmartGraphPanel<Integer, Integer> view;
	int increasingId = 6;
	
	public void addVertex(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getSceneX());
		increasingId++;
		Vertex<Integer> tokyo = g.insertVertex(increasingId);
		view.update();
		view.setVertexPosition(tokyo, 100, 100);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		g = new GraphEdgeList<>();
		 Vertex<Integer> prague = g.insertVertex(0);
        Vertex<Integer> tokyo = g.insertVertex(1);
        Vertex<Integer> beijing = g.insertVertex(2);
        Vertex<Integer> newYork = g.insertVertex(3);
        Vertex<Integer> london = g.insertVertex(4);
        Vertex<Integer> helsinky = g.insertVertex(5);
		view = new SmartGraphPanel<>(g, strategy);
		view.setLayoutX(0);
		view.setLayoutY(0);
		outlinePane.setCenter(view);
		view.setAutomaticLayout(true);
        view.setVertexPosition(beijing, 100, 100);
        view.setVertexPosition(helsinky, 924, 100);
        view.setVertexPosition(london, 200, 668);
        view.setVertexPosition(prague, 824, 668);
        view.setVertexPosition(tokyo, 512, 300);
        view.setVertexPosition(newYork, 512, 400);
		view.setOnMouseClicked(e-> {
			System.out.println(e.getX());
			System.out.println(e.getSceneX());
			increasingId++;
			Vertex<Integer> a = g.insertVertex(increasingId);
			view.update();
			view.setVertexPosition(a, 100, 100);
		});
	}
	
}
