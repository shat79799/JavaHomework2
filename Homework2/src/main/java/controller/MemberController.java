package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.MyMember;
import util.Tool;

public class MemberController extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel addressLabel;
	private JLabel phoneLabel;
	private JTextField nameTextField;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private JButton backButton;
	private MyMember m = Tool.readMyMember();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberController frame = new MemberController();
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
	public MemberController() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("Your profile");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(50, 30, 400, 30);
		contentPane.add(titleLabel);
		
		nameLabel = new JLabel("name");
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(50, 100, 100, 30);
		contentPane.add(nameLabel);
		
		usernameLabel = new JLabel("username");
		usernameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(50, 150, 100, 30);
		contentPane.add(usernameLabel);
		
		passwordLabel = new JLabel("password");
		passwordLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(50, 200, 100, 30);
		contentPane.add(passwordLabel);
		
		addressLabel = new JLabel("address");
		addressLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setBounds(50, 250, 100, 30);
		contentPane.add(addressLabel);
		
		phoneLabel = new JLabel("phone");
		phoneLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setBounds(50, 300, 100, 30);
		contentPane.add(phoneLabel);
		
		nameTextField = new JTextField();
		nameTextField.setEnabled(false);
		nameTextField.setEditable(false);
		nameTextField.setBounds(200, 100, 250, 30);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setText(m.getName());
		
		usernameTextField = new JTextField();
		usernameTextField.setEnabled(false);
		usernameTextField.setEditable(false);
		usernameTextField.setBounds(200, 150, 250, 30);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		usernameTextField.setText(m.getUsername());
		
		passwordTextField = new JTextField();
		passwordTextField.setEnabled(false);
		passwordTextField.setEditable(false);
		passwordTextField.setBounds(200, 200, 250, 30);
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);
		passwordTextField.setText(m.getPassword());
		
		addressTextField = new JTextField();
		addressTextField.setEnabled(false);
		addressTextField.setEditable(false);
		addressTextField.setBounds(200, 250, 250, 30);
		contentPane.add(addressTextField);
		addressTextField.setColumns(10);
		addressTextField.setText(m.getAddress());
		
		phoneTextField = new JTextField();
		phoneTextField.setEnabled(false);
		phoneTextField.setEditable(false);
		phoneTextField.setBounds(200, 300, 250, 30);
		contentPane.add(phoneTextField);
		phoneTextField.setColumns(10);
		phoneTextField.setText(m.getPhone());
		
		backButton = new JButton("Go back");
		backButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		backButton.setBounds(150, 400, 200, 30);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		
	}
	
	private void goBack() {
		MenuController mc = new MenuController();
		mc.setVisible(true);
		
		dispose();
	}

}
