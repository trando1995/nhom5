package present;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
// TODO: Auto-generated Javadoc


import Data_access.Database;

/**
 * tạo giao diện gửi xe
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class TraXe extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The ma ve. */
	private static JTextField maVe;
	
	/** The table. */
	private JTable table;
	
	/** The btn tx. */
	private JButton btnTX;

	

	/**
	 * Create the frame.
	 */
	public TraXe() {
		super("Trả Xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 390);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMV = new JLabel("M\u00E3 V\u00E9");
		lblMV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMV.setBounds(42, 71, 84, 28);
		contentPane.add(lblMV);

		maVe = new JTextField();
		maVe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		maVe.setBounds(42, 110, 543, 64);
		contentPane.add(maVe);
		maVe.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 185, 543, 103);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnKT = new JButton("Ki\u1EC3m Tra");
		btnKT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (xuLy() == true) {

					showBang();
					btnTX.setEnabled(true);

				} else
					JOptionPane.showMessageDialog(null, "Nhập Lại Vé");

			}
		});
		btnKT.setBounds(623, 126, 89, 47);
		contentPane.add(btnKT);

		btnTX = new JButton("Tr\u1EA3 Xe");
		btnTX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (traXe() == true) {
					JOptionPane.showMessageDialog(null, "Trả Xe Thành Công");
					maVe.setText(null);
				} else
					JOptionPane.showMessageDialog(null,
							"Trả xe không thành Công, nhập lại mã vé");
				maVe.setText(null);
			}
		});
		btnTX.setBounds(623, 212, 89, 47);
		contentPane.add(btnTX);

		JLabel lblXinCho = new JLabel("Xin Ch\u00E0o: ");
		lblXinCho.setBounds(338, 11, 76, 14);
		contentPane.add(lblXinCho);

		JLabel lblTaiKhoan = new JLabel(DangNhap.getTk());
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTaiKhoan.setBounds(407, 11, 178, 14);
		contentPane.add(lblTaiKhoan);

		JButton btnDX = new JButton("\u0110\u0103ng Xu\u1EA5t");
		btnDX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap frame = new DangNhap();
				dispose();
				frame.setVisible(true);
			}
		});
		btnDX.setBounds(604, 7, 120, 23);
		contentPane.add(btnDX);

		JButton btnDMK = new JButton("\u0110\u1ED5i M\u1EADt Kh\u1EA9u");
		btnDMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiMK frame = new DoiMK();
				frame.setVisible(true);

			}
		});
		btnDMK.setBounds(604, 39, 120, 23);
		contentPane.add(btnDMK);
		btnTX.setEnabled(false);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap14.jpg"));
		lblNewLabel.setBounds(0, -25, 744, 386);
		contentPane.add(lblNewLabel);

	}
	
	/**
	 * kiểm tra xem mã vé có trong thông tin xe đang gửi không.
	 *
	 * @return true, if successful
	 */
	public boolean xuLy() {

		try {
			Database.loadData();
			String sql = "SELECT * FROM ve";
			ResultSet rs = Database.result(sql);

			while (rs.next()) {
				if (rs.getString("mave").equals(maVe.getText())) {
					return true;
				}

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	/**
	 * hiển thị thông tin xe đang gửi.
	 */
	public void showBang() {

		try {
			Database.loadData();
			String sql = "SELECT * FROM ve";
			DefaultTableModel dtm = new DefaultTableModel();
			ResultSet rs = Database.result(sql);
			PreparedStatement pstmt = Database.getCon().prepareStatement(sql);
			ResultSetMetaData metadata = pstmt.getMetaData();
			int number = metadata.getColumnCount(); // lay so luong cot tren
													// csdl
			Vector row, colum;

			colum = new Vector();
			for (int i = 1; i <= number; i++) {
				colum.add(metadata.getColumnName(i)); // lay ten cua cot
			}

			dtm.setColumnIdentifiers(colum); // dung de add chi so cot vao
												// Jtable

			while (rs.next()) {
				if (rs.getString("mave").equals(maVe.getText())) {
					row = new Vector();
					for (int i = 1; i <= number; i++) {
						row.add(rs.getString(i));
					}
					dtm.addRow(row);
				}
			}
			table.setModel(dtm);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * trả xe cập nhật lại thông tin trong cơ sở dữ liệu.
	 *
	 * @return true, if successful
	 */
	public boolean traXe() {
		Date dNow = new Date();
		long gio = dNow.getTime();
		java.sql.Timestamp time = new java.sql.Timestamp(gio);
		try {
			Database.loadData();

			

			String sql = "SELECT* FROM thongke ";
			ResultSet rs = Database.result(sql);
			String bangVe;
			while (rs.next()) {

				if (rs.getString("mave").equals(maVe.getText())) {

					String update = "UPDATE thongke SET giotra = '" + time
							+ "' WHERE giogui = (SELECT giogui FROM ve WHERE mave='" + maVe.getText() + "')";
					PreparedStatement psstm = Database.getCon()
							.prepareStatement(update);
					psstm.executeUpdate();
					psstm.close();

					String sql2 = "SELECT* FROM sochocontrong ";
					ResultSet rss = Database.result(sql2);

					
					
					while (rss.next()) {
						String str1 = "UPDATE sochocontrong SET "
								+ rs.getString("loaixe") + "= '"
								+ (rss.getInt(rs.getString("loaixe")) + 1)
								+ "'";
						PreparedStatement stm = Database.getCon()
								.prepareStatement(str1);
						stm.executeUpdate();
						stm.close();

						
						
						
						if (rs.getString("loaive").equals("VENGAY")) {

							
							if (rs.getString("loaixe").equals("oto")) {
								bangVe = "SELECT * FROM giaveoto";
							} else
								bangVe = "SELECT * FROM giavexemay";

							ResultSet rst = Database.result(bangVe);
							while (rst.next()) {

								String sql1 = "UPDATE thongke SET thanhtoan='"
										+ tinhNgay()
										* Integer.parseInt(rst
												.getString("vengay"))
										+ "' WHERE giogui= (SELECT giogui FROM ve WHERE mave='" + maVe.getText() + "')";
								PreparedStatement psttm = Database.getCon()
										.prepareStatement(sql1);
								
								
								
								psttm.executeUpdate();
								psttm.close();
								String str = "DELETE FROM ve " + "WHERE mave='" + maVe.getText()
										+ "'";
								PreparedStatement pstm = Database.getCon().prepareStatement(str);
								pstm.executeUpdate();
								pstm.close();
								return true;

							}
						}
						
						else {
							
							String sql1 = "UPDATE thongke SET thanhtoan='0' WHERE giogui= (SELECT giogui FROM ve WHERE mave='" + maVe.getText() + "')";
							PreparedStatement psttm = Database.getCon()
									.prepareStatement(sql1);
							
							String str = "DELETE FROM ve " + "WHERE mave='" + maVe.getText()
									+ "'";
							PreparedStatement pstm = Database.getCon().prepareStatement(str);
							pstm.executeUpdate();
							pstm.close();
							
							
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

		return false;
	}
	
	/**
	 * tính số ngày gửi của xe.
	 *
	 * @return the long
	 */
	public static long tinhNgay() {
	
		try {
			Database.loadData();
			String sql = "SELECT * FROM thongke ";
			ResultSet rs = Database.result(sql);

			while (rs.next()) {

				if (rs.getString("mave").equals(maVe.getText())) {

					Date t = rs.getDate("giogui");
					long giogui = t.getTime();
					Date t2 = rs.getDate("giotra");
					long giotra = t2.getTime();
					return (giogui - giotra) / (24 * 3600 * 1000) + 1;
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
