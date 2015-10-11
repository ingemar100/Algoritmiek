/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek.les1;

/**
 *
 * @author Ingemar
 */
public class Fibonacci {
    
    public static void main(String[] args) {
        
        fibonacciIter(50);
        
        System.out.println(fibonacciRec(50));
    
    }
    
    public static int fibonacciRec(int n){
        if (n < 2){
            return 1;
        }
        int x = fibonacciRec(n - 2) + fibonacciRec(n - 1);
//        System.out.println(x);
        return x;
    }
    
    public static void fibonacciIter(int n){
        int x = 0;
        int y = 1;
        int z;
        
        for (int i = 0; i < n; i++){
            z = x + y;
            System.out.println(z);
            x = y;
            y = z;
        }
    }
}

//string omdraaien

//tapijt van sierpinski