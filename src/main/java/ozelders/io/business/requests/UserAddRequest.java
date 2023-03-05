package ozelders.io.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAddRequest {
	private int logStatus;
	private String name;
	private String password;
}
