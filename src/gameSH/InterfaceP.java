package gameSH;

import java.awt.Color;
import java.awt.Graphics;

public class InterfaceP {

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(32, 10, 200, 20);
		g.setColor(Color.green);
		g.fillRect(32, 10, (int)((Game.player.life/Game.player.maxLife)*200), 20);
	}
}
