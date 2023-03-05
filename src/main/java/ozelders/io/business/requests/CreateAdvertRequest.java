package ozelders.io.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdvertRequest {
	private int userId;
	private String description;
	private double price;
	private String publishDate;
}
