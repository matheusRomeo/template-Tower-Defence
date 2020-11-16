package com.azuryPlays.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import com.azuryPlays.main.Game;
import com.azuryPlays.world.World;
import com.azuryPlays.world.astar.AStar;
import com.azuryPlays.world.astar.Node;
import com.azuryPlays.world.astar.Vector2;

public class Enemy extends Entity{
	
	public double speed =1;
	
	public float life = 100;
	public float maxLife = 100;
	
	public int reward = 15;
	
	public Enemy(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		path = AStar.findPath(Game.world, new Vector2(World.xINITIAL, World.yINITIAL), new Vector2(World.xFINAL, World.yFINAL));
		
	}
	
	public void tick(){
		depth = 1;
		followPath(path);
		
		if(x >= Game.WIDTH) {
			Game.lifes--;
			Game.entities.remove(this);
			
		}
		
		if(life <=0) {
			Game.entities.remove(this);
			Game.coins += this.reward;
			return;
		}
	
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.red);
		g.fillRect((int)x, (int)(y-2), (int)maxLife/5, 3);
		g.setColor(Color.green);
		g.fillRect((int)x, (int)(y-2), (int)life/5, 3);
	}
	
	
	
	public void followPath(List<Node> path) {
		if(path != null) {
			if(path.size() > 0) {
				Vector2 target = path.get(path.size() - 1).tile;
				/* utilize " else " para movimentos em diagonal */
				if(x < target.x * 16) 
					x+=speed;
				else if(x > target.x * 16)
					x-=speed;
								
				if(y < target.y * 16) 
					y+=speed;
				else if(y > target.y * 16) 
					y-=speed;
								
				if(x == target.x * 16 && y == target.y * 16) 
					path.remove(path.size() - 1);							
			}
		}
	}
}
