package gameSH;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle  {	
	
	public boolean right, up, down, left;
	public int spd = 4;
	public int curAnimation = 0;
	public int curFrames = 0; public int targetFrames = 15;
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	public boolean shoot = false;
	public static int dirx = 1;
	public static int diry = 1;
	public int dir_right = 0, dir_left = 1;
	public int dir = dir_right;
	public static int ammo = 0;
	public static boolean arco = false;
	public double life = 100, maxLife = 100;

	public Player(int x, int y) {
		super (x, y, 64, 64);
	}

	public void tick () {
		
		boolean moved = false;
		 if (life <= 0) { 
			 life = 0;
			 Game.gameState = "GAME_OVER";
			}
		 
		 if (right && World.isFree(x+spd, y) && EnemiesColidding(x+spd, y) && ColiddingBoss(x+spd, y)) {
				x+= spd ;
				 moved = true;
				 dirx = 1;
				 diry = 0;
				 dir = dir_right;
				 
			} else if (left && World.isFree(x-spd, y) && EnemiesColidding(x-spd, y) && ColiddingBoss(x-spd, y)) {
				x-= spd ;
				moved = true;
				dirx = -1;
				diry = 0;
				dir = dir_left;
			}
			
			if (up && World.isFree(x , y-spd) && EnemiesColidding(x, y-spd) && ColiddingBoss(x, y-spd)) {
				y-= spd ;
				moved = true;
				diry = -1;
				dirx = 0;
				 
			} else if (down && World.isFree(x, y+spd) && EnemiesColidding(x, y+spd) && ColiddingBoss(x, y+spd)) {
				y+= spd ;
				moved = true;
				diry = 1;
				dirx = 0;
			}	
		
		if(moved) {
		curFrames++;
		if(curFrames == targetFrames) {
			curFrames = 0;
			curAnimation++;
			if(curAnimation == SpriteSheet.player_right.length) {
				curAnimation = 0;
			}
		}
		}
		if(shoot && arco && ammo > 0) {
			shoot = false;
			bullets.add(new Bullet(x, y, dirx, diry));
			ammo--;
		}
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}
	
	public boolean EnemiesColidding ( int x , int y ) {
		for ( int i = 0 ; i < Game.inimigos.size(); i ++ ) {
			Inimigo ini = Game.inimigos.get(i);
		
		if ( ini.intersects(new Rectangle (x, y, 64, 64))) {
			return false  ;
		     }
		 }	
		return true ;
	}
	
	public boolean ColiddingBoss ( int x , int y ) {
		for ( int i = 0 ; i < Game.boss.size(); i ++ ) {
			Boss boss = Game.boss.get(i);
		
		if ( boss.intersects(new Rectangle (x, y, 64, 64))) {
			return false  ;
		     }
		 }	
		return true ;
	}
	
	public boolean isColiddingAmmo() {
		for (int i = 0; i < Game.municao.size(); i++) {
		Ammo m = Game.municao.get(i);
		if (this.intersects(m)) {
			return true;
		}
	}
		return false;
	}
		
	public void render ( Graphics g ) {
		if(dir == dir_right) {
		g.drawImage(SpriteSheet.player_right[curAnimation], x, y, 64, 64, null);
		if(arco)
			g.drawImage(SpriteSheet.arco_right, x+40, y+30, 32, 32, null);
		} else if(dir == dir_left) {
			g.drawImage(SpriteSheet.player_left[curAnimation], x, y, 64, 64, null);
			if(arco)
			g.drawImage(SpriteSheet.arco_left, x-8, y+30, 32, 32, null);

		}
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
	}
}