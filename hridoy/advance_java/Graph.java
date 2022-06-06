package advance.com.company;

import java.util.LinkedList;

public class Graph {
    int vertex;
    LinkedList<Integer> list [];

    public Graph(int size){


        this.vertex = size;

        list = new LinkedList[size];
        for (int i =0; i < size;i++){
            list[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source , int destination){
        list[source].addFirst(destination);

        // Undirected Graph
       // list[destination].addFirst(source);
    }

    //Reverse Directed Graph
    public Graph reverse (Graph graph){

        Graph reverseGraph = new Graph(vertex);
        for (int i =0 ; i < vertex; i++){
            LinkedList<Integer> nodeList = list[i];
            int sorce = i;
            for (int j =0 ; j < nodeList.size();j++){
                int destination = nodeList.get(j);

                reverseGraph.addEdge(destination,sorce);
            }
        }
        return reverseGraph;
    }

    public void printGraph(){
        for (int i =0; i < vertex; i++){
            if (list[i].size()>0){
                System.out.println("Vertex " + i + " is connected to: ");
                for (int j =0; j < list[i].size(); j++){
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }
    public void printReverseGraph(){
        for (int i = 0; i < vertex; i++){
            LinkedList<Integer> nodeList = list[i];
            System.out.println("Vertex connected from vertex: " + i);
            for (int j =0; j < nodeList.size();j++){
                System.out.print(" " + nodeList.get(j));
            }
            System.out.println();
        }
    }
}

