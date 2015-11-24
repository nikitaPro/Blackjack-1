/**
 * 
 */
package main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
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
	public static DataBase db;
	public static ArrayList<Player> playerList=new ArrayList<Player>();
	
	public Main(){
		Thread runner = new Thread(){
			public void run(){
				PlayerDialog pl = new PlayerDialog(player);
				pl.setVisible(true);

			}
		};
		runner.start();
	}

}
