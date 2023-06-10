package ozelders.io.business.abstracts;

import java.util.List;

import ozelders.io.business.requests.AdvertApplyRequest;
import ozelders.io.business.requests.CreateAdvertRequest;
import ozelders.io.business.requests.RemoveApplicantRequest;
import ozelders.io.business.requests.UpdateAdvertRequest;
import ozelders.io.business.responses.GetAdvertByAdvertIdResponse;
import ozelders.io.business.responses.GetAdvertsByCategoryResponse;
import ozelders.io.business.responses.GetAdvertsByUserIdResponse;
import ozelders.io.business.responses.GetAllAdvertsResponse;
import ozelders.io.entities.concretes.Advert;

public interface AdvertService {
	
	List<GetAllAdvertsResponse> getAll();
	void add(CreateAdvertRequest createAdvertRequest);
	List<GetAdvertsByUserIdResponse> getAdvertsByUserId(int userId);
	void delete(int id);
	List<GetAdvertsByCategoryResponse> getAdvertsByCategory(int categoryId);
	GetAdvertByAdvertIdResponse getAdvert(int id);
	void applyAdvert(AdvertApplyRequest applyAdvertRequest);
	List<Advert> getAdvertsByApplied(int id);
	void removeApplicant(RemoveApplicantRequest removeApplicantRequest);
	void updateAdvert(UpdateAdvertRequest uppdateAdvertRequest);
}
