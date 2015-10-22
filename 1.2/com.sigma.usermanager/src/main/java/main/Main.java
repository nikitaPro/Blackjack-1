/**
 * 
 */
package main;

import java.util.Scanner;

import org.osgi.framework.BundleContext;

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
				PlayerForm pl = new PlayerForm(false, player);
				pl.setVisible(true);
			}
		};
		runner.start();
	}

}
