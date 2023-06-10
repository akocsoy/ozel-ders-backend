package ozelders.io.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import ozelders.io.business.abstracts.AdvertService;
import ozelders.io.business.requests.AdvertApplyRequest;
import ozelders.io.business.requests.CreateAdvertRequest;
import ozelders.io.business.requests.RemoveApplicantRequest;
import ozelders.io.business.requests.UpdateAdvertRequest;
import ozelders.io.business.responses.GetAdvertByAdvertIdResponse;
import ozelders.io.business.responses.GetAdvertsByCategoryResponse;
import ozelders.io.business.responses.GetAdvertsByUserIdResponse;
import ozelders.io.business.responses.GetAllAdvertsResponse;
import ozelders.io.core.utils.mappers.ModelMapperService;
import ozelders.io.dataAccess.abstracts.AdvertRepository;
import ozelders.io.entities.concretes.Advert;

@Data
@Service
@AllArgsConstructor
public class AdvertManager implements AdvertService{
	
	private ModelMapperService modelMapperService;
	private AdvertRepository advertRepository;
	
	@Override
	public List<GetAllAdvertsResponse> getAll() {
		List<Advert> ads = this.advertRepository.findAll();
		List<GetAllAdvertsResponse> resp = ads.stream().map(ad -> this.modelMapperService.forResponse().map(ad, GetAllAdvertsResponse.class)).collect(Collectors.toList());
		return resp;
	}

	@Override
	public void add(CreateAdvertRequest createAdvertRequest) {
		
		Advert advert = this.modelMapperService.forRequest().map(createAdvertRequest, Advert.class);
		advert.setApplicants(new ArrayList<Integer>());
		this.advertRepository.save(advert);
		
	}

	@Override
	public List<GetAdvertsByUserIdResponse> getAdvertsByUserId(int userId) {
		List<Advert> ads = this.advertRepository.findByUserId(userId);
		List<GetAdvertsByUserIdResponse> resp = ads.stream().map(ad -> this.modelMapperService.forResponse().map(ad, GetAdvertsByUserIdResponse.class)).collect(Collectors.toList());
		return resp;
	}

	@Override
	public void delete(int id) {
		this.advertRepository.deleteById(id);
	}

	@Override
	public List<GetAdvertsByCategoryResponse> getAdvertsByCategory(int categoryId) {
		 List<Advert> adverts= this.advertRepository.findAllByCategoryId(categoryId);
		 List<GetAdvertsByCategoryResponse> response = adverts.stream().map(advert -> this.modelMapperService.forResponse().map(advert, GetAdvertsByCategoryResponse.class)).collect(Collectors.toList());
		 return response;
	}

	@Override
	public GetAdvertByAdvertIdResponse getAdvert(int id) {
		Advert ad = this.advertRepository.findById(id).orElseThrow();
		GetAdvertByAdvertIdResponse resp = this.modelMapperService.forResponse().map(ad, GetAdvertByAdvertIdResponse.class);
		return resp;
	}

	@Override
	public void applyAdvert(AdvertApplyRequest applyAdvertRequest) {
		Advert ad = this.advertRepository.findById(applyAdvertRequest.getAdvertId()).orElseThrow();
		if(ad.getQuota()==0) {
			return ;
		}
		List<Integer> applicants =ad.getApplicants();
		applicants.add(applyAdvertRequest.getUserId());
		ad.setApplicants(applicants);
		ad.setQuota(ad.getQuota()-1);
		this.advertRepository.save(ad);
	}

	@Override
	public List<Advert> getAdvertsByApplied(int id) {
		List<Advert> ads = this.advertRepository.findAll();
		return ads.stream().filter(ad -> ad.getApplicants().contains(id)).collect(Collectors.toList());
	}

	@Override
	public void removeApplicant(RemoveApplicantRequest removeApplicantRequest) {
		Advert ad = this.advertRepository.findById(removeApplicantRequest.getId()).orElseThrow();
		List<Integer> appliers = ad.getApplicants();
		List<Integer> indexes = new ArrayList<Integer>();
		for(int i = 0; i < appliers.size() ;i++) {
			if(appliers.get(i) == removeApplicantRequest.getUserId()) {
				indexes.add(appliers.get(i));
			}
		}
		appliers.removeAll(indexes);
		ad.setApplicants(appliers);
		this.advertRepository.save(ad);
		
		
	}

	@Override
	public void updateAdvert(UpdateAdvertRequest updateAdvertRequest) {
		Advert advert = this.modelMapperService.forRequest().map(updateAdvertRequest, Advert.class);
		this.advertRepository.save(advert);
	}
	
	
}
