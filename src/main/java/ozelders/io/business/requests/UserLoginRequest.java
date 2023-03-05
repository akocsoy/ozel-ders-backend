package ozelders.io.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginRequest {
	private String name;
	private String password;
}
