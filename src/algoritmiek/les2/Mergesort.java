/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek.les2;

import static algoritmiek.les2.Quicksort3.swaps;
import static algoritmiek.les2.Quicksort3.verg;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Ingemar
 */
public class Mergesort {

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
//            gesorteerd = mergesort(gesorteerd);
            willekeurig = mergesort(willekeurig);

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

    public static int[] mergesort(int[] array) {
        verg++;
        if (array.length == 2) {
            verg++;
            if (array[1] < array[0]) {
                wissel(array, 0, 1);
            }
            return array;
        } else if (array.length == 1) {
            verg++;
            return array;
        }
        else {
            verg++;
        }

        int length = array.length;
        int elementenRechts = (length % 2) == 1 ? length / 2 + 1 : length / 2;

        int[] arrLinks = new int[array.length / 2];
        int[] arrRechts = new int[elementenRechts];

        for (int i = 0; i < array.length / 2; i++) {
            verg++;
            arrLinks[i] = array[i];
        }
        for (int i = array.length / 2; i < array.length / 2 + elementenRechts; i++) {
            verg++;
            arrRechts[i - array.length / 2] = array[i];
        }
        arrLinks = mergesort(arrLinks);
        arrRechts = mergesort(arrRechts);

        //merge links en rechts
        int i = 0, linksIndex = 0, rechtsIndex = 0;
        while (arrLinks.length != linksIndex && arrRechts.length != rechtsIndex) {
            verg++;
            verg++;
            if (arrLinks[linksIndex] < arrRechts[rechtsIndex]) {
                array[i] = arrLinks[linksIndex++];
            } else {
                array[i] = arrRechts[rechtsIndex++];
            }
            i++;
        }

        while (arrLinks.length != linksIndex) {
            verg++;
            array[i++] = arrLinks[linksIndex++];
        }
        while (arrRechts.length != rechtsIndex) {
            verg++;
            array[i++] = arrRechts[rechtsIndex++];
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
