package ozelders.io.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
	private int id;
	private String name;
	private String password;
	private int logStatus;
	private List<Integer> star;
}
