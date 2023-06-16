/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.util.Iterator;

public class TreeTest {
    public static void main(String[] args) {
        TreeADT<Integer> bst = new BinarySerachTree<>();
        bst.add(5);
        bst.add(4);
        bst.add(6);
        bst.add(7);
        bst.add(3);
        bst.add(2);
        bst.add(10);
        Iterator traverse = bst.traverse(TreeTraverseType.IN_ORDER);
        while(traverse.hasNext()){
            System.out.println(traverse.next());
        }
        System.out.println("---");
        Iterator traversePRE = bst.traverse(TreeTraverseType.PRE_ORDER);
        while(traversePRE.hasNext()){
            System.out.println(traversePRE.next());
        }
        System.out.println(bst.contains(50));
    }
}
// pre: f b a d c e g i h
// in: a b c d e f g h i
// post: a c e d b h i g f
// in: a b c d e g i h
