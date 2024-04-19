package gameSH;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import java.io.IOException;

public class World  {
	public static List<Blocks> blocos = new ArrayList<Blocks>();
	
	public World (String newWorld) {
		try {
			SpriteSheet.spritesheet = ImageIO.read(getClass().getResource("/"+newWorld));
		} catch (IOException e) {
			e.printStackTrace();
		     }
				SpriteSheet.piso = SpriteSheet.getSprite(0, 0, 126, 130);
				
		if(newWorld.equals("level1.png")) {
			
		for ( int xx = 0 ; xx < 20 ; xx ++) {
			blocos.add(new Blocks (xx*32, 0));
		}
		
		for ( int xx = 0 ; xx < 20 ; xx ++) {
			blocos.add(new Blocks (xx*32, 640-32));
		}
		
		for ( int yy = 0 ; yy < 20 ; yy ++) {
			blocos.add(new Blocks (0, yy*32 ));
		}
		
		for ( int yy = 0 ; yy < 20 ; yy ++) {
			blocos.add(new Blocks (640-32, yy*32 ));
		}
		
		blocos.add(new Blocks (32, 128));
		blocos.add(new Blocks (74, 128));
		blocos.add(new Blocks (32, 128+160));
		blocos.add(new Blocks (74, 128+160));
		blocos.add(new Blocks (74, 128+64));
		blocos.add(new Blocks (74, 128+128));
		
		blocos.add(new Blocks (640-180, 640-64));
		blocos.add(new Blocks (640-180, 640-128));
		blocos.add(new Blocks (640-180, 640-210));
		blocos.add(new Blocks (640-128, 640-210));
		blocos.add(new Blocks (640-64, 640-210));
		
		blocos.add(new Blocks (640-196, 138));
		blocos.add(new Blocks (640-196, 250-32));
		blocos.add(new Blocks (640-132, 138));
		blocos.add(new Blocks (640-132, 250-32));
		
		Game.inimigos.add(new Inimigo(220, 32));
		Game.inimigos.add(new Inimigo(370, 32));
		
		Game.municao.add(new Ammo(64, 96));
		
		} else if(newWorld.equals("level2.png")) {
			
			Game.inimigos.add(new Inimigo(360, 32));
			Game.inimigos.add(new Inimigo(420, 96));
			Game.inimigos.add(new Inimigo(296, 32));
			Game.municao.add(new Ammo(640-96, 640-96));
			for ( int xx = 0 ; xx < 20 ; xx ++) {
				blocos.add(new Blocks (xx*32, 0));
			}
			
			for ( int xx = 0 ; xx < 20 ; xx ++) {
				blocos.add(new Blocks (xx*32, 640-32));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (0, yy*32 ));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (640-32, yy*32 ));
			}
			
			blocos.add(new Blocks (32, 64));
			blocos.add(new Blocks (32, 128));
			blocos.add(new Blocks (32, 192));
			blocos.add(new Blocks (64, 640-256));
			blocos.add(new Blocks (128, 640-256));
			blocos.add(new Blocks (186, 640-256));
			blocos.add(new Blocks (186, 640-192));
			blocos.add(new Blocks (186, 640-128));
			blocos.add(new Blocks (186, 640-96));
			blocos.add(new Blocks (640-160, 640-256));
			blocos.add(new Blocks (640-160, 640-320));
			blocos.add(new Blocks (640-160, 640-384));
			blocos.add(new Blocks (640-160, 640-432));
			blocos.add(new Blocks (640-96, 640-432));
			blocos.add(new Blocks (640-96, 640-256));
			
		} else if(newWorld.equals("level3.png")) {
			
			for ( int xx = 0 ; xx < 20 ; xx ++) {
				blocos.add(new Blocks (xx*32, 0));
			}
			
			for ( int xx = 0 ; xx < 20 ; xx ++) {
				blocos.add(new Blocks (xx*32, 640-32));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (0, yy*32 ));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (640-32, yy*32 ));
			}
			
			blocos.add(new Blocks(160, 128));
			blocos.add(new Blocks(160, 128-64));
			blocos.add(new Blocks(160-64, 128));
			blocos.add(new Blocks(32, 128));
			blocos.add(new Blocks(640-192, 128));
			blocos.add(new Blocks(640-192, 128-64));
			blocos.add(new Blocks(640-128, 128));
			blocos.add(new Blocks(640-64, 128));
			
			Game.inimigos.add(new Inimigo(370, 32));
			Game.inimigos.add(new Inimigo(370, 96));
			Game.inimigos.add(new Inimigo(302, 32));
			Game.inimigos.add(new Inimigo(370, 166));
			
		} else if(newWorld.equals("level4.png")) {
			Game.inimigos.add(new Inimigo(370, 32));
			Game.boss.add(new Boss(320, 128));
			
			for ( int xx = 0 ; xx < 20 ; xx ++) {
				blocos.add(new Blocks (xx*32, 0));
			}
			
			for ( int xx = 0 ; xx < 20 ; xx ++) {
				blocos.add(new Blocks (xx*32, 640-32));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (0, yy*32 ));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (640-32, yy*32 ));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (122, yy*32 ));
			}
			
			for ( int yy = 0 ; yy < 20 ; yy ++) {
				blocos.add(new Blocks (640-150, yy*32 ));
			}
		}
		
	} 
	
	public static boolean isFree ( int x , int y ) {
		for ( int i = 0 ; i < blocos.size(); i ++ ) {
			Blocks blocoAtual = blocos.get(i);
		
		if ( blocoAtual.intersects(new Rectangle (x , y , 64 , 64 ))) {
			return false  ;
		     }
		 }	
		return true ;
	}
	
	public static void restartGame(String newWorld) {
		Game.inimigos = new ArrayList<Inimigo>();
		Game.municao = new ArrayList<Ammo>();
		Game.boss = new ArrayList<Boss>();
		blocos = new ArrayList<Blocks>();
		new SpriteSheet();
		Game.player  = new Player (280, 608-64) ;
		Game.world = new World (newWorld);
		return;
	}
	
	public void render (Graphics g ) {
		for ( int i = 0 ; i < blocos.size(); i ++ ) {
			blocos.get(i).render(g);
		}
		g.drawImage(SpriteSheet.piso, 32, 32, 576, 576, null);	
	}
}