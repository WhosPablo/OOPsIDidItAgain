package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class StatsViewport extends Viewport{
	
	public StatsViewport() {
		super();
		this.setBackground(new Color(100,0,0));
		this.setPreferredSize(new Dimension(600, 200));
	}
	
	public void render(){
		repaint();
	}

}
