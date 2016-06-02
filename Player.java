public class Player extends Mob{
  private Keyboard input; 
  
  
  
  public Player(Keyboard input, Level level){
    super(level);
    this.input = input;  
    this.x = 16; 
    this.y = 16; 
  }
  public Player(int x, int y,Keyboard input, Level level){
    super(level); 
    this.x = x; 
    this.y = y; 
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
    
    if (xa != 0 || ya != 0) {
      move(xa, ya); 
    } // end of if
  }
  
  public void render(Screen screen){ 
    screen.renderPlayer(x,y,Sprite.player);    
  }
}
