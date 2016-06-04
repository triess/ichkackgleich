public class Sprite{
  public final int SIZE;
  private int x,y; 
  public int[] pixels; 
  private Sprites sheet; 
  
  public static Sprite graueFliese1 = new Sprite(16,0,0,Sprites.tiles); 
  public static Sprite graueFliese2 = new Sprite(16,1,0,Sprites.tiles);
  public static Sprite graueFliese3 = new Sprite(16,2,0,Sprites.tiles);
  public static Sprite unteresWandEnde = new Sprite(16,3,0,Sprites.tiles);
  public static Sprite rechtesWandEnde = new Sprite(16,4,0,Sprites.tiles);
  public static Sprite linkesWandEnde = new Sprite(16,5,0,Sprites.tiles);
  public static Sprite horizontalesWandTeil = new Sprite(16,6,0,Sprites.tiles);
  public static Sprite rechteObereWandEcke = new Sprite(16,7,0,Sprites.tiles);
  public static Sprite linkeObereWandEcke = new Sprite(16,8,0,Sprites.tiles);
  public static Sprite vertikalesWandTeil = new Sprite(16,9,0,Sprites.tiles);
  public static Sprite mittleresWandKreuz = new Sprite(16,0,1,Sprites.tiles);
  public static Sprite oberesWandEnde = new Sprite(16,1,1,Sprites.tiles);
  public static Sprite linkeUntereWandEcke = new Sprite(16,2,1,Sprites.tiles);
  public static Sprite rechteUntereWandEcke = new Sprite(16,3,1,Sprites.tiles);
  public static Sprite linksRechtsObenWand = new Sprite(16,5,1,Sprites.tiles); 
  public static Sprite linksRechtsUntenWand = new Sprite(16,4,1,Sprites.tiles); 
  public static Sprite obenUntenRechtsWand = new Sprite(16,6,1,Sprites.tiles); 
  public static Sprite obenUntenLinksWand = new Sprite(16,7,1,Sprites.tiles);                         
  public static Sprite holzParkett = new Sprite(16,0,2,Sprites.tiles);
  public static Sprite gelbeFliese = new Sprite(16,1,2,Sprites.tiles);
  public static Sprite graueFliese4 = new Sprite(16,2,2,Sprites.tiles); 
  public static Sprite normalesGras = new Sprite(16,3,2,Sprites.tiles); 
  public static Sprite leeresSprite = new Sprite(16, 0x000000); 
  public static Sprite horizontalesZerstoerbaresWandTeil = new Sprite(16,9,2,Sprites.tiles);
  public static Sprite vertikalesZerstoerbaresWandTeil = new Sprite(16,8,2,Sprites.tiles);
  
  public static Sprite player = new Sprite(14,0,0,Sprites.playerTiles);   
  public Sprite(int size, int x, int y, Sprites sheet){
    SIZE = size; 
    pixels = new int[SIZE*SIZE]; 
    this.x = x*size; 
    this.y = y*size; 
    this.sheet = sheet; 
    load(); 
  }
  
  public Sprite(int size, int colour){
    SIZE = size; 
    pixels = new int[SIZE*SIZE]; 
    setColour(colour); 
  }
  
  private void setColour(int colour){
    for (int i = 0;i < SIZE*SIZE ;i++ ) {
      pixels[i] = colour; 
    } // end of for
    
  }
  
  
  private void load(){
    for (int y = 0;y < SIZE ;y++ ) {
      for (int x = 0;x < SIZE ;x++ ) {
        pixels[x+y*SIZE] = sheet.pixels[(x+this.x) + (y+this.y)*sheet.SIZE]; 
      } // end of for
    } // end of for
    
    
  }
  
  
}