/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author admin
 */
public class InsertionSort {
    // effectivelly using with nearly sorted array 
    // big o = n^2
    public static void main(String[] args) {
        int [] a ={11,12,13,5,6};
        int n = a.length;
        int current;
        for (int i = 1; i <n; i++) {
           current = a[i];
           int j = i - 1;
            while (j >= 0 && a[j] > current) {                
                a[j+1] = a[j];
                j --;
            }
            a[j+1] = current;
        }
        for (int i : a) {
            System.out.print(i +" ");
        }
    }
}
