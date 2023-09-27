package SweetBank.sweetBank.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.sql.results.graph.FetchOptions;

import SweetBank.sweetBank.Business.Actions.Abstract.AccountInformationService;
import SweetBank.sweetBank.Business.Actions.Abstract.BillPaymentService;
import SweetBank.sweetBank.Business.Actions.Abstract.DepositMoneyService;
import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.Business.Actions.Abstract.TransferMoneyService;
import SweetBank.sweetBank.Business.Actions.Abstract.UserApplyService;
import SweetBank.sweetBank.Business.Actions.Abstract.UserLoginService;
import SweetBank.sweetBank.Business.Actions.Abstract.WithdrawMoneyService;
import SweetBank.sweetBank.Business.Actions.Concrete.AccountInformationManager;
import SweetBank.sweetBank.Business.settings.Abstract.ActionSettingService;
import SweetBank.sweetBank.Business.settings.Abstract.ButtonSettingService;
import SweetBank.sweetBank.Business.settings.Abstract.DialogSettingService;
import SweetBank.sweetBank.Business.settings.Abstract.IRegulator;
import SweetBank.sweetBank.Business.settings.Abstract.TextSettingService;
import SweetBank.sweetBank.Business.settings.Abstract.UserApplicationService;
import lombok.AllArgsConstructor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@AllArgsConstructor
public class ApplicationPage2 extends JFrame implements IRegulator, InformationControllerService{
	private TextSettingService textSettingService;
	private ButtonSettingService buttonSettingService;
	private ActionSettingService actionSettingService;
	private DialogSettingService dialogSettingService;
	
