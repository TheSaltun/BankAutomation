package SweetBank.sweetBank.Business.Actions.Concrete;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.Business.Actions.Abstract.TransferMoneyService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbConnection;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Service
@AllArgsConstructor
public class TransferMoneyManager extends DbConnection implements TransferMoneyService, InformationControllerService {
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;
	private int transferQuantitiy = 0;
	private String transferToWho = null;

	@Override
	public boolean isTransferDone() {

		if (isInformationValid()) {
			String query = "UPDATE user_balance" + "SET balance = balance - " + this.transferQuantitiy + "'"
					+ "WHERE user_id = '" + getAccountInformationManager().getUserId() + "'";

			String query2 = "UPDATE user_balance" + "SET balance = balance + " + this.transferQuantitiy + "'"
					+ "WHERE user_no = '" + this.transferToWho + "'";
			try {
				super.statement = super.connection.createStatement();
				if (statement.executeUpdate(query2) == 1) {
					statement.executeQuery(query);
					getAccountInformationManager()
							.setBalance(getAccountInformationManager().getBalance() - this.transferQuantitiy);
					return true;

				} else {
					return false;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return true;
			}

		} else {
			return false;
		}
	}

	@Override
	public boolean isInformationValid() {
		return !(this.transferQuantitiy == 0 || this.transferToWho == null
				|| this.transferQuantitiy > getAccountInformationManager().getBalance()
				|| this.transferToWho.equals(getAccountInformationManager().getUserNo()));

	}

	@Override
	public AccountInformationManager getAccountInformationManager() {
		// TODO Auto-generated method stub
		return getAccountInformationManager();
	}

}
