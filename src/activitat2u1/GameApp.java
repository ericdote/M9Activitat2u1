package activitat2u1;

import activitat2u1.GameFrame;
import activitat2u1.GameWorld;

/**
 *
 * @author Usuario
 */
public class GameApp{
GameFrame frame = new GameFrame();
 
/**
  * @param args the command line arguments
  */
public static void main(String[] args) {
GameApp app = new GameApp();
GameWorld ballWorld = new GameWorld();
app.frame.init(ballWorld);
ballWorld.init(app.frame.getCanvas());
 
app.frame.setVisible(true);
}
}
