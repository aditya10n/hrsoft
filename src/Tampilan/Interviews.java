package Tampilan;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Kelas.Interview;

import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Interviews extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DBConn.Interview inter;
	DefaultTableCellRenderer center;
	String[] listId;
	String type;
	JButton btnDetail;
	JButton btnEdit;
	JButton btnInterviewNow;
	boolean openNowInterview;
	String idSelected, statusButton;
	JButton btnEditInterview;
	private JButton btnDetailInterview;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interviews frame = new Interviews();
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
	public Interviews() {
		inter = new DBConn.Interview();
		center = new DefaultTableCellRenderer();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);
		
		btnInterviewNow = new JButton("Interview Now");
		btnInterviewNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setIdSelected(listId[table.getSelectedRow()]);
				openNowInterview = true;
				statusButton = btnInterviewNow.getText();
			}
		});
		
		btnDetail = new JButton("Detail");
		btnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openSetInterviewD(listId[table.getSelectedRow()]);
				refresh();
			}
		});
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openSetInterviewE(listId[table.getSelectedRow()]);
				refresh();
			}
		});
		
		btnEditInterview = new JButton("Edit Interview");
		btnEditInterview.setVisible(false);
		btnEditInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setIdSelected(listId[table.getSelectedRow()]);
				openNowInterview = true;
				statusButton = btnEditInterview.getText();
			}
		});
		
		btnDetailInterview = new JButton("Detail Interview");
		btnDetailInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setIdSelected(listId[table.getSelectedRow()]);
				openNowInterview = true;
				statusButton = btnDetailInterview.getText();
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInterviewNow)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditInterview)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnDetailInterview)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDetail)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnInterviewNow, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDetail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEditInterview, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDetailInterview, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
		);
		panel_4.setLayout(gl_panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseListener() {@Override
			public void mouseReleased(MouseEvent arg0) {
				btnDetail.setVisible(true);
				btnEdit.setVisible(true);
				if(type.equals("TODAY")){
					btnInterviewNow.setVisible(true);
					btnEdit.setVisible(true);
					btnDetail.setVisible(true);
				}else if(type.equals("FINISHED")){
					btnEditInterview.setVisible(true);
					btnEdit.setVisible(false);
					btnDetail.setVisible(false);
					btnDetailInterview.setVisible(true);
				}
			}@Override
			public void mousePressed(MouseEvent arg0) {}@Override
			public void mouseExited(MouseEvent arg0) {}@Override
			public void mouseEntered(MouseEvent arg0) {}@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		scrollPane.setViewportView(table);
		prepareList();
		
	}
	
	public void prepareList(){
		openNowInterview = false;
		this.type="";
		table.setModel(inter.interviewList());
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(center);
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		table.getTableHeader().setReorderingAllowed(false);
		listId = inter.listIdList();
		
		btnDetail.setVisible(false);
		btnEdit.setVisible(false);
		btnInterviewNow.setVisible(false);
		btnEditInterview.setVisible(false);
		btnDetailInterview.setVisible(false);
	}
	
	public void prepareCost(String type){
		openNowInterview = false;
		this.type = type;
		if(type.equals("TODAY")){
			table.setModel(inter.interviewToday());
			listId = inter.listIdToday();
		}else if(type.equals("LATER")){
			table.setModel(inter.interviewLater());
			listId = inter.listIdLater();
		}else if(type.equals("MISSED")){
			table.setModel(inter.interviewMissed());
			listId = inter.listIdMissed();
		}else if(type.equals("FINISHED")){
			table.setModel(inter.interviewFinished());
			listId = inter.listIdFinished();
		}
		
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(center);
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		table.getTableHeader().setReorderingAllowed(false);
		
		btnDetail.setVisible(false);
		btnEdit.setVisible(false);
		btnInterviewNow.setVisible(false);
		btnEditInterview.setVisible(false);
		btnDetailInterview.setVisible(false);
	}
	
	public void openSetInterviewD(String id){
		SetInterviewPanel sIP = new SetInterviewPanel();
		Kelas.Interview inter = new Kelas.Interview();
		this.inter = new DBConn.Interview();
		inter = this.inter.getDataFK(id);
		sIP.setTgl(Integer.parseInt(inter.getTanggal().substring(0, 4)),
				Integer.parseInt(inter.getTanggal().substring(5,7)),
				Integer.parseInt(inter.getTanggal().substring(8,10)));
		sIP.setDesc(inter.getDeskripsi());
		sIP.setLoc(inter.getLokasi());
		sIP.setTime(inter.getJam_mulai(),inter.getJam_selesai());
		sIP.setWith(inter.getDengan());
		sIP.showDialog("Set Interview"); 
		
		sIP.setEnabled(false);
		
	}
	
	public void openSetInterviewE(String id){
		SetInterviewPanel sIP = new SetInterviewPanel();
		Kelas.Interview inter = new Kelas.Interview();
		this.inter = new DBConn.Interview();
		inter = this.inter.getDataFK(id);
		sIP.setTgl(Integer.parseInt(inter.getTanggal().substring(0, 4)),
				Integer.parseInt(inter.getTanggal().substring(5,7)),
				Integer.parseInt(inter.getTanggal().substring(8,10)));
		sIP.setDesc(inter.getDeskripsi());
		sIP.setLoc(inter.getLokasi());
		sIP.setTime(inter.getJam_mulai(),inter.getJam_selesai());
		sIP.setWith(inter.getDengan());
		
		int response = sIP.showDialog("Set Interview"); //==============================
		if(response == 0){
			System.out.println("Save Set Interview");
			
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
				this.inter.add(id,interN);
			}else{
				this.inter.update(id,interN);
			}
			
			
		}else{
			System.out.println("Cancel");
		}
	}
	
	public void refresh(){
		if(type.equals("")){
			prepareList();
		}else{
			prepareCost(type);
		}
	}
	
	public void setStatus(boolean value){
		this.openNowInterview = value;
	}
	
	public boolean getStatus(){
		return this.openNowInterview;
	}
	
	public String getIdSelected(){
		return this.idSelected;
	}
	
	public void setIdSelected(String id){
		this.idSelected=id;
	}
	public String getStatusButton(){
		return this.statusButton;
	}
}
