package com.oopsididitagain.controller.states;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PlayGameController;
import com.oopsididitagain.gui.AreaViewport;
import com.oopsididitagain.gui.StatsViewport;
import com.oopsididitagain.io.KeyCode;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.GameObject;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.Terrain;
import com.oopsididitagain.model.Tile;

public class PlayGameState extends GameState {

	private static PlayGameState instance;
	private GameMap map;
	private List<GameObject> gameObjects;
	private Entity avatar;
	
	private PlayGameState() {
		// TODO: get model game things
		avatar = new Entity();
		avatar.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/avatar.png")));
		Position p = new Position(0,0);
		avatar.setPosition(p);
//		Tile [][] t = new Tile[60][60];
		Terrain one = Terrain.createTerrain(Terrain.GRASS);
		Terrain two = Terrain.createTerrain(Terrain.MOUNTAIN);
		Terrain three  = Terrain.createTerrain(Terrain.WATER);
//		for(int i = 0; i != 60; ++i){
//			for(int j = 0; j!= 60; ++j){
//				t[i][j] = new Tile(one);
//				t[i][++j] = new Tile(two);
//				t[i][++j] = new Tile(three);
//			}
//		}
		Tile[][] t = {
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(one),new Tile(one),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(two),new Tile(two),new Tile(three),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(three),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				{new Tile(one),new Tile(two),new Tile(three),new Tile(one),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two),new Tile(two)},
				};
		t[0][0].setEntity(avatar);
		
		
		map = new GameMap(t,11,10);
	}
	
	public GameMap getGameMap() {
		return map;
	}
	
	public Entity getAvatar(){
		return avatar;
	}
	
	
	public void moveAvatar(int keyCode) {
		int x = avatar.getPosition().getX();
		int y = avatar.getPosition().getY();
		switch (keyCode) {
			case KeyCode.SOUTH: {
				Position updatedPosition = new Position(y+1, x);
				if (!map.checkIfValid(updatedPosition)) break;
				map.getTileAt(avatar.getPosition()).setEntity(null);
				avatar.setPosition(updatedPosition);
				map.getTileAt(updatedPosition).setEntity(avatar);
			}
		}
		
	}
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new PlayGameState();
		}
		return instance;
	}
	
	@Override
	public Controller getController() {
		return PlayGameController.getInstance();
	}
	
}
