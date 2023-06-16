/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;


public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add("h");
        dll.addLast("u");
        dll.addLast("n");
        dll.addLast("g");
        dll.addLast("h");
        dll.addLast("a");
        dll.addLast("i");
        
        System.out.println(dll.toString());
    }
    
}
