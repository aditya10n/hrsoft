package Tampilan;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.Component;
import java.awt.Rectangle;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;

public class SetInterviewPanel extends JPanel {

	private UtilDateModel model;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	public JTextField textField;
	public JTextArea textPane;
	public JTextArea textPane_1;
	JSpinner spinner;
	JSpinner spinner_1;
	JSpinner.DateEditor de,deTo;
	/**
	 * Create the panel.
	 */
	public SetInterviewPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Set Interview", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel);
		
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.getJFormattedTextField().setFont(new Font("Times New Roman", Font.BOLD, 12));
		datePicker.getJFormattedTextField().setText("Set Date -->");
		datePicker.getJFormattedTextField().setBackground(new Color(255, 255, 102));
		datePicker.setBackground(new Color(255, 255, 153));
		
		panel.add(datePicker);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Note", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Time", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "With", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Location", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
						.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
		);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_4.add(scrollPane_1, BorderLayout.CENTER);
		
		textPane_1 = new JTextArea();
		scrollPane_1.setViewportView(textPane_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextArea();
		scrollPane.setViewportView(textPane);
		panel_3.setLayout(new BorderLayout(0, 0));
		//scrollPane.setViewportView(textPane);
		
		textField = new JTextField();
		panel_3.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JLabel lblStart = new JLabel("Start");
		
		JLabel lblTo = new JLabel("to");
		
		spinner = new JSpinner();
		Date date = new Date();
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		  spinner = new javax.swing.JSpinner(sm);
		de = new JSpinner.DateEditor(spinner, "HH:mm");
		
		spinner.setEditor(de);
		
		
		spinner_1 = new JSpinner();
		Date dateTo = new Date();
		  SpinnerDateModel smTo = 
		  new SpinnerDateModel(dateTo, null, null, Calendar.HOUR_OF_DAY);
		  spinner_1 = new javax.swing.JSpinner(smTo);
		deTo = new JSpinner.DateEditor(spinner_1, "HH:mm");
		spinner_1.setEditor(deTo);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStart)
						.addComponent(lblTo))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spinner_1)
						.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStart)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTo)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
	}
	
	
	public int showDialog(String title) {
	      return JOptionPane.showOptionDialog(null, this, title,
	            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
	            new String[] { "OK", "Cancel" }, "OK");
	}
	
	public void setTgl(int d, int m, int y){
		model.setSelected(true);
		model.setDate(y, m-1, d);
		datePanel= new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
	}
	
	public String getTgl(){
		String tgl = model.getYear() +"-"+ Integer.toString(model.getMonth()+1)+"-"+ model.getDay();
		return tgl;
	}
	
	public void setDesc(String desc){
		this.textPane.setText(desc);
	}
	
	public String getDesc(){
		return this.textPane.getText();
	}
	
	
	public void setWith(String with){
		this.textField.setText(with);
	}
	
	public String getWith(){
		return this.textField.getText();
	}
	
	public void setLoc(String loc){
		this.textPane_1.setText(loc);
	}
	
	public String getLoc(){
		return this.textPane_1.getText();
	}
	
	public void setTime(String start, String to){
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		try {
			spinner.setValue(format.parseObject(start));
			spinner_1.setValue(format.parseObject(to));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getTimeStart(){
		return de.getFormat().format(spinner.getValue())+":00";
	}
	
	public String getTimeTo(){
		return deTo.getFormat().format(spinner_1.getValue())+":00";
	}
	
	public void setEnabled(boolean value){
		datePanel.setEnabled(value);
		datePicker.setEnabled(value);
		spinner.setEnabled(value);
		spinner_1.setEnabled(value);
		textPane.setEditable(value);
		textPane_1.setEditable(value);
		textField.setEditable(value);
		
	}
	
	
	
}
