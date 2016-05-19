package present;

import java.awt.Font;
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
 * tạo giao diện mất vé
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class MatVe extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The ma ve. */
	private JTextField maVe;


	/**
	 * Create the frame.
	 */
	public MatVe() {
		super("Mất Vé");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMV = new JLabel("M\u00E3 V\u00E9");
		lblMV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMV.setBounds(46, 85, 60, 14);
		contentPane.add(lblMV);

		maVe = new JTextField();
		maVe.setBounds(127, 73, 221, 43);
		contentPane.add(maVe);
		maVe.setColumns(10);

		JButton btnKhoa = new JButton("Kh\u00F3a");
		btnKhoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(xuLy()==true) {
					JOptionPane.showMessageDialog(null, "Xử Lý Thành Công");
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Nhập lại mã vé");
			}
		});
		btnKhoa.setBounds(153, 158, 111, 33);
		contentPane.add(btnKhoa);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap10.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 300);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * thêm thông tin vào cột ghi chú trong bảng cơ sở dữ liệu.
	 *
	 * @return true, if successful
	 */
	public boolean xuLy() {
		try {
			Database.loadData();
			String sql = "SELECT* FROM ve";
			ResultSet rs = Database.result(sql);
			String str = "";
			while (rs.next()) {
				if (rs.getString("mave").equals(maVe.getText())) {

					str = "UPDATE thongke SET ghichu='Mat Ve' WHERE giogui = (SELECT giogui FROM ve WHERE mave='" + maVe.getText() + "')";
					PreparedStatement pstm = Database.getCon()
							.prepareStatement(str);
					pstm.executeUpdate();
					pstm.close();
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
}
