package SweetBank.sweetBank.Business.Actions.Concrete;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.DepositMoneyService;
import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbConnection;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class DepositMoneyManager extends DbConnection implements DepositMoneyService, InformationControllerService {
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;

	private int depositAmount;

	@Override
	public boolean isDepositMoney() {
		if (isInformationValid()) {
			String query = "UPDATE user_balance" + "SET balance = balance" + this.depositAmount + "'"
					+ "WHERE user_id = '" + getAccountInformationManager().getUserId() + "'";
			try {
				super.statement = super.connection.createStatement();
				statement.executeQuery(query);
				getAccountInformationManager()
						.setBalance(getAccountInformationManager().getBalance() + this.depositAmount);

			} catch (SQLException e) {

				e.printStackTrace();
			}

			return true;
		} else {

		}
		return false;
	}

	@Override
	public AccountInformationManager getAccountInformationManager() {

		return getAccountInformationManager();
	}

	@Override
	public boolean isInformationValid() {
		// TODO Auto-generated method stub
		return !(this.depositAmount == 0);
	}

}
