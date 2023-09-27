package SweetBank.sweetBank.Business.Actions.Abstract;

import org.springframework.stereotype.Service;

@Service
public interface UserApplyService {
	
	boolean isApplyApproved();
	boolean isNationalIdentityOnTable();
	boolean isUserNoOnTable();
	void approveApplicaiton();
	String takeRandomUserNo();
	String takeRandomPassword();

}
