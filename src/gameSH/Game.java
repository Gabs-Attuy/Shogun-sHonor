package gameSH;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable , KeyListener 	{

	public static int WIDTH = 640 , HEIGHT = 640 ;  
	public static Player  player ;
	public static World world ;
	public static int level = 1, maxLevel = 4;
	public static Random rand = new Random();
	public static List<Inimigo> inimigos = new ArrayList<Inimigo>();
	public static List<Boss> boss = new ArrayList<Boss>();
	public static List<Ammo> municao = new ArrayList<Ammo>();
	public static List<Arco> arco = new ArrayList<Arco>();
	public InterfaceP InterfaceP;
	public static String gameState = "MENU";
	private boolean showMessageGameOver = true;
	private int framesGameOver = 0;
	private boolean restartGame = false;
	public Menu Menu;
	public EndGame EndGame;
	public Game() {
		InterfaceP = new InterfaceP();
		
		this.addKeyListener(this);
		
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		new SpriteSheet();
		player  = new Player (280, 608-64) ;
		world = new World (newWorld);
		arco.add(new Arco(96, 96));
		Menu = new Menu();
		EndGame = new EndGame();
	}
	
	public static String newWorld = "level1.png";
	
	public void tick() {
		if (gameState == "NORMAL") {
			this.restartGame = false;
		player.tick();
		
		for(int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).tick();
		}
		
		for(int i = 0; i < municao.size(); i++) {
			municao.get(i).tick();
		}
		
		for(int i = 0; i < arco.size(); i++) {
			arco.get(i).tick();
		}
		
		for(int i = 0; i < boss.size(); i++) {
			boss.get(i).tick();
		}
		
		if (inimigos.size() == 0 && level < maxLevel) {
			level++;
			newWorld = "level"+level+".png";
			World.restartGame(newWorld);
		} else if(level == maxLevel && inimigos.size() == 0 && boss.size() == 0) {
				gameState = "END_GAME";
			}
						
		} else if (gameState == "GAME_OVER") {
			this.framesGameOver++;
			if (this.framesGameOver == 30) {
				this.framesGameOver = 0;
				if (this.showMessageGameOver)
					this.showMessageGameOver = false;
					else
						this.showMessageGameOver = true;
				}
			if (restartGame) {
				this.restartGame = false;
				this.gameState = "NORMAL";
				level = 1;
				newWorld = "level1.png";
				World.restartGame(Game.newWorld);
			} 
	} else if (gameState == "MENU") {
		Menu.tick();
	} else if (gameState == "END_GAME") {
		EndGame.tick();
	}
			
}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if ( bs == null ) {
			this.createBufferStrategy(3);
			return ;
		}
		Graphics g = bs.getDrawGraphics();
		
		world.render(g);
		for(int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).render(g);
		}
		for(int i = 0; i < municao.size(); i++) {
			municao.get(i).render(g);
		}
		for(int i = 0; i < arco.size(); i++) {
			arco.get(i).render(g);
		}
		for(int i = 0; i < boss.size(); i++) {
			boss.get(i).render(g);
		}
		player.render(g);
			
		InterfaceP.render(g);
		g.setFont(new Font("arial",Font.BOLD, 17));
		g.setColor(Color.white);
		g.drawString("Vida: " + player.life + "/" + player.maxLife, 46, 28);
		g.drawString("Munição: " + player.ammo, 500, 28);
		if (gameState == "GAME_OVER") {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillRect(0, 0, WIDTH, HEIGHT);
			g.setFont(new Font("arial",Font.BOLD, 28));
			g.setColor(Color.white);
			g.drawString("GAME OVER!", (WIDTH / 2) - 100, (HEIGHT / 2) - 32);
			if (showMessageGameOver)
			g.drawString("<PRESSIONE ENTER PARA REINICIAR>", (WIDTH / 2) - 302, (HEIGHT / 2) + 32);
		} else if (gameState == "MENU") {
			Menu.render(g);
		} else if (gameState == "END_GAME") {
			EndGame.render(g);
		}
		
		bs.show();
	}
	
	public static void main(String[] args) {
		
		Game game = new Game ();
		
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Shogun's Honor");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Sounds.runMusic("res/Musica.wav");

		new Thread(game).start();
	}
	public void run() {
		
		while( true ) {
			
		   tick();
		   render();
		   try {
			Thread.sleep(1000/60);
		} catch (InterruptedException e) {
			  
			e.printStackTrace();
		}
		   
			//System.out.println("");
		}	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			player.right = true ;
			player.dirx = 1;
			player.diry = 0;
		}
		else if  ( e.getKeyCode() == KeyEvent.VK_LEFT ) {
			player.left = true ;
			player.dirx = -1;
			player.diry = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.shoot = true;
		}
		if  ( e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true ;
			player.diry = -1;
			player.dirx = 0;
			
			if (gameState == "MENU") {
				Menu.up = true;
			} else if (gameState == "END_GAME") {
				EndGame.up = true;
			}
		}
		else if ( e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
			player.diry = 1;
			player.dirx = 0;
			
			if (gameState == "MENU") {
				Menu.down = true;
			} else if (gameState == "END_GAME") {
				EndGame.down = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.restartGame = true;
			
			if(gameState == "MENU") {
				Menu.enter = true;
			} else if (gameState == "END_GAME") {
				EndGame.enter = true;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			gameState = "MENU";
			Menu.pause = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false ;
		}
		else if ( e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false ;
		}
		else if ( e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false ;
		}
		else if ( e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}	
	}
}