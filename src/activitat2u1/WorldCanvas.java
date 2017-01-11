/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activitat2u1;

/**
 *
 * @author Usuario
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.JPanel;
 
public class WorldCanvas extends JPanel{
private GameWorld ballWorld=null;
 
public void init(GameWorld ballWorld){
this.ballWorld = ballWorld;
ballWorld.startSimulation();
}
 
public void add (Ball b) {
ballWorld.addBall(b);
}
 
@Override
public void paintComponent (Graphics g) {
super.paintComponent(g);
Graphics2D g2 = (Graphics2D)g;
Color defColor = g2.getColor();
Iterator<Ball> iter = ballWorld.getBalls();
while(iter.hasNext()) {
Ball b = iter.next();
g2.setColor(b.getColor());
g2.fill(b);
}
g2.setColor(defColor);
}
 
public int getBallCount(){
return ballWorld.getBallCount();
}
}
