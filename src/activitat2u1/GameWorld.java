/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat2u1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Usuario
 */
public class GameWorld implements Runnable {

    ArrayList<Ball> bolas = new ArrayList();
    boolean simulador = true;
    WorldCanvas canvas;
    Thread thread;

    /**
     * Metode que s'utilitza per fintalitzar la simulació, per fer aixo es diu
     * que el boolean simulador passa a a ser false.
     */
    void endSimulation() {
        simulador = false;
    }

    void startSimulation() {
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Metode que afegeix al array bolas una ball mes.
     *
     * @param b
     */
    void addBall(Ball b) {
        bolas.add(b);
    }

    /**
     * Metode que retorna un Iterator, dins d'aquest es recorreix tot l'array de
     * boles i el retorna.
     *
     * @return
     */
    Iterator<Ball> getBalls() {
        return bolas.iterator();
    }

    /**
     * Inicilaitza el Worldcanvas i l'emmagatzema.
     *
     * @param canvas
     */
    void init(WorldCanvas canvas) {
        this.canvas = canvas;
    }

    /**
     * Metode que compta i retorna el numero de boles que tenim.
     *
     * @return
     */
    int getBallCount() {   
        return bolas.size();
    }

    @Override
    public void run() {
        do {
            try {
                for (Ball i : bolas) {
                    i.move(canvas.getSize());
                }
                canvas.repaint();

                Thread.sleep(1);
            } catch (Exception e) {
            }

        } while (simulador);
    }

}
