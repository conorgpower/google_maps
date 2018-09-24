import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    //Create custom graphs
    static ArrayList<GraphNode> graphNodes = new ArrayList<>();
    static ArrayList<String> graphNodeData = new ArrayList<>();

    //Declaring JavaFX stages
    static Stage primaryStage;
    static AnchorPane startScreen;

    //Start JavaFX main menu
    @Override
    public void start(Stage stage) throws Exception {
        try {
            primaryStage = stage;
            startScreen = FXMLLoader.load(getClass().getResource("startScreen.fxml"));
            primaryStage.setScene(new Scene (startScreen, 600, 400));
            primaryStage.setTitle("Main Menu");
            primaryStage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    //Main method to start project
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("GoogleMapsCA.txt"));
        input.useDelimiter("\r\n");

        while (input.hasNextLine()) {
            String in = input.nextLine();

            //If Graph Node, select third word as graph node and add to the graphNodes array
            if (in.contains("graphNode")) {
                String[] splitNodeStrings = in.split(" ");
                String data = splitNodeStrings[2];

                GraphNode graphNode = new GraphNode(data);
                if (!graphNodeData.contains(graphNode.getData())) {
                    graphNodes.add(graphNode);
                    graphNodeData.add(graphNode.getData());
                    System.out.println(graphNode.getData() + " added!");
                } else {
                    System.out.println("Error, " + graphNode.getData() + "already Exists!");
                }

            /*If Graph Link,
            * select third word as source node,
            * select fifth word as destination node,
            * select seventh word as cost,
            * select ninth word as speed,
            * add all data to graphNodesData array
            * */
            } else if (in.contains("graphLink")) {
                Boolean sourceNodeExists = false;
                Boolean destNodeExists = false;
                String[] splitLinkStrings = in.split(" ");
                String sourceNode = splitLinkStrings[2];
                String destNode = splitLinkStrings[4];
                int cost = Integer.parseInt(splitLinkStrings[6]);
                int speed = Integer.parseInt(splitLinkStrings[8]);
                GraphNode realSourceNode = null;
                GraphNode realDestNode = null;

                for (GraphNode graphNode : graphNodes) {
                    if ((graphNode.getData().equals(sourceNode)) && (!sourceNodeExists)) {
                        sourceNodeExists = true;
                        realSourceNode = graphNode;
                    }
                    if ((graphNode.getData().equals(destNode)) && (!destNodeExists)) {
                        destNodeExists = true;
                        realDestNode = graphNode;
                    }
                }
                if (sourceNodeExists && destNodeExists) {
                    GraphLink graphLink = new GraphLink(realSourceNode, realDestNode, cost, speed);
                    for (GraphNode graphNode : graphNodes) {
                        if (graphNode.getData().equals(realSourceNode.getData())) {
                            realSourceNode.getAdjList().add(graphLink);
                            graphNode.connectToNodeUndirected(realSourceNode, realDestNode, cost, speed);
                        }
                    }
                    System.out.println("Link from " + realSourceNode.getData() + " to " + realDestNode.getData() + " created! \n Cost is " + graphLink.getCost());
                }
            }
        }
        launch(args);
    }
}

