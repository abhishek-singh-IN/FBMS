import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	Connection conn = null;

	public Welcome() {
		conn = JDBCconn.dbconn();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 584, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcomeToFootball = new JLabel("Welcome to ");
		lblWelcomeToFootball.setFont(new Font("Apple Color Emoji", Font.BOLD, 18));
		lblWelcomeToFootball.setBounds(199, 24, 152, 24);
		contentPane.add(lblWelcomeToFootball);

		JLabel lblFootballDatabaseManagement = new JLabel("Football Database Management System");
		lblFootballDatabaseManagement.setFont(new Font("Apple Color Emoji", Font.BOLD, 18));
		lblFootballDatabaseManagement.setBounds(80, 54, 415, 32);
		contentPane.add(lblFootballDatabaseManagement);

		JLabel lblChooseAnOption = new JLabel("Choose an option :");
		lblChooseAnOption.setFont(new Font("Courier New", Font.BOLD, 14));
		lblChooseAnOption.setBounds(42, 129, 152, 16);
		contentPane.add(lblChooseAnOption);

		JButton btnNewButton = new JButton("Teams");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Teams w = new Teams();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(55, 165, 139, 46);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Matches");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matches w = new Matches();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_1.setBounds(55, 237, 139, 46);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Leagues");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Leagues w = new Leagues();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnNewButton_2.setBounds(55, 303, 139, 46);
		contentPane.add(btnNewButton_2);

	}
}
