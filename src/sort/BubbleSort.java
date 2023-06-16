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
public class BubbleSort {
    // using with small number of elements only
    // worst case is when the smallest el is at the end of array
    // big o is O(n^2)
    public static void main(String[] args) {
        int [] a ={1,5,2,9,7,4};
        int n = a.length;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n-1; j++){
                if(a[i] < a[j]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
    
}
