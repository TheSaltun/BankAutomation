package SweetBank.sweetBank.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class TransferPage extends JFrame implements IRegulator {
	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;
	private JPanel transferPagePanel;
	private JTextField withdrawMoneyText;
	private JTextField howMuchText;
	private final String MUSTERI_NO_TEXT_ORIGINAL = "Müşteri No:";
	private int gonderilecekMiktar = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferPage frame = new TransferPage();
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
	public TransferPage() {
		
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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 385);
		transferPagePanel = new JPanel();
		transferPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(transferPagePanel);
		transferPagePanel.setLayout(null);
		
		JLabel previousIcon = new JLabel("");
		previousIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new AccountPage());
			
			}
		});
		previousIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\previousIcon.png"));
		previousIcon.setBounds(12, 13, 48, 58);
		transferPagePanel.add(previousIcon);
		
		JLabel kullaniciAdiSoyasiLabel = new JLabel("Sayın [Kullanıcı adı soyadı]");
		kullaniciAdiSoyasiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		kullaniciAdiSoyasiLabel.setForeground(Color.RED);
		kullaniciAdiSoyasiLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		kullaniciAdiSoyasiLabel.setBackground(Color.GRAY);
		kullaniciAdiSoyasiLabel.setBounds(153, 41, 309, 30);
		transferPagePanel.add(kullaniciAdiSoyasiLabel);
		
		JLabel limitallertLabel = new JLabel("Tek seferde en fazla 20.000 tl ve altında işlem yapabilirsiniz!");
		limitallertLabel.setHorizontalAlignment(SwingConstants.CENTER);
		limitallertLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		limitallertLabel.setBounds(78, 87, 470, 21);
		transferPagePanel.add(limitallertLabel);
		
		JLabel totalBalanceLabel = new JLabel("Toplam Bakiyeniz :");
		totalBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalBalanceLabel.setBounds(53, 138, 177, 25);
		transferPagePanel.add(totalBalanceLabel);
		
		JLabel totalBalanceLabelLabel = new JLabel("{Bakiye}");
		totalBalanceLabelLabel.setBounds(248, 138, 220, 25);
		transferPagePanel.add(totalBalanceLabelLabel);
		
		JLabel withdrawMoneyLabel = new JLabel("Göndereceğiniz Miktar");
		withdrawMoneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		withdrawMoneyLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		withdrawMoneyLabel.setBounds(63, 180, 177, 25);
		transferPagePanel.add(withdrawMoneyLabel);
		
		withdrawMoneyText = new JTextField();
		withdrawMoneyText.addKeyListener(new KeyAdapter() {
			
			private int gonderilecekMiktar;
			@Override
			public void keyReleased(KeyEvent e) {
				this.gonderilecekMiktar = textSettingService.checkTheTextKeyReleased(howMuchText, 2000);
				System.out.println(gonderilecekMiktar);
			}
		});
		withdrawMoneyText.setText("{miktar}");
		withdrawMoneyText.setColumns(10);
		withdrawMoneyText.setBounds(258, 180, 220, 25);
		transferPagePanel.add(withdrawMoneyText);
		
		JButton transferButton = new JButton("Havale Yap!");
		transferButton.addActionListener(new ActionListener() {
			private int gonderilecekMiktar = 0;
			
			
			public void actionPerformed(ActionEvent e) {
				TransferPage havaleEkrani = new TransferPage();				
				JOptionPane.showMessageDialog(havaleEkrani, "BAŞARILI.\n" 
				+ "Gönderilen Tutar:" + this.gonderilecekMiktar + "TL" );
				actionSettingService.visable(this, new AccountPage());
		
			}
			
		});
		transferButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		transferButton.setBounds(248, 270, 220, 25);
		transferPagePanel.add(transferButton);
		
		JLabel tranferToWhoLabel = new JLabel("Havale Alacak Kişi");
		tranferToWhoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tranferToWhoLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tranferToWhoLabel.setBounds(63, 218, 177, 25);
		transferPagePanel.add(tranferToWhoLabel);
		
		howMuchText = new JTextField();
		howMuchText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				textSettingService.checkTheTextFocusGained(howMuchText, MUSTERI_NO_TEXT_ORIGINAL);
			}
			@Override
			public void focusLost(FocusEvent e) {
				textSettingService.checkTheTextFocusLost(howMuchText);

			}
		});
		howMuchText.setText("{miktar}");
		howMuchText.setColumns(10);
		howMuchText.setBounds(258, 218, 220, 25);
		transferPagePanel.add(howMuchText);
		
		
		getEdits();
		this.setLocationRelativeTo(null);
		transferPagePanel.setFocusable(true);
		textSettingService.setOnlyNumber(howMuchText);
		textSettingService.setMaxLimit(howMuchText, 2000);
		textSettingService.setOnlyNumber(howMuchText);
		howMuchText.setText(MUSTERI_NO_TEXT_ORIGINAL);
		
		
	}

	@Override
	public void getEdits() {
		// TODO Auto-generated method stub
		
	}
}
