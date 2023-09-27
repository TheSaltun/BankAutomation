package SweetBank.sweetBank.Business.settings.Abstract;

import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;

import javax.swing.JFrame;

import org.springframework.stereotype.Service;

@Service
public interface ActionSettingService {
	void visable(ActionListener actionListener, JFrame newFrame);
	void visable(MouseAdapter mouseAdapter, JFrame newFrame);
	void visable(JFrame oldFrame, JFrame newFrame);
	

}
