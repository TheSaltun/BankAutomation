package SweetBank.sweetBank.Business.Actions.Abstract;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Concrete.AccountInformationManager;
@Service
public interface InformationControllerService {
	public AccountInformationManager getAccountInformationManager();
	boolean isInformationValid();
}
