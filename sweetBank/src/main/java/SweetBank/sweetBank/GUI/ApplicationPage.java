package SweetBank.sweetBank.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
import SweetBank.sweetBank.DataBase.DbDataCenter;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class ApplicationPage extends JFrame implements InformationControllerService, IRegulator {
	
	
	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;
	private UserApplicationService userApplicationService;
	
	private AccountInformationService accountInformationService;
	private BillPaymentService billPaymentService;
	private DepositMoneyService depositMoneyService;
	private InformationControllerService ınformationControllerService;
	private TransferMoneyService transferMoneyService;
	private UserApplyService userApplyService;

	private UserLoginService userLoginService;
	private WithdrawMoneyService withdrawMoneyService;
	
	ApplicationPage applicationPage;

	private JPanel contentPane;
	private JPanel applicationPagePanel;
	private JTextField nameText;
	private JTextField nationalIdentityText;
	private JTextField phoneNumberText;
	private JTextField securityAnswerText;
	private JTextField securityQuestionText;
	private JTextField userNoText;
	private JTextField passwordText;
	private String name;
	private String nationalIdentity;
	private String phoneNumber;
	private String securityQuestion;
	private String securityAnswer;
	
	

	@Override
	public void setContentPane(Container contentPane) {
		// TODO Auto-generated method stub
		super.setContentPane(contentPane);
		contentPane.setVisible(true);
	}
	
	public ApplicationPage() {
		userApplyService = new UserApplyService() {
			
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
		};
		
		
		
		actionSettingService = new ActionSettingService() {
			public void visable(JFrame oldFrame, JFrame newFrame) { }
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
		
		accountInformationService = new AccountInformationService() {
			
			@Override
			public void takeUser(String nationalIdentityOrUserNo) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void takeBill() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void takeBalance() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void login(String nationalIdentityOrUserNo) {
				// TODO Auto-generated method stub
				
			}
		};
		
		billPaymentService= new BillPaymentService() {
			
			@Override
			public void resetBill() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isBillPaid() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void decreaseBalance() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void BillPayment() {
				// TODO Auto-generated method stub
				
			}
		};
		
		depositMoneyService = new DepositMoneyService() {
			
			@Override
			public boolean isDepositMoney() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		ınformationControllerService = new InformationControllerService() {
			
			@Override
			public boolean isInformationValid() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public AccountInformationManager getAccountInformationManager() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		transferMoneyService = new TransferMoneyService() {
			
			@Override
			public boolean isTransferDone() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		
		userLoginService = new UserLoginService() {
			
			@Override
			public boolean isEntrySuccessfull() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isEntryInformationValid() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		withdrawMoneyService = new WithdrawMoneyService() {
			
			@Override
			public boolean isMoneyWtihdraw() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		
  
    setTitle("Sweet Bank Başvuru Ekranı");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setBounds(100, 100, 500,500); 
    applicationPagePanel = new JPanel(); 
    applicationPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
  
    setContentPane(applicationPagePanel); applicationPagePanel.setLayout(null);
  
    JLabel privateInformationLabel = new JLabel("Kişisel Bilgiler");
    privateInformationLabel.setHorizontalAlignment(SwingConstants.LEFT);
    privateInformationLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    privateInformationLabel.setBounds(40, 15, 170, 25);
    applicationPagePanel.add(privateInformationLabel);
  
    JLabel nameLabel = new JLabel("Ad Soyad :");
    nameLabel.setHorizontalAlignment(SwingConstants.RIGHT); 
    nameLabel.setFont(new
    Font("Tahoma", Font.BOLD, 12)); 
    nameLabel.setBounds(12, 55, 139, 25);
    applicationPagePanel.add(nameLabel);
  
    nameText = new JTextField(); 
    nameText.setFont(new Font("Tahoma", Font.BOLD, 12));
    nameText.setBounds(180, 55, 220, 22);
    applicationPagePanel.add(nameText); 
    nameText.setColumns(10);
  
    JLabel nationalIdentityLabel = new JLabel("T.C. No :");
    nationalIdentityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    nationalIdentityLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    nationalIdentityLabel.setBounds(12, 92, 139, 26);
    applicationPagePanel.add(nationalIdentityLabel);
  
    nationalIdentityText = new JTextField(); 
    nationalIdentityText.setFont(new Font("Tahoma", Font.BOLD, 12)); 
    nationalIdentityText.setColumns(10);
    nationalIdentityText.setBounds(180, 96, 220, 22);
    applicationPagePanel.add(nationalIdentityText);
  
    JLabel phoneNumberLabel = new JLabel("Tel No :");
    phoneNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    phoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    phoneNumberLabel.setBounds(10, 131, 141, 26);
    applicationPagePanel.add(phoneNumberLabel);
  
    phoneNumberText = new JTextField(); 
    phoneNumberText.setFont(new
    Font("Tahoma", Font.BOLD, 12)); 
    phoneNumberText.setColumns(10);
    phoneNumberText.setBounds(180, 133, 220, 22);
    applicationPagePanel.add(phoneNumberText);
  
    JLabel securityInformationLabel = new JLabel("Güvenlik Bilgileri");
    securityInformationLabel.setHorizontalAlignment(SwingConstants.LEFT);
    securityInformationLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
    securityInformationLabel.setBounds(40, 200, 168, 26);
    applicationPagePanel.add(securityInformationLabel);
  
    JLabel securtyQuestionLabel = new JLabel("Güvenlik Sorusu :");
    securtyQuestionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    securtyQuestionLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    securtyQuestionLabel.setBounds(12, 254, 139, 26);
    applicationPagePanel.add(securtyQuestionLabel);
  
    JComboBox securtyQuestion = new JComboBox(); securtyQuestion.setModel(new
     DefaultComboBoxModel(new String[] { "Evcil hayvanınızın adı nedir?",
    "En sevdiğiniz nesne nedir?", "İlkokul öğretmenizin adı nedir?",
    "Yaşamak istediğiniz yer neresidir?", "Rastgele cümle giriniz (Önerilir)."
    })); 
    
    securtyQuestion.setBounds(180, 255, 220, 24);
    applicationPagePanel.add(securtyQuestion);
    
    JLabel securityAnswerLabel = new JLabel("Güvenlik Cavabı :");
    securityAnswerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    securityAnswerLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
    securityAnswerLabel.setBounds(12, 302, 139, 26);
    applicationPagePanel.add(securityAnswerLabel);
  
    JTextField securityAnswerText = new JTextField(); 
    securityAnswerText.setFont(new Font("Tahoma", Font.BOLD, 12)); 
    securityAnswerText.setColumns(10);
    securityAnswerText.setBounds(180, 304, 220, 22);
    applicationPagePanel.add(securityAnswerText);
 
  
	JButton applyButton = new JButton("Başvur!");
	applyButton.addActionListener(new ActionListener() {
 
		
	

		public void actionPerformed(ActionEvent e) {

			if (this.isInformationValid()) {

				this.isApproveApplicaiton();

			} else {
				dialogSettingService.showNotNullMessage(applicationPage);

			}

		}

		private void isApproveApplicaiton() {
			
			 String name = nameText.getText().trim();
			 String nationalIdentity = nationalIdentityText.getText().trim();
			 String phoneNumber = phoneNumberText.getText().trim();
			 String securityQuestion = securityQuestionText.getSelectedText().toString();
			 String securityAnswer = securityAnswerText.getText().trim();
			 
		}

		private boolean isInformationValid() {

			return textSettingService.isTextFilled(applicationPagePanel);
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
  
    applyButton.setBackground(Color.WHITE); applyButton.setFont(new
    Font("Tahoma", Font.BOLD, 15)); applyButton.setBounds(241, 353, 97, 25);
    applicationPagePanel.add(applyButton);
  
  
	 getEdits(); 
	 applicationPagePanel.setFocusable(true);
	 textSettingService.setOnlyAlphabetic(nameText);
	 textSettingService.setOnlyNumber(nationalIdentityText);
	 textSettingService.setOnlyNumber(phoneNumberText);
	 textSettingService.setMaxLimit(nationalIdentityText, 11);
	 textSettingService.setMaxLimit(phoneNumberText, 11);
  
  }

	
	  @Override 
	  public void getEdits() { 
		  this.setLocationRelativeTo(null);
	  }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationPage frame = new ApplicationPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
