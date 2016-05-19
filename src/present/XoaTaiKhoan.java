package present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
// TODO: Auto-generated Javadoc


import Data_access.Database;

/**
 * tạo giao diện xóa tài khoản
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class XoaTaiKhoan extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The taikhoan. */
	private JTextField taikhoan;


	/**
	 * Create the frame.
	 */
	public XoaTaiKhoan() {
		super("Xóa Tài Khoản Nhân Viên");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTiKhon = new JLabel("T\u00E0i Kho\u1EA3n");
		lblTiKhon.setBounds(165, 71, 92, 14);
		contentPane.add(lblTiKhon);
		
		taikhoan = new JTextField();
		taikhoan.setBounds(136, 104, 181, 20);
		contentPane.add(taikhoan);
		taikhoan.setColumns(10);
		
		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (xoaTK() == true) {
						JOptionPane.showMessageDialog(null,
								"Xóa tài khoản thành công");
						dispose();
					} else
						JOptionPane.showMessageDialog(null,
								"Nhập lại tài khoản");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnXoa.setBounds(110, 176, 102, 39);
		contentPane.add(btnXoa);
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThot.setBounds(242, 176, 102, 39);
		contentPane.add(btnThot);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap6.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 300);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * xóa thông tin tài khoản.
	 *
	 * @return true, if successful
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public boolean xoaTK() throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM nhanvien";
		Database.loadData();
		
		

		ResultSet rs = Database.result(sql);
		if (taikhoan.getText() == null)
			JOptionPane.showMessageDialog(null, "chưa nhập tài khoản");
		else {
			while (rs.next()) {
				if (rs.getString("taikhoan").equals(taikhoan.getText()) && rs.getString("taikhoan").equals("admin")== false) {
					String sqlt = "DELETE FROM nhanvien where taikhoan='"
							+ taikhoan.getText() + "'";
					PreparedStatement pstm = Database.getCon().prepareStatement(sqlt);
					pstm.executeUpdate();
					pstm.close();
					return true;
					
				}
			}
		}
		return false;
	}
}
