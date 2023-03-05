package ozelders.io.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAdvertsResponse {
	private int id;
	private String userName;
	private String description;
	private String publishDate;
	private double price;
}
