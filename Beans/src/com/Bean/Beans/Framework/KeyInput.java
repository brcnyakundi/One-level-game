package com.Bean.Beans.Framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import com.Bean.Beans.Window.Handler;

public class KeyInput extends KeyAdapter { //keyadaptor receves key events
		Handler handler;
		
		public KeyInput (Handler handler) { //pass handler object from our game class
			this.handler = handler;
		}
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode(); //gets keycode our comp stores
			
			
			//looping thru our entire list
			for (int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i); //getting the object at an index
				if (tempObject.getId() == ObjectId.Player) { //making sure we have an object of id player -- or aplayer object
					if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) tempObject.setVelocityX(5); //moves by 5
					if (key == KeyEvent.VK_A|| key == KeyEvent.VK_LEFT) tempObject.setVelocityX(-5);
					if (key == KeyEvent.VK_SPACE && !tempObject.isJumping()){//must state falling back to true -- in pl;ayer  class
					tempObject.setJumping(true);
					tempObject.setVelocityY(-10);
					}
					}
			} 
			if (key == KeyEvent.VK_ESCAPE) { //instead of using ascii for escape we use .vk escape which is enum for ascii code number itself 
				System.exit(23);
			}
//			if (key == KeyEvent.VK_ENTER) {
//				System.exit(1);
//			}
			
		}
		
		public void keyReleased(KeyEvent e) {
			
		}
}