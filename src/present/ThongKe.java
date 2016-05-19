package present;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
// TODO: Auto-generated Javadoc


import Data_access.Database;

/**
 * tạo giao diện thống kê doanh thu của bãi gửi xe
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class ThongKe extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The table. */
	private JTable table;
	
	/** The thang. */
	private JComboBox thang;
	
	/** The nam. */
	private JComboBox nam;
	
	/** The dtm. */
	DefaultTableModel dtm = new DefaultTableModel();

	/**
	 * Create the frame.
	 */
	public ThongKe() {
		super("Thống Kê Doanh Thu");
		setBounds(100, 100, 500, 370);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblThngKDoanh = new JLabel(
				"Th\u1ED1ng K\u00EA Doanh Thu Theo Th\u00E1ng");
		lblThngKDoanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngKDoanh.setBounds(77, 23, 308, 48);
		contentPane.add(lblThngKDoanh);

		JLabel lblThng = new JLabel("Th\u00E1ng");
		lblThng.setBounds(77, 85, 46, 14);
		contentPane.add(lblThng);

		thang = new JComboBox();
		thang.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3",
				"4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		thang.setBounds(131, 82, 61, 20);
		contentPane.add(thang);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 177, 431, 123);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNm = new JLabel("N\u0103m");
		lblNm.setBounds(229, 85, 46, 14);
		contentPane.add(lblNm);

		nam = new JComboBox();
		nam.setModel(new DefaultComboBoxModel(new String[] { "2015", "2016",
				"2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024",
				"2025" }));
		nam.setBounds(279, 85, 94, 20);
		contentPane.add(nam);

		JButton btnXem = new JButton("Xem");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showbang();
			}
		});
		btnXem.setBounds(186, 136, 89, 23);
		contentPane.add(btnXem);

		Vector colum;
		colum = new Vector();
		colum.add("Tháng");
		colum.add("Doanh Thu");
		dtm.setColumnIdentifiers(colum);
		table.setModel(dtm);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap12.jpg"));
		lblNewLabel.setBounds(0, 0, 500, 350);
		contentPane.add(lblNewLabel);

	}
	
	/**
	 * Xu ly.
	 *
	 * @return trả lại tổng số tiền của tháng
	 */
	public long xuLy() {
		long tongtien = 0;
		String str = "thang" + thang.getSelectedItem().toString();
		try {
			Database.loadData();
			String sql = "SELECT * FROM thongke WHERE MONTH(giogui) =' "
					+ thang.getSelectedItem().toString()
					+ "' and YEAR(giogui) ='"
					+ nam.getSelectedItem().toString() + "'";
			ResultSet rs = Database.result(sql);

			while (rs.next()) {

				tongtien += Integer.parseInt(rs.getString("thanhtoan"));

			}

			String sql2 = "SELECT * FROM vethang";

			ResultSet bvethang = Database.result(sql2);
			while (bvethang.next()) {
				
				String sql1 = "SELECT* FROM dongtienvethang ";
				ResultSet bdongtienvethang = Database.result(sql1);
				while (bdongtienvethang.next()) {
					if (bdongtienvethang.getString("mave").equals(bvethang.getString("mave"))) {
						if (bdongtienvethang.getString(str).equals("1")) {

							if (bvethang.getString("loaixe").equals("o to")) {

								String sql3 = "SELECT * FROM giaveoto";
								ResultSet rss = Database.result(sql3);

								while (rss.next()) {

									tongtien += Integer.parseInt(rss
											.getString("vethang"));

								}

							} else {
								String sql3 = "SELECT * FROM giavexemay";
								ResultSet rss = Database.result(sql3);

								while (rss.next()) {

									tongtien += Integer.parseInt(rss
											.getString("vethang"));

								}

							}

						}

					}
				}
			}

			return tongtien;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tongtien;
	}
	
	/**
	 * thêm dữ liệu vào bảng.
	 */
	public void showbang() {

		Vector row;

		row = new Vector();
		row.add(thang.getSelectedItem().toString());
		row.add(xuLy());
		dtm.addRow(row);

		table.setModel(dtm);
	}

}
