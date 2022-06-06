package advance.com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphHashMap {
    static class Graph{
        HashMap<Object, LinkedList<Object>> adjList = new HashMap<>();
        HashMap<Object,Integer> indexes = new HashMap<>();
        int index = -1;

    public Graph(ArrayList<Object> vertices){
        for (int i =0 ; i < vertices.size();i++){
            Object vertex = vertices.get(i);
            LinkedList<Object> list = new LinkedList<>();
            adjList.put(vertex,list);
            indexes.put(vertex,index++);
        }
    }
    public void addEdge(Object source, Object destination){

        LinkedList<Object> list;
        list = adjList.get(source);
        list.addFirst(destination);
        adjList.put(source,list);
    }
    
    public void print (){
        for (int i =0 ; i < adjList.size();i++){
                System.out.println(adjList.get(i));
        }
    }
    }


}
