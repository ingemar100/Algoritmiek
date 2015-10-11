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
public class Piramideprobleem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 10000;
        
        long startTime = System.currentTimeMillis();
        System.out.println("Iteratief:");
        driehoekgetalIteratief(n);
        long iterTijd = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        System.out.println("Recursief:");
        driehoekgetalRecursief(n);
        long recTijd = System.currentTimeMillis() - startTime;
        
        startTime = System.currentTimeMillis();
        System.out.println("Formule:");
        driehoekgetalFormule(n);
        long formTijd = System.currentTimeMillis() - startTime;
        
        System.out.println("Tijd iteratief: " + iterTijd);
        System.out.println("Tijd recursief: " + recTijd);
        System.out.println("Tijd formule: " + formTijd);
    }
    
    public static int driehoekgetalRecursief(int n){
        if (n > 0){
            n += driehoekgetalRecursief(n - 1) + driehoekgetalRecursief(0);
            System.out.println(n);
        }
        return n;
    }
    
    public static void driehoekgetalIteratief(int n){
        int getal = 0;
        int i = 0;
        while (i < n){
            i++;
            getal += i;
            System.out.println(getal);
        }
    }
    
    public static void driehoekgetalFormule(int n){
        System.out.println(0.5 * n * (n+1));
    }
}
