import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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

	public Register() {
		conn = JDBCconn.dbconn();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblName.setBounds(92, 25, 93, 21);
		contentPane.add(lblName);

		textField = new JTextField();
		textField.setBounds(266, 23, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblEmailId = new JLabel("E-Mail id : ");
		lblEmailId.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEmailId.setBounds(92, 63, 93, 31);
		contentPane.add(lblEmailId);

		textField_1 = new JTextField();
		textField_1.setBounds(266, 66, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblUsername.setBounds(92, 106, 108, 21);
		contentPane.add(lblUsername);

		textField_2 = new JTextField();
		textField_2.setBounds(266, 104, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPassword.setBounds(92, 146, 108, 16);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(266, 142, 130, 26);
		contentPane.add(passwordField);

		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into users (Name,Email_Id,Username,Password)  values(?,?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, passwordField.getText());

					pst.execute();

					JOptionPane.showMessageDialog(null, "User Registered Successfully ");

					pst.close();

					Welcome w = new Welcome();
					w.setVisible(true);
					dispose();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnRegister.setBounds(186, 211, 140, 40);
		contentPane.add(btnRegister);
	}

}
