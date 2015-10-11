/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek.les2;

import static algoritmiek.les2.Mergesort.ARRAY_SIZE;
import static algoritmiek.les2.Mergesort.vulArrays;
import static algoritmiek.les2.Quicksort3.swaps;
import static algoritmiek.les2.Quicksort3.verg;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Ingemar
 */
public class Bubblesort {

    static final int ARRAY_SIZE = 1000;
    static int[] gesorteerd = new int[ARRAY_SIZE];
    static int[] willekeurig = new int[ARRAY_SIZE];
    static int verg = 0;
    static int swaps = 0;
    static long uitvoertijd = 0;
    static final int AANTAL = 1000;

    public static void main(String[] args) {
//        quicksort(gesorteerd);
        for (int i = 0; i < AANTAL; i++) {
            vulArrays();
            long startTime = System.currentTimeMillis();
//        System.out.println(Arrays.toString(gesorteerd));
//        System.out.println(Arrays.toString(willekeurig));
//            gesorteerd = bubblesort(gesorteerd);
            willekeurig = bubblesort(willekeurig);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            uitvoertijd += elapsedTime;
//            System.out.println(Arrays.toString(gesorteerd));
//            System.out.println(Arrays.toString(willekeurig));
        }
        System.out.println("Tijd: " + uitvoertijd);
        System.out.println("Swaps: " + swaps);
        System.out.println("Verg: " + verg);
    }

    public static int[] bubblesort(int[] array) {
        boolean swapped = true;
        int n = array.length;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                verg++;
                if (array[i] < array[i - 1]) {
                    wissel(array, i, i - 1);
                    swapped = true;
                }
                verg++;
            }
            n = n - 1;
        }
        return array;
    }

    public static int[] wissel(int[] array, int a, int b) {
        swaps++;
        int h = array[a];
        array[a] = array[b];
        array[b] = h;
        return array;
    }

    public static void vulArrays() {
        int last = 0;
        Random r = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int w = r.nextInt(5) + last + 1;
//            System.out.println(w);
            gesorteerd[i] = w;
            willekeurig[i] = w;
            last = w;
        }

        int index, temp;
        for (int i = willekeurig.length - 1; i > 0; i--) {
            index = r.nextInt(i + 1);
            temp = willekeurig[index];
            willekeurig[index] = willekeurig[i];
            willekeurig[i] = temp;
        }
    }
}
