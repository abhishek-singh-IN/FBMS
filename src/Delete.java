import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.*;

public class Delete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JComboBox<String> comboBox_1, comboBox;
	String a, b;

	/**
	 * Launch the application.
	 */
	Connection conn = null;
	private JButton btnSubmit;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillComboBox1() {
		try {
			a = (String) comboBox.getSelectedItem();

			String query = "";

			if (a == "Teams") {
				query = "select distinct(Team_Name) from teams";
			} else if (a == "Players") {
				query = "select distinct(Player_name) from players";
			} else if (a == "Stadiums") {
				query = "select distinct(Stadium_Name) from stadium";
			} else if (a == "Coaches") {
				query = "select distinct(Coach_Name) from coach";
			} else if (a == "Matches") {
				query = "select distinct(match_id) from match_info";
			} else if (a == "League") {
				query = "select distinct(season) from league";
			}

			PreparedStatement pst = conn.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			comboBox_1.removeAllItems();

			while (rs.next()) {
				comboBox_1.addItem(rs.getString(1));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	public void fillComboBox() {
		try {
			comboBox.removeAllItems();
			comboBox.addItem("Teams");
			comboBox.addItem("Players");
			comboBox.addItem("Stadiums");
			comboBox.addItem("Coaches");
			comboBox.addItem("Matches");
			comboBox.addItem("League");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	/**
	 * Create the frame.
	 */
	public Delete() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(207, 58, 126, 27);
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				a = (String) comboBox.getSelectedItem();
				fillComboBox1();

			}
		});
		contentPane.add(comboBox);

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(214, 135, 119, 27);
		contentPane.add(comboBox_1);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					b = (String) comboBox_1.getSelectedItem();

					String query = "";

					if (a == "Teams") {
						query = "delete from teams where Team_Name = ?";
					} else if (a == "Players") {
						query = "delete from players where Player_name = ?";
					} else if (a == "Stadiums") {
						query = "delete from stadium where Stadium_Name = ?";
					} else if (a == "Coaches") {
						query = "delete from coach where Coach_Name = ?";
					} else if (a == "Matches") {
						query = "delete from match_info where match_id = ?";
					} else if (a == "League") {
						query = "delete from league where season = ?";
					}

					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, b);

					pst.execute();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSubmit.setBounds(134, 210, 117, 29);
		contentPane.add(btnSubmit);
		fillComboBox();
	}
}
