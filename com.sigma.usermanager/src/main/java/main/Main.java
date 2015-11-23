/**
 * 
 */
package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

import javax.swing.JFrame;

import mySender.Sender;

import org.osgi.framework.BundleContext;

import form.PlayerDialog;
import postgresql.DataBase;
import userPlayer.Player;

/**
 * @author NikitaNB
 *
 */
public class Main  {
	private Player player;
	public static Sender snd;
	
	public Main(DataBase db, Sender snd){
		this.snd=snd;
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
