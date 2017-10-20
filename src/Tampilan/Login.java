package Tampilan;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					/*frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setUndecorated(true);
					frame.setAlwaysOnTop(true);
					frame.setResizable(false); */
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
	public Login() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 179);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLogin.setBounds(0, 0, 284, 23);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(50, 37, 84, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 62, 84, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBConn.Login login= new DBConn.Login();
				if (login.cekPass(txtUsername.getText().toString(),
									txtPassword.getText().toString())==true){
					JOptionPane.showMessageDialog(null,"Login Sukses");
					Home_main hm = new Home_main();
					hm.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null,"Username atau Password salah");
				}
			}
		});
		btnLogin.setBounds(93, 106, 89, 23);
		contentPane.add(btnLogin);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(144, 34, 86, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(144, 59, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
	}
}
