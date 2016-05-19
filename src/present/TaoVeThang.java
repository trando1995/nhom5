package present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
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
 * tạo giao diện tạo vé tháng
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class TaoVeThang extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The mave. */
	private JTextField mave;
	
	/** The hoten. */
	private JTextField hoten;
	
	/** The bienso. */
	private JTextField bienso;
	
	/** The mauxe. */
	private JTextField mauxe;
	
	/** The hangxe. */
	private JTextField hangxe;
	
	/** The loaixe. */
	private JComboBox loaixe;



	/**
	 * Create the frame.
	 */
	public TaoVeThang() {
		super("Tạo Vé Tháng");
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMV = new JLabel("M\u00E3 V\u00E9");
		lblMV.setBounds(60, 53, 46, 14);
		contentPane.add(lblMV);
		
		mave = new JTextField();
		mave.setBounds(135, 50, 257, 20);
		contentPane.add(mave);
		mave.setColumns(10);
		
		JLabel lblHTn = new JLabel("H\u1ECD T\u00EAn");
		lblHTn.setBounds(60, 93, 46, 14);
		contentPane.add(lblHTn);
		
		hoten = new JTextField();
		hoten.setBounds(135, 90, 257, 20);
		contentPane.add(hoten);
		hoten.setColumns(10);
		
		JLabel lblBinS = new JLabel("Bi\u1EC3n S\u1ED1");
		lblBinS.setBounds(60, 137, 46, 14);
		contentPane.add(lblBinS);
		
		bienso = new JTextField();
		bienso.setBounds(135, 134, 257, 20);
		contentPane.add(bienso);
		bienso.setColumns(10);
		
		JLabel lblLoiXe = new JLabel("Lo\u1EA1i Xe");
		lblLoiXe.setBounds(60, 183, 46, 14);
		contentPane.add(lblLoiXe);
		
		loaixe = new JComboBox();
		loaixe.setModel(new DefaultComboBoxModel(new String[] {"o to", "xe may"}));
		loaixe.setBounds(135, 180, 257, 20);
		contentPane.add(loaixe);
		
		JLabel lblNewLabel = new JLabel("H\u00E3ng Xe");
		lblNewLabel.setBounds(60, 226, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMuXe = new JLabel("M\u00E0u Xe");
		lblMuXe.setBounds(60, 268, 46, 14);
		contentPane.add(lblMuXe);
		
		mauxe = new JTextField();
		mauxe.setBounds(135, 265, 257, 20);
		contentPane.add(mauxe);
		mauxe.setColumns(10);
		
		JButton btnTao = new JButton("T\u1EA1o ");
		btnTao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (load()==true) {
					JOptionPane.showMessageDialog(null, "Tạo Vé tháng thành công");
					dispose();
				}
			}
		});
		btnTao.setBounds(103, 310, 89, 40);
		contentPane.add(btnTao);
		
		JButton btnThoat = new JButton("Tho\u00E1t");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setBounds(270, 310, 89, 40);
		contentPane.add(btnThoat);
		
		hangxe = new JTextField();
		hangxe.setBounds(134, 223, 258, 20);
		contentPane.add(hangxe);
		hangxe.setColumns(10);
	}
	
	/**
	 * chèn thông tin vé vào cơ sở dữ liệu.
	 *
	 * @return trả lại giá trị true hoặc false
	 */
	public boolean  load(){
		
		try {
			Database.loadData();
			String ma = mave.getText();
			String ten = hoten.getText();
			String biens = bienso.getText();
			String loaix = loaixe.getSelectedItem().toString();
			String hangx = hangxe.getText();
			String maux = mauxe.getText();
			
			String ins = "INSERT INTO VETHANG (mave, hoten, bienso, loaixe, hangxe, mauxe, hansudung)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
			String sql = "SELECT * FROM vethang";
			
			PreparedStatement sttm = Database.getCon().prepareStatement(ins);
			
			ResultSet rs = Database.result(sql);
			while (rs.next()) {
				if (rs.getString("mave").equals(ma)) {
					JOptionPane.showMessageDialog(null, "Vé đã tồn tại");
					return false;
				} else {
					if (ma.equals("") || ten.equals("") || biens.equals("") || loaix.equals("")
							|| maux.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Yêu cầu nhập đầy đủ thông tin");
						return false;
					}

				}
			}
			sttm.setString(1, ma);
			sttm.setString(2, ten);
			sttm.setString(3, biens);
			sttm.setString(4, loaix);
			sttm.setString(5, hangx);
			sttm.setString(6, maux);
			sttm.setString(7, "0");
			
			
			String in = "INSERT INTO dongtienvethang (mave, thang1, thang2, thang3, thang4, thang5, thang6, thang7, thang8, thang9, thang10, thang11, thang12 )"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement psttm = Database.getCon().prepareStatement(in);
			psttm.setString(1, ma);
			psttm.setString(2, "0");
			psttm.setString(3, "0");
			psttm.setString(4, "0");
			psttm.setString(5, "0");
			psttm.setString(6, "0");
			psttm.setString(7, "0");
			psttm.setString(8, "0");
			psttm.setString(9, "0");
			psttm.setString(10, "0");
			psttm.setString(11, "0");
			psttm.setString(12, "0");
			psttm.setString(13, "0");
			psttm.executeUpdate();
			sttm.executeUpdate();
			sttm.close();
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
}
