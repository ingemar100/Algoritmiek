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
public class Optellen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 10;
        print(n);
    }
    
    public static void print(int n){
       if (n != 0){
            print (n -1);
       }
       System.out.println(n);
    }
    
}
