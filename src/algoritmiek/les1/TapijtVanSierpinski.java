/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek.les1;

import java.awt.*;
import java.applet.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ingemar
 */
public class TapijtVanSierpinski extends Applet {

    private Graphics g = null;
    private int d0 = 729; // 3^6
    private int maxDiepte;

//    public static void main(String[] args){
//        TapijtVanSierpinski tapijt = new TapijtVanSierpinski();
//        tapijt.init();
//    }
    public void init() {
        g = getGraphics();
        resize(d0, d0);
    }

    public void paint(Graphics g) {
//        maxDiepte = 5;
        tekenTapijt(0, 0, getWidth(), getHeight(), 5);
    }

    private void tekenTapijt(int xOL, int yOL, int breedte, int hoogte, int diepte) {
        if (breedte > 2 && hoogte > 2) {
            int b = breedte / 3;
            int h = hoogte / 3;
            if (diepte != 5) {
                g.fillRect(xOL + b, yOL + h, b, h);
            }
            diepte--;
            if (diepte > 0) {
                for (int k = 0; k < 9; k++) {
                    if (k != 4) {
                        int i = k / 3;
                        int j = k % 3;
//                        try {
//                            Thread.sleep(1);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(TapijtVanSierpinski.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                        tekenTapijt(xOL + i * b, yOL + j * h, b, h, diepte); 
                    }
                }
            }
        }
    }
}
