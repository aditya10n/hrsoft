package Tampilan;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import DBConn.Candidate;
import Kelas.Interview;
import Kelas.Kandidat;

import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Character.Subset;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SpinnerModel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobCandPanel extends JPanel {
	private JTable table;
	private DBConn.Candidate cand;
	private JPanel panel_5;
	private JButton btnSetInter;
	private String id;
	JPanel panel_3;
	
	private JLabel label_2;
	private JLabel label_1;
	private JLabel label;
	private JLabel labelName;
	private JLabel labelPhone;
	private JLabel labelEmail;
	private JTextPane alamat;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JSpinner startSpinner;
	private JSpinner toSpinner_1;
	JLabel valueWith;
	JLabel valueTo;
	JLabel valueStart;
	JTextArea valueLoc;
	JTextArea valueDesc;
	JLabel valueDate;
	
	Kelas.Kandidat kand;
	Kelas.Interview inter;
	
	JSpinner.DateEditor de, deTo;
	
	private String[] listId;
	String start;
	String to;
	DBConn.Interview in;
	
	
	/**
	 * Create the panel.
	 */
	public JobCandPanel(String title, String idJob) {
		id=idJob;
		setLayout(new BorderLayout(0, 0));
		
		in = new DBConn.Interview();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new CompoundBorder(), null));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel, BorderLayout.NORTH);
		
		JLabel lblNamejob = new JLabel(title.substring(0, title.length()-11));
		lblNamejob.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblHired = new JLabel("HIRED");
		
		JLabel lblInterview = new JLabel("INTERVIEW");
		
		JLabel lblApplicant = new JLabel("APPLICANT");
		
		label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		label_1 = new JLabel("0");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		label_2 = new JLabel("0");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNamejob)
					.addPreferredGap(ComponentPlacement.RELATED, 493, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblApplicant, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblInterview, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblHired, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(11, Short.MAX_VALUE)
					.addComponent(lblNamejob)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHired)
						.addComponent(lblInterview)
						.addComponent(lblApplicant))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBorder(new CompoundBorder());
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		labelName = new JLabel("<Name>");
		labelName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		labelEmail = new JLabel("<Email>");
		labelEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		labelPhone = new JLabel("<Phone>");
		labelPhone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Set Interview", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		//panel_5.setVisible(false);
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 0, 0));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"APPLICANT", "INTERVIEW", "HIRED", "DROP"}));
		comboBox.setSelectedIndex(1);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!table.getValueAt(table.getSelectedRow(), 1).equals(comboBox.getSelectedItem().toString())){
					
					if(comboBox.getSelectedItem().toString().equals("INTERVIEW")){
						btnSetInter.setEnabled(true);
					}else if(comboBox.getSelectedItem().toString().equals("HIRED")){
						btnSetInter.setEnabled(false);
					}else{
						if(table.getValueAt(table.getSelectedRow(), 1).toString().equals("INTERVIEW")||
							table.getValueAt(table.getSelectedRow(), 1).toString().equals("HIRED")){
							if(comboBox.getSelectedItem().toString().equals("INTERVIEW")||
								comboBox.getSelectedItem().toString().equals("HIRED")){
								
							}else{
								int result = JOptionPane.showConfirmDialog(null, 
										"Interview Data : "+table.getValueAt(table.getSelectedRow(), 0)
										+" will be deleted! Are you sure ?");
								if(result == 0){
									in.delete(listId[table.getSelectedRow()]);
									btnSetInter.setEnabled(false);
								}else{
									comboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 1));
									btnSetInter.setEnabled(true);
								}
							}
						}
						
					}
					
					cand.editGroup(listId[table.getSelectedRow()], comboBox.getSelectedItem().toString());
					table.setValueAt(comboBox.getSelectedItem(), table.getSelectedRow(), 1);
					comboBox_1.setSelectedItem("not Confirmed");
					setSumGroup(id);
					setDetail(listId[table.getSelectedRow()]);
					
					
				}
				
			}
		});
		
		JButton btnDeleteCandidate = new JButton("Delete Candidate");
		btnDeleteCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Delete Candidate :"+table.getValueAt( table.getSelectedRow(),0)+"?");
				if(result == 0){
					cand.deleteCandidate(listId[table.getSelectedRow()]);
					
				}
				prepare(table, id);
			}
		});
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"not Confirmed", "Confirmed"}));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblEmail)
								.addComponent(lblPhone)
								.addComponent(lblAddress))
							.addGap(41)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(labelName)
								.addComponent(labelEmail)
								.addComponent(labelPhone)
								.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeleteCandidate, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName)
								.addComponent(labelName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(labelEmail))
							.addGap(6)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(labelPhone)
								.addComponent(lblPhone)))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(5)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(btnDeleteCandidate))
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		alamat = new JTextPane();
		scrollPane_3.setViewportView(alamat);
		alamat.setEditable(false);
		alamat.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		comboBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!table.getValueAt(table.getSelectedRow(), 2).equals(comboBox_1.getSelectedItem().toString())){
					cand.editStatus(listId[table.getSelectedRow()], comboBox_1.getSelectedItem().toString());
					table.setValueAt(comboBox_1.getSelectedItem(), table.getSelectedRow(), 2);
				}
				
			}
		});
		
		btnSetInter = new JButton("Set Interview");
		btnSetInter.setEnabled(false);
		btnSetInter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openSetInterview();
			}
			
		});
		btnSetInter.setVisible(false);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		valueDate = new JLabel("<Date>");
		valueDate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblStart = new JLabel("Start");
		lblStart.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		valueStart = new JLabel("<Start>");
		
		valueTo = new JLabel("<to>");
		
		JLabel lblWith = new JLabel("With");
		lblWith.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		valueWith = new JLabel("<With>");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Location", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Note", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDate)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(10)
									.addComponent(valueDate)))
							.addPreferredGap(ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
							.addComponent(btnSetInter, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTime)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStart)
										.addComponent(lblTo))
									.addGap(18)
									.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
										.addComponent(valueTo)
										.addComponent(valueStart))))
							.addContainerGap(336, Short.MAX_VALUE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(10)
									.addComponent(valueWith))
								.addComponent(lblWith))
							.addContainerGap(380, Short.MAX_VALUE))))
				.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(lblDate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valueDate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTime)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStart)
						.addComponent(valueStart))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(valueTo)
						.addComponent(lblTo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblWith)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(valueWith)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(btnSetInter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
		);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_7.add(scrollPane_2, BorderLayout.CENTER);
		
		valueDesc = new JTextArea();
		valueDesc.setEditable(false);
		scrollPane_2.setViewportView(valueDesc);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1, BorderLayout.CENTER);
		
		valueLoc = new JTextArea();
		valueLoc.setEditable(false);
		scrollPane_1.setViewportView(valueLoc);
		panel_5.setLayout(gl_panel_5);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"NAME", "GROUP", "STATUS"
			}
		));
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {}@Override
			public void mousePressed(MouseEvent arg0) {}@Override
			public void mouseExited(MouseEvent arg0) {}@Override
			public void mouseEntered(MouseEvent arg0) {}@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.isColumnSelected(table.getSelectedColumn())){
					setDetail(listId[table.getSelectedRow()]);
					btnSetInter.setVisible(true);
					panel_3.setVisible(true);
					
					if(table.getValueAt(table.getSelectedRow(), 1).toString().equals("INTERVIEW")){
						btnSetInter.setEnabled(true);
					}else{
						btnSetInter.setEnabled(false);
					}
				}
				
			}
		});
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
					.addGap(0))
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
					.addGap(0))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
					.addGap(0))
		);
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(gl_panel_2);
		
		prepare(table, idJob);
		
		
	}
	
	
	public void setSumGroup(String id){
		String[] sumGrup = cand.getSumGroup(id);
		label_2.setText(sumGrup[0]);
		label_1.setText(sumGrup[1]);
		label.setText(sumGrup[2]);
	}
	
	public void prepare(JTable tabel, String id){
		cand = new Candidate();
		listId = cand.listId(id);
		
		setTable(tabel, id);
		setSumGroup(id);
		
		try {
			for (int i=0;i<listId.length;i++){
				System.out.print(listId[i]+", ");
			}
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(null, "No Candidate(s)");
		}
		
		
	}
	
	public void setDetail(String id){
		String[] detail = cand.getDetail(id);
		
		kand = new Kelas.Kandidat();
		inter = new Kelas.Interview();
		
		kand.setNama(detail[0]);
		kand.setEmail(detail[1]);
		kand.setPhone(detail[2]);
		kand.setAlamat(detail[3]);
		kand.setGroup(detail[4]);
		kand.setStatus(detail[5]);
		
		inter.setTanggal(in.getTglIndo(detail[6]));
		System.out.println(inter.getTanggal());
		inter.setJam_mulai(detail[7]);
		inter.setJam_selesai(detail[8]);
		inter.setDengan(detail[9]);
		inter.setLokasi(detail[10]);
		inter.setDeskripsi(detail[11]);
		
		labelName.setText(kand.getNama());
		labelEmail.setText(kand.getEmail());
		labelPhone.setText(kand.getPhone());
		alamat.setText(kand.getAlamat());
		
		comboBox.setSelectedItem(kand.getGroup());
		comboBox_1.setSelectedItem(kand.getStatus());
		valueDate.setText(inter.getTanggal());
		
		try {
			valueStart.setText(inter.getJam_mulai().substring(0,5));
			valueTo.setText(inter.getJam_selesai().substring(0,5));
		} catch (Exception e) {
			valueStart.setText("<Start>");
			valueTo.setText("<to>");
		}
		
		try {
			valueWith.setText(inter.getDengan());
		} catch (Exception e) {
			valueWith.setText("");
		}
		
		try {
			valueLoc.setText(inter.getLokasi());
		} catch (Exception e) {
			valueLoc.setText("");
		}
		
		try {
			valueDesc.setText(inter.getDeskripsi());
		} catch (Exception e) {
			valueDesc.setText("");
		}
		
		
	}
	
	public int showDialog(String title) {
	      return JOptionPane.showOptionDialog(null, this, title,
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "OK" }, "OK");
	}
	
	public void setTable(JTable tabel, String id){
		table.setModel(setTableMod(tabel, id));
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(center);
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		table.getTableHeader().setReorderingAllowed(false);
		
	}
	
	public DefaultTableModel setTableMod(JTable tabel, String id){
		cand = new Candidate();
		DefaultTableModel dm = cand.jobCandTmodel(id);
		return dm;
	}
	
	
	public void openSetInterview(){
		
		SetInterviewPanel sIP = new SetInterviewPanel();
		try {
			sIP.setTgl(Integer.parseInt(inter.getTanggal().substring(0,2)),
					Integer.parseInt(inter.getTanggal().substring(3,5)),
					Integer.parseInt(inter.getTanggal().substring(6, 10)));
			sIP.setDesc(inter.getDeskripsi());
			sIP.setLoc(inter.getLokasi());
			sIP.setTime(inter.getJam_mulai(),inter.getJam_selesai());
			sIP.setWith(inter.getDengan());
		} catch (Exception e) {}
		
		
		
		int response = sIP.showDialog("Set Interview"); //==============================
		if(response == 0){
			System.out.println("Save Set Interview");
			DBConn.Interview interC = new DBConn.Interview();
			Kelas.Interview interN = new Interview();
			
			interN.setTanggal(sIP.getTgl());
			interN.setJam_mulai(sIP.getTimeStart());
			interN.setJam_selesai(sIP.getTimeTo());
			interN.setDengan(sIP.getWith());
			interN.setLokasi(sIP.getLoc());
			interN.setDeskripsi(sIP.getDesc());
			
			if(inter.getDengan()==null && 
					inter.getDeskripsi()==null &&
					inter.getHasil()==null &&
					inter.getId_interview()==null &&
					inter.getJam_mulai()==null &&
					inter.getJam_selesai()==null&&
					inter.getLokasi()==null &&
					inter.getTanggal()==null){
				interC.add(listId[table.getSelectedRow()],interN);
			}else{
				interC.update(listId[table.getSelectedRow()],interN);
			}
			
			
		}else{
			System.out.println("Cancel");
		}
		setDetail(listId[table.getSelectedRow()]);
	}
}
