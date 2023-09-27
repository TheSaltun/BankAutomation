package SweetBank.sweetBank.Business.settings.Concrete;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.settings.Abstract.ActionSettingService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ActionSettingManager implements ActionSettingService {
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;

	@Override
	public void visable(JFrame oldFrame, JFrame newFrame) {
		if (oldFrame != null) {
			oldFrame.setVisible(false);
		}
		newFrame.setVisible(true);

	}

	@Override
	public void visable(ActionListener actionListener, JFrame newFrame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visable(MouseAdapter mouseAdapter, JFrame newFrame) {
		// TODO Auto-generated method stub
		
	}

}
