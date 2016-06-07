public class Player extends Mob{
  private Keyboard input; 
  
  
  
  public Player(Keyboard input, Level level){
    super(level);
    this.input = input;  
    this.x = 16; 
    this.y = 16; 
    breite = Sprite.player.breite-1; 
    hoehe = Sprite.player.hoehe-1; 
  }
  public Player(int x, int y,Keyboard input, Level level){
    super(level); 
    this.x = x; 
    this.y = y; 
    this.input = input; 
    breite = Sprite.player.breite-1; 
    hoehe = Sprite.player.hoehe-1; 
  }
  
  public void update(){
    int xa = 0, ya = 0; 
    if (input.up) {
      ya--; 
    } // end of if
    if (input.down) {
      ya++; 
    } // end of if
    if (input.left) {
      xa--; 
    } // end of if
    if (input.right) {
      xa++; 
    } // end of if
    
    if(input.space){
      switch(direction){
      case 0: if(welt.getTile((x+breite/2)/16, (y+hoehe/2)/16-1)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16, (y+hoehe/2)/16-1)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16, (y+hoehe/2)/16-1,20 );
      break;
      case 1: if(welt.getTile((x+breite/2)/16+1, (y+hoehe/2)/16)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16+1, (y+hoehe/2)/16)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16+1, (y+hoehe/2)/16,20 );
      break;
      case 2: if(welt.getTile((x+breite/2)/16, (y+hoehe/2)/16+1)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16, (y+hoehe/2)/16+1)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16, (y+hoehe/2)/16+1,20 );
      break;
      case 3: if(welt.getTile((x+breite/2)/16-1, (y+hoehe/2)/16)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16-1, (y+hoehe/2)/16)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16-1, (y+hoehe/2)/16,20 );
      break;
      }
    }
    
    if (xa != 0 || ya != 0) {
      move(xa, ya); 
    } // end of if
  }
  
  public void render(Screen screen){ 
    screen.renderPlayer(x,y,Sprite.player);    
  }
}
