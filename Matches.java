import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Matches extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JComboBox<String> comboBox, comboBox_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matches frame = new Matches();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}

	public void fillComboBox() {
		try {
			comboBox.removeAllItems();
			comboBox.addItem("Year");
			comboBox.addItem("Stadium");
			comboBox.addItem("Team");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	public void fillComboBox2() {
		try {
			comboBox_1.removeAllItems();
			comboBox_1.addItem("2015");
			comboBox_1.addItem("2016");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	public void fillComboBox3() {
		try {
			comboBox_1.removeAllItems();
			String query = "select Stadium_Name from stadium";
			PreparedStatement pst = conn.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox_1.addItem(rs.getString(1));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	public void fillComboBox4() {
		try {
			comboBox_1.removeAllItems();
			String query = "select Team_id from teams";
			PreparedStatement pst = conn.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox_1.addItem(rs.getString(1));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	/**
	 * Create the frame.
	 */
	Connection conn = null;
	private JTable table;

	public Matches() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 25, 751, 258);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblRefineYourSearch = new JLabel("Refine your Search :");
		lblRefineYourSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblRefineYourSearch.setBounds(41, 324, 143, 16);
		contentPane.add(lblRefineYourSearch);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(219, 321, 157, 27);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String s = (String) comboBox.getSelectedItem();

					if (s == "Year") {
						fillComboBox2();
					} else if (s == "Stadium") {
						fillComboBox3();
					} else if (s == "Team") {
						fillComboBox4();
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(499, 321, 149, 27);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String s = (String) comboBox.getSelectedItem();
					String query = "";

					if (s == "Year") {
						query = "select * from match_info natural join plays where Year(Date) = ?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, (String) comboBox_1.getSelectedItem());
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));

					} else if (s == "Stadium") {
						query = "select match_id,Home_team,Away_Team,score,result,Date,Stadium_id,Stadium_Name from match_info natural join plays natural join stadium where Home_Team = team_id and Stadium_Name = ?";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, (String) comboBox_1.getSelectedItem());
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));

					} else if (s == "Team") {

						query = "select * from match_info natural join plays where (Away_Team =? or Home_Team = ?)";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, (String) comboBox_1.getSelectedItem());
						pst.setString(2, (String) comboBox_1.getSelectedItem());
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		contentPane.add(comboBox_1);

		JButton btnReturnToHome = new JButton("Return To Home");
		btnReturnToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w = new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		btnReturnToHome.setBounds(321, 370, 143, 29);
		contentPane.add(btnReturnToHome);

		fillComboBox();
	}
}
