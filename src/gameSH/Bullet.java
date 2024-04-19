package gameSH;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle{
public int dirx = 1;
public int diry = 1;
public int speed = 6;
public int frames = 0;

public Bullet(int x, int y, int dirx, int diry) {
	super(x+16, y+16, 16, 16);
	this.dirx = dirx;
	this.diry = diry;
}
public void tick() {
	x+= speed*dirx;
	y+= speed*diry;
	frames++;
	if (frames == 60) {
		Player.bullets.remove(this);
		return;
	}
}
public void render(Graphics g) {

	if(Player.dirx == 1)
	g.drawImage(SpriteSheet.arrow_right, x, y, 32, 32, null);
	else if(Player.dirx == -1)
		g.drawImage(SpriteSheet.arrow_left, x, y, 32, 32, null);
	else if(Player.diry == -1)
		g.drawImage(SpriteSheet.arrow_up, x, y, 32, 32, null);
	else if(Player.diry == 1)
		g.drawImage(SpriteSheet.arrow_down, x, y, 32, 32, null);
	}
}
