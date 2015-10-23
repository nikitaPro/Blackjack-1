/**
 * 
 */
package form;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JTabbedPane;


import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import user_player.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField logPassField;
	private JTextField regEmailField;
	private JTextField regPassField;
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
		/*gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};*/
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
		
		logPassField = new JTextField();
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
				System.out.println(logEmailField.getText());
				if (logEmailField.getText().length() > 0 && logPassField.getText().length() > 0) {
					player.login(logEmailField.getText(), logPassField.getText());
					
				} else
					JOptionPane.showMessageDialog(null, "One or more field is empty!", "Warning",
							JOptionPane.WARNING_MESSAGE);
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
		/*gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};*/
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPleasEnterNext = new JLabel("Please enter next data: ");
		GridBagConstraints gbc_lblPleasEnterNext = new GridBagConstraints();
		gbc_lblPleasEnterNext.insets = new Insets(30, 0, 5, 5);
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
		
		regPassField = new JTextField();
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
			public void actionPerformed(ActionEvent e) {
				//System.out.println(textEmail.get);
				if ((regEmailField.getText().length() > 0) && (regPassField.getText().length() > 0)) {
					System.out.println(regEmailField.getText()+"  "+regPassField.getText());
					String nick;
					if (regNickField.getText().length() == 0)
						nick = "Player1"; // Generate nick for player
					else
						nick = regNickField.getText();
					System.out.println(nick);
					/*
					 * Check the entered data
					 */
					switch (player.registr(regEmailField.getText(), regPassField.getText(), nick)) {
					case -1:
						JOptionPane.showMessageDialog(null, "E-mail ins not correct!", "Warning",
								JOptionPane.WARNING_MESSAGE);
						break;
					case -2:
						JOptionPane.showMessageDialog(null, "Password must have more than 5 symbol!", "Warning",
								JOptionPane.WARNING_MESSAGE);
						break;
					case 0:
						JOptionPane.showMessageDialog(null, "Registration success!", "Congratulations",
								JOptionPane.PLAIN_MESSAGE);
						break;
						//PlayerForm.this.setVisible(false);
						//PlayerForm.this.dispose();

					}

				} else{

					System.out.println(regEmailField.getText()+"  - "+regPassField.getText());
					JOptionPane.showMessageDialog(null, "One or more field is empty!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnRegistreate = new GridBagConstraints();
		gbc_btnRegistreate.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistreate.gridx = 2;
		gbc_btnRegistreate.gridy = 7;
		panel_1.add(btnRegistreate, gbc_btnRegistreate);
	}

}
