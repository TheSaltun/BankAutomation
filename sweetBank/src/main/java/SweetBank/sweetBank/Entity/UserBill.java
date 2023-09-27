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
public class UserBill {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="electricity")
	private int electricity;
	
	@Column(name="water")
	private int water;
	
	@Column(name="naturalGas")
	private int naturalGas;
	
	@Column(name="internet")
	private int internet;

}
