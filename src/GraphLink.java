public class GraphLink {

    //Fields
    public GraphNode sourceNode;
    public GraphNode destNode;
    public int cost;
    public int speed; //Other link attributes could be similarly stored

    //Constructor
    public GraphLink(GraphNode sourceNode, GraphNode destNode,int cost, int speed) {
        this.sourceNode=sourceNode;
        this.destNode=destNode;
        this.cost=cost;
        this.speed = speed;
    }

    //Getters
    public GraphNode getSourceNode() {
        return sourceNode;
    }

    public GraphNode getDestNode() {
        return destNode;
    }

    public int getCost() {
        return cost;
    }

    public int getSpeed() {
        return speed;
    }

    //Setters
    public void setSourceNode(GraphNode sourceNode) {
        this.sourceNode = sourceNode;
    }

    public void setDestNode(GraphNode destNode) {
        this.destNode = destNode;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSpeed(int speed) {
        this.cost = speed;
    }
}