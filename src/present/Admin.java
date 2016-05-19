package present;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data_access.Database;

/**
 * 
 * @author anhtuan
 *
 */

public class Admin extends JFrame {

	protected static final boolean MouseEvent = false;
	private JPanel contentPane;
	private JButton btnTK;
	private JButton btnXoa;
	private JButton btnDangXuat;
	private JButton btnXemTT;
	private JButton btnTKnguoidung;
	private JButton btndoiMK;
	private JButton btndoiChucNang;
	private JButton btnXoaTk;
	private JButton btnDoiMKmd;
	private JButton btnQuanLyXe;
	private JButton btnXemTTXe;
	private JButton btnMatVe;
	private JButton btnHuyVe;
	private JButton btnThemVeNgay;
	private JButton btnQuanLyVeThang;
	private JButton btnBaiDo;
	private JButton btnThongKe;
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private JTable table2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 530);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 255, 255));
		desktopPane.setBounds(0, 0, 204, 501);
		contentPane.add(desktopPane);
		

		JButton btnChucNang = new JButton("Chức Năng");
		btnChucNang.setForeground(new Color(0, 0, 0));
		btnChucNang.setBackground(Color.YELLOW);
		btnChucNang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChucNang.setBounds(0, 0, 204, 35);
		desktopPane.add(btnChucNang);

		JButton btnHeThong = new JButton("Hệ Thống");
		btnHeThong.setBackground(Color.GREEN);
	
		btnHeThong.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (btnXoa.isVisible() == false && btnXemTT.isVisible() == true
						&& btnXemTTXe.isVisible() == false) {
					btnXoa.setVisible(true);
					btnXoa.setBounds(0, 71, 204, 23);
					btnDangXuat.setVisible(true);
					btnDangXuat.setBounds(0, 95, 204, 23);
					btnTK.setBounds(0, 119, 204, 35);
					btnXemTT.setBounds(0, 119 + 35, 204, 23);
					btnTKnguoidung.setBounds(0, 119 + 35 + 23, 204, 23);
					btndoiMK.setBounds(0, 119 + 35 + 23 * 2, 204, 23);
					btndoiChucNang.setBounds(0, 119 + 35 + 23 * 3, 204, 23);
					btnXoaTk.setBounds(0, 119 + 35 + 23 * 4, 204, 23);
					btnDoiMKmd.setBounds(0, 119 + 35 + 23 * 5, 204, 23);
					btnQuanLyXe.setBounds(0, 119 + 35 + 23 * 6, 204, 35);
				} else if (btnXoa.isVisible() == false
						&& btnXemTT.isVisible() == true
						&& btnXemTTXe.isVisible() == true) {
					btnXoa.setVisible(true);
					btnXoa.setBounds(0, 71, 204, 23);
					btnDangXuat.setVisible(true);
					btnDangXuat.setBounds(0, 95, 204, 23);
					btnTK.setBounds(0, 119, 204, 35);
					btnXemTT.setBounds(0, 119 + 35, 204, 23);
					btnTKnguoidung.setBounds(0, 119 + 35 + 23, 204, 23);
					btndoiMK.setBounds(0, 119 + 35 + 23 * 2, 204, 23);
					btndoiChucNang.setBounds(0, 119 + 35 + 23 * 3, 204, 23);
					btnXoaTk.setBounds(0, 119 + 35 + 23 * 4, 204, 23);
					btnDoiMKmd.setBounds(0, 119 + 35 + 23 * 5, 204, 23);
					btnQuanLyXe.setBounds(0, 119 + 35 + 23 * 6, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 119 + 35 + 35 + 23 * 6, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 119 + 35 + 35 + 23 * 7, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 119 + 35 + 35 + 23 * 8, 204,
							23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 119 + 35 + 35 + 23 * 9, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 119 + 35 + 35 + 23 * 10, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 119 + 35 + 35 + 23 * 11, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 119 + 35 + 35 + 23 * 12, 204, 23);

				} else if (btnXoa.isVisible() == false
						&& btnXemTT.isVisible() == false
						&& btnXemTTXe.isVisible() == true) {
					btnXoa.setVisible(true);
					btnXoa.setBounds(0, 71, 204, 23);
					btnDangXuat.setVisible(true);
					btnDangXuat.setBounds(0, 95, 204, 23);
					btnTK.setBounds(0, 119, 204, 35);
					btnQuanLyXe.setBounds(0, 119 + 35, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 119 + 35 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 119 + 35 + 35 + 23, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 119 + 35 + 35 + 23 * 2, 204,
							23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 119 + 35 + 35 + 23 * 3, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 119 + 35 + 35 + 23 * 4, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 119 + 35 + 35 + 23 * 5, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 119 + 35 + 35 + 23 * 6, 204, 23);

				} else if (btnXoa.isVisible() == false
						&& btnXemTT.isVisible() == false
						&& btnXemTTXe.isVisible() == false) {
					btnXoa.setVisible(true);
					btnXoa.setBounds(0, 71, 204, 23);
					btnDangXuat.setVisible(true);
					btnDangXuat.setBounds(0, 95, 204, 23);
					btnTK.setBounds(0, 119, 204, 35);
					btnQuanLyXe.setBounds(0, 119 + 35, 204, 35);
				} else if (btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == false
						&& btnXemTTXe.isVisible() == false) {
					btnXoa.setVisible(false);
					btnDangXuat.setVisible(false);
					btnTK.setBounds(0, 72, 204, 35);
					btnQuanLyXe.setBounds(0, 72 + 35, 204, 35);
				} else if (btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == true
						&& btnXemTTXe.isVisible() == false) {
					btnXoa.setVisible(false);
					btnDangXuat.setVisible(false);
					btnTK.setBounds(0, 72, 204, 35);
					btnXemTT.setBounds(0, 72 + 35, 204, 23);
					btnTKnguoidung.setBounds(0, 72 + 35 + 23, 204, 23);
					btndoiMK.setBounds(0, 72 + 35 + 23 * 2, 204, 23);
					btndoiChucNang.setBounds(0, 72 + 35 + 23 * 3, 204, 23);
					btnXoaTk.setBounds(0, 72 + 35 + 23 * 4, 204, 23);
					btnDoiMKmd.setBounds(0, 72 + 35 + 23 * 5, 204, 23);
					btnQuanLyXe.setBounds(0, 72 + 35 + 23 * 6, 204, 35);
				} else if (btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == false
						&& btnXemTTXe.isVisible() == true) {
					btnXoa.setVisible(false);
					btnDangXuat.setVisible(false);
					btnTK.setBounds(0, 72, 204, 35);
					btnQuanLyXe.setBounds(0, 72 + 35, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 72 + 35 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 72 + 23 + 35 + 35, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang
							.setBounds(0, 72 + 23 * 2 + 35 * 2, 204, 23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 72 + 35 + 23 * 3 + 35, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 72 + 35 + 23 * 4 + 35, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 72 + 35 + 23 * 5 + 35, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 72 + 35 + 23 * 6 + 35, 204, 23);

				} else if (btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == true
						&& btnXemTTXe.isVisible() == true) {
					btnXoa.setVisible(false);
					btnDangXuat.setVisible(false);
					btnTK.setBounds(0, 72, 204, 35);
					btnXemTT.setBounds(0, 72 + 35, 204, 23);
					btnTKnguoidung.setBounds(0, 72 + 35 + 23, 204, 23);
					btndoiMK.setBounds(0, 72 + 35 + 23 * 2, 204, 23);
					btndoiChucNang.setBounds(0, 72 + 35 + 23 * 3, 204, 23);
					btnXoaTk.setBounds(0, 72 + 35 + 23 * 4, 204, 23);
					btnDoiMKmd.setBounds(0, 72 + 35 + 23 * 5, 204, 23);
					btnQuanLyXe.setBounds(0, 72 + 35 + 23 * 6, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 72 + 35 + 23 * 6 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 72 + 35 + 23 * 7 + 35, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 72 + 35 + 23 * 8 + 35, 204,
							23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 72 + 35 + 23 * 9 + 35, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 72 + 35 + 23 * 10 + 35, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 72 + 35 + 23 * 11 + 35, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 72 + 35 + 23 * 12 + 35, 204, 23);
				}

			}
		});
		btnHeThong.setBounds(0, 30, 204, 41);
		desktopPane.add(btnHeThong);
		ImageIcon btnXoaImage = new ImageIcon("data\\icon\\thietlapthongtin.png");
		btnXoa = new JButton("Thiết Lập Thông Tin ",btnXoaImage);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThietLapThongTin frame = new ThietLapThongTin();
				frame.setVisible(true);

			}
		});
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoa.setBackground(Color.WHITE);
		desktopPane.add(btnXoa);
		btnXoa.setVisible(false);
		ImageIcon btnDangXuatImage = new ImageIcon("data\\icon\\dangxuat.png");
		btnDangXuat = new JButton("Đăng xuất",btnDangXuatImage);
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				DangNhap.main(null);

			}
		});
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setBackground(Color.WHITE);

		desktopPane.add(btnDangXuat);
		btnDangXuat.setVisible(false);
		btnTK = new JButton("T\u00E0i Kho\u1EA3n");
		btnTK.setBackground(Color.GREEN);
		// ImageIcon icon = new ImageIcon("image\\50.jpg") ;
		// btnNewButton_4.setIcon(icon);
		btnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnXemTT.isVisible() == false && btnXoa.isVisible() == true
						&& btnXemTTXe.isVisible() == false) {
					btnXemTT.setVisible(true);
					btnXemTT.setBounds(0, 119 + 35, 204, 23);
					btnTKnguoidung.setVisible(true);
					btnTKnguoidung.setBounds(0, 119 + 35 + 23, 204, 23);
					btndoiMK.setVisible(true);
					btndoiMK.setBounds(0, 119 + 35 + 23 * 2, 204, 23);
					btndoiChucNang.setVisible(true);
					btndoiChucNang.setBounds(0, 119 + 35 + 23 * 3, 204, 23);
					btnXoaTk.setVisible(true);
					btnXoaTk.setBounds(0, 119 + 35 + 23 * 4, 204, 23);
					btnDoiMKmd.setVisible(true);
					btnDoiMKmd.setBounds(0, 119 + 35 + 23 * 5, 204, 23);
					btnQuanLyXe.setBounds(0, 119 + 35 + 23 * 6, 204, 35);
				} else if (btnXemTT.isVisible() == false
						&& btnXoa.isVisible() == true
						&& btnXemTTXe.isVisible() == true) {
					btnXemTT.setVisible(true);
					btnXemTT.setBounds(0, 119 + 35, 204, 23);
					btnTKnguoidung.setVisible(true);
					btnTKnguoidung.setBounds(0, 119 + 35 + 23, 204, 23);
					btndoiMK.setVisible(true);
					btndoiMK.setBounds(0, 119 + 35 + 23 * 2, 204, 23);
					btndoiChucNang.setVisible(true);
					btndoiChucNang.setBounds(0, 119 + 35 + 23 * 3, 204, 23);
					btnXoaTk.setVisible(true);
					btnXoaTk.setBounds(0, 119 + 35 + 23 * 4, 204, 23);
					btnDoiMKmd.setVisible(true);
					btnDoiMKmd.setBounds(0, 119 + 35 + 23 * 5, 204, 23);
					btnQuanLyXe.setBounds(0, 119 + 35 + 23 * 6, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 119 + 35 + 23 * 6 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 119 + 35 + 23 * 7 + 35, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 119 + 35 + 23 * 8 + 35, 204,
							23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 119 + 35 + 23 * 9 + 35, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 119 + 35 + 23 * 10 + 35, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 119 + 35 + 23 * 11 + 35, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 119 + 35 + 23 * 12 + 35, 204, 23);

				} else if (btnXemTT.isVisible() == false
						&& btnXoa.isVisible() == false
						&& btnXemTTXe.isVisible() == true) {
					btnXemTT.setVisible(true);
					btnXemTT.setBounds(0, 105, 204, 23);
					btnTKnguoidung.setVisible(true);
					btnTKnguoidung.setBounds(0, 128, 204, 23);
					btndoiMK.setVisible(true);
					btndoiMK.setBounds(0, 150, 204, 23);
					btndoiChucNang.setVisible(true);
					btndoiChucNang.setBounds(0, 173, 204, 23);
					btnXoaTk.setVisible(true);
					btnXoaTk.setBounds(0, 195, 204, 23);
					btnDoiMKmd.setVisible(true);
					btnDoiMKmd.setBounds(0, 218, 204, 23);
					btnQuanLyXe.setBounds(0, 218 + 23, 204, 35);
					btnXemTTXe.setBounds(0, 218 + 23 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 218 + 35 + 23 + 23, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 218 + 35 + 23 * 3, 204, 23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 218 + 35 + 23 * 4, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 218 + 35 + 23 * 5, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 218 + 35 + 23 * 6, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 218 + 35 + 23 * 7, 204, 23);
				} else if (btnXemTT.isVisible() == false
						&& btnXoa.isVisible() == false
						&& btnXemTTXe.isVisible() == false) {
					btnXemTT.setVisible(true);
					btnXemTT.setBounds(0, 105, 204, 23);
					btnTKnguoidung.setVisible(true);
					btnTKnguoidung.setBounds(0, 128, 204, 23);
					btndoiMK.setVisible(true);
					btndoiMK.setBounds(0, 150, 204, 23);
					btndoiChucNang.setVisible(true);
					btndoiChucNang.setBounds(0, 173, 204, 23);
					btnXoaTk.setVisible(true);
					btnXoaTk.setBounds(0, 195, 204, 23);
					btnDoiMKmd.setVisible(true);
					btnDoiMKmd.setBounds(0, 218, 204, 23);
					btnQuanLyXe.setBounds(0, 218 + 23, 204, 35);
				} else if (btnXemTT.isVisible() == true
						&& btnXoa.isVisible() == false
						&& btnXemTTXe.isVisible() == false) {
					btnXemTT.setVisible(false);
					btnTKnguoidung.setVisible(false);
					btndoiMK.setVisible(false);
					btndoiChucNang.setVisible(false);
					btnXoaTk.setVisible(false);
					btnDoiMKmd.setVisible(false);
					btnQuanLyXe.setBounds(0, 108, 204, 35);
				} else if (btnXemTT.isVisible() == true
						&& btnXoa.isVisible() == true
						&& btnXemTTXe.isVisible() == false) {
					btnXemTT.setVisible(false);
					btnTKnguoidung.setVisible(false);
					btndoiMK.setVisible(false);
					btndoiChucNang.setVisible(false);
					btnXoaTk.setVisible(false);
					btnDoiMKmd.setVisible(false);
					btnQuanLyXe.setBounds(0, 119 + 35, 204, 35);
				} else if (btnXemTT.isVisible() == true
						&& btnXoa.isVisible() == false
						&& btnXemTTXe.isVisible() == true) {
					btnXemTT.setVisible(false);
					btnTKnguoidung.setVisible(false);
					btndoiMK.setVisible(false);
					btndoiChucNang.setVisible(false);
					btnXoaTk.setVisible(false);
					btnDoiMKmd.setVisible(false);
					btnQuanLyXe.setBounds(0, 108, 204, 35);
					btnXemTTXe.setBounds(0, 108 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 108 + 35 + 23, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 108 + 35 + 23 * 2, 204, 23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 108 + 35 + 23 * 3, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 108 + 35 + 23 * 4, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 108 + 35 + 23 * 5, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 108 + 35 + 23 * 6, 204, 23);
				} else if (btnXemTT.isVisible() == true
						&& btnXoa.isVisible() == true
						&& btnXemTTXe.isVisible() == true) {
					btnXemTT.setVisible(false);
					btnTKnguoidung.setVisible(false);
					btndoiMK.setVisible(false);
					btndoiChucNang.setVisible(false);
					btnXoaTk.setVisible(false);
					btnDoiMKmd.setVisible(false);
					btnTK.setBounds(0, 119, 204, 35);
					btnQuanLyXe.setBounds(0, 119 + 35, 204, 35);
					btnXemTTXe.setBounds(0, 119 + 35 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 119 + 35 + 23 + 35, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 119 + 35 + 23 * 2 + 35, 204,
							23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 119 + 35 + 35 + 23 * 3, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 119 + 35 + 35 + 23 * 4, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 119 + 35 + 35 + 23 * 5, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 119 + 35 + 35 + 23 * 6, 204, 23);
				}

			}
		});
		btnTK.setBounds(0, 66, 204, 41);
		desktopPane.add(btnTK);

		ImageIcon btnXemTTImage = new ImageIcon("data\\icon\\xemthongtintaikhoan.jpg");
		btnXemTT = new JButton("Xem thông tin tài khoản",btnXemTTImage);
		btnXemTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane = new JScrollPane();
				scrollPane.setBounds(228, 183, 640, 277);
				contentPane.add(scrollPane);
				table = new JTable();
				table.setEnabled(false);
				scrollPane.setViewportView(table);

				loadData();
			}
		});
		btnXemTT.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemTT.setBackground(Color.WHITE);
		desktopPane.add(btnXemTT);
		btnXemTT.setVisible(false);

		ImageIcon btnTKnguoidungImage = new ImageIcon("data\\icon\\taonguoidungmoi.png");
		btnTKnguoidung = new JButton("Tạo tài khoản người dùng",btnTKnguoidungImage);
		btnTKnguoidung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TaoTaiKhoan frame = new TaoTaiKhoan();
				frame.setVisible(true);
			}
		});

		ImageIcon btndoiMKImage = new ImageIcon("data\\icon\\doimatkhau.jpg");
		btndoiMK = new JButton("Đổi mật khẩu",btndoiMKImage);
		btndoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiMK frame = new DoiMK();
				frame.setVisible(true);
			}
		});
		btndoiMK.setHorizontalAlignment(SwingConstants.LEFT);
		btndoiMK.setBackground(Color.WHITE);
		desktopPane.add(btndoiMK);
		btndoiMK.setVisible(false);
		btnTKnguoidung.setHorizontalAlignment(SwingConstants.LEFT);
		btnTKnguoidung.setBackground(Color.WHITE);
		desktopPane.add(btnTKnguoidung);
		btnTKnguoidung.setVisible(false);

		ImageIcon btndoiChucNangImage = new ImageIcon("data\\icon\\doichucvunguoidung.jpg");
		btndoiChucNang = new JButton("Đổi chức vụ người dùng",btndoiChucNangImage);
		btndoiChucNang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doicv frame = new Doicv();
				frame.setVisible(true);
			}
		});
		btndoiChucNang.setHorizontalAlignment(SwingConstants.LEFT);
		btndoiChucNang.setBackground(Color.WHITE);
		desktopPane.add(btndoiChucNang);
		btndoiChucNang.setVisible(false);

		ImageIcon btnXoaTkImage = new ImageIcon("data\\icon\\xoataikhoannguoidung.jpg");
		btnXoaTk = new JButton("Xóa tài khoản người dùng",btnXoaTkImage);
		btnXoaTk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XoaTaiKhoan frame = new XoaTaiKhoan();
				frame.setVisible(true);
			}
		});
		btnXoaTk.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoaTk.setBackground(Color.WHITE);
		desktopPane.add(btnXoaTk);
		btnXoaTk.setVisible(false);

		ImageIcon btnDoiMKmdImage = new ImageIcon("data\\icon\\datlaimk.jpg");
		btnDoiMKmd = new JButton("Đặt mật khẩu mặc định",btnDoiMKmdImage);
		btnDoiMKmd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetMK frame = new ResetMK();
				frame.setVisible(true);
			}
		});
		btnDoiMKmd.setHorizontalAlignment(SwingConstants.LEFT);
		btnDoiMKmd.setBackground(Color.WHITE);
		desktopPane.add(btnDoiMKmd);
		btnDoiMKmd.setVisible(false);

		btnQuanLyXe = new JButton("Quản Lý");
		btnQuanLyXe.setBackground(Color.GREEN);
		btnQuanLyXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnXemTTXe.isVisible() == false
						&& btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == false) {
					btnQuanLyXe.setBounds(0, 119 + 35, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 119 + 35 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 119 + 35 + 35 + 23, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 119 + 35 + 35 + 23 * 2, 204,
							23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 119 + 35 + 35 + 23 * 3, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 119 + 35 + 35 + 23 * 4, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 119 + 35 + 35 + 23 * 5, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 119 + 35 + 35 + 23 * 6, 204, 23);
				} else if (btnXemTTXe.isVisible() == false
						&& btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == true) {
					btnQuanLyXe.setBounds(0, 119 + 35 + 23 * 6, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 119 + 35 + 35 + 23 * 6, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 119 + 35 + 35 + 23 * 7, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 119 + 35 + 35 + 23 * 8, 204,
							23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 119 + 35 + 35 + 23 * 9, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 119 + 35 + 35 + 23 * 10, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 119 + 35 + 35 + 23 * 11, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 119 + 35 + 35 + 23 * 12, 204, 23);
				} else if (btnXemTTXe.isVisible() == false
						&& btnXoa.isVisible() == false
						&& btnXemTT.isVisible() == true) {
					btnQuanLyXe.setBounds(0, 218 + 23, 204, 35);
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 218 + 23 + 35, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 218 + 23 + 35 + 23, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 218 + 35 + 23 * 3, 204, 23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 218 + 35 + 23 * 4, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 218 + 35 + 23 * 5, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 218 + 35 + 23 * 6, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 218 + 35 + 23 * 7, 204, 23);
				}

				else if (btnXemTTXe.isVisible() == false
						&& btnXoa.isVisible() == false
						&& btnXemTT.isVisible() == false) {
					btnXemTTXe.setVisible(true);
					btnXemTTXe.setBounds(0, 141, 204, 23);
					btnThemVeNgay.setVisible(true);
					btnThemVeNgay.setBounds(0, 164, 204, 23);
					btnQuanLyVeThang.setVisible(true);
					btnQuanLyVeThang.setBounds(0, 187, 204, 23);
					btnMatVe.setVisible(true);
					btnMatVe.setBounds(0, 187 + 23, 204, 23);
					btnHuyVe.setVisible(true);
					btnHuyVe.setBounds(0, 187 + 23 * 2, 204, 23);
					btnBaiDo.setVisible(true);
					btnBaiDo.setBounds(0, 187 + 23 * 3, 204, 23);
					btnThongKe.setVisible(true);
					btnThongKe.setBounds(0, 187 + 23 * 4, 204, 23);

				} else if (btnXemTTXe.isVisible() == true
						&& btnXoa.isVisible() == false
						&& btnXemTT.isVisible() == false) {
					btnXemTTXe.setVisible(false);
					btnThemVeNgay.setVisible(false);
					btnQuanLyVeThang.setVisible(false);
					btnMatVe.setVisible(false);
					btnHuyVe.setVisible(false);
					btnBaiDo.setVisible(false);
					btnThongKe.setVisible(false);
				} else if (btnXemTTXe.isVisible() == true
						&& btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == false) {
					btnXemTTXe.setVisible(false);
					btnThemVeNgay.setVisible(false);
					btnQuanLyVeThang.setVisible(false);
					btnMatVe.setVisible(false);
					btnHuyVe.setVisible(false);
					btnBaiDo.setVisible(false);
					btnThongKe.setVisible(false);
				} else if (btnXemTTXe.isVisible() == true
						&& btnXoa.isVisible() == false
						&& btnXemTT.isVisible() == true) {
					btnXemTTXe.setVisible(false);
					btnThemVeNgay.setVisible(false);
					btnQuanLyVeThang.setVisible(false);
					btnMatVe.setVisible(false);
					btnHuyVe.setVisible(false);
					btnBaiDo.setVisible(false);
					btnThongKe.setVisible(false);
				} else if (btnXemTTXe.isVisible() == true
						&& btnXoa.isVisible() == true
						&& btnXemTT.isVisible() == true) {
					btnXemTTXe.setVisible(false);
					btnThemVeNgay.setVisible(false);
					btnQuanLyVeThang.setVisible(false);
					btnMatVe.setVisible(false);
					btnHuyVe.setVisible(false);
					btnBaiDo.setVisible(false);
					btnThongKe.setVisible(false);
				}

			}
		});
		btnQuanLyXe.setBounds(0, 102, 204, 41);
		desktopPane.add(btnQuanLyXe);

		ImageIcon btnXemTTXeImage = new ImageIcon("data\\icon\\xemtoanbothongtin.jpg");
		btnXemTTXe = new JButton("Xem toàn bộ thông tin", btnXemTTXeImage );
		btnXemTTXe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				scrollPane2 = new JScrollPane();
				scrollPane2.setBounds(228, 183, 640, 277);
				contentPane.add(scrollPane2);
				table2 = new JTable();
				table2.setEnabled(false);
				scrollPane2.setViewportView(table2);
				showBang();

			}
		});
		btnXemTTXe.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemTTXe.setBackground(Color.WHITE);
		desktopPane.add(btnXemTTXe);
		btnXemTTXe.setVisible(false);

		ImageIcon btnMatVeImage = new ImageIcon("data\\icon\\matve.jpg");
		btnMatVe = new JButton("Mất vé", btnMatVeImage);
		btnMatVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatVe frame = new MatVe();
				frame.setVisible(true);

			}
		});
		btnMatVe.setHorizontalAlignment(SwingConstants.LEFT);
		btnMatVe.setBackground(Color.WHITE);
		desktopPane.add(btnMatVe);
		btnMatVe.setVisible(false);

		ImageIcon btnHuyVeImage = new ImageIcon("data\\icon\\xoave.png");
		btnHuyVe = new JButton("Hủy vé", btnHuyVeImage);
		btnHuyVe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HuyVe frame = new HuyVe();
				frame.setVisible(true);
			}
		});
		btnHuyVe.setHorizontalAlignment(SwingConstants.LEFT);
		btnHuyVe.setBackground(Color.WHITE);
		desktopPane.add(btnHuyVe);

		ImageIcon btnThemVeNgayImage = new ImageIcon("data\\icon\\themvengay.png");
		btnThemVeNgay = new JButton("Thêm Vé Ngày",btnThemVeNgayImage);
		btnThemVeNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapVeNgay frame = new NhapVeNgay();
				frame.setVisible(true);
			}
		});
		btnThemVeNgay.setHorizontalAlignment(SwingConstants.LEFT);
		btnThemVeNgay.setBackground(Color.WHITE);
		desktopPane.add(btnThemVeNgay);
		btnThemVeNgay.setVisible(false);

		ImageIcon btnQuanLyVeThangImage = new ImageIcon("data\\icon\\themvethang.png");
		btnQuanLyVeThang = new JButton("Thêm Vé Tháng",btnQuanLyVeThangImage);
		btnQuanLyVeThang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VeThang frame = new VeThang();
				frame.setVisible(true);
			}
		});
		btnQuanLyVeThang.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyVeThang.setBackground(Color.WHITE);
		desktopPane.add(btnQuanLyVeThang);
		btnQuanLyVeThang.setVisible(false);

		ImageIcon btnBaiDoImage = new ImageIcon("data\\icon\\thongtinbaixe.png");
		btnBaiDo = new JButton("Thông Tin Bãi Gửi Xe",btnBaiDoImage) ;
		btnBaiDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhapThongTinBaiGuiXe frame = new NhapThongTinBaiGuiXe();
				frame.setVisible(true);
			}
		});
		btnBaiDo.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaiDo.setBackground(Color.WHITE);
		desktopPane.add(btnBaiDo);
		btnBaiDo.setVisible(false);

		ImageIcon btnThongKeImage = new ImageIcon("data\\icon\\thongke.png");
		btnThongKe = new JButton("Thống Kê",btnThongKeImage) ;
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThongKe frame = new ThongKe();
				frame.setVisible(true);
			}
		});
		btnThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		btnThongKe.setBackground(Color.WHITE);
		desktopPane.add(btnThongKe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 204, 501);
		desktopPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("data\\icon\\dangnhap13.jpg"));
		btnThongKe.setVisible(false);

		JLabel lblNewLabel = new JLabel(
				"                Quản Lý Bãi Gửi Xe");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setBounds(203, 0, 681, 95);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		lblNewLabel_2.setBounds(203, 0, 691, 501);
		lblNewLabel_2.setIcon(new ImageIcon("data\\icon\\dangnhap5.jpg"));
		contentPane.add(lblNewLabel_2);
		btnBaiDo.setVisible(false);

	}

	/**
	 * phương thức tạo bảng cho phần thống kê nhân viên
	 */
	public void loadData() {
		String sql = "SELECT * FROM nhanvien";
		try {
			Database.loadData();
			DefaultTableModel dtm = new DefaultTableModel();
			ResultSet rs = Database.result(sql);
			PreparedStatement pstmt = Database.getCon().prepareStatement(sql);
			ResultSetMetaData metadata = pstmt.getMetaData();

			int number = metadata.getColumnCount(); // lay so luong cot tren
													// csdl
			Vector row, colum;

			colum = new Vector();
			for (int i = 1; i <= number; i++) {
				colum.add(metadata.getColumnName(i)); // lay ten cua cot
			}

			dtm.setColumnIdentifiers(colum); // dung de add chi so cot vao
												// Jtable

			while (rs.next()) {
				row = new Vector();
				for (int i = 1; i <= number; i++) {
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
	/**
	 * phương thức tạo bảng cho phần xem toàn bộ thông tin xe đã gửi
	 */
	public void showBang() {

		try {
			Database.loadData();
			String sql = "SELECT * FROM thongke";
			DefaultTableModel dtm = new DefaultTableModel();
			ResultSet rs = Database.result(sql);
			PreparedStatement pstmt = Database.getCon().prepareStatement(sql);
			ResultSetMetaData metadata = pstmt.getMetaData();
			int number = metadata.getColumnCount(); // lay so luong cot tren csdl
													
			Vector row, colum;

			colum = new Vector();
			for (int i = 1; i <= number; i++) {
				colum.add(metadata.getColumnName(i)); // lay ten cua cot
			}

			dtm.setColumnIdentifiers(colum); // dung de add chi so cot vao
												// Jtable

			while (rs.next()) {
				row = new Vector();
				for (int i = 1; i <= number; i++) {
					row.add(rs.getString(i));
				}
				dtm.addRow(row);
			}
			table2.setModel(dtm);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
