/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import stack.LinkedListStack;
import stack.StackADT;

/**
 *
 * @author admin
 */
public class BinarySerachTree<T extends Comparable<T>> implements TreeADT<T>{
    private int nodeCount = 0;
    private Node root =null;
    

    @Override
    public boolean isEmpty() {
        return nodeCount == 0;
    }

    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }
    private int height(Node node){
        if(node == null) return 0;
        else return 1 + Math.max(height(node.getLeft()),height(node.getRight()));
    }

    @Override
    public boolean contains(T el) {
        return contains(root,el);
    }
    private boolean contains(Node node,T el){
        if(node == null) return false;
        int result = el.compareTo((T) node.getData());
        if(result < 0)return contains(node.getLeft(), el);
        else if(result > 0)return contains(node.getRight(), el);
        else return true;
    }

    @Override
    public boolean add(T el) {
        if(contains(el)) return false;
        root = add(root, el);
        return true;
    }
    private Node add(Node node, T el){
        if(node == null) {
            node = new Node(el, null, null);
        }else{
            if(el.compareTo((T) node.getData()) > 0){
                node.setRight(add(node.getRight(), el));
            }else{
                node.setLeft(add(node.getLeft(), el));
            }
        }
        nodeCount++;
        return node;
    }
    

    @Override
    public boolean remove(T el) {
        if(!contains(el)) return false;
        root = remove(root, el);
        nodeCount--;
        return true;
    }
    public Node remove(Node node, T el){
        int result = el.compareTo((T) node.getData());
        if(result > 0){
            node.setRight(remove(node.getRight(), el));
        }else if (result > 0){
            node.setLeft(remove(node.getLeft(), el));
        }else{
            if(node.getLeft() == null){
                Node rightnode = node.getRight();
                node.setData(null);
                node = null;
                return rightnode;
            }else if(node.getRight() == null){
                Node leftnode = node.getLeft();
                node.setData(null);
                node = null;
                return leftnode;
            }
            T tmp = minRight(node);
            node.setData(tmp);
            node.setRight(remove(node.getRight(),tmp));
        }
        return node;
    }

    private T minRight(Node node){
        
        while(node != null && node.getLeft()!= null) node = node.getLeft();
        return (T) node.getData();
    }
    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        switch (type) {
            case PRE_ORDER : return preOrderTraverse();
            case IN_ORDER : return inOderTraverse();
            case POST_ORDER : return postOrderTraverse();
            case LEVEL_ORDER : return levelOrderTraverse();
            default: return null;
        }
    }

    @Override
    public int compareTo(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Iterator<T> preOrderTraverse() {
        final int expectedCount = nodeCount;
        StackADT<Node> stack = new LinkedListStack();
        stack.push(root);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();
                Node node = stack.pop();
                if(node.getLeft()!= null)stack.push(node.getLeft());
                if(node.getRight()!= null)stack.push(node.getRight());
                return (T) node.getData();
            }
        };
        
    }

    private Iterator<T> inOderTraverse() {
        final int expectedCount = nodeCount;
        StackADT<Node> stack = new LinkedListStack();
        stack.push(root);
        return new Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();
                return root != null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != nodeCount) throw new ConcurrentModificationException();
                while(trav!= null && trav.getLeft()!=null){
                    stack.push(trav.getLeft());
                    trav = trav.getLeft();
                }
                Node node = stack.pop();
                if(node.getRight()!=null){
                    stack.push(node.getRight());
                    trav= node.getRight();
                }
                return (T) node.getData();
            }
        };
        
    }

    private Iterator<T> postOrderTraverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Iterator<T> levelOrderTraverse() {
        return null;
    }
    

    
    
}
