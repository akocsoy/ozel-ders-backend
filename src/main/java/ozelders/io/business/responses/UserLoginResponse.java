package ozelders.io.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {
	private int id;
	private String email;
	private String Name;
	private int isSeller;
}
