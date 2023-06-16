package graph;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class test {

    public static void main(String[] args) {
        Graph g = new Graph();
        g = g.loadFromFile1("D:\\FALL22\\PRO\\DSA_Studying\\src\\graph");
        System.out.println(g.toString());
        ArrayList<Edge> edges = g.depthFirstSearch();
        System.out.println("Depth First Search");
        g.printEdges(edges, System.out);
        edges = g.breadFirstSearch();
        System.out.println("Bread First Search ");
        g.printEdges(edges, System.out);
    }
}
