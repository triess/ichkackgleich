public class Tile{
  
  public int x,y; 
  public Sprite sprite;
  protected boolean solid;
  public static Tile leeresTile = new Tile(Sprite.leeresSprite,false); 
  public static Tile graueFliese1 = new Tile(Sprite.graueFliese1,false); 
  public static Tile unteresWandEnde = new Tile(Sprite.unteresWandEnde,true);  
  public static Tile linkesWandEnde = new Tile(Sprite.linkesWandEnde,true);  
  public static Tile rechtesWandEnde = new Tile(Sprite.rechtesWandEnde,true);  
  public static Tile oberesWandEnde = new Tile(Sprite.oberesWandEnde,true);  
  public static Tile horizontalesWandTeil = new Tile(Sprite.horizontalesWandTeil,true); 
  public static Tile vertikalesWandTeil = new Tile(Sprite.vertikalesWandTeil,true);  
  public static Tile wandKreuz = new Tile(Sprite.mittleresWandKreuz,true);  
  public static Tile linkeUntereWandEcke = new Tile(Sprite.linkeUntereWandEcke,true); 
  public static Tile rechteUntereWandEcke = new Tile(Sprite.rechteUntereWandEcke,true); 
  public static Tile linkeObereWandEcke = new Tile(Sprite.linkeObereWandEcke,true); 
  public static Tile rechteObereWandEcke = new Tile(Sprite.rechteObereWandEcke,true); 
  public static Tile linksRechtsObenWand = new Tile(Sprite.linksRechtsObenWand,true); 
  public static Tile linksRechtsUntenWand = new Tile(Sprite.linksRechtsUntenWand,true); 
  public static Tile obenUntenRechtsWand = new Tile(Sprite.obenUntenRechtsWand,true); 
  public static Tile obenUntenLinksWand = new Tile(Sprite.obenUntenLinksWand,true); 
  public static Tile holzParkett = new Tile(Sprite.holzParkett,false); 
  public static Tile gelbeFliese = new Tile(Sprite.gelbeFliese,false); 
  public static Tile graueFliese2 = new Tile(Sprite.graueFliese2,false); 
  public static Tile graueFliese3 = new Tile(Sprite.graueFliese3,false);   
  public static Tile graueFliese4 = new Tile(Sprite.graueFliese4,false); 
  public static Tile normalesGras = new Tile(Sprite.normalesGras,false); 
  public static Tile horizontalesZerstoerbaresWandTeil = new Tile(Sprite.horizontalesZerstoerbaresWandTeil,true); 
  public static Tile vertikalesZerstoerbaresWandTeil = new Tile(Sprite.vertikalesZerstoerbaresWandTeil,true);
  public static Tile zerstoertesWandTeil = new Tile(Sprite.zerstoertesWandTeil,false);
  
  public Tile(Sprite sprite, boolean solid){
    this.sprite = sprite;
    this.solid = solid; 
  }
  
  public void render(int x, int y, Screen screen){
    screen.renderTile(x << 4,y << 4,this);
  }
  
  public boolean getSolid(){
    return solid;
  }
}
