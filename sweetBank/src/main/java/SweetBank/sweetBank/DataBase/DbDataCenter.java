package SweetBank.sweetBank.DataBase;

public class DbDataCenter extends DbConnection {
	
	protected int userId = 0;
	protected String name, nationalIdentity, phoneNumber, userNo;
	protected int password;
	protected double balance;
	protected double elektricityBill, waterBill, naturalGasBill,  internetBill;
	
	
	public DbDataCenter() {
		super();
	}
	public DbDataCenter(int userId, String name, String nationalIdentity, String phoneNumber, String userNo,
			int password, double balance, double elektricityBill, double waterBill, double naturalGasBill,
			double internetBill) {
		super();
		this.userId = userId;
		this.name = name;
		this.nationalIdentity = nationalIdentity;
		this.phoneNumber = phoneNumber;
		this.userNo = userNo;
		this.password = password;
		this.balance = balance;
		this.elektricityBill = elektricityBill;
		this.waterBill = waterBill;
		this.naturalGasBill = naturalGasBill;
		this.internetBill = internetBill;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationalIdentity() {
		return nationalIdentity;
	}
	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getElektricityBill() {
		return elektricityBill;
	}
	public void setElektricityBill(double elektricityBill) {
		this.elektricityBill = elektricityBill;
	}
	public double getWaterBill() {
		return waterBill;
	}
	public void setWaterBill(double waterBill) {
		this.waterBill = waterBill;
	}
	public double getNaturalGasBill() {
		return naturalGasBill;
	}
	public void setNaturalGasBill(double naturalGasBill) {
		this.naturalGasBill = naturalGasBill;
	}
	public double getInternetBill() {
		return internetBill;
	}
	public void setInternetBill(double internetBill) {
		this.internetBill = internetBill;
	}
	

}
