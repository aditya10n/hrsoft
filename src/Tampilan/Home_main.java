
package Tampilan;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Home_main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JInternalFrame internalFrame = new JInternalFrame();
	private JButton btnDataJob;
	private JButton btnCandidates;
	private JButton btnApplicant;
	private JCheckBox chckbxGroup;
	private JCheckBox chckbxDataMaster;
	private JButton btnElist;
	private JButton btnHired;
	private JButton btnInterview;
	private JCheckBox chckbxEvent;
	private JButton btnEtoday;
	private JButton btnElater;
	private JButton btnEmissed;
	private JButton btnNewButton;
	private JLabel lblUser;
	private JLabel lbluser;
	private JLabel label;
	private JLabel lblNama;
	private JButton btnEfinished;
	Jobs jobs = new Jobs();
	Candidates cand = new Candidates();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_main frame = new Home_main();
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
	public Home_main() {
		setTitle("HRSoft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		panel_4.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setDragMode(2);
		desktopPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_4.add(panel, BorderLayout.NORTH);
		panel.setBackground(new Color(153, 255, 102));
		
		JLabel lblBulanPenimbanganBalita = new JLabel("");
		lblBulanPenimbanganBalita.setFont(new Font("Source Code Pro Semibold", Font.BOLD, 27));
		panel.add(lblBulanPenimbanganBalita);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1, BorderLayout.WEST);
		panel_1.setBackground(new Color(153, 255, 153));
		
		chckbxDataMaster = new JCheckBox("DATA MASTER");
		chckbxDataMaster.setFont(new Font("Times New Roman", Font.BOLD, 11));
		chckbxDataMaster.setSelected(true);
		chckbxDataMaster.setBorderPainted(true);
		chckbxDataMaster.setBorderPaintedFlat(true);
		
		btnDataJob = new JButton("JOBS");
		btnDataJob.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnDataJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getJobs();
			}
		});
		
		btnCandidates = new JButton("CANDIDATES");
		btnCandidates.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnCandidates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getCandidates();
			}
		});
		
		chckbxGroup = new JCheckBox("GROUP");
		chckbxGroup.setFont(new Font("Times New Roman", Font.BOLD, 11));
		chckbxGroup.setBorderPaintedFlat(true);
		chckbxGroup.setBorderPainted(true);
		
		btnApplicant = new JButton("APPLICANT");
		btnApplicant.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getCandidateApplicant();
			}
		});
		
		btnInterview = new JButton("INTERVIEW");
		btnInterview.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getCandidateInterview();
			}
		});
		
		btnHired = new JButton("HIRED");
		btnHired.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnHired.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getCandidateHired();
			}
		});
		
		chckbxEvent = new JCheckBox("EVENT");
		chckbxEvent.setFont(new Font("Times New Roman", Font.BOLD, 11));
		chckbxEvent.setBorderPaintedFlat(true);
		chckbxEvent.setBorderPainted(true);

		
		
		btnElist = new JButton("LIST");
		btnElist.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnElist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getListInterview();
			}
		});
		
		btnEtoday = new JButton("TODAY");
		btnEtoday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getListInterviewToday();
			}
		});
		btnEtoday.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		btnElater = new JButton("LATER");
		btnElater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getListInterviewLater();
			}
		});
		
		btnElater.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnEmissed = new JButton("MISSED");
		btnEmissed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getListInterviewMissed();
			}
		});
		
		btnEmissed.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login lg = new Login();
				lg.setVisible(true);
			}
		});
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnEfinished = new JButton("FINISHED");
		btnEfinished.setVisible(false);
		btnEfinished.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getListInterviewFinish();
			}
		});
		btnEfinished.setFont(new Font("Times New Roman", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(44)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxDataMaster, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnDataJob, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnCandidates, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(chckbxGroup, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnApplicant, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnInterview, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnHired, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(chckbxEvent, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnElist, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnEtoday, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnElater, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnEmissed, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnEfinished, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addGap(18))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxDataMaster)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDataJob)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCandidates)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxGroup)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnApplicant)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInterview)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnHired)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxEvent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnElist)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEtoday)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnElater)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEmissed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEfinished)
					.addPreferredGap(ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(153, 204, 255));
		contentPane.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(153, 204, 255));
		contentPane.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 255));
		panel_6.add(panel_2, BorderLayout.EAST);
		
		lblUser = new JLabel("User :");
		panel_2.add(lblUser);
		
		lbluser = new JLabel("username");
		panel_2.add(lbluser);
		
		label = new JLabel("-");
		panel_2.add(label);
		
		lblNama = new JLabel("name");
		panel_2.add(lblNama);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(153, 204, 255));
		contentPane.add(panel_7, BorderLayout.WEST);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(153, 204, 255));
		contentPane.add(panel_8, BorderLayout.EAST);
		
		
		chckbxDataMaster.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxDataMaster.isSelected()){
					btnDataJob.setVisible(true);
					btnCandidates.setVisible(true);
					if(getId().equals("ADMIN")){
					}
				}else{
					btnDataJob.setVisible(false);
					btnCandidates.setVisible(false);
				}
					
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}
		});
		
		
		btnApplicant.setVisible(false);
		btnInterview.setVisible(false);
		btnHired.setVisible(false);
		chckbxGroup.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxGroup.isSelected()){
					btnApplicant.setVisible(true);
					btnInterview.setVisible(true);
					btnHired.setVisible(true);

				}else{
					btnApplicant.setVisible(false);
					btnInterview.setVisible(false);
					btnHired.setVisible(false);
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {}
		});
		
		btnElist.setVisible(false);
		btnEtoday.setVisible(false);
		btnElater.setVisible(false);
		btnEmissed.setVisible(false);
		chckbxEvent.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(chckbxEvent.isSelected()){
					btnElist.setVisible(true);
					btnEtoday.setVisible(true);
					btnElater.setVisible(true);
					btnEmissed.setVisible(true);
					btnEfinished.setVisible(true);
				}else{
					btnElist.setVisible(false);
					btnEtoday.setVisible(false);
					btnElater.setVisible(false);
					btnEmissed.setVisible(false);
					btnEfinished.setVisible(false);
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}@Override
			public void mouseExited(MouseEvent arg0) {}@Override
			public void mousePressed(MouseEvent arg0) {}@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		getCover();
	}
	
	/*
	protected void getLaporanPerbulan() {
		desktopPane.removeAll();
		desktopPane.repaint();
		internalFrame = new JInternalFrame("Laporan Penimbangan Perbulan", false, false);
		LaporanPenimbanganPerbulan db = new LaporanPenimbanganPerbulan();
		internalFrame.setContentPane(db.getContentPane());
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		
	}
	*/
	private void getCover() {
		desktopPane.removeAll();
		desktopPane.repaint();
		internalFrame.setContentPane(jobs.getContentPane());
		internalFrame.setTitle("Jobs");
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		
	}
	
	private void getCandidates(){
		internalFrame.setContentPane(cand.getContentPane());
		cand.prepare();
		internalFrame.setTitle("Candidate");
	}
	
	private void getJobs(){
		internalFrame.setContentPane(jobs.getContentPane());
		internalFrame.setTitle("Jobs");
		jobs.preTable();
	}
	
	private void getCandidateApplicant(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Group Applicant");
		cand.prepare("APPLICANT");
	}
	
	private void getCandidateInterview(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Group Interview");
		cand.prepare("INTERVIEW");
	}
	
	private void getCandidateHired(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Group Hired");
		cand.prepare("HIRED");
	}
	
	private void getListInterview(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("List Interview");
		cand.prepare("HIRED");
	}
	
	private void getListInterviewToday(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Interview Today");
		cand.prepare("HIRED");
	}
	
	private void getListInterviewLater(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Interview Later");
		cand.prepare("HIRED");
	}
	
	private void getListInterviewMissed(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Interview Missed");
		cand.prepare("HIRED");
	}
	
	private void getListInterviewFinish(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Interview Finished");
		cand.prepare("HIRED");
	}
	
	
	public void setId(String s){
		this.lbluser.setText(s);
	}
	public void setUser(String s){
		this.lblNama.setText(s);
	}
	
	public String getId(){
		return lbluser.getText();
	}
	
	public String getUser(){
		return lblNama.getText();
	}
}
