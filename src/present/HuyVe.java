package present;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
 * tạo giao diện hủy vé
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class HuyVe extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The ma ve. */
	private JTextField maVe;


	/**
	 * Create the frame.
	 */
	public HuyVe() {
		super("Hủy Vé");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHu = new JLabel("M\u00E3 V\u00E9");
		lblHu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHu.setBounds(39, 69, 67, 19);
		contentPane.add(lblHu);
		
		maVe = new JTextField();
		maVe.setBounds(116, 60, 242, 40);
		contentPane.add(maVe);
		maVe.setColumns(10);
		
		JButton btnHuyVe = new JButton("H\u1EE7y V\u00E9");
		btnHuyVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(xuLy()==true) {
					JOptionPane.showMessageDialog(null, "Hủy vé thành công");
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Nhập Lại Mã Vé");
			}
		});
		btnHuyVe.setBounds(152, 145, 118, 40);
		contentPane.add(btnHuyVe);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap10.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 300);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * xóa toàn bộ thông tin của vé trong cơ sở dữ liệu.
	 *
	 * @return trả lại giá trị đúng sai
	 */
	public boolean xuLy() {
		Date dNow = new Date();
		long gio = dNow.getTime();
		java.sql.Timestamp time = new java.sql.Timestamp(gio);
		
		
		try {
			Database.loadData();
			String sql = "SELECT* FROM thongke";
			ResultSet rs = Database.result(sql);
			
			while (rs.next()) {
				if(rs.getString("mave").equals(maVe.getText()) && rs.getString("ghichu").equals("Mat Ve")) {
					if (rs.getString("loaive").equals("vethang")) {
						String str = "DELETE FROM vethang WHERE mave='" + maVe.getText() +"'";
						PreparedStatement pstm = Database.getCon()
								.prepareStatement(str);
						pstm.executeUpdate();
						pstm.close();
						
						String str2 = "DELETE FROM dongtienvethang WHERE mave='" + maVe.getText() + "'";
						PreparedStatement psstm = Database.getCon()
								.prepareStatement(str2);
						psstm.executeUpdate();
						psstm.close();
						
						String sql1 = "UPDATE thongke SET thanhtoan='0' WHERE giogui= (SELECT giogui FROM ve WHERE mave='" + maVe.getText() + "')";
						PreparedStatement psttm = Database.getCon()
								.prepareStatement(sql1);
						
						
						
						psttm.executeUpdate();
						psttm.close();
						return true;
						
					}
					else {
						String str = "DELETE FROM vengay WHERE mave='" + maVe.getText() +"'";
						PreparedStatement pstm = Database.getCon()
								.prepareStatement(str);
						pstm.executeUpdate();
						pstm.close();
						
						String sql1 = "UPDATE thongke SET thanhtoan='0' WHERE giogui= (SELECT giogui FROM ve WHERE mave='" + maVe.getText() + "')";
						PreparedStatement psttm = Database.getCon()
								.prepareStatement(sql1);
						
						
						
						psttm.executeUpdate();
						psttm.close();
						
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
