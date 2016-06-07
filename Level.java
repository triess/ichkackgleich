import java.util.*; 
public class Level{
  
  public int width, height; 
  public int[] tiles; 
  protected int raeume; 
  protected int a, b; 
  public double destructablility=0.93;
  
  //Konstruktor für ein random Level
  public Level(int width, int height, int raeume, int a, int b){
    this.width = width; 
    this.height = height; 
    tiles = new int[width*height]; 
    this.raeume = raeume; 
    this.a = a;                                     
    this.b = b;    
    
    generateLevel();   
  }
  
  //Konstruktor zum Laden eines Levels
  public Level(String path){
    loadLevel(path);   
  }
  
  protected void generateLevel(){
    for (int y = 0;y < height; y++ ) {
      for (int x = 0; x < width ;x++ ) {
        tiles[x+y*width] = 1  ; 
      } // end of for
    } // end of for
    raeumeErstellen(); 
    labyrinthErstellen();
    bilderSetzen(); 
  }
  public void raeumeErstellen(){
    for (int n = 0;n < raeume ;n++ ) {
      int x1 = (int)(Math.random() * (width-3-a)); 
      int x2 =  x1 + (int)(Math.random() * a)+4;
      int y1 = (int)(Math.random() * (height-3-b));
      int y2 =  y1 + (int)(Math.random() * b)+4;  
      for (int i = 0;i < height ;i++ ) {
        for (int j = 0;j < width ;j++ ) {
          if (i > y1 && i < y2 && j > x1 && j < x2) {
            tiles[j+i*width] = 0; 
          } // end of if
          if (i == y1 && i < y2 && j >= x1 && j <= x2) {
            tiles[j+i*width] = 1; 
          } // end of if
          if (i > y1 && i == y2 && j >= x1 && j <= x2) {
            tiles[j+i*width] = 1; 
          } // end of if
          if (i >= y1 && i <= y2 && j == x1 && j < x2) {
            tiles[j+i*width] = 1; 
          } // end of if
          if (i >= y1 && i <= y2 && j > x1 && j == x2) {
            tiles[j+i*width] = 1; 
          } // end of if
        } // end of for
      } // end of for
    } // end of for
  }
  
  public void labyrinthErstellen(){
    int xa; 
    int ya;  
    Deque<Integer> stack = new ArrayDeque<Integer>();
    do {
      xa = (int)(Math.random()*(width-3))+1; 
      ya = (int)(Math.random()*(height-3))+1; 
    } while (tiles[xa+ya*width] != 1 || xa%2 == 0 || ya%2 == 0); // end of do-while     
    stack.push(xa); 
    stack.push(ya); 
    tiles[xa+ya*width] = 0; 
    
    while (stack.size() != 0) { 
      ya = stack.pop(); 
      xa = stack.peek(); 
      stack.push(ya);
      ArrayList<Character> wege  = new ArrayList<Character>(); 
      if (xa+2 < width-1 ) {
        if (tiles[xa+2+ya*width] == 1) {
          wege.add('r');
        } // end of if
      } // end of if
      if (xa-2 > 0 ) {
        if (tiles[xa-2+ya*width] == 1) {
          wege.add('l');
        } // end of if
      } // end of if    
      if (ya-2 > 0 ) {
        if (tiles[xa+(ya-2)*width] == 1) {
          wege.add('o');
        } // end of if
      } // end of if
      if (ya+2 < height-1 ) {
        if (tiles[xa+(ya+2)*width] == 1) {
          wege.add('u');
        } // end of if
      } // end of if
      
      if (wege.isEmpty()){
        stack.pop(); 
        stack.pop(); 
      }
      else {
        int chance = (int)(Math.random()*wege.size()); 
        char richtung = wege.get(chance); 
        if (richtung == 'r') {
          stack.push(xa+2); 
          stack.push(ya); 
          tiles[xa+1+ya*width] = 0; 
          tiles[xa+2+ya*width] = 0; 
        } // end of if
        if (richtung == 'l') {
          stack.push(xa-2); 
          stack.push(ya); 
          tiles[xa-1+ya*width] = 0; 
          tiles[xa-2+ya*width] = 0; 
        } // end of if
        if (richtung == 'o') {
          stack.push(xa); 
          stack.push(ya-2); 
          tiles[xa+(ya-1)*width] = 0; 
          tiles[xa+(ya-2)*width] = 0; 
        } // end of if
        if (richtung == 'u') {
          stack.push(xa); 
          stack.push(ya+2); 
          tiles[xa+(ya+1)*width] = 0; 
          tiles[xa+(ya+2)*width] = 0; 
        } // end of if
      } // end of if-else
    } // end of while
  }
  
  public void türenFinden(){         
    
  }
  
  public void loadLevel(String path){
    
  }
  
  public void update(){
    
  }
  
  private void time(){
    
  }
  
  public void render(int xScroll, int yScroll, Screen screen){
    screen.setOffset(xScroll, yScroll); 
    int x0 = xScroll >> 4;  // >> 4 == / 16      ===> tile Position und nicht Pixel Position 
    int x1 = (xScroll + screen.width + 16)  >> 4;
    int y0 = yScroll >> 4; 
    int y1 = (yScroll + screen.height + 16) >> 4; 
    
    for (int y = y0; y < y1 ; y++ ) {
      for (int x = x0;x < x1 ;x++ ) {
        getTile(x,y).render(x,y,screen);
      } // end of for
    } // end of for
  }
  
