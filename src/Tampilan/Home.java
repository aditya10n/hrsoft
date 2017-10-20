package Tampilan;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.text.html.ListView;

import org.omg.PortableServer.AdapterActivator;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.UIManager;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;

public class Home {

	private JFrame frame;
	JDesktopPane desktopPane;
	JInternalFrame internalFrame;
	
	
	
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		JCheckBox chckbxCandidates = new JCheckBox("CANDIDATES");
		
		JCheckBox chckbxJobs = new JCheckBox("JOBS");
		
		JCheckBox chckbxEvents = new JCheckBox("EVENTS");
		
		JButton btnNewButton = new JButton("CREATE");
		
		JButton btnAllJobs = new JButton("ALL JOBS");
		btnAllJobs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getJobs();
			}
		});
		
		JButton btnApplicant = new JButton("APPLICANT");
		
		JButton btnInterview = new JButton("INTERVIEW");
		
		JButton btnHired = new JButton("HIRED");
		
		JButton btnList = new JButton("LIST");
		
		JButton btnToday = new JButton("TODAY");
		
		JButton btnLater = new JButton("LATER");
		
		JButton btnMissed = new JButton("MISSED");
		
		JButton btnFinished = new JButton("FINISHED");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnApplicant, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(chckbxEvents, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(chckbxCandidates, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(chckbxJobs, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addComponent(btnAllJobs, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addComponent(btnToday, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addComponent(btnList, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addComponent(btnLater, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addComponent(btnMissed, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(btnInterview, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(btnHired, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addComponent(btnFinished, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxJobs)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(3)
					.addComponent(btnAllJobs)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxCandidates)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnApplicant)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInterview)
					.addGap(5)
					.addComponent(btnHired)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxEvents)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnToday)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLater)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMissed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFinished)
					.addContainerGap(177, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblUsername = new JLabel("username");
		panel_2.add(lblUsername);
		
		JLabel lblUser = new JLabel("User :");
		panel_2.add(lblUser);
		
		JLabel lblnama = new JLabel("nama");
		panel_2.add(lblnama);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		panel_4.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setDragMode(2);
		desktopPane.setLayout(new BorderLayout(0, 0));
		
		
		
	}
	
	 void getJobs() {
		//desktopPane.removeAll();
		//desktopPane.repaint();
		internalFrame = new JInternalFrame("Jobs", false, false);
		Jobs db = new Jobs();
		internalFrame.setContentPane(db.getContentPane());
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		
	}
	
}
