package SweetBank.sweetBank.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.web.bind.annotation.RestController;

import SweetBank.sweetBank.Business.settings.Abstract.ActionSettingService;
import SweetBank.sweetBank.Business.settings.Abstract.ButtonSettingService;
import SweetBank.sweetBank.Business.settings.Abstract.DialogSettingService;
import SweetBank.sweetBank.Business.settings.Abstract.IRegulator;
import SweetBank.sweetBank.Business.settings.Abstract.TextSettingService;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@Data
@AllArgsConstructor
public class AccountPage extends JFrame implements IRegulator {
	
	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;
	

	@Override
	public void getEdits() {
		this.setLocationRelativeTo(null);
	
	}
	@Override
	public void setContentPane(Container contentPane) {
		// TODO Auto-generated method stub
		super.setContentPane(contentPane);
		contentPane.setVisible(true);
	}
	
	public AccountPage() {
		
		  actionSettingService = new ActionSettingService() { public void
		  visable(JFrame oldFrame, JFrame newFrame) { } public void
		  visable(MouseAdapter mouseAdapter, JFrame newFrame) {} public void
		  visable(ActionListener actionListener, JFrame newFrame) {} };
		  buttonSettingService = new ButtonSettingService() { public void
		  originalForegroundColor(JButton button, Color foregroundColor) {} public void
		  originalBackgroundColor(JButton button, Color backgroundColor) {} public void
		  foregroundColor(JButton button, Color foregroundColor) {} public void
		  backgroundColor(JButton button, Color backgroundColor) {} };
		  
		  textSettingService = new TextSettingService() { public void
		  setOnlyNumber(JTextField textField) {} public void
		  setOnlyAlphabetic(JTextField textField) {} public void setMaxLimit(JTextField
		  textField, int limit) {} public boolean isTextFilled(JPanel panel) {return
		  false;} public int checkTheTextKeyReleased(JTextField textField, int
		  moneyLimit) {return 0;} public void checkTheTextFocusLost(JTextField
		  textField) {} public void checkTheTextFocusGained(JTextField textField,
		  String original) {}
		@Override
		public boolean isLengthSmallFromThat(int lenght, String string) {
			// TODO Auto-generated method stub
			return false;
		} };
		  
		  dialogSettingService = new DialogSettingService() { public void
		  showPrivateMessage(JFrame frame, String message) {} public void
		  showNotNullMessage(JFrame frame) {} };
		 
		
		
		setTitle("Sweet Bank Account Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 443);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel accountPagePanel = new JPanel();
		accountPagePanel.setBackground(Color.LIGHT_GRAY);
		accountPagePanel.setBounds(0, 0, 576, 404);
		contentPane.add(accountPagePanel);
		accountPagePanel.setLayout(null);

		JLabel welcomeLabel = new JLabel("HOŞGELDİNİZ");
		welcomeLabel.setBounds(227, 5, 136, 22);
		welcomeLabel.setForeground(Color.BLUE);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		accountPagePanel.add(welcomeLabel);

		JLabel userNameLabel = new JLabel("{KULLANICI ADI SOYADI}");
		userNameLabel.setBounds(165, 46, 260, 16);
		userNameLabel.setForeground(Color.BLUE);
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		accountPagePanel.add(userNameLabel);

		JLabel tlIcon = new JLabel("");
		tlIcon.setBounds(120, 127, 115, 88);
		tlIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\turkishLiraIcon.png"));
		accountPagePanel.add(tlIcon);

		JLabel balanceLabel = new JLabel("BAKİYE");
		balanceLabel.setBounds(243, 154, 244, 31);
		balanceLabel.setFont(new Font("Arial", Font.BOLD, 25));
		accountPagePanel.add(balanceLabel);

		JLabel withdrawIcon = new JLabel("");
		withdrawIcon.setBounds(45, 256, 94, 56);
		withdrawIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\paraCekIcon.png"));
		accountPagePanel.add(withdrawIcon);

		JButton withdrawButton = new JButton("Para Çekme");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSettingService.visable(this, new WithdrawPage());
			}
		});
		withdrawButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(withdrawButton, Color.white);
				buttonSettingService.foregroundColor(withdrawButton, Color.black);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(withdrawButton, getBackground());
				buttonSettingService.originalForegroundColor(withdrawButton, getForeground());

			}
		});
		withdrawButton.setBounds(33, 325, 107, 25);
		withdrawButton.setFont(new Font("Arial", Font.BOLD, 15));
		accountPagePanel.add(withdrawButton);
		withdrawButton.setCursor(new Cursor(HAND_CURSOR));

		JLabel depositIcon = new JLabel("");
		depositIcon.setFont(new Font("Tahoma", Font.PLAIN, 10));
		depositIcon.setBounds(165, 256, 94, 56);
		depositIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\paraYatırIcon.png"));
		accountPagePanel.add(depositIcon);

		JButton depositButton = new JButton("Para Yatırma");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSettingService.visable(this, new DepositPage());

			}

		});
		depositButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(depositButton, Color.white);
				buttonSettingService.foregroundColor(depositButton, Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(depositButton, getBackground());
				buttonSettingService.originalForegroundColor(depositButton, getForeground());

			}
		});
		depositButton.setBounds(165, 325, 107, 25);
		depositButton.setFont(new Font("Arial", Font.BOLD, 20));
		accountPagePanel.add(depositButton);
		depositButton.setCursor(new Cursor(HAND_CURSOR));

		JLabel paymentIcon = new JLabel("");
		paymentIcon.setBounds(436, 256, 94, 56);
		paymentIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\odemelerIcon.png"));
		accountPagePanel.add(paymentIcon);

		JButton paymentButton = new JButton("Ödemeler");
		paymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSettingService.visable(this, new PaymentPage());
			}
		});
		paymentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(paymentButton, Color.white);
				buttonSettingService.foregroundColor(paymentButton, Color.black);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(paymentButton, getBackground());
				buttonSettingService.originalForegroundColor(paymentButton, getForeground());
			}
		});
		paymentButton.setBounds(436, 325, 107, 25);
		paymentButton.setFont(new Font("Arial", Font.BOLD, 20));
		accountPagePanel.add(paymentButton);
		paymentButton.setCursor(new Cursor(HAND_CURSOR));

		JLabel transferIcon = new JLabel("");
		transferIcon.setBounds(316, 256, 94, 56);
		transferIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\havaleIcon.png"));
		accountPagePanel.add(transferIcon);

		JButton transferButton = new JButton("Havale");
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSettingService.visable(this, new TransferPage());
			}
		});
		transferButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(transferButton, Color.white);
				buttonSettingService.foregroundColor(transferButton, Color.black);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(transferButton, getBackground());
				buttonSettingService.originalForegroundColor(transferButton, getForeground());

			}
		});
		transferButton.setBounds(304, 325, 107, 25);
		transferButton.setFont(new Font("Arial", Font.BOLD, 20));
		accountPagePanel.add(transferButton);
		transferButton.setCursor(new Cursor(HAND_CURSOR));

		JLabel logoutIcon = new JLabel("");
		logoutIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new LoginPage());
			}
		});
		logoutIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\logout.png"));
		logoutIcon.setBounds(12, 10, 64, 46);
		accountPagePanel.add(logoutIcon);
		logoutIcon.setCursor(new Cursor(HAND_CURSOR));

		JLabel settingsIcon = new JLabel("");
		settingsIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new SettingPage());
			}
		});
		settingsIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\settingsIcon.png"));
		settingsIcon.setBounds(497, 10, 64, 46);
		accountPagePanel.add(settingsIcon);
		settingsIcon.setCursor(new Cursor(HAND_CURSOR));
		

		getEdits();
		accountPagePanel.setFocusable(true);
		
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountPage frame = new AccountPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
