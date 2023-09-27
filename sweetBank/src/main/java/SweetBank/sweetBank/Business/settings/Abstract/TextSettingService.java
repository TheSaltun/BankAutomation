package SweetBank.sweetBank.Business.settings.Abstract;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Service;

@Service
public interface TextSettingService {
	void checkTheTextFocusGained(JTextField textField, String original);
	void checkTheTextFocusLost(JTextField textField);
	
	void setOnlyNumber(JTextField textField);
	void setOnlyAlphabetic(JTextField textField);
	
	void setMaxLimit(JTextField textField, int limit);
	int checkTheTextKeyReleased(JTextField textField, int moneyLimit);
	
	boolean isTextFilled(JPanel panel);
	
	
	boolean isLengthSmallFromThat(int lenght, String string);
	

}
