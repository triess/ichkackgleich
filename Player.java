public class Player extends Mob{
  private Keyboard input; 
  
  
  
  public Player(Keyboard input, Level level){
    super(level);
    breite=13;
    hoehe=13;
    this.input = input;  
    this.x = 16; 
    this.y = 16; 
    sprite=Sprite.player;
  }
  public Player(int x, int y,Keyboard input, Level level){
    super(level);
    breite=11;
    hoehe=13;
    this.x = x; 
    this.y = y; 
    sprite=Sprite.player;
    this.input = input; 
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
    	case 0: if(welt.getTile((x+breite/2)/16, (y+hoehe/2)/16-1)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16, (y+hoehe/2)/16-1)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16, (y+hoehe/2)/16-1,23 );
    	break;
    	case 1: if(welt.getTile((x+breite/2)/16+1, (y+hoehe/2)/16)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16+1, (y+hoehe/2)/16)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16+1, (y+hoehe/2)/16,23 );
    	break;
    	case 2: if(welt.getTile((x+breite/2)/16, (y+hoehe/2)/16+1)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16, (y+hoehe/2)/16+1)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16, (y+hoehe/2)/16+1,23 );
    	break;
    	case 3: if(welt.getTile((x+breite/2)/16-1, (y+hoehe/2)/16)==Tile.vertikalesZerstoerbaresWandTeil ||welt.getTile((x+breite/2)/16-1, (y+hoehe/2)/16)==Tile.horizontalesZerstoerbaresWandTeil )welt.setTile((x+breite/2)/16-1, (y+hoehe/2)/16,23 );
    	break;
    	}
    }
    
    if (xa != 0 || ya != 0) {
      move(xa, ya); 
    } // end of if
  }
  
  public void render(Screen screen){ 
    screen.renderPlayer(x,y,sprite);    
  }
}
