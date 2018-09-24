import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class StartScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField destinationPoint;

    @FXML
    private TextField startPoint;

    @FXML
    void shortestRoute(ActionEvent event) {
        System.out.println(startPoint.getText());
        System.out.println(destinationPoint.getText());

        for(String start : Main.graphNodeData) {
            if(start.equals(startPoint.getText())) {
                for(GraphNode thisOne : Main.graphNodes) {
                    if(thisOne.getData().equals(start)) {
                        System.out.println("The quickest path from " + start + "to " + destinationPoint.getText());
                        System.out.println("Using Dijikstra's Algorithm: ");
                        System.out.println("-------------------------------------");
                        CostedPath.findCheapestPathDijkstra(thisOne, destinationPoint.getText());
                        System.out.println(CostedPath.findCheapestPathDijkstra(thisOne, destinationPoint.getText()).pathCost);
                        System.out.println("Route taken is;");
                        for (GraphNode p : CostedPath.findCheapestPathDijkstra(thisOne, destinationPoint.getText()).pathList) {
                            System.out.println("\n" + p.getData());
                        }
                    }
                }
            }
        }
    }

    @FXML
    void quickestRoute(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert destinationPoint != null : "fx:id=\"destinationPoint\" was not injected: check your FXML file 'startScreen.fxml'.";
        assert startPoint != null : "fx:id=\"startPoint\" was not injected: check your FXML file 'startScreen.fxml'.";
    }

}