	private UserApplyService userApplyObjcet = null;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel applicationPagePanel;
	private JTextField securityAnswerText;
	private JTextField phoneNumberText;
	private JTextField nationalIdentityText;
	private JTextField nameText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationPage2 frame = new ApplicationPage2();
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
	public ApplicationPage2() {
		dialogSettingService = new DialogSettingService() {
			
			@Override
			public void showPrivateMessage(JFrame frame, String message) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void showNotNullMessage(JFrame frame) {
				// TODO Auto-generated method stub
				
			}
		};
		
		buttonSettingService = new ButtonSettingService() {
			
			@Override
			public void originalForegroundColor(JButton button, Color foregroundColor) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void originalBackgroundColor(JButton button, Color backgroundColor) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void foregroundColor(JButton button, Color foregroundColor) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void backgroundColor(JButton button, Color backgroundColor) {
				// TODO Auto-generated method stub
				
			}
		};
	
		textSettingService = new TextSettingService() {
			
			@Override
			public void setOnlyNumber(JTextField textField) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setOnlyAlphabetic(JTextField textField) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setMaxLimit(JTextField textField, int limit) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isTextFilled(JPanel panel) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isLengthSmallFromThat(int lenght, String string) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public int checkTheTextKeyReleased(JTextField textField, int moneyLimit) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void checkTheTextFocusLost(JTextField textField) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void checkTheTextFocusGained(JTextField textField, String original) {
				// TODO Auto-generated method stub
				
			}
		};
		actionSettingService = new ActionSettingService() {
			
			@Override
			public void visable(JFrame oldFrame, JFrame newFrame) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visable(MouseAdapter mouseAdapter, JFrame newFrame) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void visable(ActionListener actionListener, JFrame newFrame) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 493);
		applicationPagePanel = new JPanel();
		applicationPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(applicationPagePanel);
		applicationPagePanel.setLayout(null);
		
		JLabel securityAnswerLabel = new JLabel("Güvenlik Cavabı :");
		securityAnswerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		securityAnswerLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		securityAnswerLabel.setBounds(30, 318, 139, 26);
		applicationPagePanel.add(securityAnswerLabel);
		
		securityAnswerText = new JTextField();
		securityAnswerText.setFont(new Font("Tahoma", Font.BOLD, 12));
		securityAnswerText.setColumns(10);
		securityAnswerText.setBounds(198, 320, 220, 22);
		applicationPagePanel.add(securityAnswerText);
		
		JButton applyButton = new JButton("Başvur!");
		applyButton.addActionListener(new ActionListener() {
			private boolean isInformationValid;

			public void actionPerformed(ActionEvent e) {
				if (this.isInformationValid) {
					JOptionPane.showMessageDialog(applyButton, "Bşvurnuz kabul edilmiştir!");
					
				}else {
					JOptionPane.showMessageDialog(applyButton, "Tüm alanlar dolu olmalıdır");
				actionSettingService.visable(this, new AccountPage());	
					
				}
				
				
						
				}
		});
		applyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(applyButton, Color.black);
				buttonSettingService.foregroundColor(applyButton, Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(applyButton, getBackground());
				buttonSettingService.originalForegroundColor(applyButton, getForeground());
				
			}
		});
		applyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		applyButton.setBackground(Color.WHITE);
		applyButton.setBounds(259, 369, 97, 25);
		applicationPagePanel.add(applyButton);
		
		JComboBox securtyQuestion = new JComboBox();
		securtyQuestion.setBounds(198, 271, 220, 24);
		applicationPagePanel.add(securtyQuestion);
		
		JLabel securtyQuestionLabel = new JLabel("Güvenlik Sorusu :");
		securtyQuestionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		securtyQuestionLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		securtyQuestionLabel.setBounds(30, 270, 139, 26);
		applicationPagePanel.add(securtyQuestionLabel);
		
		phoneNumberText = new JTextField();
		phoneNumberText.setFont(new Font("Tahoma", Font.BOLD, 12));
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(198, 149, 220, 22);
		applicationPagePanel.add(phoneNumberText);
		
		JLabel securityInformationLabel = new JLabel("Güvenlik Bilgileri");
		securityInformationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		securityInformationLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		securityInformationLabel.setBounds(58, 216, 168, 26);
		applicationPagePanel.add(securityInformationLabel);
		
		JLabel phoneNumberLabel = new JLabel("Tel No :");
		phoneNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		phoneNumberLabel.setBounds(28, 147, 141, 26);
		applicationPagePanel.add(phoneNumberLabel);
		
		nationalIdentityText = new JTextField();
		nationalIdentityText.setFont(new Font("Tahoma", Font.BOLD, 12));
		nationalIdentityText.setColumns(10);
		nationalIdentityText.setBounds(198, 112, 220, 22);
		applicationPagePanel.add(nationalIdentityText);
		
		JLabel nationalIdentityLabel = new JLabel("T.C. No :");
		nationalIdentityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nationalIdentityLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nationalIdentityLabel.setBounds(30, 108, 139, 26);
		applicationPagePanel.add(nationalIdentityLabel);
		
		nameText = new JTextField();
		nameText.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameText.setColumns(10);
		nameText.setBounds(198, 71, 220, 22);
		applicationPagePanel.add(nameText);
		
		JLabel nameLabel = new JLabel("Ad Soyad :");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameLabel.setBounds(30, 71, 139, 25);
		applicationPagePanel.add(nameLabel);
		
		JLabel privateInformationLabel = new JLabel("Kişisel Bilgiler");
		privateInformationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		privateInformationLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		privateInformationLabel.setBounds(58, 31, 170, 25);
		applicationPagePanel.add(privateInformationLabel);
		
		getEdits();
		this.setLocationRelativeTo(null);
		setFocusable(true);
		textSettingService.setOnlyAlphabetic(nameText);
		textSettingService.setOnlyNumber(nationalIdentityText);
		textSettingService.setOnlyNumber(phoneNumberText);
		textSettingService.setMaxLimit(nationalIdentityText, 11);
		textSettingService.setMaxLimit(phoneNumberText, 11);
	}

	@Override
	public void getEdits() {
		// TODO Auto-generated method stub
		
	}
	public UserApplyService getUserApplyObjcet() {
		if (this.userApplyObjcet == null) {
			userApplyObjcet = new UserApplyService() {
				
				@Override
				public String takeRandomUserNo() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public String takeRandomPassword() {
					// TODO Auto-generated method stub
					return null;
				}
				
				@Override
				public boolean isUserNoOnTable() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public boolean isNationalIdentityOnTable() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public boolean isApplyApproved() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public void approveApplicaiton() {
					// TODO Auto-generated method stub
					
				}
			};
			
		}
		return userApplyObjcet;
	}

	@Override
	public AccountInformationManager getAccountInformationManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInformationValid() {
		return textSettingService.isTextFilled(applicationPagePanel);
	}
	
}
