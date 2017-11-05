package Tampilan;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Class.Pekerjaan;
import DBConn.DBSingle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Jobs extends JFrame {

	private JPanel contentPane;
	private JTable table;
	//ArrayList<Pekerjaan> arr_job;
	public String kode="";
	private String[]listId;
	private DBConn.Jobs job;
	private JobPanel jp;
	private JobCandPanel jcp;
	private JButton btnSelect;
	private JButton btnEdit;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jobs frame = new Jobs();
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
	public Jobs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createJob();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblCreateANew = new JLabel("CREATE A NEW JOB");
		lblCreateANew.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateANew)
					.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(lblCreateANew, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"NAME","LOCATION","APPLICANT","INTERVIEW", "HIRED"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.SOUTH);
		
		btnSelect = new JButton("Show Candidates");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openJob(listId[table.getSelectedRow()]);
			}
		});
		btnSelect.setVisible(false);
		
		btnEdit = new JButton("Edit");
		btnEdit.setVisible(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.setVisible(false);
		
		JButton btnAddCandidate = new JButton("Add Candidate");
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(btnEdit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
					.addComponent(btnAddCandidate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSelect)
					.addContainerGap())
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnAddCandidate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		);
		panel_6.setLayout(gl_panel_6);
		
		preTable();
		
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(table.isColumnSelected(table.getSelectedColumn())){
					btnSelect.setVisible(true);
					btnEdit.setVisible(true);
					btnDelete.setVisible(true);
					/*System.out.println(listId[table.getSelectedRow()]+", "+table.getSelectedRow()+", "+table.getSelectedColumn()+", "
					+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())); */
				}
			}
		});
		
	}
	
	public void preCode() {
		job = new DBConn.Jobs();
		listId = job.listId();
	}
	
	public void preTable(){
		table.setModel(preTableMod());
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(center);
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(2).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(100);
		
		preCode();
	}
	
	public DefaultTableModel preTableMod(){
		job = new DBConn.Jobs();
		DefaultTableModel dm = job.tableModel(table);
		return dm;
	}
	
	public void createJob(){
		jp = new JobPanel("Create a new Job");
		int response = jp.showDialog("Create a new Job"); //==============================
		if(response == 0){
			job.createJob(jp.getName(), jp.getLoc(), jp.getDesc());
			preTable();
		}else{
			System.out.println("Cancel");
		}
	}
	
	public void editJob(String id){
		jp = new JobPanel("Edit a new Job");
		int response = jp.showDialog("Edit a new Job"); //==============================
		if(response == 0){
			job.createJob(jp.getName(), jp.getLoc(), jp.getDesc());
			preTable();
		}else{
			System.out.println("Cancel");
		}
	}
	
	public void openJob(String id){
		jcp = new JobCandPanel(table.getValueAt(table.getSelectedRow(), 0)+" Candidates", id);
		int response = jcp.showDialog(table.getValueAt(table.getSelectedRow(), 0)+" Candidates"); //==============================
		if(response == 0){
			btnSelect.setVisible(false);
			btnEdit.setVisible(false);
			btnDelete.setVisible(false);
			preTable();
		}else{
			System.out.println("Cancel");
		}
	}
}
