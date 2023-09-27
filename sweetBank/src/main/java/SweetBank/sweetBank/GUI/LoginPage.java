package SweetBank.sweetBank.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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


@AllArgsConstructor
@RestController
public class LoginPage extends JFrame implements IRegulator{
	
	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;
	private final String KIMLIK_TEXT_ORIJINAL= "T.C. No / Müşteri No";
	private final String SIFRE_TEXT_ORIJINAL = "**********";

	
	
	private JTextField nationalIdentityText;
	private JPasswordField passwordText;
	private Color originalBackgraoundColor;
	private Component girisEkraniPanel;
	


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void setContentPane(Container contentPane) {
		// TODO Auto-generated method stub
		super.setContentPane(contentPane);
		contentPane.setVisible(true);
	}
	
	
	public LoginPage() {
		actionSettingService = new ActionSettingService() {
			public void visable(JFrame oldFrame, JFrame newFrame) {}
			public void visable(MouseAdapter mouseAdapter, JFrame newFrame) {}
			public void visable(ActionListener actionListener, JFrame newFrame) {}
		};
		buttonSettingService = new ButtonSettingService() {
			public void originalForegroundColor(JButton button, Color foregroundColor) {}
			public void originalBackgroundColor(JButton button, Color backgroundColor) {}
			public void foregroundColor(JButton button, Color foregroundColor) {}
			public void backgroundColor(JButton button, Color backgroundColor) {}
		};
		
		textSettingService = new TextSettingService() {
			public void setOnlyNumber(JTextField textField) {}
			public void setOnlyAlphabetic(JTextField textField) {}
			public void setMaxLimit(JTextField textField, int limit) {}
			public boolean isTextFilled(JPanel panel) {return false;}
			public int checkTheTextKeyReleased(JTextField textField, int moneyLimit) {return 0;}
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
	
		//new DbConnection();
		
		
		setTitle("Sweet Bank Giriş Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 425);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	

		JPanel loginPagePanel = new JPanel();
		loginPagePanel.setBackground(Color.LIGHT_GRAY);
		loginPagePanel.setBounds(20, 33, 423, 312);
		contentPane.add(loginPagePanel);
		loginPagePanel.setLayout(null);

		JLabel welcomeMessageLabel = new JLabel("SWEET BANKA HOŞGELDİNİZ!");
		welcomeMessageLabel.setForeground(new Color(153, 0, 0));
		welcomeMessageLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMessageLabel.setBounds(34, 11, 339, 19);
		loginPagePanel.add(welcomeMessageLabel);

		nationalIdentityText = new JTextField();
		textSettingService.setOnlyNumber(nationalIdentityText);
		nationalIdentityText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textSettingService.checkTheTextFocusGained(nationalIdentityText, KIMLIK_TEXT_ORIJINAL);

			}
			@Override
			public void focusLost(FocusEvent e) {
				textSettingService.checkTheTextFocusLost(nationalIdentityText);
			
			}
		});
		nationalIdentityText.setForeground(Color.GRAY);
		nationalIdentityText.setFont(new Font("Tahoma", Font.BOLD, 15));
		nationalIdentityText.setBounds(100, 50, 200, 30);
		loginPagePanel.add(nationalIdentityText);
		nationalIdentityText.setColumns(10);

		passwordText = new JPasswordField();
		passwordText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textSettingService.checkTheTextFocusGained(passwordText, SIFRE_TEXT_ORIJINAL);
			
			}
			@Override
			public void focusLost(FocusEvent e) {
				textSettingService.checkTheTextFocusLost(passwordText);
				
			}
		});
		passwordText.setForeground(Color.GRAY);
		passwordText.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordText.setBounds(100, 100, 200, 30);
		loginPagePanel.add(passwordText);

		JButton loginButton = new JButton("GİRİŞ");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSettingService.visable(this, new AccountPage());
			
			}
		});
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(loginButton, Color.cyan);
				buttonSettingService.foregroundColor(loginButton, Color.blue);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(loginButton, originalBackgraoundColor);
				buttonSettingService.originalForegroundColor(loginButton, originalBackgraoundColor);

			}
		});
		loginButton.setBackground(Color.WHITE);
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginButton.setBounds(150, 150, 100, 30);
		loginPagePanel.add(loginButton);
		

		JLabel notCustomerYetLabel = new JLabel("Hala müşterimiz değilmisiniz!");
		notCustomerYetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		notCustomerYetLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		notCustomerYetLabel.setBounds(34, 266, 225, 19);
		loginPagePanel.add(notCustomerYetLabel);

		JButton applyButon = new JButton("BAŞVUR");
		applyButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSettingService.visable(this, new ApplicationPage());
			}
		});
		applyButon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(applyButon, Color.cyan);
				buttonSettingService.foregroundColor(applyButon, Color.blue);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(applyButon, originalBackgraoundColor);
				buttonSettingService.originalForegroundColor(applyButon, originalBackgraoundColor);
				
			}
		});
		applyButon.setForeground(Color.BLACK);
		applyButon.setFont(new Font("Tahoma", Font.BOLD, 15));
		applyButon.setBackground(Color.CYAN);
		applyButon.setBounds(282, 260, 100, 30);
		loginPagePanel.add(applyButon);
		
		JLabel forgotLabel = new JLabel("Şifreni mi unuttun!");
		forgotLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PasswordResetPage passwordResetPage = new PasswordResetPage();
				actionSettingService.visable(this, new PasswordResetPage());
			passwordResetPage.getEskiSifreText().setEnabled(false);
			}
		});
		forgotLabel.setHorizontalAlignment(SwingConstants.CENTER);
		forgotLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		forgotLabel.setBounds(88, 193, 212, 16);
		loginPagePanel.add(forgotLabel);



	}
	@Override
	public void getEdits() {
		
		girisEkraniPanel.setFocusable(true);
		nationalIdentityText.setText(KIMLIK_TEXT_ORIJINAL);
		passwordText.setText(SIFRE_TEXT_ORIJINAL);
		textSettingService.setOnlyNumber(nationalIdentityText);
		
		
	}
}
