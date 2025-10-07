package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import config.MyProduct;
import model.MyMember;
import model.MyOrder;
import util.Tool;

public class OrderController extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JTextField nameTextField;
	private JTextField product1TextField;
	private JTextField product2TextField;
	private JTextField product3TextField;
	private JTextField product4TextField;
	private JLabel calculateLabel;
	private JCheckBox payCheckBox;
	private JCheckBox memberCheckBox;
	private JTextArea resultTextArea;
	
	final String title = "萊爾學校飲料訂購系統";
	final String nameTitle = "顧客姓名";
	final String totalTitle = "小計";
	final String confirmButtonTitle = "確定下單";
	final String resetButtonTitle = "清除訂單";
	final String printButtonTitle = "列印收據";
	final String backButtonTitle = "返回";
	final String payCheckBoxTitle = "使用excel pay進行支付(滿1500可享有87折優惠)";
	final String memberCheckBoxTitle = "使用尊爵不凡綠色黨證(可享有4折優惠, 優先計算)";
	
	private int totalBlackTea = 0;
	private int totalGreenTea = 0;
	private int totalOolongTea = 0;
	private int totalMilkTea = 0;
	private MyMember m = Tool.readMyMember();
	private MyOrder o = Tool.readMyOrder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderController frame = new OrderController();
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
	public OrderController() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.WHITE);
		titlePanel.setBounds(10, 10, 460, 40);
		contentPane.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel(title);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(0, 0, 460, 40);
		titlePanel.add(titleLabel);
		
		JPanel namePanel = new JPanel();
		namePanel.setBackground(Color.WHITE);
		namePanel.setBounds(60, 60, 150, 40);
		contentPane.add(namePanel);
		namePanel.setLayout(null);
		
		JLabel nameLabel = new JLabel(nameTitle);
		nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		nameLabel.setBounds(10, 0, 130, 40);
		namePanel.add(nameLabel);
		
		JPanel product1Panel = new JPanel();
		product1Panel.setBackground(Color.WHITE);
		product1Panel.setBounds(60, 110, 150, 40);
		contentPane.add(product1Panel);
		product1Panel.setLayout(null);
		
		JLabel product1Label = new JLabel(MyProduct.BlackTea.getDescription());
		product1Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product1Label.setBounds(10, 0, 130, 40);
		product1Panel.add(product1Label);
		
		JPanel product2Panel = new JPanel();
		product2Panel.setBackground(Color.WHITE);
		product2Panel.setBounds(60, 160, 150, 40);
		contentPane.add(product2Panel);
		product2Panel.setLayout(null);
		
		JLabel product2Label = new JLabel(MyProduct.GreenTea.getDescription());
		product2Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product2Label.setBounds(10, 0, 130, 40);
		product2Panel.add(product2Label);
		
		JPanel product3Panel = new JPanel();
		product3Panel.setBackground(Color.WHITE);
		product3Panel.setBounds(60, 210, 150, 40);
		contentPane.add(product3Panel);
		product3Panel.setLayout(null);
		
		JLabel product3Label = new JLabel(MyProduct.OolongTea.getDescription());
		product3Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product3Label.setBounds(10, 0, 130, 40);
		product3Panel.add(product3Label);
		
		JPanel product4Panel = new JPanel();
		product4Panel.setBackground(Color.WHITE);
		product4Panel.setBounds(60, 260, 150, 40);
		contentPane.add(product4Panel);
		product4Panel.setLayout(null);
		
		JLabel product4Label = new JLabel(MyProduct.MilkTea.getDescription());
		product4Label.setHorizontalAlignment(SwingConstants.TRAILING);
		product4Label.setBounds(10, 0, 130, 40);
		product4Panel.add(product4Label);
			
		JPanel totalPanel = new JPanel();
		totalPanel.setBackground(Color.WHITE);
		totalPanel.setBounds(60, 310, 150, 40);
		contentPane.add(totalPanel);
		totalPanel.setLayout(null);
		
		JLabel totalLabel = new JLabel(totalTitle);
		totalLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		totalLabel.setBounds(10, 0, 130, 40);
		totalPanel.add(totalLabel);
		
		nameTextField = new JTextField();
		nameTextField.setEnabled(false);
		nameTextField.setEditable(false);
		nameTextField.setBounds(220, 60, 200, 40);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setText(m.getName());
		
		product1TextField = new JTextField();
		product1TextField.setBounds(220, 110, 200, 40);
		contentPane.add(product1TextField);
		product1TextField.setColumns(10);
		product1TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateBlackTea();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateBlackTea();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateBlackTea();
            }
        });
		
		product2TextField = new JTextField();
		product2TextField.setBounds(220, 160, 200, 40);
		contentPane.add(product2TextField);
		product2TextField.setColumns(10);
		product2TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateGreenTea();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateGreenTea();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateGreenTea();
            }
        });
		
		product3TextField = new JTextField();
		product3TextField.setBounds(220, 210, 200, 40);
		contentPane.add(product3TextField);
		product3TextField.setColumns(10);
		product3TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateOolongTea();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateOolongTea();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateOolongTea();
            }
        });
		
		product4TextField = new JTextField();
		product4TextField.setBounds(220, 260, 200, 40);
		contentPane.add(product4TextField);
		product4TextField.setColumns(10);
		product4TextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	updateMilkTea();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	updateMilkTea();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	updateMilkTea();
            }
        });
		
		JPanel calculatePanel = new JPanel();
		calculatePanel.setBackground(Color.WHITE);
		calculatePanel.setBounds(220, 310, 200, 40);
		contentPane.add(calculatePanel);
		calculatePanel.setLayout(null);
		
		calculateLabel = new JLabel("$");
		calculateLabel.setBounds(10, 0, 180, 40);
		calculatePanel.add(calculateLabel);
		
		payCheckBox = new JCheckBox(payCheckBoxTitle);
		payCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		payCheckBox.setBounds(10, 360, 460, 30);
		contentPane.add(payCheckBox);
		payCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateAmount();
			}
		});
		
		memberCheckBox = new JCheckBox(memberCheckBoxTitle);
		memberCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		memberCheckBox.setBounds(10, 390, 460, 30);
		contentPane.add(memberCheckBox);
		memberCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				updateAmount();
			}
		});
		
		resultTextArea = new JTextArea();
		resultTextArea.setBounds(10, 470, 460, 180);
		contentPane.add(resultTextArea);
		
		JButton confirmButton = new JButton(confirmButtonTitle);
		confirmButton.setBounds(10, 430, 90, 30);
		contentPane.add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if (totalBlackTea >= 0 && totalGreenTea >= 0 && totalOolongTea >= 0 && totalMilkTea >= 0) {
		    		showRecipt();
		    	} else {
		    		showError();
		    	}
		    }
		});
		
		JButton resetButton = new JButton(resetButtonTitle);
		resetButton.setBounds(130, 430, 90, 30);
		contentPane.add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		
		JButton printButton = new JButton(printButtonTitle);
		printButton.setBounds(260, 430, 90, 30);
		contentPane.add(printButton);
		printButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					resultTextArea.print();
				} catch (PrinterException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
		    }
		});
		
		JButton backButton = new JButton(backButtonTitle);
		backButton.setBounds(380, 430, 90, 30);
		contentPane.add(backButton);
		
		backButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		        MenuController mc = new MenuController();
		        mc.setVisible(true);
		        
		        dispose();
		    }
		});
		
		setTimer();
	}
	
	private void updateBlackTea() {
		try {
			if (product1TextField.getText().length() > 0) {
				int product1Value = Integer.parseInt(product1TextField.getText());
				if (product1Value >= 0) {
					o.setBlackTea(product1Value);
					totalBlackTea = product1Value * MyProduct.BlackTea.getPrice();
				}
			}
		} catch (NumberFormatException exception) {
			totalBlackTea = -1;
		}
	}
	
	private void updateGreenTea() {
		try {
			if (product2TextField.getText().length() > 0) {
				int product2Value = Integer.parseInt(product2TextField.getText());
				if (product2Value >= 0) {
					o.setGreenTea(product2Value);
					totalGreenTea = product2Value * MyProduct.GreenTea.getPrice();
				}
			}
		} catch (NumberFormatException e) {
			totalGreenTea = -1;
		}
	}
	
	private void updateOolongTea() {
		try {
			if (product3TextField.getText().length() > 0) {
				int product3Value = Integer.parseInt(product3TextField.getText());
				if (product3Value >= 0) {
					o.setOolongTea(product3Value);
					totalOolongTea = product3Value * MyProduct.OolongTea.getPrice();
				}
			}
		} catch (NumberFormatException e) {
			totalOolongTea = -1;
		}
	}
	
	private void updateMilkTea() {
		try {
			if (product4TextField.getText().length() > 0) {
				int product4Value = Integer.parseInt(product4TextField.getText());
				if (product4Value >= 0) {
					o.setMilkTea(product4Value);
					totalMilkTea = product4Value * MyProduct.MilkTea.getPrice();
				}
			}
		} catch (NumberFormatException e) {
			totalMilkTea = -1;
		}
	}
	
	private void updateAmount() {
		updateBlackTea();
		updateGreenTea();
		updateOolongTea();
		updateMilkTea();
		
		calculateLabel.setText("$ " + calculate());
	}
	
	private double calculate() {
		double blackTea = o.getBlackTea() * MyProduct.BlackTea.getPrice();
		double greenTea = o.getGreenTea() * MyProduct.GreenTea.getPrice();
		double oolongTea = o.getOolongTea() * MyProduct.OolongTea.getPrice();
		double milkTea = o.getMilkTea() * MyProduct.MilkTea.getPrice();
		double result = blackTea + greenTea + oolongTea + milkTea;
		
		if (memberCheckBox.isSelected()) {
			result = result * 0.4;
		}
		
		if (payCheckBox.isSelected() && result >= 1500) {
			result = result * 0.87;
		}
		
		return result;
	}
	
	private void reset() {
		o = null;
		
		nameTextField.setText(null);
		product1TextField.setText(null);
		product2TextField.setText(null);
		product3TextField.setText(null);
		product4TextField.setText(null);
		payCheckBox.setSelected(false);
		memberCheckBox.setSelected(false);
		resultTextArea.setText(null);
		
		updateAmount();
	}
	
	private String getLocalTimeNow() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		return "現在時間: " + now.format(dtf);
	}
	
	private void showRecipt() {
		String time = "結帳時間: " + getLocalTimeNow();
		String username = "客戶: " + nameTextField.getText();
		String blackTea = "紅茶: " + o.getBlackTea() + "杯, 共 " + totalBlackTea + "元";
		String greenTea = "綠茶: " + o.getGreenTea() + "杯, 共 " + totalGreenTea + "元";
		String oolongTea = "烏龍茶: " + o.getOolongTea() + "杯, 共 " + totalOolongTea + "元";
		String milkTea = "奶茶: " + o.getMilkTea() + "杯, 共 " + totalMilkTea + "元";
		String total = "共" + Math.round(calculate()) + "元 (最後顯示金額為四捨五入至整數)";
		
		String recipt = time + "\n" + username + "\n" + blackTea + "\n" + greenTea + "\n" + oolongTea + "\n" + milkTea + "\n" + total;
		resultTextArea.setText(recipt);
		
		Tool.saveMyOrder(o);
	}
	
	private void showError() {
		String errorMessage = "輸入內容有誤, 請重新確認!";
		resultTextArea.setText(errorMessage);
	}
	
	private void setTimer() {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                titleLabel.setText(getLocalTimeNow());
            }
        }, 0, 1000);
	}

}
