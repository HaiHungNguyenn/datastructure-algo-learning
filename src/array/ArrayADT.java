/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

/**
 *
 * @author admin
 */
public interface ArrayADT<T> {
    public int size();
    public boolean isEmpty();
    public T get(int index);
    public void set(int index, T el);
    public void clear();
    public void add(T el);
    public void removeAt(int removeIndex);
    public void remove(Object object);
    public int indexOf(Object object);
    public boolean contains(Object object);
    
    
     
     
    
}
