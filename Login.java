import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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

	Connection conn = null;

	public Login() {
		initialize();
		conn = JDBCconn.dbconn();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 445, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblUsername.setBounds(36, 40, 95, 16);
		frame.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblPassword.setBounds(36, 88, 84, 21);
		frame.getContentPane().add(lblPassword);

		textField = new JTextField();
		textField.setBounds(156, 36, 182, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(157, 88, 181, 26);
		frame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from users where Username = ? and Password = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());

					ResultSet rs = pst.executeQuery();
					int count = 0;
					while (rs.next()) {
						count++;
					}
					if (count == 1) {
						JOptionPane.showMessageDialog(null, "Correct Username and Password ");
						if (textField.getText() == "Admin" && passwordField.getText() == "admin") {
							frame.dispose();
							Modify m = new Modify();
							m.setVisible(true);
						} else {
							frame.dispose();
							Welcome w = new Welcome();
							w.setVisible(true);
						}

					} else if (count > 1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password ");

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Username and Password ");
					}

					rs.close();
					pst.close();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}
		});

		btnLogin.setBounds(156, 139, 101, 40);
		frame.getContentPane().add(btnLogin);

		JLabel lblNotRegisteredYet = new JLabel("Not Registered yet, ");
		lblNotRegisteredYet.setBounds(55, 215, 124, 16);
		frame.getContentPane().add(lblNotRegisteredYet);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Register reg = new Register();
				reg.setVisible(true);
			}
		});
		btnRegister.setBounds(183, 210, 95, 29);
		frame.getContentPane().add(btnRegister);
	}
}
