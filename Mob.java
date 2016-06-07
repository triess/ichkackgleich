public abstract class Mob extends Entity{
  
  protected Sprite sprite; 
  protected int direction = 0; // 0 = norden, 1 = osten, 2 = süden, 3 = westen 
  protected boolean moving = false; 
  protected Level welt; 
  public int breite;
  public int hoehe;
  
  public Mob(Level level){
    welt = level; 
    
  }
  
  public void move(int xa, int ya){       // xa & ya => Änderung der Koordinaten 
    
    if (xa > 0) {
      direction = 1; 
    } // end of if
    if (xa < 0) {
      direction = 3; 
    } // end of if
    if (ya > 0) {
      direction = 2; 
    } // end of if
    if (ya < 0) {
      direction = 0; 
    } // end of if
    
    if (!xCollision(xa)) {
      x += xa;        
    } // end of if
    if (!yCollision(ya)) {
      y += ya;
    } // end of if
    
  }
  public void update(){
    
    
  }
  public void render(){
    
  }
  private boolean xCollision(int xa){
    if (welt.getTile((x+xa)/16,(y)/16).getSolid()) {             // links oben
      return true;
    } // end of if
    if (welt.getTile((x+xa+breite)/16,(y)/16).getSolid()) {             // rechts oben
      return true;
    } // end of if
    if (welt.getTile((x+xa)/16,(y+hoehe)/16).getSolid()) {             // links unten
      return true;
    } // end of if
    if (welt.getTile((x+xa+breite)/16,(y+hoehe)/16).getSolid()) {                    // rechts unten
      return true;
    } // end of if
    return false;
  }
  private boolean yCollision(int ya){
    if (welt.getTile((x)/16,(y+ya)/16).getSolid()) {             // links oben
      return true;
    } // end of if
    if (welt.getTile((x+breite)/16,(y+ya)/16).getSolid()) {             // rechts oben
      return true;
    } // end of if
    if (welt.getTile((x)/16,(y+ya+hoehe)/16).getSolid()) {             // links unten
      return true;
    } // end of if
    if (welt.getTile((x+breite)/16,(y+ya+hoehe)/16).getSolid()) {                    // rechts unten
      return true;
    } // end of if
    return false;
  }
  
  
}
