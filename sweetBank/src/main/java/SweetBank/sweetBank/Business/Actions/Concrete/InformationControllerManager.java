package SweetBank.sweetBank.Business.Actions.Concrete;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbDataCenter;
import lombok.Data;


@Service
@Data

public class InformationControllerManager extends DbDataCenter implements InformationControllerService{
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;

	private static AccountInformationManager accountInformationManager = null;
	
	
	
	public AccountInformationManager getAccountInformationManager() {
		if (accountInformationManager == null) {
			accountInformationManager = new AccountInformationManager();
		}
		return accountInformationManager;
	}

	@Override
	public boolean isInformationValid() {
		return !(super.userId == 0);
	}

	
}
