/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author admin
 */
public interface StackADT <T> extends Iterable<T>{
    void push(T el);
    T pop();
    T top();
    int size();
    boolean isEmpty();
}
