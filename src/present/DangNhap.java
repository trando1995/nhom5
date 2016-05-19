package present;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
 * tạo giao diện đăng nhập 
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class DangNhap extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The tfd tk. */
	public JTextField tfdTK;
	
	/** The pass. */
	private JPasswordField pass;
	
	/** The ch. */
	private char ch[] = new char [20];
	
	/** The tk. */
	private static String tk;
	
	/** The mk. */
	private static String mk;
	
	/** The chucvu. */
	private static String chucvu;

	

	/**
	 * Gets the tk.
	 *
	 * @return the tk
	 */
	public static String getTk() {
		return tk;
	}

	/**
	 * Gets the mk.
	 *
	 * @return the mk
	 */
	public static String getMk() {
		return mk;
	}

	/**
	 * Gets the chucvu.
	 *
	 * @return the chucvu
	 */
	public static String getChucvu() {
		return chucvu;
	}

	
	/**
	 * Create the frame.
	 */
	public DangNhap() {
		super("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 280);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTiKhon = new JLabel("T\u00E0i Kho\u1EA3n");
		lblTiKhon.setBounds(156, 85, 71, 14);
		contentPane.add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMtKhu.setBounds(156, 135, 71, 14);
		contentPane.add(lblMtKhu);
		
		tfdTK = new JTextField();
		tfdTK.setBounds(226, 82, 198, 20);
		contentPane.add(tfdTK);
		tfdTK.setColumns(10);
		
		JButton btnDN = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {			
					ch = pass.getPassword();
					String p = new String(ch);
					if (conection(tfdTK.getText(), p)==1) {
						Admin frame = new Admin();
						dispose();
						frame.setVisible(true);
					
					}
					else 
						if (conection(tfdTK.getText(), p)==2) {
							NhanXe frame = new NhanXe();
							dispose();
							frame.setVisible(true);
						}
						else
							if (conection(tfdTK.getText(), p)==3){
								
								TraXe frame = new TraXe();
								dispose();
								frame.setVisible(true);
							}
							
							else JOptionPane.showMessageDialog(null	, "tài khoản mật khẩu không đúng nhập lại");
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDN.setBounds(145, 186, 129, 23);
		contentPane.add(btnDN);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnThoat.setBounds(298, 186, 126, 23);
		contentPane.add(btnThoat);
		
		pass = new JPasswordField();
		pass.setBounds(226, 132, 198, 20);
		contentPane.add(pass);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dang nhap 2.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 250);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * kiểm tra thông tin nhập vào là tài khoản của nhân viên nào.
	 *
	 * @param tkhoan xâu lấy từ khung nhập từ textField
	 * @param mkhau xâu lấy mật khẩu từ Jpassworld
	 * @return 1 trong 3 giá trị 1: quản lý 2: nhận xe 3: trả xe
	 */
	public static int conection(String tkhoan, String mkhau)
			 {
		
		String sql = "SELECT * FROM nhanvien";
		try {
			Database.loadData();
			ResultSet rs = Database.result(sql);
			while (rs.next()) {
				tk = rs.getString("taikhoan");
				mk = rs.getString("matkhau");
				chucvu = rs.getString("chucvu");
				System.out.print(chucvu);
				if (tk.equals(tkhoan) && mk.equals(mkhau)
						&& chucvu.equals("quan ly")) {

					return 1;
				} else if (tk.equals(tkhoan) && mk.equals(mkhau)
						&& chucvu.equals("nhan xe")) {

					return 2;
				} else if (tk.equals(tkhoan) && mk.equals(mkhau)
						&& chucvu.equals("tra xe")) {

					return 3;
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
