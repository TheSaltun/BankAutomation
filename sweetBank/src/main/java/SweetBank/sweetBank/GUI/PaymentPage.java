package SweetBank.sweetBank.GUI;

import java.awt.Color;
import java.awt.Container;
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
public class PaymentPage extends JFrame implements IRegulator {
	private ActionSettingService actionSettingService;
	private ButtonSettingService buttonSettingService;
	private DialogSettingService dialogSettingService;
	private TextSettingService textSettingService;

	private JPanel contentPane;

	private JPanel paymentPagePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPage frame = new PaymentPage();
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
	public PaymentPage() {
		
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
		setTitle("Sweet Bank Ödemeler Ekranı");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 339);
		paymentPagePanel = new JPanel();
		paymentPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(paymentPagePanel);
		paymentPagePanel.setLayout(null);

		JLabel userNameLabel = new JLabel("Sayın [Kullanıcı adı soyadı]");
		userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLabel.setForeground(Color.RED);
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		userNameLabel.setBackground(Color.GRAY);
		userNameLabel.setBounds(214, 23, 309, 30);
		paymentPagePanel.add(userNameLabel);

		JLabel messageElectricityLabel = new JLabel("Toplam elektrik faturası borcunuz:");
		messageElectricityLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		messageElectricityLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		messageElectricityLabel.setBounds(12, 86, 245, 25);
		paymentPagePanel.add(messageElectricityLabel);

		JLabel electricityDebt = new JLabel("[ELEK BORC]");
		electricityDebt.setBounds(295, 86, 105, 25);
		paymentPagePanel.add(electricityDebt);

		JButton electrictiyPaymentButton = new JButton("Öde");
		electrictiyPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(paymentPagePanel, "Fatura ödemeniz başarıyla gerçekleşti");
			actionSettingService.visable(this, new PaymentPage());
			}
		});
		electrictiyPaymentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(electrictiyPaymentButton, Color.black);
				buttonSettingService.foregroundColor(electrictiyPaymentButton, Color.white);
		
			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(electrictiyPaymentButton, getBackground());
				buttonSettingService.originalForegroundColor(electrictiyPaymentButton, getForeground());
			
			}
		});
		electrictiyPaymentButton.setBounds(417, 86, 105, 25);
		paymentPagePanel.add(electrictiyPaymentButton);

		JLabel messageWaterLabel = new JLabel("Toplam su faturası borcunuz:");
		messageWaterLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		messageWaterLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		messageWaterLabel.setBounds(12, 129, 245, 25);
		paymentPagePanel.add(messageWaterLabel);

		JLabel waterDebt = new JLabel("[Su BORC]");
		waterDebt.setBounds(295, 129, 105, 25);
		paymentPagePanel.add(waterDebt);

		JButton waterPaymentButton = new JButton("Öde");
		waterPaymentButton.setBounds(417, 129, 105, 25);
		paymentPagePanel.add(waterPaymentButton);

		waterPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(paymentPagePanel, "Fatura ödemeniz başarıyla gerçekleşti");
				actionSettingService.visable(this, new AccountPage());
			
			}
		});

		waterPaymentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(waterPaymentButton, Color.black);
				buttonSettingService.foregroundColor(waterPaymentButton, Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(waterPaymentButton, getBackground());
				buttonSettingService.originalForegroundColor(waterPaymentButton, getForeground());
			}
		});

		JLabel messageNaturalGasLabel = new JLabel("Toplam doğalgaz faturası borcunuz:");
		messageNaturalGasLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		messageNaturalGasLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		messageNaturalGasLabel.setBounds(12, 176, 245, 25);
		paymentPagePanel.add(messageNaturalGasLabel);

		JLabel naturalGasDebt = new JLabel("[gaz BORC]");
		naturalGasDebt.setBounds(295, 176, 105, 25);
		paymentPagePanel.add(naturalGasDebt);

		JButton naturalGasPaymentButton = new JButton("Öde");
		naturalGasPaymentButton.setBounds(417, 176, 105, 25);
		paymentPagePanel.add(naturalGasPaymentButton);

		naturalGasPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(paymentPagePanel, "Fatura ödemeniz başarıyla gerçekleşti");
				actionSettingService.visable(this, new AccountPage());
			}
		});

		naturalGasPaymentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(naturalGasPaymentButton, Color.black);
				buttonSettingService.foregroundColor(naturalGasPaymentButton, Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(naturalGasPaymentButton, getBackground());
				buttonSettingService.originalForegroundColor(naturalGasPaymentButton, getForeground());
			}
		});

		JLabel messageInternetLabel = new JLabel("Toplam internet faturası borcunuz:");
		messageInternetLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		messageInternetLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		messageInternetLabel.setBounds(12, 214, 245, 25);
		paymentPagePanel.add(messageInternetLabel);

		JLabel internetDebt = new JLabel("[int BORC]");
		internetDebt.setBounds(295, 214, 105, 25);
		paymentPagePanel.add(internetDebt);

		JButton internetPaymentButton = new JButton("Öde");
		internetPaymentButton.setBounds(417, 214, 105, 25);
		paymentPagePanel.add(internetPaymentButton);

		internetPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(paymentPagePanel, "Fatura ödemeniz başarıyla gerçekleşti");
				actionSettingService.visable(this, new AccountPage());
			}
		});

		internetPaymentButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonSettingService.backgroundColor(internetPaymentButton, Color.black);
				buttonSettingService.foregroundColor(internetPaymentButton, Color.white);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				buttonSettingService.originalBackgroundColor(internetPaymentButton, getBackground());
				buttonSettingService.originalForegroundColor(internetPaymentButton, getForeground());
			}
		});

		JLabel logoutIcon = new JLabel("");
		logoutIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actionSettingService.visable(this, new AccountPage());
			}
		});
		logoutIcon.setIcon(new ImageIcon("C:\\Users\\Saltun\\Desktop\\icons\\previousIcon.png"));
		logoutIcon.setBounds(12, 13, 48, 40);
		paymentPagePanel.add(logoutIcon);

		getEdits();
		this.setLocationRelativeTo(null);
		paymentPagePanel.setFocusable(true);

	}

	@Override
	public void getEdits() {
		// TODO Auto-generated method stub

	}
}
