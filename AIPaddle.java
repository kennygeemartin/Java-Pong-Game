package pongGame;

import java.awt.Color;
import java.awt.Graphics;


public class AIPaddle implements Paddle {
	
	    Ball b1;
		double y , yVel;
		boolean upAccel, downAccel;
		int player , x;
		final double GRAVITY = 0.94;
		
		public AIPaddle(int player, Ball b) {
			b1 = b;
			y = 210;
			yVel = 0;
			if(player == 1) {
				x = 20;		
			}
			else
				x = 760;
		}
		
		public void move() {
			
			y = b1.getY() - 10;
		
			if(y < 0)
				y = 0;
			if(y > 520)
				y = 520;
		}
		public void draw(Graphics g) {
			g.setColor(Color.white);
			g.fillRect(x, (int)y, 20, 80);
		}
		
		
		public int getY() {
			return (int) y;
		}
		
		
}
