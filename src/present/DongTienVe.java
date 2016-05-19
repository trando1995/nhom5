package present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
// TODO: Auto-generated Javadoc

import Data_access.Database;

/**
 * tạo giao diện đóng tiền vé
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class DongTienVe extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The mave. */
	private JTextField mave;
	
	/** The thangdong. */
	private JComboBox thangdong;
	
	/** The namdong. */
	private JComboBox namdong;

	/**
	 * Create the frame.
	 */
	public DongTienVe() {
		super("Đóng Tiền Vé Tháng");
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMaVe = new JLabel("M\u00E3 V\u00E9");
		lblMaVe.setBounds(25, 58, 46, 14);
		contentPane.add(lblMaVe);

		mave = new JTextField();
		mave.setBounds(104, 55, 222, 20);
		contentPane.add(mave);
		mave.setColumns(10);

		JLabel lblThngng = new JLabel("Th\u00E1ng");
		lblThngng.setBounds(25, 96, 59, 14);
		contentPane.add(lblThngng);

		thangdong = new JComboBox();
		thangdong.setModel(new DefaultComboBoxModel(new String[] { "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		thangdong.setBounds(104, 93, 222, 20);
		contentPane.add(thangdong);

		JLabel lblNm = new JLabel("N\u0103m");
		lblNm.setBounds(25, 144, 46, 14);
		contentPane.add(lblNm);

		namdong = new JComboBox();
		namdong.setModel(new DefaultComboBoxModel(new String[] { "2015",
				"2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023",
				"2024", "2025" }));
		namdong.setBounds(104, 141, 222, 20);
		contentPane.add(namdong);

		JButton btnng = new JButton("N\u1ED9p Ti\u1EC1n");
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (load() == true) {
					JOptionPane.showMessageDialog(null, "nộp tiền thành công");
					dispose();
				}

				else
					JOptionPane.showMessageDialog(null,
							"Nộp tiền không thành công nhập lại");
			}
		});
		btnng.setBounds(68, 190, 103, 36);
		contentPane.add(btnng);

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setBounds(222, 190, 104, 36);
		contentPane.add(btnThot);
	}
	
	/**
	 * update thông tin của bảng dongtienvethang.
	 *
	 * @return true, if successful
	 */
	public boolean load() {
		Calendar cal = Calendar.getInstance();
		int thang = Integer.parseInt(thangdong.getSelectedItem().toString());
		int month = cal.get(Calendar.MONTH) + 1;

		int nam = Integer.parseInt(namdong.getSelectedItem().toString());
		int year = cal.get(Calendar.YEAR);
		if (thang < month && (nam<=year || nam-year>=2))
			return false;
		else {
			try {
				Database.loadData();
				String sql = "SELECT * FROM vethang";
				ResultSet rs = Database.result(sql);
				String sql1 = ""; // xac dinh de select toi bang gia ve
				String giave = ""; // gia ve
				String sl = ""; // update bang dongtien ve

				String str = "SELECT* FROM dongtienvethang";

				String cot = "thang" + thang;
				ResultSet rst = Database.result(str);
				while (rst.next()) {
					if (rst.getString(cot).equals("1"))
						return false;					
					else {

						switch (thang) {
						case 1:
							sl = "UPDATE dongtienvethang SET thang1 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 2:
							sl = "UPDATE dongtienvethang SET thang2 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 3:
							sl = "UPDATE dongtienvethang SET thang3 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 4:
							sl = "UPDATE dongtienvethang SET thang4 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 5:
							sl = "UPDATE dongtienvethang SET thang5 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 6:
							sl = "UPDATE dongtienvethang SET thang6 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 7:
							sl = "UPDATE dongtienvethang SET thang7 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 8:
							sl = "UPDATE dongtienvethang SET thang8 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 9:
							sl = "UPDATE dongtienvethang SET thang9 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 10:
							sl = "UPDATE dongtienvethang SET thang10 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 11:
							sl = "UPDATE dongtienvethang SET thang11 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;
						case 12:
							sl = "UPDATE dongtienvethang SET thang12 = '1' WHERE mave='"
									+ mave.getText() + "'";
							break;

						default:
							break;
						}

						while (rs.next()) {

							if (rs.getString("mave").equals(mave.getText())) {

								if (rs.getString("loaixe").equals("o to")) {
									sql1 = "SELECT* FROM giaveoto";
								} else if (rs.getString("loaixe").equals(
										"xe may")) {
									sql1 = "SELECT* FROM giavexemay";
								}
								ResultSet rs1 = Database.result(sql1);
								while (rs1.next()) {

									giave = rs1.getString("vethang");
								}
							
								JOptionPane.showMessageDialog(null, "So tien: "
										+ giave);

								PreparedStatement psttm = Database.getCon()
										.prepareStatement(sl);
								psttm.executeUpdate();

								psttm.close();

								return true;

							}

						}

					}
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}
}
