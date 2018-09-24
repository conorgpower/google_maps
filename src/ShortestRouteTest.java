import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ShortestRouteTest {

    @Test
    public void shortestRouteTest() {
        //Graph Nodes hard coded for tests
        GraphNode graphNode = new GraphNode("GraphNode");
        GraphNode waterford = new GraphNode("Waterford");
        GraphNode cork = new GraphNode("Cork");
        GraphNode dungarvan = new GraphNode("Dungarvan");
        GraphNode clonmel = new GraphNode("Clonmel");
        GraphNode mitchelstown = new GraphNode("Mitchelstown");

        //Graph Route 1 - Waterford -> Dungarvan -> Cork = 132km (Expected shortest route)
        waterford.connectToNodeUndirected(waterford, dungarvan, 49, 100);
        dungarvan.connectToNodeUndirected(dungarvan, cork, 83, 100);

        //Graph Route 2 - Waterford -> Clonmel -> Mitchelstown -> Cork = 163km (Longer route)
        waterford.connectToNodeUndirected(waterford, clonmel, 47, 100);
        clonmel.connectToNodeUndirected(clonmel, mitchelstown, 54, 100);
        mitchelstown.connectToNodeUndirected(mitchelstown, cork, 62, 100);

        //assertEquals test should return the cheapest path (Graph Route 1)
        assertEquals(132, CostedPath.findCheapestPathDijkstra(waterford, "Cork").pathCost);
        }
}
