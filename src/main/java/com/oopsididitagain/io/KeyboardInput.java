package com.oopsididitagain.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
	int input = KeyCode.SOUTH;

	public int getInput() {
		int temp = input;
		input = 0;
		return temp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KeyCode: " + e.getKeyCode());
		
		int temp = e.getKeyCode() - 96;
		if (temp > 0 && temp <= 9) {
			input = temp;
			return;
		}
		switch (e.getKeyChar()) {
		case 'q': 
			input = KeyCode.NORTH_WEST;
			break;
		case 'w': 
			input = KeyCode.NORTH;
			break;
		case 'e': 
			input = KeyCode.NORTH_EAST;
			break;
		case 'd': 
			input = KeyCode.EAST;
			break;
		case 'c': 
			input = KeyCode.SOUTH_EAST;
			break;
		case 'x': 
			input = KeyCode.SOUTH;
			break;
		case 'z': 
			input = KeyCode.SOUTH_WEST;
			break;
		case 'a': 
			input = KeyCode.WEST;
			break;
		case 'p':
			input = KeyCode.PAUSE;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("KeyCode: RELEASED " + e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("KeyCode: " + e.getKeyCode());
	}
	
	
}
