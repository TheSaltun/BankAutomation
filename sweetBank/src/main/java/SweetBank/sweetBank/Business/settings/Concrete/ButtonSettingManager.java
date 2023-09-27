package SweetBank.sweetBank.Business.settings.Concrete;

import java.awt.Color;

import javax.swing.JButton;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.settings.Abstract.ButtonSettingService;
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
public class ButtonSettingManager implements ButtonSettingService{
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;
	private Color originalBackgroundColor, originalForegroundColor;
	
	@Override
	public void backgroundColor(JButton button, Color backgroundColor) {
		originalBackgroundColor= button.getBackground();
	}

	@Override
	public void foregroundColor(JButton button, Color foregroundColor) {
		originalForegroundColor= button.getForeground();
		
	}

	@Override
	public void originalBackgroundColor(JButton button, Color backgroundColor) {
		button.setBackground(backgroundColor);
		
	}

	@Override
	public void originalForegroundColor(JButton button, Color foregroundColor) {
		button.setBackground(foregroundColor);
		
	}
	

	
}