  public void bilderSetzen(){
    for (int i = 0;i < width;i++ ) {
      for (int j = 0;j < height;j++ ) {
        if (tiles[i+j*width] == 1) {
          if (i == 0 || j == 0 || i == width-1 || j == height-1) {
            if ( i == 0 && j == 0) {
              tiles[i+j*width] = 12; 
            } // end of if
            if ( i == 0 && j == height -1) {
              tiles[i+j*width] = 10; 
            } // end of if
            if ( i == width -1 && j == 0) {
              tiles[i+j*width] = 13; 
            } // end of if
            if ( i == width -1 && j == height - 1) {
              tiles[i+j*width] = 11; 
            } // end of if
            if ( (i == 0 && j != 0 && j != height-1 && tiles[i+1+j*width] != 1) || ( i == width -1 && j != 0 && j != height-1 && tiles[i-1+j*width] != 1)) {
              tiles[i+j*width] = 5; 
            } // end of if
            if ( (j == 0 && i != 0 && i != width-1 && tiles[i+(j+1)*width] != 1)|| (j == height -1 && i != 0 && i != width-1 && tiles[i+(j-1)*width] != 1)) {
              tiles[i+j*width] = 4; 
            } // end of if
            if (i == 0 && j != 0 && j != height-1 && tiles[i+1+j*width] == 1) {
              tiles[i+j*width] = 16; 
            } // end of if
            if (i == width -1 && j != 0 && j != height-1 && tiles[i-1+j*width] == 1) {
              tiles[i+j*width] = 17; 
            } // end of if
            if (j == 0 && i != 0 && i != width-1 && tiles[i+(j+1)*width] == 1) {
              tiles[i+j*width] = 15; 
            } // end of if
            if (j == height -1 && i != 0 && i != width-1 && tiles[i+(j-1)*width] == 1) {
              tiles[i+j*width] = 14; 
            } // end of if
          } // end of if
          else {
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] == 0) {
              tiles[i+j*width] = 9; 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] == 0) {
              tiles[i+j*width] = 8; 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] != 0) {
              tiles[i+j*width] = 6; 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] == 0) {
              tiles[i+j*width] = 7; 
            } // end of if
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] != 0) {
              tiles[i+j*width] = 3; 
            } // end of if
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] == 0) {
              if(Math.random()<destructablility){
              tiles[i+j*width] = 4;
              }else{
                tiles[i+j*width] = 21;
              } 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] != 0) {
              if(Math.random()<destructablility){
                  tiles[i+j*width] = 5;
                  }else{
                    tiles[i+j*width] = 22;
                  } 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] != 0) {
              tiles[i+j*width] = 11; 
            } // end of if
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] != 0) {
              tiles[i+j*width] = 10; 
            } // end of if
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] == 0) {
              tiles[i+j*width] = 12; 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] == 0) {
              tiles[i+j*width] = 13; 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] == 0) {
              tiles[i+j*width] = 0; 
            } // end of if
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] == 0) {
              tiles[i+j*width] = 15; 
            } // end of if
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] == 0 && tiles[i+(j-1)*width] != 0) {
              tiles[i+j*width] = 14; 
            } // end of if
            if (tiles[i+1+j*width] == 0 && tiles[i-1+j*width] != 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] != 0) {
              tiles[i+j*width] = 17; 
            } // end of if
            if (tiles[i+1+j*width] != 0 && tiles[i-1+j*width] == 0 && tiles[i+(j+1)*width] != 0 && tiles[i+(j-1)*width] != 0) {
              tiles[i+j*width] = 16; 
            } // end of if
          } // end of if-else
        } // end of if
      } // end of for
    } // end of for
    
  }
  
  public Tile getTile(int x, int y){
    if (x < 0 || y < 0 || x >= width || y >= height)  return Tile.leeresTile;
    
    if (tiles[x+y*width] == 0 ) return Tile.holzParkett;   
    if (tiles[x+y*width] == 1 ) return Tile.graueFliese3; 
    if (tiles[x+y*width] == 2 ) return Tile.graueFliese2;
    if (tiles[x+y*width] == 3 ) return Tile.wandKreuz;  
    if (tiles[x+y*width] == 4 ) return Tile.horizontalesWandTeil; 
    if (tiles[x+y*width] == 5 ) return Tile.vertikalesWandTeil; 
    if (tiles[x+y*width] == 6 ) return Tile.unteresWandEnde; 
    if (tiles[x+y*width] == 7 ) return Tile.oberesWandEnde; 
    if (tiles[x+y*width] == 8 ) return Tile.rechtesWandEnde; 
    if (tiles[x+y*width] == 9 ) return Tile.linkesWandEnde; 
    if (tiles[x+y*width] == 10 ) return Tile.linkeUntereWandEcke;
    if (tiles[x+y*width] == 11 ) return Tile.rechteUntereWandEcke;
    if (tiles[x+y*width] == 12 ) return Tile.linkeObereWandEcke; 
    if (tiles[x+y*width] == 13 ) return Tile.rechteObereWandEcke;
    if (tiles[x+y*width] == 14 ) return Tile.linksRechtsObenWand;
    if (tiles[x+y*width] == 15 ) return Tile.linksRechtsUntenWand;
    if (tiles[x+y*width] == 16 ) return Tile.obenUntenRechtsWand;
    if (tiles[x+y*width] == 17 ) return Tile.obenUntenLinksWand; 
    if (tiles[x+y*width] == 18 ) return Tile.gelbeFliese; 
    if (tiles[x+y*width] == 19 ) return Tile.graueFliese4; 
    if (tiles[x+y*width] == 20 ) return Tile.normalesGras;
    if (tiles[x+y*width] == 21 ) return Tile.horizontalesZerstoerbaresWandTeil; 
    if (tiles[x+y*width] == 22 ) return Tile.vertikalesZerstoerbaresWandTeil; 
    
    return Tile.leeresTile;  
  }
  
  public void setTile(int xt,int yt,int tileNumber){
    tiles[xt+yt*width]=tileNumber;
  }
}