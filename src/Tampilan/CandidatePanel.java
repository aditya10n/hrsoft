package Tampilan;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

public class CandidatePanel extends JPanel {
	private JTextField fieldNama;
	private JTextField fieldPhone;
	private JTextField fieldEmail;
	JTextPane alamat;
	JComboBox group;
	JComboBox status;
	JTextArea textPaneExp;
	JTextArea textPaneEdu;
		
	
	/**
	 * Create the panel.
	 */
	public CandidatePanel() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Group", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Status", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Education", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Experience", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		textPaneExp = new JTextArea();
		scrollPane_2.setViewportView(textPaneExp);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		textPaneEdu = new JTextArea();
		scrollPane_1.setViewportView(textPaneEdu);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] {"not Confirmed", "Confirmed"}));
		panel_2.add(status, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		group = new JComboBox();
		group.setModel(new DefaultComboBoxModel(new String[] {"APPLICANT", "INTERVIEW", "HIRED"}));
		panel_1.add(group, BorderLayout.CENTER);
				
		JLabel lblNama = new JLabel("Nama");
		
		JLabel lblPhone = new JLabel("Phone");
		
		fieldNama = new JTextField();
		fieldNama.setColumns(10);
		
		fieldPhone = new JTextField();
		fieldPhone.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		
		fieldEmail = new JTextField();
		fieldEmail.setColumns(10);
		
		JLabel lblAlamat = new JLabel("Alamat");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNama)
						.addComponent(lblPhone)
						.addComponent(lblAlamat)
						.addComponent(lblEmail))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(fieldEmail, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(fieldNama, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
						.addComponent(fieldPhone, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNama)
						.addComponent(fieldNama, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhone)
						.addComponent(fieldPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAlamat)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		alamat = new JTextPane();
		scrollPane.setViewportView(alamat);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
	
	public int showDialog(String title) {
	      return JOptionPane.showOptionDialog(null, this, title,
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "OK", "Cancel" }, "OK");
	}
	
	public void detail(){
		fieldNama.setEditable(false);
		fieldEmail.setEditable(false);
		fieldPhone.setEditable(false);
		alamat.setEditable(false);
		textPaneEdu.setEditable(false);
		textPaneExp.setEditable(false);
	}
	
	public void edit(){
		fieldNama.setEditable(true);
		fieldEmail.setEditable(true);
		fieldPhone.setEditable(true);
		alamat.setEditable(true);
		textPaneEdu.setEditable(true);
		textPaneExp.setEditable(true);
		
	}
	
	public void setNama(String nama){
		this.fieldNama.setText(nama);
	}
	
	public String getNama(){
		return this.fieldNama.getText();
	}
	
	public void setPhone(String phone){
		this.fieldPhone.setText(phone);
	}
	
	public String getPhone(){
		return this.fieldPhone.getText();
	}
	
	public void setEmail(String email){
		this.fieldEmail.setText(email);
	}
	
	public String getEmail(){
		return this.fieldEmail.getText();
	}
	
	public void setGroup(String group){
		int model=0;
		if(group.equals("APPLICANT")){
			model = 0;
		}else if(group.equals("INTERVIEW")){
			model = 1;
		}else if(group.equals("HIRED")){
			model = 2;
		}
		this.group.setSelectedIndex(model);
	}
	
	public String getGroup(){
		return this.group.getItemAt(this.group.getSelectedIndex()).toString();
	}
	
	public void setStatus(String status){
		this.status.setSelectedItem(status);
	}
	
	public String getStatus(){
		return this.status.getItemAt(this.status.getSelectedIndex()).toString();
	}
	
	public void setExp(String exp){
		this.textPaneExp.setText(exp);
	}
	
	public String getExp(){
		return this.textPaneExp.getText();
	}
	
	public void setEdu(String edu){
		this.textPaneEdu.setText(edu);
	}
	
	public String getEdu(){
		return this.textPaneEdu.getText();
	}
	
	public void setAlamat(String alamat){
		this.alamat.setText(alamat);
	}
	
	public String getAlamat(){
		return this.alamat.getText();
	}
}
