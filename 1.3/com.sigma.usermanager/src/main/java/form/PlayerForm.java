package form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user_player.Player;

public class PlayerForm extends JFrame {

	private Player player= null;
	private JTextField textEmail = null;
	private JTextField textPass= null;
	private JTextField textNick= null;
	private JButton bRegister=null;
	private JButton bLogin=null;
	private JButton bRegForm=null;
	private JButton bLogForm = null;
	private JPanel regPanel=null;

	/**
	 * 
	 * @param formType:
	 *            register form - true; login form - false
	 * @param player
	 *            - current game player, that want login/register
	 */

	public PlayerForm(boolean formType, Player player) {
		this.setSize(260, 290);
		this.player = player;
		if (formType == true) {
			initRegister();
		} else {
			initLogin();
		}

	}

	/**
	 * login form user interface
	 */
	private void initLogin() {
		
		this.setTitle("Login");
		regPanel = new JPanel();
		this.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Enter E-mail");
		lblNewLabel.setBounds(10, 11, 77, 19);
		regPanel.add(lblNewLabel);
		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setBounds(10, 60, 77, 19);
		regPanel.add(lblEnterPassword);
		textEmail = new JTextField();
		textEmail.setBounds(10, 30, 130, 20);
		textEmail.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(textEmail.getText()+"");
			}

			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("key "+e.getKeyChar());
				
			}
			
		});
		this.getContentPane().add(textEmail);
		//textEmail.setColumns(10);
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBounds(10, 79, 130, 20);
		this.getContentPane().add(textPass);
		bLogin = new JButton("Go!");
		bLogin.setBounds(129, 123, 101, 23);
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(textEmail.getText());
				if (textEmail.getText().length() > 0 && textPass.getText().length() > 0) {
					player.login(textEmail.getText(), textPass.getText());
					PlayerForm.this.setVisible(false);
					PlayerForm.this.dispose();
				} else
					JOptionPane.showMessageDialog(null, "One or more field is empty!", "Warning",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		this.getContentPane().add(bLogin);
		bRegForm = new JButton("Register me");
		bRegForm.addActionListener(new ActionListener() {
/*
 * At Log In form user press "Register me" button 
 * 
 */
			public void actionPerformed(ActionEvent arg0) {
				//PlayerForm.this.dispose();
				//PlayerForm pl = new PlayerForm(true, player);
				initRegister();
				//pl.setVisible(true);
				
				
			}
		});

		bRegForm.setBounds(10, 123, 101, 23);
		this.getContentPane().add(bRegForm);

	}

	/**
	 * login form user interface
	 */
	private void initRegister() {
		this.setTitle("Register");
		this.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Enter E-mail");
		lblNewLabel.setBounds(10, 11, 77, 19);
		this.getContentPane().add(lblNewLabel);
		JLabel lblEnterPassword = new JLabel("Enter password");
		lblEnterPassword.setBounds(10, 60, 77, 19);
		this.getContentPane().add(lblEnterPassword);
		textEmail = new JTextField();
		//textEmail.setText("hren'");
		textEmail.setBounds(10, 30, 146, 20);
		this.getContentPane().add(textEmail);
		//textEmail.setColumns(10);
		textPass = new JTextField();
		//textPass.setColumns(10);
		textPass.setBounds(10, 79, 146, 20);
		this.getContentPane().add(textPass);
		bRegister = new JButton("Registration");

		bRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//System.out.println(textEmail.get);
				if ((textEmail.getText().length() > 0) && (textPass.getText().length() > 0)) {
					System.out.println(textEmail.getText().length()+"  "+textPass.getText().length());
					String nick;
					if (textNick.getText().length() == 0)
						nick = "Player1"; // Generate nick for player
					else
						nick = textNick.getText();
					/*
					 * Check the entered data
					 */
					switch (player.registr(textEmail.getText(), textPass.getText(), nick)) {
					case -1:
						JOptionPane.showMessageDialog(null, "E-mail ins not correct!", "Warning",
								JOptionPane.WARNING_MESSAGE);
					case -2:
						JOptionPane.showMessageDialog(null, "Password must have more than 5 symbol!", "Warning",
								JOptionPane.WARNING_MESSAGE);
					case 0:
						JOptionPane.showMessageDialog(null, "Registration success!", "Congratulations",
								JOptionPane.PLAIN_MESSAGE);
						PlayerForm.this.setVisible(false);
						PlayerForm.this.dispose();

					}

				} else{

					System.out.println(textEmail.getText()+"  "+textPass.getText());
					JOptionPane.showMessageDialog(null, "One or more field is empty!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		bRegister.setBounds(129, 213, 101, 23);
		this.getContentPane().add(bRegister);
		JLabel lblEnterNick = new JLabel("Enter nick (not necessary)");
		lblEnterNick.setBounds(10, 133, 136, 19);
		this.getContentPane().add(lblEnterNick);
		textNick = new JTextField();
		//textNick.setColumns(10);
		textNick.setBounds(10, 158, 146, 20);
		this.getContentPane().add(textNick);
/*
 * At register form user press "Log In" button
 */
		bLogForm = new JButton("Log In");
		bLogForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PlayerForm.this.dispose();
				//PlayerForm pl = new PlayerForm(false, player);
				initLogin();
				//pl.setVisible(true);

			
			}
		});
		bLogForm.setBounds(10, 213, 109, 23);
		this.getContentPane().add(bLogForm);

	}
}
