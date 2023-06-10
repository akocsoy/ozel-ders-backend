package ozelders.io.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="advert")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advert {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "detailedDescription")
	private String detailedDescription;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "quota" )
	private int quota;
	
	@Column(name = "platform")
	private String platform;
	
	@Column(name = "publish_date")
	private String publishDate;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "weeklyHours")
	private double weeklyHours;
	
	@Column(name = "platformCode")
	private String platformCode;
	
	@Column(name = "applicants")
	private List<Integer> applicants;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
}
