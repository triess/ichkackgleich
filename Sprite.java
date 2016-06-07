public class Sprite{
  private int x,y; 
  public int[] pixels; 
  private Sprites sheet; 
  public int breite, hoehe;
  
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
  
  public static Sprite player = new Sprite(10,16,0,0,Sprites.playerTiles);   
  public Sprite(int size, int x, int y, Sprites sheet){
    breite = size;
    hoehe = size;
    pixels = new int[size*size]; 
    this.x = x*size; 
    this.y = y*size; 
    this.sheet = sheet; 
    load(breite,hoehe); 
  }
  public Sprite(int breite, int hoehe,int x, int y, Sprites sheet){
    this.breite = breite; 
    this.hoehe = hoehe; 
    this.x = x*breite; 
    this.y = y*hoehe; 
    pixels = new int[breite*hoehe]; 
    this.sheet = sheet; 
    load(breite,hoehe);
    }
  
  public Sprite(int size, int colour){
    breite = size; 
    hoehe = size;
    pixels = new int[size*size]; 
    setColour(colour); 
  }
  
  private void setColour(int colour){
    for (int i = 0;i < breite*hoehe ;i++ ) {
      pixels[i] = colour; 
    } // end of for
    
  }
  
  
  private void load(int breite, int hoehe){
    for (int y = 0;y < hoehe ;y++ ) {
      for (int x = 0;x < breite ;x++ ) {
        pixels[x+y*breite] = sheet.pixels[(x+this.x) + (y+this.y)*sheet.SIZE]; 
      } // end of for
    } // end of for
    
    
  }
  
  
}