package SweetBank.sweetBank.Business.Actions.Abstract;

import org.springframework.stereotype.Service;

@Service
public interface BillPaymentService {
	boolean isBillPaid();
	void resetBill(); 
	void decreaseBalance();
	void BillPayment();
}
