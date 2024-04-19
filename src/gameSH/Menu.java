package gameSH;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {
	
	public String[] options = {"Novo Jogo", "Sair"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	public boolean up, down, enter;
	public boolean pause;

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
			if(options[currentOption] == "Novo Jogo" || options[currentOption] == "Continuar") {
				Game.gameState = "NORMAL";
				pause = false;
			} else if(options[currentOption] == "Sair") {
				System.exit(1);
			}
		}
	}
	
	public void render (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if(pause == false) {
		g.drawImage(SpriteSheet.telaInicio, 0, 0, Game.WIDTH, Game.HEIGHT, null);
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.BOLD, 24));
		g.drawString("Novo Jogo", (Game.WIDTH / 2) - 60, (Game.HEIGHT / 2) + 64);
		g.drawString("Sair", (Game.WIDTH / 2) - 22, (Game.HEIGHT / 2) + 96);
		} else {
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.setColor(Color.white);
			g.setFont(new Font("arial", Font.BOLD, 24));
			g.drawString("Continuar", (Game.WIDTH / 2) - 60, (Game.HEIGHT / 2) + 64);
			g.drawString("Sair", (Game.WIDTH / 2) - 22, (Game.HEIGHT / 2) + 96);
		} 
		
		if(options[currentOption] == "Novo Jogo") {
			g.drawString(">", (Game.WIDTH / 2) - 90, (Game.HEIGHT / 2) + 64);
		} else if(options[currentOption] == "Sair") {
			g.drawString(">", (Game.WIDTH / 2) - 60, (Game.HEIGHT / 2) + 96);
		}
	}
}
