package SweetBank.sweetBank.Business.Actions.Concrete;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.Business.Actions.Abstract.UserLoginService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbDataCenter;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserLoginManager extends DbDataCenter implements UserLoginService, InformationControllerService {
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;
	
	private String nationalIdentityOrUserNo= null;
	private String password = null;

	

	@Override
	public boolean isEntryInformationValid() {
		if (isInformationValid()) {
			if (isEntrySuccessfull()) {
			return true;
			}else {
				return false;
			}
		}else {
				return false;
			}
	}

	@Override
	public boolean isEntrySuccessfull() {
		String query = "SELECT national_ıdentity, user_no, password FROM users"
				+ "WEHERE"
				+ "(national_ıdentity = '" + this.nationalIdentityOrUserNo + "'"
				+ "OR"
				+ "(user_no = '" + this.nationalIdentityOrUserNo + "'"
				+ "AND"
				+ "password = '"+ this.password + "'";

		try {
			super.statement = super.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next());
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public AccountInformationManager getAccountInformationManager() {
		// TODO Auto-generated method stub
		return getAccountInformationManager();
	}

	@Override
	public boolean isInformationValid() {
		return !(this.nationalIdentityOrUserNo == null
				||this.password == null);
	}

}
