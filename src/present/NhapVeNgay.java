package present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data_access.Database;
import entity.FileTypeFilter;
import entity.VeNgay;

// TODO: Auto-generated Javadoc
/**
 * tạo giao diện nhập vé ngày
 * xử lý dữ liệu.
 *
 * @author duonganh
 */
public class NhapVeNgay extends JFrame {

	/** The content pane. */
	private JPanel contentPane;
	
	/** The text field. */
	private JTextField textField;
	
	/** The xau. */
	private String xau = new String();
	
	/** The fi. */
	private File fi;
	

	/**
	 * Create the frame.
	 */
	public NhapVeNgay() {
		super("Nhập Vé Ngày");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(56, 76, 227, 35);
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Browser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser(new File("c:\\"));
				c.setDialogTitle("open a file");
				c.setFileFilter(new FileTypeFilter(".txt","Text file"));
				c.setFileFilter(new FileTypeFilter(".doc","word file"));	
				int rval = c.showOpenDialog( null);
				
				if (rval == JFileChooser.APPROVE_OPTION) {
					String filename = c.getSelectedFile().getName();
					String dir = c.getCurrentDirectory().toString();
					xau = dir + "\\" + filename;
					textField.setText(xau);
					
					fi = c.getSelectedFile();
					
				}
			}
		});
		btnNewButton.setBounds(301, 76, 89, 40);
		contentPane.add(btnNewButton);

		JButton btnNhpV = new JButton("Nh\u1EADp V\u00E9");
		btnNhpV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				load();
				dispose();
			}
		});
		btnNhpV.setBounds(91, 163, 89, 40);
		contentPane.add(btnNhpV);

		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setBounds(233, 163, 89, 40);
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		contentPane.add(btnThot);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("data\\icon\\dangnhap8.jpg"));
		lblNewLabel.setBounds(0, 0, 450, 300);
		contentPane.add(lblNewLabel);
		
		
	}
	
	/**
	 * đọc thông tin file được đưa vào.
	 *
	 * @param path the path
	 * @return the array list
	 */
	public ArrayList<VeNgay> docTep(String path) {
		ArrayList<VeNgay> array = new ArrayList<VeNgay>(); 
	
		
		try {
			Scanner input = new Scanner  (new File (path));
			String id, loaixe;
			while (input.hasNext()) {
				 id = input.nextLine();
				 loaixe = input.nextLine();
				array.add(new VeNgay(id, loaixe));
				
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array;
		
	}
	
	/**
	 * nhập thông tin các vé được nhập vào từ tệp  vào cơ sở dữ liệu.
	 */
	public void load() {
		try {
			Database.loadData();
			String sql = "INSERT INTO vengay (mave, loaixe)" + "VALUES(?, ?)";
			PreparedStatement sttm = Database.getCon().prepareStatement(sql);
			
			ArrayList<VeNgay> a = docTep(fi.getPath());
			for (int i=0; i<a.size(); i++)	{
			
				sttm.setString(1, a.get(i).getId());
				sttm.setString(2, a.get(i).getLoaixe());
				
				sttm.executeUpdate();
			}
			sttm.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Mã vé bị trùng");
		}
		
		
	}

}