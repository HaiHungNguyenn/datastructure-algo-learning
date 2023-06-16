/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Iterator;

/**
 *
 * @author admin
 */
public interface TreeADT <T> extends Comparable<T>{
    boolean isEmpty();
    int size();
    int height();
    boolean contains(T el);
    boolean add(T el);
    boolean remove(T el);
    Iterator<T> traverse (TreeTraverseType type);
    
}
