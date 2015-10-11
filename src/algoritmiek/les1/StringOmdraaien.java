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
public class StringOmdraaien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        draaiOm("Poep");
        draaiOm("Selman");
        draaiOm("ramegnI");
        
        System.out.println(isPalindroom("lepel"));
        System.out.println(isPalindroom("paling"));
        System.out.println(isPalindroom("parterretrap"));
    }
    
    public static void draaiOm(String s){
        if (s.length() > 0){
            System.out.print(s.substring(s.length() - 1, s.length()));
            draaiOm(s.substring(0, s.length() - 1));
        }
        else {
            System.out.print("\n");
        }
    }
    
    public static boolean isPalindroom(String s){
        if (s.length() < 2){
            return true;
        }
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        
        if (first == last){
            return isPalindroom(s.substring(1, s.length() - 1));
        }
        else { 
            return false;
        }
    }
    
}
