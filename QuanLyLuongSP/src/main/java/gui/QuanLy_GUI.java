package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuKeyEvent;

import dao.NhanVien_DAO;
import entity.NhanVien;



import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.Component;

public class QuanLy_GUI extends JFrame implements MouseListener,ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JLabel label;
	private JLabel lblQL;
	private JButton btnDangXuat;
	private JPanel panel;
	
	private int kt = 0;
	private JButton btnTroGiup;
	private int page = 0;
	private JLabel lbCty;
	private JLabel lbNV;
	private JLabel lbllogo;
	private NhanVien_DAO nvDao =new NhanVien_DAO();
	private NhanVien nv = nvDao.getNVtheoma(Login_GUI.txtTendn.getText());
	/**
	 * Create the frame.
	 */
	public QuanLy_GUI(NhanVien nv) {
		
		ImageIcon img = new ImageIcon(QuanLy_GUI.class.getResource("/images/logo11.png"));
		setIconImage(img.getImage());
		
		setResizable(true);
		
		
		setTitle("Chương Trình Quản lý tính lương theo sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(0, 0, 1540, 825);
//		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(3, 101, 1530, 690);
		panel.add(tabbedPane);
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/home_48px.png"));
		tabbedPane.addTab("Trang chủ",icon,new SlideShow_GUI(nv),"Trang chủ");
		tabbedPane.addTab("Quản lý nhân viên",new ImageIcon(QuanLy_GUI.class.getResource("/images/staff_48px.png")),
				new QLNV(), "Quản lý nhân viên");
		tabbedPane.addTab("Quản lý sản phẩm", new ImageIcon(QuanLy_GUI.class.getResource("/images/clothes.png")),
				new QLSP_GUI(), null);
		tabbedPane.addTab("Dữ liệu tính lương",new ImageIcon(QuanLy_GUI.class.getResource("/images/dataluong.png")) ,
				null, "Dữ liệu tính lương");
		tabbedPane.addTab("Tính lương", new ImageIcon(QuanLy_GUI.class.getResource("/images/dollar.png")), null,
				null);
		
		tabbedPane.addTab("Thống kê", new ImageIcon(QuanLy_GUI.class.getResource("/images/Thongke.png")), new QuanLy_ThongKe(), null);
	
//		tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jTabbedPane1MouseClicked(evt);
//            }
//        });
		tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
//		tabbedPane.setComponentAt(3, new TinhLuong_GUI());
		
		
		
//		tabbedPane.setBackground(new Color(50, 168, 82));
		tabbedPane.setBackground(new Color(204,255,204));
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		if(nv.isGioiTinh())
		{
			label.setIcon(new ImageIcon(QuanLy_GUI.class.getResource("/images/userr.png")));
		}
		else
		{
			label.setIcon(new ImageIcon(QuanLy_GUI.class.getResource("/images/nu.jpg")));
		}
		label.setBounds(1000, 0, 90, 90);
		panel.add(label);

		lbCty = new JLabel("Công ty may mặc Cao Thắng");
		lbCty.setHorizontalAlignment(SwingConstants.LEFT);
		lbCty.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbCty.setBounds(70, 11, 500,70);
		
		lbllogo = new JLabel();
		lbllogo.setIcon(new ImageIcon(QuanLy_GUI.class.getResource("/images/factory1.png")));
		lbllogo.setBounds(10, 11,50, 50);
		panel.add(lbllogo);
		panel.add(lbCty);

		btnDangXuat = new JButton("Đăng xuất");
		
//		btnDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setIcon(new ImageIcon(QuanLy_GUI.class.getResource("/images/exit.png")));
		btnDangXuat.setBounds(1390, 50, 138, 33);
		btnDangXuat.setBackground(new Color(51,153,255));
		lbNV = new JLabel(nv.getTenNV());
	
		lbNV.setBounds(1100, 11, 150,133);
		panel.add(lbNV);
		panel.add(btnDangXuat);
		List<String> l = new ArrayList<String>();
		
	
		btnTroGiup = new JButton("Trợ giúp");
		btnDangXuat.setMnemonic(MenuKeyEvent.VK_X);
		btnTroGiup.setMnemonic(MenuKeyEvent.VK_H);
		btnTroGiup.setBorderPainted(false);
		btnTroGiup.setFocusPainted(false);
		btnTroGiup.setBackground(new Color(51,153,255));
		btnTroGiup.setBounds(1240, 50, 138, 33);
		panel.add(btnTroGiup);
		btnDangXuat.addActionListener(this);
		btnTroGiup.addActionListener(this);
		btnTroGiup.setIcon(new ImageIcon(QuanLy_GUI.class.getResource("/Photo for Design Form/About.png")));
			
		
		
		
		
			
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(btnDangXuat))
		{
			int yn = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất", "Thông báo", JOptionPane.YES_NO_OPTION);
			if(yn== JOptionPane.YES_OPTION) {
				setVisible(false);
				new Login_GUI().setVisible(true);
			}
			
		}
		if(obj.equals(btnTroGiup))
		{
			int row = tabbedPane.getSelectedIndex();
//			JOptionPane.showMessageDialog(null, row);
			
			
		
			new TroGiup(row-1).setVisible(true);
			
		        
		
			
		}
		
			
	}
	private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
		int row = tabbedPane.getSelectedIndex();
		if(row == 0)
		{
			tabbedPane.setComponentAt(0, new SlideShow_GUI(nv));
		}
		else if(row == 1)
		{
			tabbedPane.setComponentAt(1, new QLNV());
		}
		else if (row ==2)
		{
			tabbedPane.setComponentAt(2, new QLSP_GUI());
		}
		else if (row ==3)
		{
			tabbedPane.setComponentAt(3, new DuLieuTinhLuong_GUI());
		}
		else if (row ==4)
		{
			tabbedPane.setComponentAt(4, new TinhLuong_GUI());
		}
		else if (row ==5)
		{
			tabbedPane.setComponentAt(5, new QuanLy_ThongKe());
		}
    } 
	
	 private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {                                          
	        // TODO add your handling code here:
		 int row = tabbedPane.getSelectedIndex();
			if(row == 0)
			{
				tabbedPane.setComponentAt(0, new SlideShow_GUI(nv));
			}
			else if(row == 1)
			{
				tabbedPane.setComponentAt(1, new QLNV());
			}
			else if (row ==2)
			{
				tabbedPane.setComponentAt(2, new QLSP_GUI());
			}
			else if (row ==3)
			{
				tabbedPane.setComponentAt(3, new DuLieuTinhLuong_GUI());
			}
			else if (row ==4)
			{
				tabbedPane.setComponentAt(4, new TinhLuong_GUI());
			}
			else if (row ==5)
			{
				tabbedPane.setComponentAt(5, new QuanLy_ThongKe());
			}
	    }  
	 


}
