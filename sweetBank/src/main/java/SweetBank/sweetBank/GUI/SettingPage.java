package SweetBank.sweetBank.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class SettingPage extends JFrame implements IRegulator {

	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;
	
	private JPanel settingsPagePanel;
	private JTextField phoneNumberText;
	private JTextField passwordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingPage frame = new SettingPage();
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
	@Override
	public void setContentPane(Container contentPane) {
		// TODO Auto-generated method stub
		super.setContentPane(contentPane);
		contentPane.setVisible(true);
	}
	public SettingPage() {
		
		actionSettingService = new ActionSettingService() {
			public void visable(JFrame oldFrame, JFrame newFrame) { }
			public void visable(MouseAdapter mouseAdapter, JFrame newFrame) {}
			public void visable(ActionListener actionListener, JFrame newFrame) {}
		};
		buttonSettingService = new ButtonSettingService() {
			public void originalForegroundColor(JButton button, Color foregroundColor) {			}
			public void originalBackgroundColor(JButton button, Color backgroundColor) {}
			public void foregroundColor(JButton button, Color foregroundColor) {}
			public void backgroundColor(JButton button, Color backgroundColor) {}
		};
		
		textSettingService = new TextSettingService() {
			public void setOnlyNumber(JTextField textField) {}
			public void setOnlyAlphabetic(JTextField textField) {}
			public void setMaxLimit(JTextField textField, int limit) {}
			public boolean isTextFilled(JPanel panel) {
				return false;
			}
			public int checkTheTextKeyReleased(JTextField textField, int moneyLimit) {
				return 0;
			}
			public void checkTheTextFocusLost(JTextField textField) {}
			public void checkTheTextFocusGained(JTextField textField, String original) {}
			@Override
			public boolean isLengthSmallFromThat(int lenght, String string) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		dialogSettingService = new DialogSettingService() {
			public void showPrivateMessage(JFrame frame, String message) {}
			public void showNotNullMessage(JFrame frame) {}
		};
		
		
		setTitle("SQET BANK AYARLAR EKRANI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 385);
		settingsPagePanel = new JPanel();
		settingsPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(settingsPagePanel);
		settingsPagePanel.setLayout(null);
		
		JLabel previousIcon = new JLabel("");
		previousIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new AccountPage());
			}
		});
		previousIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\previousIcon.png"));
		previousIcon.setBounds(31, 23, 48, 40);
		settingsPagePanel.add(previousIcon);
		
		JLabel userNameLabel = new JLabel("Sayın [Kullanıcı adı soyadı]");
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setForeground(Color.RED);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		userNameLabel.setBackground(Color.GRAY);
		userNameLabel.setBounds(136, 23, 309, 30);
		settingsPagePanel.add(userNameLabel);
		
		JLabel phoneNumberLabel = new JLabel("Telefon Numaranız:");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		phoneNumberLabel.setBounds(31, 90, 152, 25);
		settingsPagePanel.add(phoneNumberLabel);
		
		phoneNumberText = new JTextField();
		phoneNumberText.setEnabled(false);
		phoneNumberText.setBounds(173, 90, 244, 25);
		settingsPagePanel.add(phoneNumberText);
		phoneNumberText.setColumns(10);
		
		JLabel phoneNumberChangeIcon = new JLabel("");
		
		phoneNumberChangeIcon.addMouseListener(new MouseAdapter() {
			private int clickCounter = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				if (this.clickCounter ==0) {
				phoneNumberText.setEnabled(true);
				clickCounter++;
				}else {
					phoneNumberText.setEnabled(false);
					JOptionPane.showMessageDialog(settingsPagePanel, "Telefon numarası güncellendi!");
					clickCounter = 0;
					
				}
			}
		});
		phoneNumberChangeIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\telNoDegistiIcon.png"));
		phoneNumberChangeIcon.setBounds(429, 75, 48, 40);
		settingsPagePanel.add(phoneNumberChangeIcon);
		
		JLabel passwordLabel = new JLabel("Şifreniz");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordLabel.setBounds(31, 143, 152, 25);
		settingsPagePanel.add(passwordLabel);
		
		passwordText = new JTextField();
		passwordText.setEnabled(false);
		passwordText.setColumns(10);
		passwordText.setBounds(173, 143, 244, 25);
		settingsPagePanel.add(passwordText);
		
		JLabel passwordChangeIcon = new JLabel("");
		passwordChangeIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new PasswordResetPage());
				
				
			}
		});
		passwordChangeIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\telNoDegistiIcon2.png"));
		passwordChangeIcon.setBounds(429, 128, 48, 40);
		settingsPagePanel.add(passwordChangeIcon);
		
		
		getEdits();
		settingsPagePanel.setFocusable(true);
	
		textSettingService.setOnlyNumber(phoneNumberText);
		textSettingService.setMaxLimit(phoneNumberText, 11);
		
		
	
		
	}

	@Override
	public void getEdits() {
		this.setLocationRelativeTo(null);
		
		
	}
}
