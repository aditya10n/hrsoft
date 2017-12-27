package Tampilan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import DBConn.Staff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JButton btnEdit;
	JButton btnDelete;
	JButton btnAdd;
	Staff staff;
	DefaultTableCellRenderer center;
	UserPanel up;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUser frame = new ListUser();
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
	public ListUser() {
		center = new DefaultTableCellRenderer();
		staff = new Staff();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnEdit.setVisible(true);
				btnDelete.setVisible(true);
				
			}@Override
			public void mousePressed(MouseEvent arg0) {}@Override
			public void mouseExited(MouseEvent arg0) {}@Override
			public void mouseEntered(MouseEvent arg0) {}@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				up = new UserPanel();
				
				up.user.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				up.pass.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				up.name.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				up.phone.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				
				
				int result = up.showDialog("Edit User");
				if(result==0){
					Kelas.Staff staf = new Kelas.Staff(up.user.getText(), 
							up.pass.getText(), 
							up.name.getText(), 
							up.phone.getText());
					
					staff.update(staf);
					prepare();
				}
			}
		});
		btnEdit.setVisible(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Delete username : "+table.getValueAt(table.getSelectedRow(), 0)+"?")==0){
					staff.delete(table.getValueAt(table.getSelectedRow(), 0).toString());
					prepare();
				}
			}
		});
		btnDelete.setVisible(false);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				up = new UserPanel();
				int result = up.showDialog("Add User");
				if(result==0){
					Kelas.Staff staf = new Kelas.Staff(up.user.getText(), 
							up.pass.getText(), 
							up.name.getText(), 
							up.phone.getText());
					
					staff.add(staf);
					prepare();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEdit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
	}
	
	public void prepare(){
		table.setModel(staff.UserListmodel());
		center.setHorizontalAlignment(SwingConstants.CENTER);
		
		for (int i=0; i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setCellRenderer(center);
			table.getColumnModel().getColumn(i).setResizable(false);
		}
	}

}
