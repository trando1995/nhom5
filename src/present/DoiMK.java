package present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
// TODO: Auto-generated Javadoc


import Data_access.Database;

/**
 * tạo giao diện đổi mật khẩu của tài khoản đang đăng nhập
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class DoiMK extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The mk cu. */
	private JPasswordField mkCu;
	
	/** The mk moi. */
	private  JPasswordField mkMoi;
	
	/** The nhaplai. */
	private JPasswordField nhaplai;
	
	/** The cu. */
	private char [] cu = new char[20];
	
	/** The moi. */
	private char [] moi = new char[20];
	
	/** The lai. */
	private char [] lai = new char[20];
	
	/** The mk3. */
	private static String mk3;

	

	/**
	 * Create the frame.
	 */
	public DoiMK() {
		super("Đổi Mật Khẩu");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMtKhuC = new JLabel("M\u1EADt kh\u1EA9u c\u0169");
		lblMtKhuC.setBounds(117, 44, 106, 14);
		contentPane.add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("M\u1EADt Kh\u1EA9u m\u1EDBi");
		lblMtKhuMi.setBounds(117, 88, 106, 14);
		contentPane.add(lblMtKhuMi);
		
		JLabel lblNhpLiMt = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u m\u1EDBi");
		lblNhpLiMt.setBounds(117, 126, 144, 14);
		contentPane.add(lblNhpLiMt);
		
		JButton btndoi = new JButton("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		btndoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemtra()==true) {
					try {
						updatemk(mk3);
						JOptionPane.showMessageDialog(null, "đổi mật khẩu thành công");
						dispose();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
				}
				else JOptionPane.showMessageDialog(null,"nhập không đúng yêu cầu nhập lại");
			}
		});
		btndoi.setBounds(140, 184, 119, 38);
		contentPane.add(btndoi);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(291, 184, 112, 38);
		contentPane.add(btnThoat);
		
		mkCu = new JPasswordField();
		mkCu.setBounds(250, 41, 180, 20);
		contentPane.add(mkCu);
		
		mkMoi = new JPasswordField();
		mkMoi.setBounds(250, 85, 180, 20);
		contentPane.add(mkMoi);
		
		nhaplai = new JPasswordField();
		nhaplai.setBounds(250, 123, 180, 20);
		contentPane.add(nhaplai);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap6.jpg"));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * kiểm tra thông tin nhập vào có đúng không.
	 *
	 * @return trả lại giá trị true hoặc false
	 */
	public boolean kiemtra() {
		cu = mkCu.getPassword();
		moi = mkMoi.getPassword();
		lai = nhaplai.getPassword();
		
		String mk1 = new String(cu);
		String mk2 = new String(moi);
		mk3 = new String(lai);
		System.out.print(DangNhap.getMk());
		if (mk1.equals(DangNhap.getMk()) && mk2.equals(mk3)) return true;
		
		return false;
	}
	
	/**
	 * thay đổi mật khẩu của tài khoản trong cơ sở dữ liệu.
	 *
	 * @param mk mật khẩu
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static void updatemk(String mk) throws ClassNotFoundException, SQLException{
		Database.loadData();
		String sql = "UPDATE NHANVIEN SET matkhau='" + mk +"' WHERE taikhoan='" + DangNhap.getTk() + "'" ;
		PreparedStatement pstmt = Database.getCon().prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		
	}
}
