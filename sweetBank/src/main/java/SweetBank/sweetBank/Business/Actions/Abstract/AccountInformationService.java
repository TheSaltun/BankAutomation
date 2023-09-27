package SweetBank.sweetBank.Business.Actions.Abstract;

import org.springframework.stereotype.Service;

@Service
public interface AccountInformationService {

	 void login(String nationalIdentityOrUserNo);
	 void takeUser(String nationalIdentityOrUserNo);
	 void takeBalance();
	 void takeBill();
	
	 
	 

}
