package com.oopsididitagain.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JPanel;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;


public class AreaViewport extends Viewport{
	private GameMap map;
	private Entity avatar;
	
	//private areaPanel;
	public static final int TILE_SIZE = 20;//in pixels
	
	public AreaViewport(GameMap map, Entity avatar) {
		super();
		this.map = map;
		this.avatar = avatar;
		this.setBackground(new Color(100,0,0));
		this.setPreferredSize(new Dimension(600, 600));
		//JPanel area = new 
	}
	
	
	
	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}

	public Entity getAvatar() {
		return avatar;
	}

	public void setAvatar(Entity avatar) {
		this.avatar = avatar;
	}

	public int getLeft(){
		int x = avatar.getPosition().getX();
		int w = map.getWidth();
		if(x<5){
			return 0;
		}else if(x > (w - 5)){
			return w -10;
		}else{
			return x-5;
		}
		
	}
	public int getRight(){
		int x = avatar.getPosition().getX();
		int w = map.getWidth();
		if(x<5){
			return 10;
		}else if(x > (w - 5)){
			return w;
		}else{
			return x+5;
		}
	}	
	public int getTop(){
		int y = avatar.getPosition().getY();
		int h = map.getHeight();
		if(y<5){
			return 0;
		}else if(y > (h - 5)){
			return h - 9;
		}else{
			return y-4;
		}
		
	}
	public int getBottom(){
		int y = avatar.getPosition().getY();
		int h = map.getHeight();
		if(y<5){
			return 9;
		}else if(y > (h - 5)){
			return h;
		}else{
			return y+5;
		}	
	}
	private void showImage(Graphics g) {
		int width;
		int height;
		int top = getTop();
		int bottom = getBottom();
		int left = getLeft();
		int right = getRight();
		int widthpos = 0;
		int heightpos = 0;
		Image img;
		int h = 60;
		int w = 60;
		for(int i = top; i != bottom; ++i){
			for(int j = left; j != right; ++j){
				img = map.getTileAt(i,j).getTerrain().getImage();
				List<Image> images = map.getTileAt(i, j).getImages(); 
				for (int k = 0; k < images.size(); ++k) {
					Image image = images.get(k);
					if (k != 0)
						g.drawImage(image, widthpos+5, heightpos+5, h-10, w-10, null);
					else
						g.drawImage(image, widthpos, heightpos, h, w, null);
				}
				//repaint();
				widthpos += w;
			}
			widthpos = 0;
			heightpos += h;
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("paint component");
		super.paintComponent(g);
		showImage(g);
	}
	public void render(){
		repaint();
		revalidate();
	}
}
