package com.azuryPlays.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.azuryPlays.main.Game;

public class Spawner extends Entity{
	
	private int timer = 60;
	private int curTime = 0;

	public Spawner(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
	}
	
	public void tick() {
		curTime++;
		
		if(curTime == timer) {
			curTime =0;
			Enemy enemy = new Enemy(x, y, Entity.ENTITY_SIZE,Entity.ENTITY_SIZE, Entity.ENEMY1);
			Game.entities.add(enemy);
		}
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
	}

}
