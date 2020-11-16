package com.azuryPlays.graphics;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.azuryPlays.main.Game;

public class UI {
	
	public static BufferedImage hearts  = Game.spritesheet.getSprite(16, 16, 8, 8);

	public void render(Graphics g) {
		
		//coraçoes de vida
		for(int i=0; i<Game.lifes; i++) {
			g.drawImage(hearts, 20+(i*30), 10, 26,26, null);
		}
		
		//moedas do jogo
		g.setFont(new Font("arial", Font.BOLD, 19));
		g.setColor(Color.white);
		g.drawString("$$  "+ Game.coins, (Game.WIDTH* Game.SCALE) -80, 26);
	}
	
}
