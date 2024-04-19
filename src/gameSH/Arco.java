package gameSH;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Arco extends Rectangle{
	
	public Arco(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		
		if(isColiddingArco() == true) {
			Game.arco.remove(this);
			Player.arco = true;
			Player.ammo+= 20;
		}
	}
	
	public boolean isColiddingArco() {
		Player p = Game.player;
		if (this.intersects(p)) {
			return true;
		}
		return false;
	}
	
	public void render ( Graphics g ) {
		g.drawImage(SpriteSheet.arco_right, x, y, 32, 32, null);

	}
}
