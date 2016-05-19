package present;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
// TODO: Auto-generated Javadoc

/**
 * tạo giao diện thiết lập thông tin bãi gửi xe
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class ThietLapThongTin extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The localhost. */
	private JTextField localhost;
	
	/** The database. */
	private JTextField database;
	
	/** The user. */
	private JTextField user;
	
	/** The passworld. */
	private JTextField passworld;
	
	/** The f. */
	File f = new File("THIETLAP.txt");
	
	/**
	 * Instantiates a new thiet lap thong tin.
	 */
	public ThietLapThongTin() {
		super("Thiết Lập Thông Tin Bãi Gửi Xe");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLocalhost = new JLabel("Localhost");
		lblLocalhost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocalhost.setBounds(22, 25, 95, 14);
		contentPane.add(lblLocalhost);

		localhost = new JTextField();
		localhost.setBounds(134, 19, 255, 28);
		contentPane.add(localhost);
		localhost.setColumns(10);

		JLabel lblDatabase = new JLabel("DATABASE");
		lblDatabase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatabase.setBounds(22, 69, 67, 14);
		contentPane.add(lblDatabase);

		database = new JTextField();
		database.setBounds(134, 63, 255, 28);
		contentPane.add(database);
		database.setColumns(10);

		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUser.setBounds(22, 113, 46, 14);
		contentPane.add(lblUser);

		user = new JTextField();
		user.setBounds(134, 107, 255, 28);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblPassworld = new JLabel("Passworld");
		lblPassworld.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassworld.setBounds(22, 158, 67, 14);
		contentPane.add(lblPassworld);

		passworld = new JTextField();
		passworld.setBounds(134, 152, 255, 28);
		contentPane.add(passworld);
		passworld.setColumns(10);

		JButton btnThietLap = new JButton("Thi\u1EBFt L\u1EADp");
		btnThietLap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (localhost.getText().equals("")
						&& database.getText().equals("")
						&& user.getText().equals("")
						&& passworld.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"yêu cầu nhập đầy đủ thông tin");
				} else {
					ghiThietLap();
					dispose();
					JOptionPane.showMessageDialog(null, "Thiết lập thành công");
					
					NhapThongTinBaiGuiXe frame = new NhapThongTinBaiGuiXe();
					frame.setVisible(true);
					
					
				}

			}
		});
		btnThietLap.setBounds(154, 210, 117, 40);
		contentPane.add(btnThietLap);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap4.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 350);
		contentPane.add(lblNewLabel);
		
		
	}
	
	/**
	 * ghi thông tin vào tệp.
	 */
	public void ghiThietLap() 
    {
        try{
            if(!f.exists())
                f.createNewFile();
            FileWriter fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(localhost.getText() + "\r\n");
            bw.write(database.getText() + "\r\n");
            bw.write(user.getText() + "\r\n");
            bw.write(passworld.getText());
            bw.close();
        }   
        catch(Exception e){}
    }
}
