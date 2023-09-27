package SweetBank.sweetBank.Business.Actions.Concrete;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.AccountInformationService;
import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbDataCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInformationManager extends DbDataCenter implements AccountInformationService, InformationControllerService {

	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;

	@Override
	public void login(String nationalIdentityOrUserNo) {
		this.takeUser(nationalIdentityOrUserNo);
		this.takeBalance();
		this.takeBill();

	}

	@Override
	public void takeUser(String nationalIdentityOrUserNo) {

		String query = "SELECT * FROM users WHERE" + "nationalIdentity = '" + nationalIdentityOrUserNo + "'" + "OR"
				+ "userNo = '" + nationalIdentityOrUserNo + "'";

		try {
			super.statement = super.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				super.setUserId(rs.getInt("user_ıd"));
				super.setName(rs.getNString("name"));
				super.setNationalIdentity(rs.getNString("national_ıdentity"));
				super.setPhoneNumber(rs.getNString("phone_number"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void takeBalance() {
		if (this.isInformationValid()) {
			String query = "SELECT * FROM user_balance" + "WHERE" + "user_id = '" + super.getUserId() + "'";
			try {
				super.statement = super.connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					super.setBalance(rs.getDouble("balance"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void takeBill() {
		if (this.isInformationValid()) {

			String query = "SELECT * FROM user_bills" + "WHERE" + "user_ıd = '" + super.getUserId() + "'";
			try {
				super.statement = super.connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {

					super.setElektricityBill(rs.getDouble("electricity"));
					super.setWaterBill(rs.getDouble("water"));
					super.setNaturalGasBill(rs.getDouble("natural_gas"));
					super.setInternetBill(rs.getDouble("internet"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}


	@Override
	public AccountInformationManager getAccountInformationManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInformationValid() {
		// TODO Auto-generated method stub
		return false;
	}



}
