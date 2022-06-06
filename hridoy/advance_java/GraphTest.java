package advance.com.company;

import java.util.ArrayList;

public class GraphTest {
    public static void main(String[] args) {
//          Graph graph = new Graph(5);
//        graph.addEdge(0,1);
//        graph.addEdge(0,4);
//        graph.addEdge(1,2);
//        graph.addEdge(1,3);
//        graph.addEdge(1,4);
//        graph.addEdge(2,4);
//        graph.addEdge(2,3);
//        graph.printGraph();
//
//       Graph revarseGraph = graph.reverse(graph);
//        revarseGraph.printReverseGraph();


        ArrayList<Object> vertices = new ArrayList<>();

        vertices.add('a');
        vertices.add('b');
        vertices.add('c');
        vertices.add('d');
        vertices.add('e');
        vertices.add('f');

        GraphHashMap.Graph graph1 = new GraphHashMap.Graph(vertices);
        graph1.addEdge('b','k');
        graph1.addEdge('e','t');

        graph1.print();

    }


}
