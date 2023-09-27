package SweetBank.sweetBank.Business.settings.Abstract;

import javax.swing.JFrame;

import org.springframework.stereotype.Service;

@Service
public interface DialogSettingService {
	void showNotNullMessage(JFrame frame);
	void showPrivateMessage(JFrame frame, String message);
	

}
