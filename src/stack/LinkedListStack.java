/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.EmptyStackException;
import linked_list.DoublyLinkedList;

import java.util.Iterator;

/**
 *
 * @author admin
 */
public class LinkedListStack<T> implements StackADT<T>{
    private final DoublyLinkedList<T>  list = new DoublyLinkedList<>();

    public LinkedListStack() {
    }

    public LinkedListStack(T el){
        push(el);
    }
    
    

    @Override
    public void push(T el) {
        list.addLast(el);
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    @Override
    public T top() {
        if(isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
    
}
