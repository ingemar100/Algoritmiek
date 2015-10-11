/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek.les2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Ingemar
 */
public class Quicksort3 {

    static final int ARRAY_SIZE = 1000;
    static int[] gesorteerd = new int[ARRAY_SIZE];
    static int[] willekeurig = new int[ARRAY_SIZE];
    static int verg = 0;
    static int swaps = 0;
    static long uitvoertijd = 0;
    static final int AANTAL = 1000;
    String a;
    int b;

    public static void main(String[] args) {
//        quicksort(gesorteerd);
        for (int i = 0; i < AANTAL; i++) {
            vulArrays();
            long startTime = System.currentTimeMillis();
//        System.out.println(Arrays.toString(gesorteerd));
//        System.out.println(Arrays.toString(willekeurig));
//            gesorteerd = quicksort(gesorteerd, 0, gesorteerd.length - 1);
            willekeurig = quicksort(willekeurig, 0, willekeurig.length - 1);

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

    public static int[] quicksort(int[] array, int l, int r) {
//        System.out.println("l: " + l + " r: " + r);
        verg++;
        if (l >= r) {
            return array;
        }
        int pivotIndex = verdeel(array, l, r);
        quicksort(array, l, pivotIndex);
        quicksort(array, pivotIndex + 1, r);

        return array;
    }

    public static int verdeel(int[] array, int linksIndex, int rechtsIndex) {
        int first = array[linksIndex];
        int middle = array[(rechtsIndex - linksIndex) / 2 + linksIndex];
        int last = array[rechtsIndex];
        int pivot;

        verg++;
        if (first > middle) {
            verg++;
            if (middle > last) {
                pivot = middle;
            } else if (first > last) {
                verg++;
                pivot = last;
            } else {
                verg++;
                pivot = first;
            }
        } else {
            verg++;
            if (first > last) {
                pivot = first;
            } else if (middle > last) {
                verg++;
                pivot = last;
            } else {
                verg++;
                pivot = middle;
            }
        }

        while (linksIndex < rechtsIndex) {
            verg++;
            while (array[linksIndex] < pivot) {
                verg++;
                linksIndex++;
            }
            while (array[rechtsIndex] > pivot) {
                verg++;
                rechtsIndex--;
            }
            wissel(array, linksIndex, rechtsIndex);
        }
        return linksIndex;
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
