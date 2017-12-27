package Tampilan;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SetPassword extends JPanel {
	public String username;
	public JTextField old;
	public JTextField new1;
	public JTextField new2;

	/**
	 * Create the panel.
	 */
	public SetPassword() {
		
		JLabel lblOldPassword = new JLabel("Old Password");
		
		old = new JTextField();
		old.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		
		new1 = new JTextField();
		new1.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		
		new2 = new JTextField();
		new2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConfirmPassword)
						.addComponent(lblOldPassword)
						.addComponent(lblNewPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(new1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(new2, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
						.addComponent(old, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOldPassword)
						.addComponent(old, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(new1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConfirmPassword)
						.addComponent(new2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	public int showDialog(String title) {
	      return JOptionPane.showOptionDialog(null, this, title,
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "OK", "Cancel" }, "OK");
	}

}
