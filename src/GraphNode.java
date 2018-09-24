import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    //Fields
    public String data;
    public int nodeValue =Integer.MAX_VALUE;

    //Array list to store graph links
    public List<GraphLink> adjList = new ArrayList<>(); //Adjacency list now contains link objects = key!

    //Setters
    public void setData(String data) {
        this.data = data;
    }

    public void setAdjList(List<GraphLink> adjList) {
        this.adjList = adjList;
    }

    //Getters
    public String getData() {
        return data;
    }

    public List<GraphLink> getAdjList() {
        return adjList;
    }





    public GraphNode(String data) { this.data=data; }

    public void connectToNodeUndirected(GraphNode sourceNode, GraphNode destNode,int cost, int speed) {
        adjList.add( new GraphLink(sourceNode, destNode, cost, speed) ); //Add new link object to source adjacency list
        destNode.adjList.add( new GraphLink(destNode, sourceNode, cost, speed) ); //Add new link object to destination adjacency list
    }


}