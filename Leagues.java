import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leagues extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leagues frame = new Leagues();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void fillComboBox() {
		try {
			comboBox.removeAllItems();
			comboBox.addItem("2015");
			comboBox.addItem("2016");

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);

		}

	}

	/**
	 * Create the frame.
	 */
	Connection conn = null;
	private JTable table;

	public Leagues() {
		conn = JDBCconn.dbconn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblYear = new JLabel("Year : ");
		lblYear.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblYear.setBounds(279, 28, 61, 16);
		contentPane.add(lblYear);

		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Papyrus", Font.PLAIN, 15));
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					String query = "select season,pos,Team_Name,GF,GA,(GF-GA) as GD,Pl,W,D,L,Points from league natural join teams where season = ?";
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
		comboBox.setBounds(352, 25, 141, 27);
		contentPane.add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 73, 792, 274);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnHome = new JButton("Return To Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w = new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(338, 376, 155, 29);
		contentPane.add(btnHome);

		fillComboBox();
	}
}
