/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import java.util.Iterator;

/**
 *
 * @author admin
 */
public class DoublyLinkedList <T> implements LinkedListADT<T>{
    private int size;
    private Node <T> head = null;
    private Node <T> tail = null;
    
    @Override
    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            currentNode.setNext(null);
            currentNode.setPrev(null);
            currentNode.setData(null);
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
    

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) {
            head = tail = new Node<>(element, null, null);
        }else{
            Node<T> newNode = new Node<>(element, null, head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    @Override
    public void addLast(T element) {
        if(isEmpty()){
            head = tail = new Node(element,null,null);
        }else{
            Node<T> newNode = new Node<>(element,tail,null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    // lấy data của node đầu nhưng ko xóa khỏi list

    @Override
    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("Empty Linked List");
        else{
            return head.getData();
        }
    }
    // lấy data của node cuối nhưng ko xóa khỏi list
    @Override
    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("Empty Linked List");
        else{
            return tail.getData();
        }
    }
    // lấy data của node đầu r xóa khỏi list
    @Override
    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("Empty Linked List");
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        else head.setPrev(null);
        return data;
    }
    
    
    // lấy data của node cuối r xóa khỏi list
    @Override
    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("Empty Linked List");
        T data = tail.getData();
        tail = tail.getPrev();
        size--;
        if (isEmpty()) head = null;
        else tail.setNext(null);
        return data;
        
    }
    // lấy data của node r xóa khỏi list
    @Override
    public T remove(Node<T> node) {
        if(node.getPrev() == null) removeFirst();
        if(node.getNext() == null) removeLast();
        
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        
        T data = node.getData();
        size--;
        
        node.setData(null);
        node.setNext(null);
        node.setPrev(null);
        
        return data;
    }
    

    @Override
    public boolean remove(Object object) {
        Node <T> currentNode = head;
        if (object == null) {
            while (currentNode != null){
                if (currentNode.getData() == null) {
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }else{
            while (currentNode != null) {
                if(currentNode.getData() == object){
                    remove(currentNode);
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        }
        return false;
    }

    @Override
    public T removeAt(int index) {
        if(index < 0 || index > size) throw new IllegalArgumentException();
        int i = 0;
        Node <T> currentNode;
        if(index < size/2){
            i = 0;
            currentNode = head;
            while (i != index){
                currentNode = currentNode.getNext();
                i ++;
            }
        }else{
            i = size-1;
            currentNode = tail; 
            while(i != index){
                currentNode = currentNode.getPrev();
                i --;
            }
        }
        return remove (currentNode);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0; 
        Node <T> currentNode = head;
        if (object == null) {
            while (currentNode != null) {                
                if(currentNode.getData() == null){
                    return index;
                }
                currentNode = currentNode.getNext();
                index++;
            }
        }else{
            while (currentNode != null) {                
                if (currentNode.getData() == object) {
                    return index;
                }
                currentNode = currentNode.getNext();
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private boolean isEntering = true;
            private Node<T> currentNode = null;
            @Override
            public boolean hasNext() {
                if(isEntering){
                    return head != null;
                }
                return currentNode.getNext() != null;
            }

            @Override
            public T next() {
                T data = null;
                if(isEntering) {
                    data = head.getData();
                    currentNode = head;
                    isEntering =false;
                }else {
                    currentNode = currentNode.getNext();
                    data = currentNode.getData();
                }
                return data;
            }
        };
    }
    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        else{
            StringBuilder sb = new StringBuilder(size);
            sb.append("[ ");

            Node<T> currentNode = head;

            while (currentNode!=null){
                sb.append(currentNode.getData());
                if(currentNode.getNext()!=null) sb.append(", ");
                currentNode = currentNode.getNext();
            }
            sb.append(" ]");
            return sb.toString();
        }
    }
    
}
