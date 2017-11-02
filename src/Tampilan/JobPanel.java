package Tampilan;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

public class JobPanel extends JPanel {
	private JTextField textName;
	private JTextField textLoc;
	private JTextArea textDesc;
	private String id;

	/**
	 * Create the panel.
	 */
	public JobPanel(String title) {
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), title, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 22, 33, 15);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 49, 53, 15);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 75, 69, 15);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textName = new JTextField();
		textName.setBounds(110, 21, 128, 19);
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textName.setColumns(10);
		
		textLoc = new JTextField();
		textLoc.setBounds(110, 48, 128, 19);
		textLoc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		textLoc.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 72, 290, 187);
		
		textDesc = new JTextArea();
		scrollPane.setViewportView(textDesc);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		panel.add(scrollPane);
		panel.add(lblName);
		panel.add(textName);
		panel.add(lblLocation);
		panel.add(lblDescription);
		panel.add(textLoc);
		setLayout(groupLayout);

	}
	public int showDialog(String title) {
	      return JOptionPane.showOptionDialog(null, this, title,
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "OK", "Cancel" }, "OK");
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void setName(String name){
		this.textName.setText(name);
	}
	
	public void setLoc(String loc){
		this.textLoc.setText(loc);
	}
	
	public void setDesc(String desc){
		this.textDesc.setText(desc);
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getName(){
		return this.textName.getText().toString();
	}
	
	public String getLoc(){
		return this.textLoc.getText().toString();
	}
	
	public String getDesc(){
		return this.textDesc.getText().toString();
	}
}
