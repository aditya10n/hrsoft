
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
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import DBConn.Staff;

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
	Interviews inter = new Interviews();
	InterviewNow interN = new InterviewNow();
	SetPassword sp = new SetPassword();
	Staff staff = new Staff();
	ListUser lu = new ListUser();
	JLabel lblTime;
	private JCheckBox chckbxUser;
	private JButton btnLUser;
	private JButton btnSetPassw;
	

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
		
		lblTime = new JLabel("Time");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 153, 255));
		panel_3.setForeground(new Color(51, 153, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(463)
							.addComponent(lblBulanPenimbanganBalita)
							.addContainerGap(350, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTime)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBulanPenimbanganBalita)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTime)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
							.addGap(11))))
		);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHrsoft = new JLabel("HRSoft");
		panel_3.add(lblHrsoft, BorderLayout.CENTER);
		lblHrsoft.setForeground(new Color(153, 255, 51));
		lblHrsoft.setFont(new Font("Magneto", Font.BOLD, 35));
		panel.setLayout(gl_panel);
		
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
		
		chckbxEvent = new JCheckBox("INTERVIEW");
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
		
		chckbxUser = new JCheckBox("USER");
		chckbxUser.setFont(new Font("Times New Roman", Font.BOLD, 11));
		chckbxUser.setBorderPaintedFlat(true);
		chckbxUser.setBorderPainted(true);
		
		btnLUser = new JButton("LIST USER");
		btnLUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getListUser();
			}
		});
		btnLUser.setVisible(false);
		btnLUser.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		btnSetPassw = new JButton("SET PASSW");
		btnSetPassw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getSetPassPanel();
			}
		});
		btnSetPassw.setVisible(false);
		btnSetPassw.setFont(new Font("Times New Roman", Font.BOLD, 11));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(44)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(chckbxUser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(chckbxDataMaster, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnDataJob, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnCandidates, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(chckbxGroup, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnApplicant, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnInterview, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnHired, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(chckbxEvent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnElist, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnEtoday, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnElater, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnEmissed, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnEfinished, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
						.addComponent(btnLUser, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addGap(18))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSetPassw, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addGap(18))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxUser, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSetPassw)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
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
			public void mouseClicked(MouseEvent e) {}@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {
				if(chckbxDataMaster.isSelected()){
					btnDataJob.setVisible(true);
					btnCandidates.setVisible(true);
					
				}else{
					btnDataJob.setVisible(false);
					btnCandidates.setVisible(false);
				}
			}
		});
		
		
		btnApplicant.setVisible(false);
		btnInterview.setVisible(false);
		btnHired.setVisible(false);
		chckbxGroup.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}@Override
			public void mouseExited(MouseEvent e) {}@Override
			public void mousePressed(MouseEvent e) {}@Override
			public void mouseReleased(MouseEvent e) {
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
		});
		
		btnElist.setVisible(false);
		btnEtoday.setVisible(false);
		btnElater.setVisible(false);
		btnEmissed.setVisible(false);
		chckbxEvent.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}@Override
			public void mouseExited(MouseEvent arg0) {}@Override
			public void mousePressed(MouseEvent arg0) {}@Override
			public void mouseReleased(MouseEvent arg0) {
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
		});
		
		chckbxUser.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {}

			@Override
			public void mouseEntered(MouseEvent arg0) {}@Override
			public void mouseExited(MouseEvent arg0) {}@Override
			public void mousePressed(MouseEvent arg0) {}@Override
			public void mouseReleased(MouseEvent arg0) {
				if(chckbxUser.isSelected()){
					if(lbluser.getText().equals("admin")){
						btnLUser.setVisible(true);
					}
					
					btnSetPassw.setVisible(true);
				}else{
					btnLUser.setVisible(false);
					btnSetPassw.setVisible(false);
				}
			}
		});
		
		getCover();
		clock();
		
	}
	
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
		jobs.setUsename(lbluser.getText());
		jobs.preTable();
	}
	
	private void getCandidateApplicant(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Group Applicant");
		cand.setUsename(lbluser.getText());
		cand.prepare("APPLICANT");
	}
	
	private void getCandidateInterview(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Group Interview");
		cand.setUsename(lbluser.getText());
		cand.prepare("INTERVIEW");
	}
	
	private void getCandidateHired(){
		internalFrame.setContentPane(cand.getContentPane());
		internalFrame.setTitle("Group Hired");
		cand.setUsename(lbluser.getText());
		cand.prepare("HIRED");
	}
	
	private void getListInterview(){
		internalFrame.setContentPane(inter.getContentPane());
		internalFrame.setTitle("List Interview");
		inter.prepareList();
	}
	
	private void getListInterviewToday(){
		internalFrame.setContentPane(inter.getContentPane());
		internalFrame.setTitle("Interview Today");
		inter.prepareCost("TODAY");
		inter.setStatus(false);
		checkNowInterview(0);
		
	}
	
	private void getListInterviewLater(){
		internalFrame.setContentPane(inter.getContentPane());
		internalFrame.setTitle("Interview Later");
		inter.prepareCost("LATER");
	}
	
	private void getListInterviewMissed(){
		internalFrame.setContentPane(inter.getContentPane());
		internalFrame.setTitle("Interview Missed");
		inter.prepareCost("MISSED");
	}
	
	private void getListInterviewFinish(){
		internalFrame.setContentPane(inter.getContentPane());
		internalFrame.setTitle("Interview Finish");
		inter.prepareCost("FINISHED");
		inter.setStatus(false);
		checkNowInterview(1);
	}
	
	private void getListUser(){
		internalFrame.setContentPane(lu.getContentPane());
		internalFrame.setTitle("List User");
		lu.prepare();
	}
	
	private void getSetPassPanel(){
		sp = new SetPassword();
		sp.username = lbluser.getText();
		if(sp.showDialog("Change Password")==0){
			if(sp.new1.getText().equals(sp.new2.getText())&&(sp.old.getText().equals(staff.getPass(lbluser.getText())))){
				staff.setPass(lbluser.getText(), sp.new1.getText());
				JOptionPane.showMessageDialog(null, "Password Changed!");
			}else{
				JOptionPane.showMessageDialog(null, "Wrong password, can't change password!");
			}
		}
	}
	
	public void setNama(String nama){
		this.lblNama.setText(nama);
	}
	public void setUser(String user){
		this.lbluser.setText(user);
	}
	
	public String getUser(){
		return lbluser.getText();
	}
	
	public String getNama(){
		return lblNama.getText();
	}
	
	public void setTime(String time){
		this.lblTime.setText(time);
	}
	
	public String getTime(){
		return this.lblTime.getText();
	}
	
	
	public void clock(){
		Thread clock= new Thread(){
			public void run(){
				try {
					for(;;){
						Calendar cal = new GregorianCalendar();
						
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR+1);
						
						setTime("Time "+String.format("%02d", hour)+
								":"+String.format("%02d", minute)+
								":"+String.format("%02d", second)+
								"   Date "+String.format("%02d", day)+
								"/"+String.format("%02d", month)+
								"/"+String.format("%02d", year));
						
						sleep(1000);
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		clock.start();
	}
	
	public void checkNowInterview(final int mode){
		Thread clock= new Thread(){
			public void run(){
				try {
					int i =0;
					while(!inter.getStatus()==true){
						sleep(1000);
					}
						if(inter.getStatus()==true){
							internalFrame.setContentPane(interN.getContentPane());
							internalFrame.setTitle("Now Interview");
							
							interN.setIdSelected(inter.getIdSelected());
							interN.prepare(inter.getStatusButton());
							
							Thread clock= new Thread(){
								public void run(){
									try {
										while(!interN.getStatus()==false){
											sleep(1000);
										}
										if(interN.getStatus()==false){
											if(mode == 0){
												getListInterviewToday();
											}else if(mode == 1){
													getListInterviewFinish();
											}
										}
										
									} catch (Exception e) {
										// TODO: handle exception
									}
								}
							};
							clock.start();
						}
						
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		clock.start();
	}
}
