package ozelders.io.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import ozelders.io.business.abstracts.AdvertService;
import ozelders.io.business.requests.CreateAdvertRequest;
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
	
	
}
