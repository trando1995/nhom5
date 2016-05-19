package present;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
// TODO: Auto-generated Javadoc


import Data_access.Database;

/**
 * tạo giao diện vé tháng
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class VeThang extends JFrame {
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The btn cap nhat. */
	private JButton btnCapNhat;
	
	/** The month. */
	private int month;
	
	/** The thangtruoc. */
	private int thangtruoc = 0;


	/**
	 * Create the frame.
	 */
	public VeThang() {
		super("Quản Lý Vé Tháng");
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnToVThng = new JButton("T\u1EA1o V\u00E9 Th\u00E1ng");
		btnToVThng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TaoVeThang frame = new TaoVeThang();
				frame.setVisible(true);
			}
		});
		btnToVThng.setBounds(42, 30, 165, 53);
		contentPane.add(btnToVThng);
		
		JButton btnngTinV = new JButton("\u0110\u00F3ng ti\u1EC1n V\u00E9");
		btnngTinV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DongTienVe frame = new DongTienVe();
				frame.setVisible(true);
			}
		});
		btnngTinV.setBounds(250, 30, 152, 53);
		contentPane.add(btnngTinV);
		
		btnCapNhat = new JButton("C\u1EADp Nh\u1EADt Th\u00E1ng M\u1EDBi");
		final Calendar cal = Calendar.getInstance();
		month = cal.get(Calendar.MONTH) + 1;
		
		btnCapNhat.setBounds(42, 128, 169, 56);
		contentPane.add(btnCapNhat);
		if (month > thangtruoc) {
			btnCapNhat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						
						capNhat();
						JOptionPane.showMessageDialog(null, "cap nhat thanh cong" );
					
				}
			});
			thangtruoc = month;

		}
		else btnCapNhat.setEnabled(false);
		
		
		
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnThot.setBounds(250, 128, 152, 56);
		contentPane.add(btnThot);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap9.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 250);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * cập nhật hạn sử dụng của vé tháng sau khi qua tháng mới.
	 */
	public void capNhat() {
		
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;	//lay chi so thang
		String str = "thang" + month ;	//lay ten cot trong bang dongtienvethang trong sql
		try {
			
			Database.loadData();
			String sql = "SELECT* FROM vethang";	
			ResultSet rs = Database.result(sql);
			while (rs.next()) {
				
				String sql1 = "SELECT* FROM dongtienvethang ";
					ResultSet rst = Database.result(sql1);
					while (rst.next()) {

						if (rst.getString("mave").equals(rs.getString("mave"))) {
							if (rst.getString(str).equals("1")) {
								
								String sql2 = "UPDATE vethang SET hansudung = '1' WHERE mave='" + rs.getString("mave") +"'";				
								PreparedStatement pstm = Database.getCon().prepareStatement(sql2);
								pstm.executeUpdate();						
								pstm.close();
								
							}
							else {
								String sql2 = "UPDATE vethang SET hansudung = '0' WHERE mave='" + rs.getString("mave") +"'";				
								PreparedStatement pstm = Database.getCon().prepareStatement(sql2);
								pstm.executeUpdate();						
								pstm.close();
								
							}
						}
						
					}
				
				
				
					
					
				}
//				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	
}
