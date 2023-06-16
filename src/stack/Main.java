/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;


public class Main {
    public static void main(String[] args) {
        System.out.println("-------ArrayBasedStack------");
        StackADT<String> arrayBasedStack = new ArrayBasedStack<>(10);
        System.out.println(arrayBasedStack.isEmpty());
        arrayBasedStack.push("n");
        arrayBasedStack.push("g");
        arrayBasedStack.push("u");
        arrayBasedStack.push("y");
        arrayBasedStack.push("e");
        arrayBasedStack.push("n");
        arrayBasedStack.push("h");
        arrayBasedStack.push("u");
        arrayBasedStack.push("n");
        arrayBasedStack.push("g");
        arrayBasedStack.push("h");
        arrayBasedStack.push("a");
        arrayBasedStack.push("i");
        System.out.println(arrayBasedStack.toString());
        System.out.println(arrayBasedStack.size());
        arrayBasedStack.pop();
        System.out.println(arrayBasedStack.size());
        System.out.println(arrayBasedStack.top());
        System.out.println("--------------------");
        StackADT<String> linkedListBasedStack = new LinkedListStack<>();
        System.out.println(linkedListBasedStack.size());
        linkedListBasedStack.push("hai dep trai");
        linkedListBasedStack.push("nhat trai dat");
        System.out.println(linkedListBasedStack.size());
        System.out.println(linkedListBasedStack.top());
        linkedListBasedStack.pop();
        System.out.println(linkedListBasedStack.size());

    }
    
}
