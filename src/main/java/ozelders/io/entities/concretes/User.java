package ozelders.io.entities.concretes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "logStatus")
	private int logStatus = 0;
	
	@Column(name = "isSeller")
	private int isSeller;
	
	@Column(name = "studyInfo")
	private String studyInfo;

	@Column(name = "hobbies")
	private List<String> hobbies;
	
	@Column(name = "abilities")
	private List<String> abilities;
	
	private List<String> certificates;
	
	@Column(name="star")
	private List<Double> star;
	
	@JsonBackReference
	@OneToMany(mappedBy = "user")
	private List<Advert> adverts;
}
