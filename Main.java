/**
  *
  * Hauptklasse 
  *
  * 
  * @Jakob Klinger
  */
import java.awt.Canvas;
import javax.swing.JFrame; 
import java.awt.Dimension;
import java.awt.image.BufferStrategy; 
import java.awt.Graphics; 
import java.awt.Color; 
import java.awt.image.BufferedImage; 
import java.awt.image.DataBufferInt; 

public class Main extends Canvas implements Runnable{
  public static int width = 300; 
  public static int height = width / 16 * 9;                // Bildschirmgröße 16 / 9 
  public static int scale = 4;
  public static String title = "Game"; 
  
  private Screen screen; 
  
  private BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB); 
  private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
  
  private Level level; 
  
  private Player player; 
  private Keyboard key; 
  private Thread thread;  
  private JFrame frame;
  private boolean running = false; 
  
  public Main(){                                              // Konstruktor des Fensters
    Dimension size = new Dimension(width*scale,height*scale);
    setPreferredSize(size);
    screen =  new Screen(width, height);
    
    frame = new JFrame();  
    key = new Keyboard(); 
    level = new Level(63,63,10,5,5);
    player = new Player(key, level);  
    addKeyListener(key); 
  }
  
  public static void main(String[] args){                     // hier gehts los
    Main game = new Main(); 
    game.frame.setResizable(false);                           // Eigenschaften des Fensters
    game.frame.setTitle(Main.title); 
    game.frame.add(game);
    game.frame.pack(); 
    game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    game.frame.setLocationRelativeTo(null); 
    game.frame.setVisible(true); 
    
    game.start();  
    
  }
  
  
  public synchronized void start(){                                             // thread starten
    running = true; 
    thread = new Thread(this, "Display"); 
    thread.start(); 
  }
  
  public synchronized void stop(){                                              // thread stoppen 
    running = false; 
    try {
      thread.join();
      
    } catch(InterruptedException e) {
      e.printStackTrace(); 
      
    }
  }
  
  public void run(){                                                            // code der ausgeführt werden soll 
    
    //timer + fps counter
    long lastTime = System.nanoTime(); 
    long timer = System.currentTimeMillis();
    final double ns = 1000000000.0/ 60.0; 
    double delta = 0; 
    
    int frames = 0; 
    int updates = 0; 
    requestFocus(); 
    while (running == true) {                                                   // solange das Programm laufen soll 
      long now = System.nanoTime(); 
      delta += (now-lastTime) / ns; 
      lastTime = now; 
      while (delta >= 1) {                                                      // update nur 60 mal pro sekunde aufrufen 
        update();
        updates++;  
        delta--; 
      } // end of while 
      render();
      frames++; 
      
      if (System.currentTimeMillis() - timer > 1000) {                          // einmal pro Sekunde
        timer += 1000; 
        frame.setTitle(title + "        " + updates + " ups, " + frames + " fps");
        updates = 0; 
        frames = 0; 
      } // end of if
    } // end of while
    stop(); 
  }
  public void update(){                                                         // rechnen 
    key.update();
    player.update();
  }
  public void render(){                                                         //zeichnen
    BufferStrategy bs = getBufferStrategy();
    if (bs == null) {                                                           // nicht mehrere Strategien haben
      createBufferStrategy(3);                                                  // tripple Buffering
      return; 
    } // end of if
    
    screen.clear();                                                             // screen löschen                                                            // bild zeichnen
    int xScroll = player.x - screen.width / 2; 
    int yScroll = player.y - screen.height / 2; 
    level.render(xScroll,yScroll,screen);
    player.render(screen);
    
    for (int i = 0;i < pixels.length ;i++ ) {
      pixels[i] = screen.pixels[i];
    } // end of for
    
    Graphics g = bs.getDrawGraphics(); 
    
    g.setColor(Color.BLACK); 
    g.fillRect(0,0,getWidth(),getHeight()); 
    
    g.drawImage(image, 0, 0, getWidth(),getHeight(),null); 
    
    g.dispose();                                                                // entsorgt überflüssige Daten
    bs.show(); 
  }
} // end of main