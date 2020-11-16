package com.azuryPlays.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.azuryPlays.main.Game;
import com.azuryPlays.world.World;

public class Player extends Entity{
	
	public static final int PLAYER_SIZE = 16;	
	public double speed;
	
	public static int cost = 50;
	public int damage = 1;
	
	public int xtarget, ytarget;
	public boolean isAtacking = false;
	
	public Player(int x, int y, int width, int height,BufferedImage sprite) {
		super(x, y, width, height,sprite);		

	}
	
	public void tick(){
		depth = 0;
		Enemy enemy = null;
		for(int i=0; i<Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Enemy) {
				int xEnemy = e.getX();
				int yEnemy = e.getY();
				if(Entity.calculateDistance(this.getX(), this.getY(), xEnemy, yEnemy) < 40) {
					enemy = (Enemy)e;
				}
			}
		}
		if(enemy != null) {
			isAtacking = true;
			xtarget = enemy.getX();
			ytarget = enemy.getY();
			enemy.life -= this.damage;
		}else {
			isAtacking = false;
		}
		
	}
	
	public void render(Graphics g) {
		super.render(g);
		
		if(isAtacking) {
			g.setColor(Color.yellow);
			g.drawLine((int)x+8, (int)y, xtarget+8, ytarget+8);
		}
	}
	

	



}
