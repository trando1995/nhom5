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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
// TODO: Auto-generated Javadoc


import Data_access.Database;

/**
 * tạo giao diện tạo tài khoản
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class TaoTaiKhoan extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The hoten. */
	private JTextField hoten;
	
	/** The taikhoan. */
	private JTextField taikhoan;
	
	/** The matkhau. */
	private JPasswordField matkhau;
	
	/** The sodt. */
	private JTextField sodt;
	
	/** The diachi. */
	private JTextField diachi;
	
	/** The ch. */
	private char [] ch = new char[20];
	
	/** The chucvu. */
	private JComboBox chucvu;


	/**
	 * Create the frame.
	 */
	public TaoTaiKhoan() {
		super("Tạo Tài Khoản");
		setBounds(100, 100, 499, 435);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setBounds(147, 56, 46, 14);
		contentPane.add(lblHTn);
		
		hoten = new JTextField();
		hoten.setBounds(220, 53, 223, 20);
		contentPane.add(hoten);
		hoten.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("t\u00E0i kho\u1EA3n");
		lblNewLabel.setBounds(147, 95, 62, 14);
		contentPane.add(lblNewLabel);
		
		taikhoan = new JTextField();
		taikhoan.setBounds(220, 92, 223, 20);
		contentPane.add(taikhoan);
		taikhoan.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("m\u1EADt kh\u1EA9u");
		lblMtKhu.setBounds(147, 130, 62, 14);
		contentPane.add(lblMtKhu);
		
		matkhau = new JPasswordField();
		matkhau.setBounds(220, 127, 223, 20);
		contentPane.add(matkhau);
		
		JLabel lblSinThoi = new JLabel("s\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setBounds(147, 170, 95, 14);
		contentPane.add(lblSinThoi);
		
		sodt = new JTextField();
		sodt.setBounds(220, 167, 223, 20);
		contentPane.add(sodt);
		sodt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u0111\u1ECBa ch\u1EC9");
		lblNewLabel_1.setBounds(147, 212, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		diachi = new JTextField();
		diachi.setBounds(220, 209, 224, 20);
		contentPane.add(diachi);
		diachi.setColumns(10);
		
		JLabel lblChcV = new JLabel("ch\u1EE9c v\u1EE5");
		lblChcV.setBounds(147, 248, 46, 14);
		contentPane.add(lblChcV);
		
		chucvu = new JComboBox();
		chucvu.setModel(new DefaultComboBoxModel(new String[] {"nhan xe", "tra xe", "quan ly"}));
		chucvu.setBounds(220, 245, 223, 20);
		contentPane.add(chucvu);
		
		JButton btnTao = new JButton("T\u1EA1o");
		btnTao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (conect()==true) {
					JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công");
					dispose();
				}
				
			}
			
		});
		btnTao.setBounds(147, 302, 101, 38);
		contentPane.add(btnTao);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(290, 302, 101, 38);
		contentPane.add(btnThoat);
		JLabel lblNewLabel_n = new JLabel("");
		lblNewLabel_n.setIcon(new ImageIcon("data\\icon\\dangnhap3.jpg"));
		lblNewLabel_n.setBounds(0, 0,499, 435);
		contentPane.add(lblNewLabel_n);
	}
	
	/**
	 * tạo thông tin tài khoản của nhân viên vào cơ sở dữ liệu.
	 *
	 * @return true, if successful
	 */
	public boolean conect() {
		
		try {
			Database.loadData();
			ch = matkhau.getPassword();
			String tk = taikhoan.getText();
			String mk = new String(ch);
			String ten = hoten.getText();
			String sdt = sodt.getText();
			String dc = diachi.getText();
			String cv = chucvu.getSelectedItem().toString();
			
			String ins = "INSERT INTO NHANVIEN (taikhoan, matkhau, hoten, sodt,diachi,chucvu)" + "VALUES (?, ?, ?, ?, ?, ?)";
			String sql = "SELECT * FROM nhanvien";
			
			PreparedStatement sttm = Database.getCon().prepareStatement(ins);
			
			ResultSet rs = Database.result(sql);
			while (rs.next()) {
				if (rs.getString("taikhoan").equals(tk)) {
					JOptionPane.showMessageDialog(null, "tài khoản đã tồn tại");
					return false;
				} else {
					if (tk.equals("") || mk.equals("") || ten.equals("") || sdt.equals("")
							|| dc.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Yêu cầu nhập đầy đủ thông tin");
						return false;
					}

				}
			}
			sttm.setString(1, tk);
			sttm.setString(2, mk);
			sttm.setString(3, ten);
			sttm.setString(4, sdt);
			sttm.setString(5, dc);
			sttm.setString(6, cv);
			sttm.executeUpdate();
			
			sttm.close();
			return true;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
				
	}

}
