package present;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
 * tạo giao diện nhận xe
 * xử lý các thao tác với cơ sở dữ liệu.
 *
 * @author duonganh
 */
public class NhanXe extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The table. */
	private JTable table;
	
	/** The bien so. */
	private JTextField bienSo;
	
	/** The ma ve. */
	private static JTextField maVe;
	
	/** The loai xe. */
	private static JComboBox loaiXe;
	
	/** The btn ve thang. */
	private JButton btnVeThang;
	
	/** The btn tao vn. */
	private JButton btnTaoVN;
	
	/** The btn nhan xe. */
	private JButton btnNhanXe;
	
	/** The loai ve. */
	private JComboBox loaiVe;



	/**
	 * Create the frame.
	 */
	public NhanXe() {
		super("Nhận Xe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setBounds(100, 100, 900, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 100, 576, 365);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblLoai = new JLabel("Lo\u1EA1i Xe");
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoai.setBounds(10, 90, 46, 34);
		contentPane.add(lblLoai);

		loaiXe = new JComboBox();
		loaiXe.setModel(new DefaultComboBoxModel(
				new String[] { "oto", "xemay" }));
		loaiXe.setBounds(66, 73, 129, 34);
		contentPane.add(loaiXe);

		JButton btnKTCho = new JButton("Ki\u1EC3m Tra Ch\u1ED7 Tr\u1ED1ng");
		btnKTCho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemTraCT()==true) {
					loaiVe.setEnabled(true);
					bienSo.setEditable(true);
					
					JOptionPane.showMessageDialog(null, "Còn Chỗ trống");
				}
					else {
						
						btnVeThang.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Không Còn Chỗ trống");
					}
				
			}
		});
		btnKTCho.setBounds(66, 118, 159, 34);
		contentPane.add(btnKTCho);

		JLabel lblBinS = new JLabel("Bi\u1EC3n S\u1ED1");
		lblBinS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBinS.setBounds(10, 176, 46, 20);
		contentPane.add(lblBinS);

		bienSo = new JTextField();
		bienSo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bienSo.setBounds(63, 163, 194, 34);
		contentPane.add(bienSo);
		bienSo.setColumns(10);

		JLabel lblLoiV = new JLabel("Lo\u1EA1i V\u00E9");
		lblLoiV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoiV.setBounds(10, 237, 46, 14);
		contentPane.add(lblLoiV);

		loaiVe = new JComboBox();
		loaiVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loaiVe.getSelectedItem().toString().equals("VETHANG")){
					btnVeThang.setEnabled(true);
					btnTaoVN.setEnabled(false);
					maVe.setEditable(true);
					
				}
				else {
					
					btnTaoVN.setEnabled(true);
					maVe.setEditable(true);
					btnVeThang.setEnabled(false);
				}
			
			}
		});
		loaiVe.setModel(new DefaultComboBoxModel(new String[] {"VENGAY", "VETHANG"}));
		loaiVe.setBounds(66, 227, 129, 34);
		contentPane.add(loaiVe);

		maVe = new JTextField();
		maVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		maVe.setBounds(66, 295, 191, 34);
		contentPane.add(maVe);
		maVe.setColumns(10);

		JLabel lblMV = new JLabel("M\u00E3 V\u00E9");
		lblMV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMV.setBounds(10, 301, 46, 20);
		contentPane.add(lblMV);

		btnVeThang = new JButton("Ki\u1EC3m Tra V\u00E9 Th\u00E1ng");
		btnVeThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemTraVT()==true) btnNhanXe.setEnabled(true);
				else JOptionPane.showMessageDialog(null, "nhap lai thong tin");
			}
		});
		btnVeThang.setBounds(145, 352, 143, 43);
		contentPane.add(btnVeThang);

		btnTaoVN = new JButton("T\u1EA1o V\u00E9 Ng\u00E0y");
		btnTaoVN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (taoVN()==true)  btnNhanXe.setEnabled(true);
				else JOptionPane.showMessageDialog(null, "Thông tin nhập sai");
			}
		});
		btnTaoVN.setBounds(11, 352, 124, 43);
		contentPane.add(btnTaoVN);

		btnNhanXe = new JButton("Nh\u1EADn Xe");
		btnNhanXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nhanXe()==true) {
					
					
					JOptionPane.showMessageDialog(null, "Nhận xe thành công");
					showBang();
					btnNhanXe.setEnabled(false);
					btnTaoVN.setEnabled(false);
					btnVeThang.setEnabled(false);
					loaiVe.setEnabled(false);
					bienSo.setEditable(false);
					maVe.setEditable(false);
					bienSo.setText(null);
					maVe.setText(null);
				}
				else
					JOptionPane.showMessageDialog(null, "Nhập lại thông tin");
				
			}
		});
		btnNhanXe.setBounds(66, 416, 114, 49);
		contentPane.add(btnNhanXe);
		btnNhanXe.setEnabled(false);
		btnTaoVN.setEnabled(false);
		btnVeThang.setEnabled(false);
		loaiVe.setEditable(false);
		loaiVe.setEnabled(false);
		bienSo.setEditable(false);
		maVe.setEditable(false);
		
		
		JLabel lblXinChaof = new JLabel("Xin Chào:");
		lblXinChaof.setBounds(592, 21, 78, 14);
		contentPane.add(lblXinChaof);
		
		JLabel lblTaiKhoan = new JLabel(DangNhap.getTk());
		lblTaiKhoan.setBounds(680, 21, 194, 14);
		contentPane.add(lblTaiKhoan);
		
		JButton btnngXut = new JButton("Đăng Xuất");
		btnngXut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DangNhap frame = new DangNhap();
				dispose();
				frame.setVisible(true);
			}
		});
		btnngXut.setBounds(680, 46, 114, 23);
		contentPane.add(btnngXut);
		
		JButton btnNewButton = new JButton("Đổi MK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DoiMK frame = new DoiMK();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(795, 46, 89, 23);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap15.jpg"));
		lblNewLabel.setBounds(0, 0, 894, 525);
		contentPane.add(lblNewLabel);
	}
	
	/**
	 * kiểm tra số chỗ còn trống.
	 *
	 * @return true, if successful
	 */
	public boolean kiemTraCT() {
		try {
			Database.loadData();
			String sql = "SELECT * FROM sochocontrong";
			ResultSet rs = Database.result(sql);

			while (rs.next()) {
				if(rs.getInt(loaiXe.getSelectedItem().toString())>0) return true;
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
	 * nhập thông tin xe vào cơ sở dữ liệu.
	 *
	 * @return true, if successful
	 */
	public boolean nhanXe() {
		Date dNow = new Date();
		long gio = dNow.getTime();
		java.sql.Timestamp time = new java.sql.Timestamp(gio);
		
	
		
		try {
			Database.loadData();
			String sql = "SELECT * FROM sochocontrong";
			ResultSet rs = Database.result(sql);
			
			while (rs.next()) {
				String str = "UPDATE sochocontrong SET "
						+ loaiXe.getSelectedItem().toString() + "= '"
						+ (rs.getInt(loaiXe.getSelectedItem().toString()) - 1)
						+ "'";
				PreparedStatement pstm = Database.getCon()
						.prepareStatement(str);
				pstm.executeUpdate();
				pstm.close();
			}
			
				String st = "INSERT INTO thongke(mave,giogui,ghichu, taikhoan,loaixe, loaive)" + "VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement sttm = Database.getCon().prepareStatement(st);
				
				sttm.setString(1,maVe.getText());
				sttm.setTimestamp(2,time );
				sttm.setString(3, "Null");
				sttm.setString(4, DangNhap.getTk());
				sttm.setString(5, loaiXe.getSelectedItem().toString());
				sttm.setString(6, loaiVe.getSelectedItem().toString());
				
				
				String stt = "INSERT INTO ve(mave,bienso, giogui)" + "VALUES (?, ?, ?)";
				PreparedStatement psttm = Database.getCon().prepareStatement(stt);
				
				psttm.setString(1, maVe.getText());
				psttm.setString(2, bienSo.getText());
				psttm.setTimestamp(3, time );
				sttm.executeUpdate();
				sttm.close();
				psttm.executeUpdate();
				
				psttm.close();
				return true;
			
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
	 * tạo vé ngày vào bảng ve trong cơ sở dữ liệu.
	 *
	 * @return true, if successful
	 */
	public static boolean taoVN() {
		
		try {

			Database.loadData();
			String sql = "SELECT * FROM vengay";
			ResultSet rs = Database.result(sql);

			while (rs.next()) {
				if (rs.getString("mave").equals(maVe.getText())
						&& rs.getString("loaixe").equals(
								loaiXe.getSelectedItem().toString())) {

					
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
	 * kiểm tra vé tháng nhập vào có trong cơ sở dữ liệu chưa.
	 *
	 * @return true, if successful
	 */
	public boolean kiemTraVT() {
		
		try {
			Database.loadData();
			String sql = "SELECT* FROM vethang";
			ResultSet rs = Database.result(sql);
			
			while (rs.next()) {
				if (rs.getString("mave").equals(maVe.getText())) {
					if (rs.getString("hansudung").equals("1")) return true;
					else return false;
				}
				else return false;
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
	 * hiển thị bảng gồm các xe đang gửi.
	 */
	public void showBang() {
		
		try {
			Database.loadData();
			String sql = "SELECT * FROM ve";
			DefaultTableModel dtm = new DefaultTableModel();
			ResultSet rs = Database.result(sql);
			PreparedStatement pstmt = Database.getCon().prepareStatement(sql);
			ResultSetMetaData metadata = pstmt.getMetaData();
			int number = metadata.getColumnCount();		// lay so luong cot tren csdl
			Vector row,colum;
			
			colum = new Vector();
			for(int i=1; i<=number; i++){
				colum.add(metadata.getColumnName(i));	//lay ten cua cot
			}
			
			dtm.setColumnIdentifiers(colum);	//dung de add chi so cot vao Jtable
			
			while (rs.next()) {
				 row = new Vector();
				 for(int i=1;i<=number; i++) {
					 row.add(rs.getString(i));
				 }
				dtm.addRow(row);
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
}
