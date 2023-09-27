package SweetBank.sweetBank.GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class DepositPage extends JFrame implements IRegulator {
	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;

	private JTextField depositMoneyText;
	private int yatirilacakMiktar = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositPage frame = new DepositPage();
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
	
	public DepositPage() {
		
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
		  textField, int limit) {} public boolean isTextFilled(JPanel panel) { return
		  false; } public int checkTheTextKeyReleased(JTextField textField, int
		  moneyLimit) { return 0; } public void checkTheTextFocusLost(JTextField
		  textField) {} public void checkTheTextFocusGained(JTextField textField,
		  String original) {}
		@Override
		public boolean isLengthSmallFromThat(int lenght, String string) {
			// TODO Auto-generated method stub
			return false;
		} };
		  
		  dialogSettingService = new DialogSettingService() { 
			  public void showPrivateMessage(JFrame frame, String message) {} 
			  public void showNotNullMessage(JFrame frame) {} };
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel paraYatirmaEkraniPanel = new JPanel();
		paraYatirmaEkraniPanel.setLayout(null);
		paraYatirmaEkraniPanel.setFocusable(true);
		paraYatirmaEkraniPanel.setBounds(12, 13, 563, 276);
		contentPane.add(paraYatirmaEkraniPanel);

		JLabel userNameLabel = new JLabel("Sayın [Kullanıcı adı soyadı]");
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setForeground(Color.RED);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		userNameLabel.setBackground(Color.GRAY);
		userNameLabel.setBounds(131, 13, 309, 30);
		paraYatirmaEkraniPanel.add(userNameLabel);

		JLabel limitAllertLabel = new JLabel(
				"Tek seferde en fazla 40.000 tl ve altında para yatırma işlemi yapabilirsiniz!");
		limitAllertLabel.setHorizontalAlignment(SwingConstants.CENTER);
		limitAllertLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		limitAllertLabel.setBounds(50, 59, 470, 21);
		paraYatirmaEkraniPanel.add(limitAllertLabel);

		JLabel totalBalanceLabel = new JLabel("Toplam Bakiyeniz :");
		totalBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalBalanceLabel.setBounds(25, 110, 177, 25);
		paraYatirmaEkraniPanel.add(totalBalanceLabel);

		JLabel balanceLabel = new JLabel("{Bakiye}");
		balanceLabel.setBounds(220, 110, 220, 25);
		paraYatirmaEkraniPanel.add(balanceLabel);

		JLabel depositLabel = new JLabel("Yatıracağınız miktar : ");
		depositLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		depositLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		depositLabel.setBounds(25, 140, 177, 25);
		paraYatirmaEkraniPanel.add(depositLabel);

		depositMoneyText = new JTextField();
		depositMoneyText.addKeyListener(new KeyAdapter() {

			private int depositQuantity;

			@Override
			public void keyReleased(KeyEvent e) {
				this.depositQuantity = textSettingService.checkTheTextKeyReleased(depositMoneyText, 4000);
				System.out.println(depositQuantity);
			}
		});
		depositMoneyText.setText("{miktar}");
		depositMoneyText.setColumns(10);
		depositMoneyText.setBounds(220, 140, 220, 25);
		paraYatirmaEkraniPanel.add(depositMoneyText);

		JLabel previousIcon = new JLabel("");
		previousIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new AccountPage());

			}
		});
		previousIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\previousIcon.png"));
		previousIcon.setBounds(12, 13, 48, 40);
		paraYatirmaEkraniPanel.add(previousIcon);

		JButton depositButton = new JButton("Para Yatır");
		depositButton.addActionListener(new ActionListener() {

			private int depositQuantity = 0;

			public void actionPerformed(ActionEvent e) {
				DepositPage depositpage = new DepositPage();
				JOptionPane.showMessageDialog(depositpage,
						"BAŞARILI.\n" + "Yatırılan Tutar:" + this.depositQuantity + "TL");
				actionSettingService.visable(this, new AccountPage());
				
			}
		});
		depositButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		depositButton.setBounds(220, 187, 220, 25);
		paraYatirmaEkraniPanel.add(depositButton);

		JLabel geriIcon = new JLabel("");
		geriIcon.setBounds(12, 13, 48, 40);
		paraYatirmaEkraniPanel.add(geriIcon);

		getEdits();
		this.setLocationRelativeTo(null);
		paraYatirmaEkraniPanel.setFocusable(true);

		textSettingService.setOnlyNumber(depositMoneyText);
		textSettingService.setMaxLimit(depositMoneyText, 40000);

	}

	@Override
	public void getEdits() {

	}
}
