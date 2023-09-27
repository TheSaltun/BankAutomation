package SweetBank.sweetBank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "user_Informations")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInformation {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="userId")
	private String userId;
	
	@Column(name="name")
	private String name;

	@Column(name="nationalIdentity")
	private String nationalIdentity;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="securityQuestion")
	private String securityQuestion;
	
	@Column(name="securityAnswer")
	private String securityAnswer;

	@Column(name="userNo")
	private int userNo;
	
	@Column(name="password")
	private int password;

}
