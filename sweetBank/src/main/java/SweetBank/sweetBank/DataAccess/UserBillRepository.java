package SweetBank.sweetBank.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import SweetBank.sweetBank.Entity.UserBill;

public interface UserBillRepository extends JpaRepository<UserBill, Integer>{

}
