package SweetBank.sweetBank.Business.Actions.Concrete;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.Business.Actions.Abstract.WithdrawMoneyService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbDataCenter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class WithdrawMoneyManager extends DbDataCenter implements WithdrawMoneyService, InformationControllerService {
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;
	private int withdrawQuantity;
  
	@Override
	public boolean isMoneyWtihdraw() {
		if (isInformationValid()) {
			String query = "UPDATE user_balance "
					+ "SET balance = balance- '" + this.withdrawQuantity + "'"
							+ " WHERE kullanici_id = '" + getAccountInformationManager().getUserId() + "'";
			
			try {
				super.statement = super.connection.createStatement();
				statement.executeQuery(query);
				getAccountInformationManager().setBalance(getAccountInformationManager().getBalance() - this.withdrawQuantity);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return true;
			
		}else {
			return false;
			
		}
	}

	

	@Override
	public boolean isInformationValid() {
		
		return !(this.withdrawQuantity == 0 
				||getAccountInformationManager().getBalance()< this.withdrawQuantity);
	}
@Override
	public AccountInformationManager getAccountInformationManager() {
		
		return getAccountInformationManager();
}
}
