
package SweetBank.sweetBank.Business.settings.Abstract;

import javax.swing.AbstractButton;

import org.springframework.stereotype.Service;


@Service
public interface UserApplicationService {
	String setUserNo(AbstractButton abstractButton);
	String setPassword(AbstractButton abstractButton);
	boolean isApproveApplicaiton();
	Object getUserApplyObject();

}
