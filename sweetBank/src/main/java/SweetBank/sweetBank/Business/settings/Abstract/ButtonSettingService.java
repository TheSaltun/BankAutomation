package SweetBank.sweetBank.Business.settings.Abstract;

import java.awt.Color;

import javax.swing.JButton;

import org.springframework.stereotype.Service;

@Service
public interface ButtonSettingService {
	void backgroundColor(JButton button, Color backgroundColor);
	void foregroundColor(JButton button, Color foregroundColor);
	void originalBackgroundColor(JButton button, Color backgroundColor);
	void originalForegroundColor(JButton button, Color foregroundColor);

}
