package ozelders.io.business.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdvertRequest {
	private int userId;
	private String description;
	private List<Integer> applicants;
	private String detailedDescription;
	private int duration;
	private double price;
	private String startDate;
	private double weeklyHours;
	private String platformCode;
	private String publishDate;
	private int categoryId;
	private int quota;
	private String platform;
}
