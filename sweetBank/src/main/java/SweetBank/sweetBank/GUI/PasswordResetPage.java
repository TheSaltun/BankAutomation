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

@Data
@AllArgsConstructor
@RestController
public class PasswordResetPage extends JFrame implements IRegulator{
	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;

	private static final long serialVersionUID = 1L;
	private JPanel resetPasswordPanel;
	private JTextField nationalIdentityText;
	private JTextField phoneText;
	private JTextField answerSecurityQuestionLabelText;
	private JPasswordField oldPasswordText;
	private JPasswordField newPasswordText;
	private JPasswordField newPasswordAgainText;
	private boolean isEnabledEskiSifreText() {
		return this.getEskiSifreText().isEnabled();
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordResetPage frame = new PasswordResetPage();
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
	public PasswordResetPage() {
		actionSettingService = new ActionSettingService() {
			public void visable(JFrame oldFrame, JFrame newFrame) { }
			public void visable(MouseAdapter mouseAdapter, JFrame newFrame) {}
			public void visable(ActionListener actionListener, JFrame newFrame) {}
		};
		buttonSettingService = new ButtonSettingService() {
			public void originalForegroundColor(JButton button, Color foregroundColor) {
			}
			public void originalBackgroundColor(JButton button, Color backgroundColor) {}
			public void foregroundColor(JButton button, Color foregroundColor) {}
			public void backgroundColor(JButton button, Color backgroundColor) {
			}
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 464);
		resetPasswordPanel = new JPanel();
		resetPasswordPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(resetPasswordPanel);
		resetPasswordPanel.setLayout(null);
		
		JLabel logoutIcon = new JLabel("");
		logoutIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isEnabledEskiSifreText()) {
					actionSettingService.visable(this, new SettingPage());
								
				}else {
					actionSettingService.visable(this, new AccountPage());
					
				}
			}
		});
		logoutIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\previousIcon.png"));
		logoutIcon.setBounds(24, 35, 48, 40);
		resetPasswordPanel.add(logoutIcon); 
		
		JLabel passwordRenewLabel = new JLabel("ŞİFRE YENİLEME");
		passwordRenewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordRenewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordRenewLabel.setBounds(181, 35, 265, 40);
		resetPasswordPanel.add(passwordRenewLabel);
		
		JLabel nationalIdentityLabel = new JLabel("T.C. No:");
		nationalIdentityLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		nationalIdentityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nationalIdentityLabel.setBounds(108, 110, 127, 25);
		resetPasswordPanel.add(nationalIdentityLabel);
		
		nationalIdentityText = new JTextField();
		nationalIdentityText.setBounds(303, 110, 235, 25);
		resetPasswordPanel.add(nationalIdentityText);
		nationalIdentityText.setColumns(10);
		
		phoneText = new JTextField();
		phoneText.setColumns(10);
		phoneText.setBounds(305, 150, 235, 25);
		resetPasswordPanel.add(phoneText);
		
		JLabel phoneLabel = new JLabel("Telefon No:");
		phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		phoneLabel.setBounds(110, 150, 127, 25);
		resetPasswordPanel.add(phoneLabel);
		
		answerSecurityQuestionLabelText = new JTextField();
		answerSecurityQuestionLabelText.setColumns(10);
		answerSecurityQuestionLabelText.setBounds(305, 188, 235, 25);
		resetPasswordPanel.add(answerSecurityQuestionLabelText);
		
		JLabel answerSecurityQuestionLabel = new JLabel("Güvenlik Sorusu Cevabı :");
		answerSecurityQuestionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		answerSecurityQuestionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		answerSecurityQuestionLabel.setBounds(37, 188, 200, 25);
		resetPasswordPanel.add(answerSecurityQuestionLabel);
		
		JLabel oldPasswordLabel = new JLabel("Eski şifre :");
		oldPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		oldPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		oldPasswordLabel.setBounds(106, 226, 127, 25);
		resetPasswordPanel.add(oldPasswordLabel);
		
		JLabel newPasswordLabel = new JLabel("Yeni Şifre :");
		newPasswordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		newPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		newPasswordLabel.setBounds(108, 266, 127, 25);
		resetPasswordPanel.add(newPasswordLabel);
		
		JLabel newPasswordAgainLabel = new JLabel("Yeni Şifre Tekrar :");
		newPasswordAgainLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		newPasswordAgainLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		newPasswordAgainLabel.setBounds(108, 304, 127, 25);
		resetPasswordPanel.add(newPasswordAgainLabel);
		
		oldPasswordText = new JPasswordField();
		oldPasswordText.setBounds(303, 226, 235, 25);
		resetPasswordPanel.add(oldPasswordText);
		
		newPasswordText = new JPasswordField();
		newPasswordText.setBounds(303, 266, 235, 25);
		resetPasswordPanel.add(newPasswordText);
		
		newPasswordAgainText = new JPasswordField();
		newPasswordAgainText.setBounds(303, 304, 235, 25);
		resetPasswordPanel.add(newPasswordAgainText);
		
		JButton resetPasswordButton = new JButton("Şifreyi Yenile");
		resetPasswordButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		resetPasswordButton.setBounds(363, 356, 149, 25);
		resetPasswordPanel.add(resetPasswordButton);
		
		
		
		getEdits();
		resetPasswordPanel.setFocusable(true);
		textSettingService.setMaxLimit(nationalIdentityText, 11);
		textSettingService.setOnlyNumber(nationalIdentityText);
		textSettingService.setOnlyNumber(phoneText);
		textSettingService.setMaxLimit(phoneText, 11);
		
	}

	

	public JPasswordField getEskiSifreText() {
		return oldPasswordText;
	}

	

	@Override
	public void getEdits() {
		this.setLocationRelativeTo(null);
		
	}
}
