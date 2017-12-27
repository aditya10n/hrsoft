package Tampilan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import DBConn.Candidate;
import Kelas.Kandidat;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ListSelectionModel;

public class Candidates extends JFrame {

	private JPanel contentPane;
	private DBConn.Candidate cand=new Candidate();
	private JTable table;
	DefaultTableCellRenderer center = new DefaultTableCellRenderer();
	private JTextField textField;
	JComboBox comboBox ;
	JButton btnEdit;
	JButton btnDelete;
	JButton btnDetail;
	String[] listId;
	String[] listIdP;
	String group;
	DefaultComboBoxModel cbmdef;
	DefaultComboBoxModel cbmgroup;
	Kandidat kand;
	CandidatePanel cp;
	DBConn.Interview in;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidates frame = new Candidates();
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
	public Candidates() {
		kand = new Kandidat();
		cp = new CandidatePanel();
		in = new DBConn.Interview();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(table.isColumnSelected(table.getSelectedColumn())){
					btnDelete.setVisible(true);
					btnEdit.setVisible(true);
					btnDetail.setVisible(true);
				}
			}@Override
			public void mousePressed(MouseEvent arg0) {}@Override
			public void mouseExited(MouseEvent arg0) {}@Override
			public void mouseEntered(MouseEvent arg0) {}@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblSearch = new JLabel("Search :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NAME", "JOB", "GROUP", "STATUS"}));
		
		JLabel lblOrderBy = new JLabel("Order by :");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearch)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(lblOrderBy)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSearch))
						.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOrderBy)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.SOUTH);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cp.edit();
				kand = cand.getDetailG(listId[table.getSelectedRow()]);
				kand.setId_kandidat(listId[table.getSelectedRow()]);
				cp.setNama(kand.getNama());
				cp.setEmail(kand.getEmail());
				cp.setPhone(kand.getPhone());
				cp.setAlamat(kand.getAlamat());
				cp.setGroup(kand.getGroup());
				cp.setStatus(kand.getStatus());
				cp.setEdu(kand.getEducation());
				cp.setExp(kand.getExperience());
				cp.id = listId[table.getSelectedRow()];
				
				cp.group.setVisible(true);
				cp.status.setVisible(true);
				
				cp.lblstatus.setVisible(false);
				cp.lblgroup.setVisible(false);
				
				if(cp.showDialog("Detail Candidate : "+kand.getNama())==0){
					if(kand.getGroup().toString().equals("INTERVIEW")||
							kand.getGroup().toString().equals("HIRED")){
							if(cp.getGroup().toString().equals("INTERVIEW")||
									cp.getGroup().toString().equals("HIRED")){
								
							}else{
								int result = JOptionPane.showConfirmDialog(null, 
										"Interview Data : "+cp.getNama()
										+" will be deleted! Are you sure ?");
								if(result == 0){
									in.delete(listId[table.getSelectedRow()]);
								}else{
									cp.setGroup(kand.getGroup());
								}
							}
					}
					kand.setNama(cp.getNama());
					kand.setEmail(cp.getEmail());
					kand.setPhone(cp.getPhone());
					kand.setAlamat(cp.getAlamat());
					kand.setGroup(cp.getGroup());
					kand.setStatus(cp.getStatus());
					kand.setEducation(cp.getEdu());
					kand.setExperience(cp.getExp());
					
					
					listIdP = cand.listIdP();
					cand.editCandidate(kand, "admin", listIdP[table.getSelectedRow()]);
					
					if(table.getColumnCount()==4){
						prepare();
					}else{
						prepare(group);
					}
				}
			}
		});
		btnEdit.setVisible(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Delete Candidate :"+table.getValueAt( table.getSelectedRow(),0)+"?");
				if(result == 0){
					cand.deleteCandidate(listId[table.getSelectedRow()]);
					if(table.getColumnCount()==4){
						prepare();
					}else{
						prepare(group);
					}
				}
			}
		});
		btnDelete.setVisible(false);
		
		btnDetail = new JButton("Detail");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kand = cand.getDetailG(listId[table.getSelectedRow()]);
				cp.setNama(kand.getNama());
				cp.setEmail(kand.getEmail());
				cp.setPhone(kand.getPhone());
				cp.setAlamat(kand.getAlamat());
				cp.setGroup(kand.getGroup());
				cp.setStatus(kand.getStatus());
				cp.setEdu(kand.getEducation());
				cp.setExp(kand.getExperience());
				
				cp.group.setVisible(false);
				cp.status.setVisible(false);
				
				cp.lblstatus.setVisible(true);
				cp.lblstatus.setText(kand.getStatus());
				cp.lblgroup.setVisible(true);
				cp.lblgroup.setText(kand.getGroup());
				
				cp.detail();
				cp.showDialog("Detail Candidate : "+kand.getNama());
				
			}
		});
		btnDetail.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEdit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
					.addComponent(btnDetail)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDetail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.EAST);
		
		String[] def = {"NAME", "JOB", "GROUP", "STATUS"};
		String[] gr = {"NAME", "JOB", "STATUS"};
		cbmdef =  new DefaultComboBoxModel(def);
		cbmgroup =  new DefaultComboBoxModel(gr);
		
		prepare();
	}
	
	public void prepare(){
		btnDelete.setVisible(false);
		btnEdit.setVisible(false);
		btnDetail.setVisible(false);
		
		comboBox.setModel(cbmdef);
		
		table.setModel(cand.CandidateModel());
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(center);
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(0).setMinWidth(210);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		
		listId=cand.listId();
		
	}
	
	public void prepare(String group){
		this.group=group;
		btnDelete.setVisible(false);
		btnEdit.setVisible(false);
		btnDetail.setVisible(false);
		
		comboBox.setModel(cbmgroup);
		
		table.setModel(cand.CandidateModel(group));
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(center);
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(0).setMinWidth(210);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		
		listId=cand.listIdG(group);
	}
}
