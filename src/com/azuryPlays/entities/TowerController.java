package com.azuryPlays.entities;

import java.awt.image.BufferedImage;

import com.azuryPlays.main.Game;
import com.azuryPlays.world.World;

public class TowerController extends Entity{
	
	public boolean isPressed = false;
	public int xtarget, ytarget;

	public TowerController(double x, double y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		
	}
	
	public void tick() {
		if(isPressed) {
			isPressed = false;
			boolean liberado = true;
			//criar torre no mapa
			int xx=  (xtarget/16)*16;
			int yy=  (ytarget/16)*16;
			Player player = new Player(xx, yy, Player.PLAYER_SIZE, Player.PLAYER_SIZE, Entity.PLAYER_SPRITE);
			for(int i=0; i<Game.entities.size(); i++) {
				Entity e = Game.entities.get(i);
				if(e instanceof Player) {
					if(Entity.isColidding(e, player)) {
						liberado = false;
						System.out.print("ja tem uma torre aqui");
					}
				}
			}
			
			if(World.isFree(xx, yy)) {
				liberado = false;
				System.out.print("estrada de monstros");
			}
			
			if(liberado) {
				if(Game.coins >= Player.cost) {
					Game.coins-= Player.cost;
					Game.entities.add(player);
				}
				
			}
			
		}
		
		if(Game.lifes <=0 ) {
			System.exit(1);
		}
	}

}
