import java.util.Random; 
public class RandomLevel extends Level{
  
  private static final Random random = new Random(); 
  
  public RandomLevel(int width, int height){
    super(width,height);      // aufruf des konstruktors der superklasse
    
  }
  
  protected void generateLevel(){
    for (int y = 0;y < height; y++ ) {
      for (int x = 0; x < width ;x++ ) {
        tiles[x+y*width] = 0; 
      } // end of for
    } // end of for
    
    tiles[10+10*width] = 3; 
    tiles[9+10*width] = 4;
    tiles[8+10*width] = 11;
    tiles[8+11*width] = 6;
    tiles[10+9*width] = 5;
    tiles[10+8*width] = 7;
    tiles[10+11*width] = 5;
    tiles[10+12*width] = 6;
    tiles[11+10*width] = 4;
    tiles[12+10*width] = 4;
    tiles[13+10*width] = 8;
    
  }
}
