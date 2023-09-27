
package SweetBank.sweetBank.Business.settings.Concrete;

import javax.swing.AbstractButton;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.Business.Actions.Concrete.AccountInformationManager;
import SweetBank.sweetBank.Business.settings.Abstract.UserApplicationService;
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
public class UserApplicationManager implements UserApplicationService, InformationControllerService{
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;

	private String name = null;
	private String nationalIdentity = null;
	private String phoneNumber = null;
	private String securityQuestion = null;
	private String securityAnswer = null;

	private String userNo = null;
	private String password = null;

	@Override
	public boolean isApproveApplicaiton() {
		if (this.isInformationValid()) {

		} else {
			return false;
		}
		return false;
	}

	@Override
	public String setUserNo(AbstractButton abstractButton) {
		String userNo;
		userNo = String.valueOf(1000000 + (int) (Math.random() * 90000000));
		return userNo;
	}

	@Override
	public String setPassword(AbstractButton abstractButton) {
		String password;
		password = String.valueOf(1000 + (int) (Math.random() * 90000));
		return password;
	}

	@Override
	public Object getUserApplyObject() {
		return null;

	}


	@Override
	public AccountInformationManager getAccountInformationManager() {
		// TODO Auto-generated method stub
		return getAccountInformationManager();
	}


	@Override
	public boolean isInformationValid() {
		return !(this.name == null 
				|| this.nationalIdentity == null 
				|| this.phoneNumber == null
				|| this.securityQuestion == null 
				|| this.securityAnswer == null 
				|| this.userNo == null
				|| this.password == null);
	}


}
