/**
 * 
 */
package form;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;

/**
 * @author NikitaNB
 *
 */
public class CasinoFrame extends JFrame {
	private final JScrollPane scrollPane = new JScrollPane();
	public CasinoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tables");
		setSize(300,300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		getContentPane().setLayout(gridBagLayout);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnConnect = new JButton("Join");
		GridBagConstraints gbc_btnConnect = new GridBagConstraints();
		gbc_btnConnect.insets = new Insets(0, 0, 0, 5);
		gbc_btnConnect.gridx = 2;
		gbc_btnConnect.gridy = 2;
		getContentPane().add(btnConnect, gbc_btnConnect);
		
		JButton btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreate.gridx = 5;
		gbc_btnCreate.gridy = 2;
		getContentPane().add(btnCreate, gbc_btnCreate);
	}

}
