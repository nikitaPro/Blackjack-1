/**
 * 
 */
package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

import org.osgi.framework.BundleContext;

import form.PlayerDialog;
import form.PlayerForm;
import postgresql.DataBase;
import user_player.Player;

/**
 * @author NikitaNB
 *
 */
public class Main  {
	private Player player;
	
	public Main(DataBase db){

		this.player=new Player(db);
		Thread runner = new Thread(){
			public void run(){
				PlayerDialog pl = new PlayerDialog(player);
				pl.setVisible(true);

			}
		};
		runner.start();
	}

}
