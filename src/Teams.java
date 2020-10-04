import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Teams extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	JComboBox<String> comboBox, comboBox_1;
	String a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teams frame = new Teams();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection conn = null;
	private JTextField textField_1;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	public void fillComboBox() {
		try {
			comboBox.removeAllItems();
			String query = "select distinct(City) from teams";
			PreparedStatement pst = conn.prepareStatement(query);
			comboBox.addItem("none");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				comboBox.addItem(rs.getString(1));
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	public void fillComboBox1() {
		try {
			comboBox_1.removeAllItems();
			comboBox_1.addItem("none");
			comboBox_1.addItem("Nationality");
			comboBox_1.addItem("Position");
			comboBox_1.addItem("Contract Start Year");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	public Teams() {
		conn = JDBCconn.dbconn();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 868);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 81, 781, 241);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					int row = table.getSelectedRow();

					String c = (table.getModel().getValueAt(row, 0).toString());

					String query = "select * from players where team_id = ? ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, c);

					ResultSet rs = pst.executeQuery();

					table_1.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();

					fillComboBox1();

					String query2 = "select Stadium_id,Stadium_Name,Capacity from stadium where team_id = ? ";
					PreparedStatement pst2 = conn.prepareStatement(query2);
					pst2.setString(1, c);

					ResultSet rs1 = pst2.executeQuery();

					table_2.setModel(DbUtils.resultSetToTableModel(rs1));

					pst2.close();

					String query3 = "select Coach_id,concat(First_Name,Last_Name) as Coach_Name,Nationality,contract_start from coach where team_id = ? ";
					PreparedStatement pst3 = conn.prepareStatement(query3);
					pst3.setString(1, c);

					ResultSet rs2 = pst3.executeQuery();

					table_3.setModel(DbUtils.resultSetToTableModel(rs2));

					pst3.close();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		scrollPane.setViewportView(table);

		JButton btnLoadData = new JButton("List All Teams");
		btnLoadData.setBounds(45, 28, 142, 34);
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from teams natural join own";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs = pst.executeQuery();

					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		contentPane.add(btnLoadData);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(479, 34, 180, 27);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from teams natural join own where City = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, (String) comboBox.getSelectedItem());
					ResultSet rs = pst.executeQuery();

					table.setModel(DbUtils.resultSetToTableModel(rs));

					rs.close();
					pst.close();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}

			}
		});
		comboBox.setFont(new Font("Papyrus", Font.PLAIN, 15));
		contentPane.add(comboBox);

		JLabel lblNewLabel = new JLabel("Teams from City : ");
		lblNewLabel.setBounds(310, 35, 135, 16);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 379, 781, 351);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Players", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(19, 62, 714, 146);
		panel.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		JLabel lblRefineYourSearch = new JLabel("Refine your Search :");
		lblRefineYourSearch.setBounds(29, 255, 165, 16);
		panel.add(lblRefineYourSearch);
		lblRefineYourSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

		comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Papyrus", Font.PLAIN, 13));
		comboBox_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				a = (String) comboBox_1.getSelectedItem();

			}
		});
		comboBox_1.setBounds(186, 252, 172, 27);
		panel.add(comboBox_1);

		textField_1 = new JTextField();
		textField_1.setBounds(512, 251, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					if (a == "Nationality") {

						int row = table.getSelectedRow();

						String c = (table.getModel().getValueAt(row, 0).toString());

						String query = "select * from players where team_id = ? and Nationality = ? ";
						PreparedStatement pst = conn.prepareStatement(query);

						pst.setString(1, c);
						pst.setString(2, textField_1.getText());
						ResultSet rs1 = pst.executeQuery();

						table_1.setModel(DbUtils.resultSetToTableModel(rs1));

						pst.close();

					} else if (a == "Position") {

						int row = table.getSelectedRow();

						String c = (table.getModel().getValueAt(row, 0).toString());

						String query = "select * from players where team_id = ? and Position = ? ";
						PreparedStatement pst = conn.prepareStatement(query);

						pst.setString(1, c);
						pst.setString(2, textField_1.getText());
						ResultSet rs1 = pst.executeQuery();

						table_1.setModel(DbUtils.resultSetToTableModel(rs1));

						pst.close();

					} else if (a == "Contract Start Year") {

						int row = table.getSelectedRow();

						String c = (table.getModel().getValueAt(row, 0).toString());

						String query = "select * from players where team_id = ? and year_start = ? ";
						PreparedStatement pst = conn.prepareStatement(query);

						pst.setString(1, c);
						pst.setString(2, textField_1.getText());
						ResultSet rs1 = pst.executeQuery();

						table_1.setModel(DbUtils.resultSetToTableModel(rs1));

						pst.close();

					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton.setBounds(647, 251, 86, 29);
		panel.add(btnNewButton);

		JLabel lblEnterData = new JLabel("Enter Data");
		lblEnterData.setBounds(424, 256, 73, 16);
		panel.add(lblEnterData);

		JButton btnListAllPlayers = new JButton("List All Players");
		btnListAllPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select * from players ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs1 = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnListAllPlayers.setBounds(310, 21, 117, 29);
		panel.add(btnListAllPlayers);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Stadium", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(29, 75, 705, 187);
		panel_1.add(scrollPane_2);

		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);

		JButton btnListAllStadiums = new JButton("List All Stadiums");
		btnListAllStadiums.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select Stadium_id,Stadium_Name,Capacity from stadium ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs1 = pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnListAllStadiums.setBounds(307, 22, 156, 29);
		panel_1.add(btnListAllStadiums);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Coaches", null, panel_2, null);
		panel_2.setLayout(null);

		JButton btnListAllCoaches = new JButton("List All Coaches");
		btnListAllCoaches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select Coach_id,concat(First_Name,Last_Name) as Coach_Name,Nationality,contract_start from coach ";
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs1 = pst.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs1));
				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnListAllCoaches.setBounds(313, 20, 137, 29);
		panel_2.add(btnListAllCoaches);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(25, 69, 709, 191);
		panel_2.add(scrollPane_3);

		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);

		JLabel lblSelectATeam = new JLabel(
				"Note : Select a Team from the list above to know its Home Stadium, Coach and Players");
		lblSelectATeam.setForeground(Color.RED);
		lblSelectATeam.setFont(new Font("Kokonor", Font.PLAIN, 13));
		lblSelectATeam.setBounds(165, 344, 494, 16);
		contentPane.add(lblSelectATeam);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(25, 344, 128, 12);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(660, 344, 147, 12);
		contentPane.add(separator_1);

		JButton btnReturnToHome = new JButton("Return To Home");
		btnReturnToHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w = new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		btnReturnToHome.setBounds(351, 726, 135, 29);
		contentPane.add(btnReturnToHome);

		fillComboBox();

	}
}
