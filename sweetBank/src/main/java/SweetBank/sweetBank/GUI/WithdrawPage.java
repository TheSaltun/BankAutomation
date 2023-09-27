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
public class WithdrawPage extends JFrame implements IRegulator {

	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;

	private JTextField withdrawMoneyText;
	private int cekilecekMiktar = 0;

	@Override
	public void getEdits() {
		this.setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WithdrawPage frame = new WithdrawPage();
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

	public WithdrawPage() {
		
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
		setBounds(100, 100, 559, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel withdrawPagePanel = new JPanel();
		withdrawPagePanel.setBounds(12, 13, 521, 256);
		contentPane.add(withdrawPagePanel);
		withdrawPagePanel.setLayout(null);

		JLabel userNameLabel = new JLabel("Sayın [Kullanıcı adı soyadı]");
		userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLabel.setBackground(Color.GRAY);
		userNameLabel.setForeground(Color.RED);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		userNameLabel.setBounds(141, 13, 309, 30);
		withdrawPagePanel.add(userNameLabel);

		JLabel limitAllertLabel = new JLabel("Tek seferde 5000 tl veya altında işlem yapabilirsiniz");
		limitAllertLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		limitAllertLabel.setBounds(105, 59, 380, 21);
		withdrawPagePanel.add(limitAllertLabel);

		JLabel totalBalanceLabel = new JLabel("Toplam Bakiyeniz :");
		totalBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		totalBalanceLabel.setBounds(25, 110, 177, 25);
		withdrawPagePanel.add(totalBalanceLabel);

		JLabel balanceLabel = new JLabel("{Bakiye}");
		balanceLabel.setBounds(220, 110, 220, 25);
		withdrawPagePanel.add(balanceLabel);

		JLabel withdrawMoneyLabel = new JLabel("Çekeceğiniz miktar : ");
		withdrawMoneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		withdrawMoneyLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		withdrawMoneyLabel.setBounds(25, 140, 177, 25);
		withdrawPagePanel.add(withdrawMoneyLabel);

		withdrawMoneyText = new JTextField();
		withdrawMoneyText.addKeyListener(new KeyAdapter() {

			private int cekilecekMiktar;

			@Override
			public void keyReleased(KeyEvent e) {

				this.cekilecekMiktar = textSettingService.checkTheTextKeyReleased(withdrawMoneyText, 5000);

				System.out.println(cekilecekMiktar);
			}
		});
		withdrawMoneyText.setText("{miktar}");
		withdrawMoneyText.setBounds(220, 140, 220, 25);
		withdrawPagePanel.add(withdrawMoneyText);
		withdrawMoneyText.setColumns(10);

		JButton withdrawButton = new JButton("para çek");
		withdrawButton.addActionListener(new ActionListener() {
			private int cekilecekMiktar;

			public void actionPerformed(ActionEvent e) {
				WithdrawPage paraCekmeEkrani = new WithdrawPage();
				JOptionPane.showMessageDialog(paraCekmeEkrani,
						"BAŞARILI.\n" + "Çekilen Tutar:" + this.cekilecekMiktar + "TL");
				actionSettingService.visable(this, new AccountPage());
			}
		});
		withdrawButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		withdrawButton.setBounds(220, 187, 220, 25);
		withdrawPagePanel.add(withdrawButton);

		JLabel previousIcon = new JLabel("");
		previousIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new AccountPage());
			}
		});
		previousIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\previousIcon.png"));
		previousIcon.setBounds(12, 13, 48, 40);
		withdrawPagePanel.add(previousIcon);

		getEdits();
		withdrawPagePanel.setFocusable(true);
		
		
		textSettingService.setOnlyNumber(withdrawMoneyText);
		textSettingService.setMaxLimit(withdrawMoneyText, 4);

	}

}
