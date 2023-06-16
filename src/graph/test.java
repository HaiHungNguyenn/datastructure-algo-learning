/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author MSI
 */
public class test {

    public static void main(String[] args) {
        Graph g = new Graph();
        g = g.loadFromFile1("D:\\FPT\\Semester 3\\CSD\\GraphPractical\\data\\graph.txt\\");
        System.out.println(g.toString());
        ArrayList<Edge> edges = g.depthFirstSearch();
        System.out.println("Depth First Search");
        g.printEdges(edges, System.out);
        edges = g.breadFirstSearch();
        System.out.println("Bread First Search");
        g.printEdges(edges, System.out);
    }
}
