package SweetBank.sweetBank.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import SweetBank.sweetBank.Entity.UserBalance;

public interface UserBalanceRepository extends JpaRepository<UserBalance, Integer> {

}
