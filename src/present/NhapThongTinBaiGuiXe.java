package present;

import java.awt.EventQueue;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO: Auto-generated Javadoc

/**
 * tạo giao diện nhập thông tin bãi gửi xe xử lý dữ liệu.
 *
 * @author duonganh
 */
public class NhapThongTinBaiGuiXe extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/** The so cho oto. */
	private JTextField soChoOto;

	/** The so cho xm. */
	private JTextField soChoXM;

	/** The ve t oto. */
	private JTextField veTOto;

	/** The ve n oto. */
	private JTextField veNOto;

	/** The ve txm. */
	private JTextField veTXM;

	/** The ve nxm. */
	private JTextField veNXM;

	/**
	 * Create the frame.
	 */
	public NhapThongTinBaiGuiXe() {
		super("Nhập Thông Tin Bãi Gửi Xe");
		setBounds(100, 100, 450, 401);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCh = new JLabel(
				"S\u1ED1 Ch\u1ED7 \u0110\u1EC3 \u00D4 T\u00F4");
		lblCh.setBounds(10, 27, 95, 14);
		contentPane.add(lblCh);

		JLabel lblChXe = new JLabel("S\u1ED1 Ch\u1ED7 \u0110\u1EC3 Xe M\u00E1y");
		lblChXe.setBounds(10, 65, 123, 14);
		contentPane.add(lblChXe);

		JLabel lblGiVThng = new JLabel(
				"Gi\u00E1 V\u00E9 Th\u00E1ng \u00D4 T\u00F4");
		lblGiVThng.setBounds(10, 106, 123, 14);
		contentPane.add(lblGiVThng);

		JLabel lblGiVNgy = new JLabel(
				"Gi\u00E1 V\u00E9 Ng\u00E0y \u00D4 T\u00F4");
		lblGiVNgy.setBounds(10, 149, 123, 14);
		contentPane.add(lblGiVNgy);

		JLabel lblGiVThng_1 = new JLabel(
				"Gi\u00E1 V\u00E9 Th\u00E1ng Xe M\u00E1y");
		lblGiVThng_1.setBounds(10, 193, 130, 14);
		contentPane.add(lblGiVThng_1);

		JLabel lblGiVNgy_1 = new JLabel(
				"Gi\u00E1 V\u00E9 Ng\u00E0y  Xe M\u00E1y");
		lblGiVNgy_1.setBounds(10, 232, 123, 14);
		contentPane.add(lblGiVNgy_1);

		soChoOto = new JTextField();
		soChoOto.setBounds(150, 20, 254, 28);
		contentPane.add(soChoOto);
		soChoOto.setColumns(10);

		soChoXM = new JTextField();
		soChoXM.setBounds(150, 58, 254, 28);
		contentPane.add(soChoXM);
		soChoXM.setColumns(10);

		veTOto = new JTextField();
		veTOto.setBounds(150, 99, 254, 28);
		contentPane.add(veTOto);
		veTOto.setColumns(10);

		veNOto = new JTextField();
		veNOto.setBounds(150, 142, 254, 28);
		contentPane.add(veNOto);
		veNOto.setColumns(10);

		veTXM = new JTextField();
		veTXM.setBounds(150, 186, 254, 28);
		contentPane.add(veTXM);
		veTXM.setColumns(10);

		veNXM = new JTextField();
		veNXM.setBounds(150, 225, 254, 28);
		contentPane.add(veNXM);
		veNXM.setColumns(10);

		JButton btnNhap = new JButton("Nh\u1EADp");
		btnNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nhapTT() == true) {
					JOptionPane.showMessageDialog(null,
							"Nhập thông tin thành công");
					dispose();
				} else
					JOptionPane.showMessageDialog(null,
							"Nhập thông tin không thành công");
			}
		});
		btnNhap.setBounds(155, 288, 152, 49);
		contentPane.add(btnNhap);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap11.jpg"));
		lblNewLabel.setBounds(0, 0, 444, 372);
		contentPane.add(lblNewLabel);
	}

	/**
	 * nhập thông tin bãi gửi xe vào cơ sở dữ liệu.
	 *
	 * @return true, if successful
	 */
	public boolean nhapTT() {
		if (soChoOto.getText().equals("") || soChoXM.getText().equals("")
				|| veTOto.getText().equals("") || veNOto.getText().equals("")
				|| veTXM.getText().equals("") || veNXM.getText().equals("")) {

			return false;
		} else {
			try {
				Database.loadData();

				String oto = "SELECT* FROM giaveoto";
				ResultSet rs = Database.result(oto);
				while (rs.next()) {

					String sql = "UPDATE giaveoto SET vethang='"
							+ veTOto.getText() + "'";
					PreparedStatement pstm = Database.getCon()
							.prepareStatement(sql);
					pstm.executeUpdate();
					pstm.close();
					String sql2 = "UPDATE giaveoto SET vengay='"
							+ veNOto.getText() + "'";
					PreparedStatement psttm = Database.getCon()
							.prepareStatement(sql2);
					psttm.executeUpdate();
					psttm.close();
				}

				String xemay = "SELECT* FROM giavexemay";
				ResultSet rst = Database.result(xemay);
				while (rst.next()) {

					String sql = "UPDATE giavexemay SET vethang='"
							+ veTXM.getText() + "'";
					PreparedStatement pstm = Database.getCon()
							.prepareStatement(sql);
					pstm.executeUpdate();
					pstm.close();
					String sql2 = "UPDATE giavexemay SET vengay='"
							+ veNXM.getText() + "'";
					PreparedStatement psttm = Database.getCon()
							.prepareStatement(sql2);
					psttm.executeUpdate();
					psttm.close();
				}

				String socho = "SELECT* FROM socho";
				ResultSet rstt = Database.result(socho);
				while (rstt.next()) {

					String sql = "UPDATE socho SET oto='" + soChoOto.getText()
							+ "'";
					PreparedStatement pstm = Database.getCon()
							.prepareStatement(sql);
					pstm.executeUpdate();
					pstm.close();
					String sql2 = "UPDATE socho SET xemay='"
							+ soChoXM.getText() + "'";
					PreparedStatement psttm = Database.getCon()
							.prepareStatement(sql2);
					psttm.executeUpdate();
					psttm.close();

					String sochocontrong = "SELECT* FROM sochocontrong";
					ResultSet rsstt = Database.result(sochocontrong);
					while (rsstt.next()) {

						String sql1 = "UPDATE sochocontrong SET oto='"
								+ soChoOto.getText() + "'";
						PreparedStatement pspt = Database.getCon()
								.prepareStatement(sql1);
						pspt.executeUpdate();
						pspt.close();
						String sql3 = "UPDATE sochocontrong SET xemay='"
								+ soChoXM.getText() + "'";
						PreparedStatement psspt = Database.getCon()
								.prepareStatement(sql3);
						psspt.executeUpdate();
						psspt.close();

					}
				}

				return true;

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
