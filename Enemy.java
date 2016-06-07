public class Enemy extends Mob{
  
	protected int laufen=0;
	protected int bewegen=0;
	
	public Enemy(Level welt,Sprite pic){
		super(welt);
		sprite=pic;
	}
	public Enemy(Level welt,Sprite pic,int x,int y){
		super(welt);
		sprite=pic;
		this.x=x;
		this.y=y;
		hoehe=14;
		breite=14;
	}
	
	public void move(){
		bewegen=(bewegen+1)%4;
		if(bewegen==0){
		 if(laufen<20 && laufen>=0){
			super.move(1, 0);
			laufen++;
		 }
		 if(laufen>=20){
			laufen=-20;
		 }
		 if(laufen<0){
			super.move(-1, 0);
			laufen++;
		 }
			
		}
		
		
	}
	
	
	public void update(){
		move();
	}
	
}
