package SweetBank.sweetBank.Business.settings.Concrete;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.settings.Abstract.TextSettingService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TextSettingManager implements TextSettingService {
	
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;
	private String originalText;
	public Color originalForegroundColor;
	private int limit;

	// focus settings

	@Override
	public void checkTheTextFocusGained(JTextField textField, String original) {
		originalText = original;
		if (textField.getText().trim().equals(original)) {
			originalForegroundColor = textField.getForeground();
			textField.setText("");

		}
		textField.setForeground(Color.blue);
	}

	@Override
	public void checkTheTextFocusLost(JTextField textField) {
		if (textField.getText().trim().equals("")) {
			textField.setText(originalText);
			textField.setForeground(originalForegroundColor);
			;
		} else {
			textField.setForeground(Color.black);
		}
	}

	// numbers settings

	@Override
	public void setOnlyNumber(JTextField textField) {
		textField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c))
					e.consume();
			}
		});

	}

	@Override
	public void setOnlyAlphabetic(JTextField textField) {
		textField.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isAlphabetic(c))
					e.consume();
			}
		});
	}

	// LIMITAION SETTING

	@Override
	public void setMaxLimit(JTextField textField, int lim) {
		limit = lim;
		textField.setDocument(new PlainDocument() {

			@Override
			public void insertString(int offs, String str, javax.swing.text.AttributeSet a)
					throws BadLocationException {

				if (str == null) {
					return;
				}
				if ((getLength() + str.length()) <= limit) {
					super.insertString(offs, str, a);

				}

			}
		}

		);
	}

	//IS TEXT AREA FILLED
	@Override
	public boolean isTextFilled(JPanel panel) {
		Component[] components = panel.getComponents();
		for (Component c : components) {
			if (c instanceof JTextField) {
				JTextField textField = (JTextField) c;
				if (textField.getText().trim().equals("") && textField.isEnabled()) {
					return false;
				}
			}
		}

		return true;
	}

	
	//MONEY LİMİTATİON SETTİNGS
	
	@Override
	public int checkTheTextKeyReleased(JTextField textField, int moneyLimit) {
		String text = textField.getText();
		if (!text.equals("")) {
			int miktar = Integer.valueOf(text);
			if (miktar > moneyLimit) {
				miktar = moneyLimit;
				textField.setText(String.valueOf(miktar));

			}
			return miktar;
		} else {
			return 0;
		}
	}

	@Override
	public boolean isLengthSmallFromThat(int lenght, String string) {
		return (string.length() <lenght);
	}


	
}

	

