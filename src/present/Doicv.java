package present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
 * tạo giao diện đổi công việc của nhân viên
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class Doicv extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The taikhoan. */
	private JTextField taikhoan;
	
	/** The chucvu. */
	private JComboBox chucvu;

	

	/**
	 * Create the frame.
	 */
	public Doicv() {
		super("Đổi Công Việc");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTiKhon = new JLabel("T\u00E0i Kho\u1EA3n");
		lblTiKhon.setBounds(114, 66, 80, 14);
		contentPane.add(lblTiKhon);
		
		taikhoan = new JTextField();
		taikhoan.setBounds(176, 63, 211, 20);
		contentPane.add(taikhoan);
		taikhoan.setColumns(10);
		
		JLabel lblChcV = new JLabel("Ch\u1EE9c V\u1EE5");
		lblChcV.setBounds(114, 116, 52, 14);
		contentPane.add(lblChcV);
		
		chucvu = new JComboBox();
		chucvu.setModel(new DefaultComboBoxModel(new String[] {"nhan xe", "tra xe", "quan ly"}));
		chucvu.setBounds(176, 113, 211, 20);
		contentPane.add(chucvu);
		
		JButton btnDoi = new JButton("Thay \u0111\u1ED5i");
		btnDoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (doi() == true) {
						JOptionPane.showMessageDialog(null,
								"Đổi công việc thành công");
						dispose();
					}
					else JOptionPane.showMessageDialog(null, "Nhập lại tài khoản");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDoi.setBounds(114, 176, 115, 38);
		contentPane.add(btnDoi);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(272, 176, 115, 38);
		contentPane.add(btnThoat);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap6.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 300);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * đổi công việc của nhân viên.
	 *
	 * @return trả lại giá trị true hoặc false
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public boolean doi() throws ClassNotFoundException, SQLException{
		
		String sql = "SELECT * FROM nhanvien";
	
		Database.loadData();
		ResultSet rs = Database.result(sql);
		if (taikhoan.getText()==null) JOptionPane.showMessageDialog(null, "chưa nhập tài khoản");
		else 
			{
			while (rs.next()) {
				if (rs.getString("taikhoan").equals(taikhoan.getText())) {
					String sqlt = "UPDATE nhanvien SET chucvu='" + chucvu.getSelectedItem().toString() +"' WHERE taikhoan='" + taikhoan.getText() + "'";
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
