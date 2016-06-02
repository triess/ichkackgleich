import java.util.Random; 

public abstract class Entity {
  
  public int x,y; 
  private boolean removed = false; 
  protected Level level; 
  protected final Random random = new Random(); 
  
  
  public void update(){
    
    
    }
    
  public void render(Screen screen){
    
    
    }
  
  public void remove(){           //löscht das entity aus dem level 
     removed = true; 
    }
  
  public boolean isRemoved(){
    return removed;     
    }

  }
