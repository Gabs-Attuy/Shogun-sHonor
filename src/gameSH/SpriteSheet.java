package gameSH;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static BufferedImage spritesheet;
	public static BufferedImage[]  player_right;
	public static BufferedImage[] player_left;
	public static BufferedImage[] inimigo_front;
	public static BufferedImage[] boss;
	public static BufferedImage piso;
	public static BufferedImage parede;
	public static BufferedImage arco_right;
	public static BufferedImage arco_left;
	public static BufferedImage arrow_right;
	public static BufferedImage arrow_left;
	public static BufferedImage arrow_up;
	public static BufferedImage arrow_down;
	public static BufferedImage telaInicio;
	public static BufferedImage telaFinal;
	public static BufferedImage municao;
	public static String newWorld = "level"+Game.level+".png";
	public SpriteSheet () {
		
		try {
			spritesheet = ImageIO.read(getClass().getResource("/pixelarts.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		     }
		player_right = new BufferedImage[4];
		player_right[0] = SpriteSheet.getSprite(176, 16, 16, 16);
		player_right[1] = SpriteSheet.getSprite(176+16, 16, 16, 16);
		player_right[2] = SpriteSheet.getSprite(176+32, 16, 16, 16);
		player_right[3] = SpriteSheet.getSprite(176+48, 16, 16, 16);
		
		player_left = new BufferedImage[4];
		player_left[0] = SpriteSheet.getSprite(176, 32, 16, 16);
		player_left[1] = SpriteSheet.getSprite(176+16, 32, 16, 16);
		player_left[2] = SpriteSheet.getSprite(176+32, 32, 16, 16);
		player_left[3] = SpriteSheet.getSprite(176+48, 32, 16, 16);
		
		inimigo_front = new BufferedImage[3];
		inimigo_front[0] = SpriteSheet.getSprite(23, 71, 14, 17);
		inimigo_front[1] = SpriteSheet.getSprite(8, 71, 13, 17);
		inimigo_front[2] = SpriteSheet.getSprite(40, 71, 13, 17);
		
		arco_right = SpriteSheet.getSprite(256, 16, 16, 16);
		arco_left = SpriteSheet.getSprite(240, 16, 16, 16);
		
		arrow_right = SpriteSheet.getSprite(320, 16, 16, 16);
		arrow_left = SpriteSheet.getSprite(288, 16, 16, 16);
		arrow_up = SpriteSheet.getSprite(304, 0, 16, 16);
		arrow_down = SpriteSheet.getSprite(304, 32, 16, 16);
		
		municao = SpriteSheet.getSprite(272, 32, 16, 16);
		
		boss = new BufferedImage[2];
		boss[0] = SpriteSheet.getSprite(152, 132, 57, 54);
		boss[1] = SpriteSheet.getSprite(222, 132, 57, 54);
		
		try {
			spritesheet = ImageIO.read(getClass().getResource("/"+newWorld));
		} catch (IOException e) {
			
			e.printStackTrace();
		     }
				piso = SpriteSheet.getSprite(0, 0, 126, 130);
				
		try {
			spritesheet = ImageIO.read(getClass().getResource("/parede  (1).png"));
		} catch (IOException e) {
					
			e.printStackTrace();
			 }
				parede = SpriteSheet.getSprite(0, 0, 32, 32);
		try {
			spritesheet = ImageIO.read(getClass().getResource("/tela de inicio.jpg"));
			} catch (IOException e) {
					
			e.printStackTrace();
			 }
				telaInicio = SpriteSheet.getSprite(0, 0, 256, 256);
		try {
			spritesheet = ImageIO.read(getClass().getResource("/tela final.png"));
			} catch (IOException e) {
							
			e.printStackTrace();
			 }
				telaFinal = SpriteSheet.getSprite(0, 0, 126, 126);
		}
		
	
public static BufferedImage getSprite ( int x , int y , int width , int heigth) {
			
			return spritesheet.getSubimage(x, y, width, heigth);
	}
}