package pongGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener  {

	final static int WIDTH  =800; final static int HEIGHT = 600;
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	boolean gameStarted;
	int numberOfGames = 1;
	Graphics gfx;
	Image img;
	
	
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		
		gameStarted = false;
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2, b1);
		img = createImage(WIDTH,HEIGHT);
		gfx = img.getGraphics();
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void paint(Graphics g) {

		if(!gameStarted) {
			gfx.setColor(Color.WHITE);
			gfx.drawString("Tennis Game", 440, 250);
			gfx.drawString("Press Enter To Begin...", 410, 230);

		}

		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(b1.getX()< -10 || b1.getX()>810) {
			gfx.setColor(Color.red);
			gfx.drawString("Game Over", 350, 250);
			
		}
		else {
			p1.draw(gfx);
			p2.draw(gfx);
			b1.draw(gfx);
			
		}
			
		g.drawImage(img, 0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	
	public void run() {
		for(;;) {
			
			    if(gameStarted) {
			    b1.checkPaddleCollision(p1, p2);
				
				p1.move();
				b1.move();
				p2.move();
				
				
			    
			}
			    
			    
			repaint();
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
		
		else if(e.getKeyCode()== KeyEvent.VK_ENTER) {
			gameStarted = true;
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
		
	}

	
}
