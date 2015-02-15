package com.oopsididitagain.model;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Decal {
	public final static Decal HEART_DECAL = new Decal("/heart_decal.png");
	Image img;
	
	public Decal(Image img) {
		this.img = img;
	}
	
	public Decal(String imageLink) { 
		// as in new Decal("/heart.png");
		img = Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource(imageLink));
		
		// JLabel picLabel = new JLabel(new ImageIcon(img));
		// JOptionPane.showMessageDialog(null, picLabel, "About", JOptionPane.PLAIN_MESSAGE, null);
	}
	
	public Image getImage() {
		return img;
	}
	
	public void setImage(Image img) {
		this.img = img;
	}
}
