package SweetBank.sweetBank.Business.Actions.Concrete;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.BillPaymentService;
import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbConnection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class BillPaymentManager extends DbConnection implements BillPaymentService, InformationControllerService {

	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;
	
	private String billName = null;
	private double billAmount = 0;

	@Override
	public boolean isBillPaid() {
		if (isInformationValid()) {
			String query = "UPDATE user_bills" + "SET" + this.billName + "=0" + "WHERE user_id"
					+ getAccountInformationManager().getUserId() + "'";

			try {
				super.statement = super.connection.createStatement();
				statement.executeUpdate(query);
				this.decreaseBalance();
				this.resetBill();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			return false;
		}
		return false;
	}

	@Override
	public void resetBill() {
		if (isInformationValid()) {
			switch (this.billName) {
			case "electricity":
				getAccountInformationManager().setElektricityBill(0);
				break;
			case "water":
				getAccountInformationManager().setWaterBill(0);
				break;
			case "natural_gas":
				getAccountInformationManager().setNaturalGasBill(0);
				break;
			case "internet":
				getAccountInformationManager().setInternetBill(0);
				break;

			}

		}

	}

	@Override
	public void decreaseBalance() {
		String query = "UPDATE user_balance" + "SET balance = balance - '" + this.billAmount + "'"
				+ "WHERE kullanici_id = '" + getAccountInformationManager().getUserId() + "'";

		try {
			super.statement = super.connection.createStatement();
			statement.executeUpdate(query);
			getAccountInformationManager().setBalance(getAccountInformationManager().getBalance() - this.billAmount);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void BillPayment() {

	}

	@Override
	public AccountInformationManager getAccountInformationManager() {
	
		return getAccountInformationManager();
	}

	@Override
	public boolean isInformationValid() {
		 return !(this.billName ==
				  null || this.billAmount == 0 || getAccountInformationManager().getBalance() <
				  this.billAmount); }
				 

	
	 
	  




}
