package SweetBank.sweetBank.Business.Actions.Abstract;

import org.springframework.stereotype.Service;

@Service
public interface UserLoginService {
	boolean isEntryInformationValid();
	boolean isEntrySuccessfull();
	
	
}
