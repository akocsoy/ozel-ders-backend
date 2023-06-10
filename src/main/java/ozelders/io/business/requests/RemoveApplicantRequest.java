package ozelders.io.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoveApplicantRequest {
	
	private int id;
	private int userId;
	
}
