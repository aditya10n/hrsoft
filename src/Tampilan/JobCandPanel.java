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

import java.awt.Font;

import javax.swing.JDesktopPane;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;

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

public class JobCandPanel extends JPanel {
	private JTable table;
	private DBConn.Candidate cand;
	private JTextField textField_2;
	private JSpinner toSpinner_1;
	/**
	 * Create the panel.
	 */
	public JobCandPanel(String title, String idJob) {
		setLayout(new BorderLayout(0, 0));
		
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
		
		JLabel label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_1 = new JLabel("0");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_2 = new JLabel("0");
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder());
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel labelName = new JLabel("<Name>");
		labelName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel labelEmail = new JLabel("<Email>");
		labelEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel labelPhone = new JLabel("<Phone>");
		labelPhone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Set Interview", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 0, 0));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"APPLICANT", "INTERVIEW", "HIRED"}));
		comboBox.setSelectedIndex(1);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName)
						.addComponent(lblEmail)
						.addComponent(lblPhone)
						.addComponent(lblAddress))
					.addGap(41)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addComponent(labelName)
									.addComponent(labelEmail))
								.addComponent(labelPhone))
							.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addComponent(panel_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
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
							.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhone)
								.addComponent(labelPhone)))
						.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
					.addGap(8))
		);
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
		
		
		final UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.getJFormattedTextField().setFont(new Font("Times New Roman", Font.BOLD, 12));
		datePicker.getJFormattedTextField().setText("Set Date -->");
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 102));
		datePicker.setBackground(new Color(255, 255, 153));
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
		datePicker.setBounds(580, 6, 150, 25);
		panel_5.add(datePicker);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblStart = new JLabel("Start");

		
		
		JLabel lblTo = new JLabel("to");
		
		JLabel lblWith = new JLabel("With");
		lblWith.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Location");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JSpinner startSpinner;
		Date date = new Date();
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		  startSpinner = new javax.swing.JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(startSpinner, "HH:mm");
		startSpinner.setEditor(de);
		
		JSpinner toSpinner = new JSpinner();
		Date dateTo = new Date();
		  SpinnerDateModel smTo = 
		  new SpinnerDateModel(dateTo, null, null, Calendar.HOUR_OF_DAY);
		  toSpinner_1 = new javax.swing.JSpinner(smTo);
		JSpinner.DateEditor deTo = new JSpinner.DateEditor(toSpinner_1, "HH:mm");
		toSpinner_1.setEditor(deTo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"not Ready", "Ready"}));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(lblTo)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(toSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(lblStart)
									.addGap(18)
									.addComponent(startSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTime))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(4)
									.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
								.addComponent(lblNewLabel))
							.addGap(6))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(4)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblWith))
							.addGap(6)))
					.addGap(0)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.LEADING, gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTime)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStart)
								.addComponent(startSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
								.addComponent(toSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblWith)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JTextPane textPane_2 = new JTextPane();
		scrollPane_2.setViewportView(textPane_2);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1, BorderLayout.CENTER);
		
		JTextPane textPane_1 = new JTextPane();
		scrollPane_1.setViewportView(textPane_1);
		panel_5.setLayout(gl_panel_5);
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
		
		
		
	}
	
	public int showDialog(String title) {
	      return JOptionPane.showOptionDialog(null, this, title,
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "OK", "Cancel" }, "OK");
	}
}
