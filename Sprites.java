import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; 
import java.io.IOException; 
public class Sprites{ 
  private String path; 
  public final int SIZE;               // größe des SpriteSheets
  public int[] pixels; 
  
  public static Sprites tiles = new Sprites("/res/textures/Sprites.png ", 160 ); 
  public static Sprites playerTiles = new Sprites("/res/textures/Spielersprites.png ", 14);  
  
  public Sprites(String path, int size){
    this.path = path; 
    SIZE = size; 
    pixels = new int[SIZE * SIZE]; 
    load(); 
  }
  
  private void load(){
    try {
      BufferedImage image = ImageIO.read(Sprites.class.getResource(path)); 
      int w = image.getWidth(); 
      int h = image.getHeight();
      
      image.getRGB(0, 0, w, h, pixels, 0, w); 
      //image.getRGB(int startX, int startY, int w, int h, int[]rgbArray,int offset, int scansize);
    } catch(IOException e) {
      e.printStackTrace(); 
    }
    
    
    
    
    
  }
}