package SweetBank.sweetBank.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SweetBank.sweetBank.Entity.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Integer> {

}
