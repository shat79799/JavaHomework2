package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.MyMember;
import util.Tool;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class MenuController extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyMember m = Tool.readMyMember();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuController frame = new MenuController();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuController() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Welcome, " + m.getName());
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		titleLabel.setBounds(50, 50, 400, 30);
		contentPane.add(titleLabel);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(150, 300, 200, 50);
		contentPane.add(logoutButton);
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton memberButton = new JButton("Your profile");
		memberButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		memberButton.setBounds(50, 150, 150, 100);
		contentPane.add(memberButton);
		memberButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goMember();
			}
		});
		
		JButton orderButton = new JButton("order");
		orderButton.setBounds(300, 150, 150, 100);
		contentPane.add(orderButton);
		orderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				goOrder();
			}
		});

	}
	
	private void goMember() {
		MemberController mc = new MemberController();
		mc.setVisible(true);
		
		dispose();
	}
	
	private void goOrder() {
		OrderController oc = new OrderController();
		oc.setVisible(true);
		
		dispose();
	}

}
