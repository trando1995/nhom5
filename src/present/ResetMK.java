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

import Data_access.Database;
// TODO: Auto-generated Javadoc

/**
 * Tạo giao diện khởi tạo lại mật khẩu về mặc định
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class ResetMK extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The taikhoan. */
	private JTextField taikhoan;

	/**
	 * Create the frame.
	 */
	public ResetMK() {
		super("Thay Đổi Mật Khẩu");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTiKhon = new JLabel("T\u00E0i Kho\u1EA3n");
		lblTiKhon.setBounds(173, 66, 74, 14);
		contentPane.add(lblTiKhon);

		taikhoan = new JTextField();
		taikhoan.setBounds(142, 109, 179, 20);
		contentPane.add(taikhoan);
		taikhoan.setColumns(10);

		JButton btnResetMk = new JButton("reset MK");
		btnResetMk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (resetMK() == true) {
					JOptionPane.showMessageDialog(null,
							"reset mật khẩu thành công");
					dispose();
				} else
					JOptionPane.showMessageDialog(null, "Nhập lại tài khoản");
			}
		});
		btnResetMk.setBounds(108, 165, 101, 38);
		contentPane.add(btnResetMk);

		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(244, 165, 101, 38);
		contentPane.add(btnThoat);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap7.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 300);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * thay đổi mật khẩu trong cơ sở dữ liệu.
	 *
	 * @return true, if successful
	 */
	public boolean resetMK() {

		try {
			Database.loadData();
			String sql = "SELECT * FROM nhanvien";

			ResultSet rs = Database.result(sql);
			if (taikhoan.getText() == null)
				JOptionPane.showMessageDialog(null, "chưa nhập tài khoản");
			else {
				while (rs.next()) {
					if (rs.getString("taikhoan").equals(taikhoan.getText())) {
						String sqlt = "UPDATE nhanvien SET matkhau='12345678' WHERE taikhoan='"
								+ taikhoan.getText() + "'";
						PreparedStatement pstm = Database.getCon()
								.prepareStatement(sqlt);
						pstm.executeUpdate();
						pstm.close();
						return true;

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
}
