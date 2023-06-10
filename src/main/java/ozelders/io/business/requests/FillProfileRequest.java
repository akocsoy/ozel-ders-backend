package ozelders.io.business.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FillProfileRequest {
	private int id;
	private String name;
	private List<String> hobbies;
	private String studyInfo;
	private List<String> abilities;
	private List<String> certificates;
}
