package ozelders.io.business.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ozelders.io.entities.concretes.Advert;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByUserIdResponse {
	private int id;
	private int isSeller;
	private String studyInfo;
	private List<String> certificates;
	private List<String> hobbies;
	private List<String> abilities; 
	private String name;
	private String email;
	private int logStatus;
	private List<Advert> adverts;
	private List<Integer> star;
}
