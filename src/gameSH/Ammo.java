package gameSH;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ammo extends Rectangle{
	
	public Ammo(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		
		if(isColiddingAmmo() == true) {
			Game.municao.remove(this);
			Player.ammo+= Game.rand.nextInt(12, 15);
		}
	}
	
	public boolean isColiddingAmmo() {
		Player p = Game.player;
		if (this.intersects(p)) {
			return true;
		}
		return false;
	}
	
	public void render ( Graphics g ) {
		
		g.drawImage(SpriteSheet.municao, x, y, 32, 32, null);
	}
}
