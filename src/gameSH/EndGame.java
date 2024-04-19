package gameSH;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class EndGame {
	
	public String[] options = {"Jogar Novamente", "Sair"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	public boolean up, down, enter;

	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}
		if(enter) {
			enter = false;
			if(options[currentOption] == "Jogar Novamente") {
				Game.level = 1;
				Game.newWorld = "level1.png";
				World.restartGame(Game.newWorld);
				Game.gameState = "NORMAL";
			} else if(options[currentOption] == "Sair") {
				System.exit(1);
			}
		}
	}
	
	public void render (Graphics g) {
		g.drawImage(SpriteSheet.telaFinal, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 24));
		g.drawString("Jogar Novamente", (Game.WIDTH / 2) + 80, (Game.HEIGHT / 2) - 80);
		g.drawString("Sair", (Game.WIDTH / 2) + 165, (Game.HEIGHT / 2) - 48);
		
		if(options[currentOption] == "Jogar Novamente") {
			g.drawString(">", (Game.WIDTH / 2) + 50, (Game.HEIGHT / 2) - 80);
		} else if(options[currentOption] == "Sair") {
			g.drawString(">", (Game.WIDTH / 2) + 136, (Game.HEIGHT / 2) - 48);
		}
	}
}
