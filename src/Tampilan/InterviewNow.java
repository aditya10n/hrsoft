package Tampilan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Font;

import javax.swing.UIManager;

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import DBConn.Candidate;
import DBConn.Interview;
import Kelas.Kandidat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterviewNow extends JFrame {

	private JPanel contentPane;
	boolean open;
	JTextArea edu;
	JTextArea exp;
	JTextArea address;
	JLabel name;
	JLabel time;
	JComboBox comboBox;
	Interview inter;
	String idSelected;
	String data[];
	JLabel job;
	JLabel group;
	JTextArea note;
	JTextArea desc;
	JTextArea hasil;
	Candidate cand;
	JButton btnFinish;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterviewNow frame = new InterviewNow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterviewNow() {
		cand = new Candidate();
		inter = new Interview();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		group = new JLabel("<group>");
		group.setForeground(new Color(0, 0, 255));
		group.setFont(new Font("Tahoma", Font.PLAIN, 16));
		group.setVisible(false);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"HIRED", "DROP"}));
		
		btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int response = JOptionPane.showConfirmDialog(null, "Set this Result and Set to Group :"+comboBox.getSelectedItem().toString());
				if(response==0){
					finish();
				}
				
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnClose)
					.addPreferredGap(ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
					.addComponent(group)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFinish)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(9)
					.addComponent(btnClose))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFinish)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(group)))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Info Candidate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Result", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		time = new JLabel("<time>");
		time.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(time, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
				.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(8)
					.addComponent(time)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
		);
		
		JLabel lblJob = new JLabel("Job :");
		
		job = new JLabel("<job>");
		
		JLabel lblDescription = new JLabel("Description :");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblNote = new JLabel("Note :");
		
		JScrollPane scrollPane_5 = new JScrollPane();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
						.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_6.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_6.createSequentialGroup()
										.addGap(10)
										.addComponent(job))
									.addComponent(lblJob)
									.addComponent(lblDescription)))
							.addGroup(gl_panel_6.createSequentialGroup()
								.addGap(20)
								.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
							.addGroup(gl_panel_6.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNote))))
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblJob)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(job)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNote)
					.addGap(9)
					.addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
		);
		
		note = new JTextArea();
		note.setEditable(false);
		scrollPane_5.setViewportView(note);
		
		desc = new JTextArea();
		desc.setEditable(false);
		scrollPane_3.setViewportView(desc);
		panel_6.setLayout(gl_panel_6);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_8.add(scrollPane_4, BorderLayout.CENTER);
		
		hasil = new JTextArea();
		scrollPane_4.setViewportView(hasil);
		
		JLabel lblName = new JLabel("Name :");
		
		name = new JLabel("<name>");
		
		JLabel lblAddress = new JLabel("Address :");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblExperience = new JLabel("Experience :");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("Education");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblAddress))
					.addGap(163))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblExperience)
					.addContainerGap(151, Short.MAX_VALUE))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(164, Short.MAX_VALUE))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(20)
					.addComponent(name, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(name)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAddress)
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExperience)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
		);
		
		edu = new JTextArea();
		edu.setEditable(false);
		scrollPane_2.setViewportView(edu);
		
		exp = new JTextArea();
		exp.setEditable(false);
		scrollPane_1.setViewportView(exp);
		
		address = new JTextArea();
		address.setEditable(false);
		scrollPane.setViewportView(address);
		panel_5.setLayout(gl_panel_5);
		panel_4.setLayout(gl_panel_4);
		
	}
	
	public void prepare(String value){
		open = true;
		data = inter.getDetailNow(getIdSelected());
		setName(data[0]);
		setAdd(data[1]);
		setExp(data[2]);
		setEdu(data[3]);
		setJob(data[4]);
		setDesc(data[5]);
		setNote(data[6]);
		setTime("Time : "+data[7]+" to "+data[8]);
		if(value.equals("Detail Interview")){
			setHasil(data[9]);
			hasil.setEditable(false);
			btnFinish.setVisible(false);
			comboBox.setVisible(false);
			group.setText(data[10]);
			group.setVisible(true);
		}else if(value.equals("Edit Interview")){
			setHasil(data[9]);
			hasil.setEditable(true);
			btnFinish.setVisible(true);
			comboBox.setVisible(true);
			comboBox.setSelectedItem(data[10]);
			group.setVisible(false);
		}
		
	}
	
	public void finish(){
		inter.updateHasil(getIdSelected(), getHasil());
		cand.editGroup(getIdSelected(), comboBox.getSelectedItem().toString());
		open = false;
	}
	
	public void close(){
		open = false;
	}
	
	public void setName(String name){
		this.name.setText(name);
	}
	public String getName(){
		return this.name.getText();
	}
	public void setEdu(String edu){
		this.edu.setText(edu);
	}
	public String getEdu(){
		return this.edu.getText();
	}
	public void setExp(String exp){
		this.exp.setText(exp);
	}
	public String getExp(){
		return this.exp.getText();
	}
	public void setAdd(String address){
		this.address.setText(address);
	}
	public String getAdd(){
		return this.address.getText();
	}
	public void setJob(String job){
		this.job.setText(job);
	}
	public String getJob(){
		return job.getText();
	}
	public void setStatus(boolean value){
		this.open = value;
	}
	public boolean getStatus(){
		return this.open;
	}
	public String getIdSelected(){
		return this.idSelected;
	}
	public void setIdSelected(String id){
		this.idSelected=id;
	}
	public void setNote(String note){
		this.note.setText(note);
	}
	public String getNote(){
		return this.note.getText();
	}
	public void setDesc(String desc){
		this.desc.setText(desc);
	}
	public String getDesc(){
		return this.desc.getText();
	}
	public void setHasil(String hasil){
		this.hasil.setText(hasil);
	}
	public String getHasil(){
		return this.hasil.getText();
	}
	public void setTime(String time){
		this.time.setText(time);
	}
	public String getTime(){
		return this.time.getText();
	}
	
}
