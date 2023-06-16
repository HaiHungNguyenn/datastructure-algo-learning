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
public class Main {
    public static void main(String[] args) {
        DynamicArray<String> da = new DynamicArray<String>();
        da.add("h");
        da.add("u");
        da.add("n");
        da.add("g");
        da.add("h");
        da.add("a");
        da.add("i");
        System.out.println(da.toString());
        System.out.println(da.get(3));
        System.out.println(da.isEmpty());
        da.remove("i");
        System.out.println(da.toString());

    }
    
}
