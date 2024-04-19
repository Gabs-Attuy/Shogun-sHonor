package gameSH;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Inimigo extends Rectangle  {	
	
	public int right = 1 , up = 0 , down = 0, left = 0;
		public int spd = 2 ;
		public int curAnimation = 0;
		public int curFrames = 0; public int targetFrames = 15;
		private int life = 10;

	public Inimigo(int x , int y ) {
		super ( x, y , 64 , 64);
		        
	}
	
	public void perseguirPlayer() {
		Player p = Game.player;
		if (isColiddingWithPlayer(p.x, p.y) == false) {
		if (x < p.x && World.isFree(x+spd, y) && !isColidding(x+spd, y )) {
			x+=spd;
		} else if (x > p.x && World.isFree(x-spd, y) && !isColidding(x-spd, y)) {
			x-=spd;
		}
		if (y < p.y && World.isFree(x, y+spd) && !isColidding(x, y+spd)) {
			y+=spd;
		} else if (y > p.y && World.isFree(x, y-spd) && !isColidding(x, y-spd)) {
			y-=spd;
		} 
		} else {
			if (Game.rand.nextInt(100) < 10) {
				Game.player.life-= Game.rand.nextInt(3);
			}
		}
	}

	public void tick () {
		boolean moved = true;
		perseguirPlayer();
		coliddingBullet();
		if(life <= 0) {
			destroySelf();
			Game.municao.add(new Ammo(this.x, this.y));
		}
		if(moved) {
		curFrames++;
		if(curFrames == targetFrames) {
			curFrames = 0;
			curAnimation++;
			if(curAnimation == SpriteSheet.inimigo_front.length) {
				curAnimation = 0;
			}
		}
		}
	}
	
	public boolean isColiddingWithPlayer(int x, int y) {
		Player p = Game.player;
		for (int i = 0; i < Game.inimigos.size(); i++) {
		Inimigo in = Game.inimigos.get(i);
		Rectangle player = new Rectangle(p.x, p.y, 64, 64);
		if (this.intersects(player)) {
			return true;
		}
	}
		return false;
	}
	
	public void destroySelf() {
		Game.inimigos.remove(this);
	}
	
	public void coliddingBullet() {
		for(int i = 0; i < Player.bullets.size(); i++) {
			Rectangle e = Player.bullets.get(i);
			if(e.intersects(this)) {
				life-= Game.rand.nextInt(1, 3);
			Player.bullets.remove(i);
			}
			return;
		}
	}
	
	public boolean isColidding (int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext, ynext, 64, 64);
		for ( int i = 0 ; i < Game.inimigos.size(); i ++ ) {
			Inimigo in = Game.inimigos.get(i);
		if (in == this)
			continue;
		if (enemyCurrent.intersects(in)) {
			return true;
		     }
		 }	
		return false;
	}
	
	public void render ( Graphics g ) {
		g.drawImage(SpriteSheet.inimigo_front[curAnimation], x, y, 64, 64, null);
	}
}