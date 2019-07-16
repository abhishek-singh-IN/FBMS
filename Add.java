import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Add extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;

	/**
	 * Create the frame.
	 */
	public Add() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(29, 29, 789, 386);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Teams", null, panel, null);
		panel.setLayout(null);

		JLabel lblTeamid = new JLabel("Team_Id :");
		lblTeamid.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamid.setBounds(76, 39, 115, 37);
		panel.add(lblTeamid);

		JLabel lblTeamname = new JLabel("Team_Name :");
		lblTeamname.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTeamname.setBounds(76, 103, 115, 37);
		panel.add(lblTeamname);

		JLabel lblNewLabel = new JLabel("City :");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(76, 152, 86, 43);
		panel.add(lblNewLabel);

		JLabel lblOwner = new JLabel("Owner :");
		lblOwner.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblOwner.setBounds(76, 207, 69, 34);
		panel.add(lblOwner);

		textField = new JTextField();
		textField.setBounds(283, 44, 130, 26);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(283, 108, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(283, 160, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(283, 211, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into teams values(?,?,?,?);";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.execute();

					pst.close();

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnSubmit.setBounds(545, 81, 117, 29);
		panel.add(btnSubmit);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modify m = new Modify();
				m.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(545, 161, 117, 29);
		panel.add(btnReturn);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Players", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Stadiums", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Coaches", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Matches", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("League", null, panel_5, null);
		panel_5.setLayout(null);
	}
}
