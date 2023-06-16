/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;

/**
 *
 * @author MSI
 */
public class MyQueue<E> extends LinkedList<E> {

    public MyQueue() {
        super();
    }

    public void enqueue(E x) {
        this.addLast(x);
    }

    public E dequeue() {
        return this.poll();
    }
}
