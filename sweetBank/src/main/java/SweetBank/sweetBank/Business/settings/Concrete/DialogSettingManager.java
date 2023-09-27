package SweetBank.sweetBank.Business.settings.Concrete;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.settings.Abstract.DialogSettingService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class DialogSettingManager implements DialogSettingService{
	
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;
	
	
	@Override
	public void showNotNullMessage(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "Tüm alanlar dolu olmalıdır!");
		
	}

	@Override
	public void showPrivateMessage(JFrame frame, String message) {
		JOptionPane.showMessageDialog(frame, message);
		
	}
	
}
