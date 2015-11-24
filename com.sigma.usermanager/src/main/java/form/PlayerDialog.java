/**
 * 
 */
package form;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import main.Main;
import userPlayer.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * @author NikitaNB
 *
 */
public class PlayerDialog extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.nonvisual location=589,134
	 */
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField logEmailField;
	private JPasswordField logPassField;
	private JTextField regEmailField;
	private JPasswordField regPassField;
	private JTextField regNickField;
	private Player player;
	
	public PlayerDialog(Player pl) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension scrSize=tk.getScreenSize();
		setLocation(scrSize.width/3, scrSize.height/3);
		this.setSize(480, 290);
		this.player = pl;
		setTitle("Welcome!");
		this.setContentPane(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Login", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		JLabel lblEmail = new JLabel("E-mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 2;
		panel.add(lblEmail, gbc_lblEmail);
		
		logEmailField = new JTextField();
		GridBagConstraints gbc_logEmailField = new GridBagConstraints();
		gbc_logEmailField.insets = new Insets(0, 0, 5, 0);
		gbc_logEmailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_logEmailField.gridx = 4;
		gbc_logEmailField.gridy = 2;
		gbc_logEmailField.ipadx = 100;
		panel.add(logEmailField, gbc_logEmailField);

		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(20, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 4;
		panel.add(lblPassword, gbc_lblPassword);
		
		logPassField = new JPasswordField();
		GridBagConstraints gbc_logPassField = new GridBagConstraints();
		gbc_logPassField.insets = new Insets(20, 0, 5, 0);
		gbc_logPassField.fill = GridBagConstraints.HORIZONTAL;
		gbc_logPassField.gridx = 4;
		gbc_logPassField.gridy = 4;
		gbc_logPassField.ipadx = 100;
		panel.add(logPassField, gbc_logPassField);

		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		GridBagConstraints bLogin = new GridBagConstraints();
		bLogin.insets = new Insets(10, 0, 0, 5);
		bLogin.gridx = 2;
		bLogin.gridy = 6;
		panel.add(btnLogin, bLogin);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Registration", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPleasEnterNext = new JLabel("Please enter next data: ");
		GridBagConstraints gbc_lblPleasEnterNext = new GridBagConstraints();
		gbc_lblPleasEnterNext.insets = new Insets(20, 0, 5, 5);
		gbc_lblPleasEnterNext.gridx = 2;
		gbc_lblPleasEnterNext.gridy = 1;
		panel_1.add(lblPleasEnterNext, gbc_lblPleasEnterNext);
		
		JLabel lblNewLabel = new JLabel("*E-mail:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		regEmailField = new JTextField();
		GridBagConstraints gbc_regEmailField = new GridBagConstraints();
		gbc_regEmailField.insets = new Insets(0, 0, 5, 0);
		gbc_regEmailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regEmailField.gridx = 3;
		gbc_regEmailField.gridy = 2;
		gbc_regEmailField.ipadx = 100;
		panel_1.add(regEmailField, gbc_regEmailField);
		
		JLabel lblPassword_1 = new JLabel("*Password:");
		GridBagConstraints gbc_lblPassword_1 = new GridBagConstraints();
		gbc_lblPassword_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_1.gridx = 2;
		gbc_lblPassword_1.gridy = 3;
		panel_1.add(lblPassword_1, gbc_lblPassword_1);
		
		regPassField = new JPasswordField();
		GridBagConstraints gbc_regPassField = new GridBagConstraints();
		gbc_regPassField.insets = new Insets(0, 0, 5, 0);
		gbc_regPassField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regPassField.gridx = 3;
		gbc_regPassField.gridy = 3;
		gbc_regPassField.ipadx = 100;
		panel_1.add(regPassField, gbc_regPassField);
		
		JLabel lblNickName = new JLabel("Nick name:");
		GridBagConstraints gbc_lblNickName = new GridBagConstraints();
		gbc_lblNickName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickName.gridx = 2;
		gbc_lblNickName.gridy = 4;
		panel_1.add(lblNickName, gbc_lblNickName);
		
		regNickField = new JTextField();
		GridBagConstraints gbc_regNickField = new GridBagConstraints();
		gbc_regNickField.insets = new Insets(0, 0, 5, 0);
		gbc_regNickField.fill = GridBagConstraints.HORIZONTAL;
		gbc_regNickField.gridx = 3;
		gbc_regNickField.gridy = 4;
		gbc_regNickField.ipadx = 100;
		panel_1.add(regNickField, gbc_regNickField);
		
		JLabel lblNoteFieldsMarked = new JLabel("Note: Fields marked * are mandatory");
		GridBagConstraints gbc_lblNoteFieldsMarked = new GridBagConstraints();
		gbc_lblNoteFieldsMarked.gridwidth = 2;
		gbc_lblNoteFieldsMarked.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoteFieldsMarked.gridx = 2;
		gbc_lblNoteFieldsMarked.gridy = 5;
		panel_1.add(lblNoteFieldsMarked, gbc_lblNoteFieldsMarked);
		
		JButton btnRegistreate = new JButton("Register me!");
		btnRegistreate.addActionListener(new ActionListener() {
			/**
			 * @Override
			 */
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		GridBagConstraints gbc_btnRegistreate = new GridBagConstraints();
		gbc_btnRegistreate.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistreate.gridx = 2;
		gbc_btnRegistreate.gridy = 7;
		panel_1.add(btnRegistreate, gbc_btnRegistreate);
	}
	/**
	 * Action method for registration
	 * */
	private void register(){
		if ((regEmailField.getText().length() > 0) && (regPassField.getPassword().length > 0)) {
			//System.out.println(regEmailField.getText()+"  "+regPassField.getText());
			//System.out.println(nick);
			/*
			 * Check the entered data
			 */
			String ERR = "Error"; 
			switch (Player.registr(regEmailField.getText(), regPassField.getPassword(), regNickField.getText())) {
			case -1:
				JOptionPane.showMessageDialog(null, "E-mail isn't correct!", ERR,
						JOptionPane.ERROR_MESSAGE);
				break;
			case -2:
				JOptionPane.showMessageDialog(null, "Password must have more than 5 symbol!", ERR,
						JOptionPane.ERROR_MESSAGE);
				break;
			case -3:
				JOptionPane.showMessageDialog(null, "E-mail already exist", ERR,
						JOptionPane.ERROR_MESSAGE);
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Registration success!", "Congratulations",
						JOptionPane.PLAIN_MESSAGE);
				regEmailField.setText(null);
				regNickField.setText(null);
				regPassField.setText(null);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Sorry", "UnnownError",
						JOptionPane.PLAIN_MESSAGE);
			}
		} else{
			System.out.println(regEmailField.getText()+"  - "+Arrays.toString(regPassField.getPassword()));
			JOptionPane.showMessageDialog(null, "One or more field is empty!", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * Action method for authorization
	 * */
	private void login(){
		if (logEmailField.getText().length() > 0 && logPassField.getPassword().length > 0) {
			try{
				Player player =Player.login(logEmailField.getText(),  logPassField.getPassword());
				logPassField.setText("");
				Main.playerList.add(player);
				JOptionPane.showMessageDialog(this, "Welcome, "+player.getNick(), "Success!",
						JOptionPane.PLAIN_MESSAGE);
				player.openTables();
			} catch(java.lang.SecurityException e3) {
				e3.printStackTrace();
				JOptionPane.showMessageDialog(null, "Invalid password or E-mail!", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		} else
			JOptionPane.showMessageDialog(null, "One or more field is empty!", "Warning",
					JOptionPane.WARNING_MESSAGE);
	}
}
