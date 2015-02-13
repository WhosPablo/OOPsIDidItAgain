package com.oopsididitagain.model;

public class GameMap {
	Tile [][] tiles;

	public GameMap(Tile[][] tiles) {
		super();
		this.tiles = tiles;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public Tile getTileAt(int x, int y){
		return tiles[x][y];
	}
	
	public Tile getTileAt(Position pos) {
		return tiles[pos.getX()][pos.getY()];
	}
	
	public boolean checkIfValid(Position pos) {
		if (pos.getX() > tiles.length - 1) return false;
		if (pos.getY() > tiles[0].length - 1) return false;
		Tile tile = tiles[pos.getX()][pos.getY()];
		if (tile.getEntity() != null) return false;
		if (!tile.getTerrain().isMovableOnGround()) return false;
		if (!tile.getTerrain().isMovableInAir()) return false;
		/*
		 * List<Item> items = tile.getItems();
		 * for (Item item: items) {
			if (item.)
		}*/
		return true;
	}
}
