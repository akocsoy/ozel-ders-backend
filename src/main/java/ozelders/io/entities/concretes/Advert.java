package ozelders.io.entities.concretes;

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
	
	@Column(name = "publish_date")
	private String publishDate;
	
	@Column(name = "price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	
}
