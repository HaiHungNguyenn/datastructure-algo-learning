/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import java.util.Iterator;

/**
 *
 * @author admin
 */
public class DynamicArray<T> implements ArrayADT<T>,Iterable<T>{
    
    private T[] array;
    private int capacity = 0;
    private int size = 0;
    public DynamicArray(){
        this(10);
    }
    public DynamicArray(int capacity) {
        if(capacity < 0)throw new IllegalArgumentException("Capacity can not be negative");
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, T el) {
        array[index] = el;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(T el) {
        if(size >= capacity -1){
            if (capacity == 0) {
                capacity =1;
            }else{
                capacity *= 2;
            }
            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            
        }
        array[size++] = el;
    }

    @Override
    public void removeAt(int removeIndex) {
        if(removeIndex < 0 || removeIndex > size) throw new IndexOutOfBoundsException();
        T[] newArray = (T[]) new Object[size-1];
        for(int oldArrIdx = 0, newArrIdx = 0; oldArrIdx < size; oldArrIdx++, newArrIdx++){
            if(oldArrIdx == removeIndex){
                newArrIdx --;
            }else{
                newArray[newArrIdx] = array[oldArrIdx];
            }
        }
        array = newArray;
        capacity = -- size;
    }

    @Override
    public void remove(Object object) {
        int removeIndex = indexOf(object);
        removeAt(removeIndex);
    }
    public T removeAtWithoutMoving(int removeIndex) {
        if(removeIndex>=size || removeIndex<0) throw new IndexOutOfBoundsException();
        T item = array[removeIndex];
        array[removeIndex] = null;
        capacity = --size;
        return item;
    }
    @Override
    public int indexOf(Object object) {
        for(int i = 0; i< size;i++){
            if (object == null){
                if (array[i] == null)
                    return i;
            }
            else{
                if(object.equals(array[i])) return i;
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
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index ++];
            }
        };
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        else{
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");
            for (int i = 0; i < size-1; i++) {
                sb.append(array[i]).append(",");
            }
            sb.append(array[size-1]).append("]");
            return sb.toString();
        }
    }
}
