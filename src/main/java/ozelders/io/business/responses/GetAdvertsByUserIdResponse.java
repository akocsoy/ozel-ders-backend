package ozelders.io.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAdvertsByUserIdResponse {
	private int id;
	private int userId;
	private String categoryName;
	private String userName;
	private String userEmail;
	private String description;
	private String detailedDescription;
	private String startDate;
	private double weeklyHours;
	private int duration;
	private double price;
	private String publishDate;
	private int categoryId;
	private int quota;
	private String platform;
	private String platformCode;
	private List<Integer> userStar;
	private List<Integer> applicants;
	
}
