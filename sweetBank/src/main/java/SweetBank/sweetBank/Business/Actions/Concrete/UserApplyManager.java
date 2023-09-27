package SweetBank.sweetBank.Business.Actions.Concrete;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import SweetBank.sweetBank.Business.Actions.Abstract.InformationControllerService;
import SweetBank.sweetBank.Business.Actions.Abstract.UserApplyService;
import SweetBank.sweetBank.Business.settings.Abstract.TextSettingService;
import SweetBank.sweetBank.DataAccess.UserBalanceRepository;
import SweetBank.sweetBank.DataAccess.UserBillRepository;
import SweetBank.sweetBank.DataAccess.UserInformationRepository;
import SweetBank.sweetBank.DataBase.DbDataCenter;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserApplyManager extends DbDataCenter implements UserApplyService, InformationControllerService {
	private UserInformationRepository userInformationRepository;
	private UserBalanceRepository userBalanceRepository;
	private UserBillRepository userBillRepository;

	private String name = null;
	private String nationalIdentity = null;
	private String phoneNumber = null;
	private String securtyQuestion = null;
	private String securtyAnswer = null;

	private String userNo = null;
	private String password = null;

	private TextSettingService textSettingService;

	@Override
	public boolean isApplyApproved() {
		if (isInformationValid()) {
			if (this.isNationalIdentityOnTable()) {
				return false;
			} else {
				this.approveApplicaiton();
			}

		} else {
			return false;

		}
		return false;
	}

	@Override
	public boolean isNationalIdentityOnTable() {
		String query = "SELECT national_ıdentity FROM users WHERE national_ıdentity = '" + this.nationalIdentity + "'";
		try {
			super.statement = super.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean isUserNoOnTable() {
		String query = "SELECT user_no FROM users WHERE user_no = '" + this.userNo + "'";
		try {
			super.statement = super.connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public void approveApplicaiton() {
		String query = "INSERT INTO users(user_no, password, "
				+ "name, national_ıdentity, phone_number, securty_question, securty_answer)" + " VALUES(" + "'"
				+ this.userNo + "'," + "'" + this.password + "'," + "'" + this.name + "'," + "'" + this.nationalIdentity
				+ "'," + "'" + this.phoneNumber + "'," + "'" + this.securtyQuestion + "'," + "'" + this.securtyAnswer
				+ "'" + ")";
		try {
			super.statement = super.connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public AccountInformationManager getAccountInformationManager() {
		return getAccountInformationManager();
	}

	@Override
	public boolean isInformationValid() {
		return !(this.name == null || this.nationalIdentity == null || this.phoneNumber == null
				|| this.securtyQuestion == null || this.securtyAnswer == null || this.userNo == null
				|| this.password == null || textSettingService.isLengthSmallFromThat(11, this.nationalIdentity)
				|| textSettingService.isLengthSmallFromThat(11, this.phoneNumber));

	}

	@Override
	public String takeRandomUserNo() {
		String userNo;
		userNo = String.valueOf(100000 + (int) (Math.random() * 9000000));
		return userNo;
	}

	@Override
	public String takeRandomPassword() {
		String password;
		password = String.valueOf(1000 + (int) (Math.random() * 10000));
		return password;
	}
}
