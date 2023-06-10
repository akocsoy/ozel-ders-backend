package ozelders.io.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GiveStarToUserRequest {
	
	private int userId;
	private double points;
	
}
