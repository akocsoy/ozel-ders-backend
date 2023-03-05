package ozelders.io.business.abstracts;

import java.util.List;

import ozelders.io.business.requests.CreateAdvertRequest;
import ozelders.io.business.responses.GetAdvertsByUserIdResponse;
import ozelders.io.business.responses.GetAllAdvertsResponse;

public interface AdvertService {
	
	List<GetAllAdvertsResponse> getAll();
	void add(CreateAdvertRequest createAdvertRequest);
	List<GetAdvertsByUserIdResponse> getAdvertsByUserId(int userId);
	void delete(int id);
	
}
