package ozelders.io.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ozelders.io.business.abstracts.AdvertService;
import ozelders.io.business.requests.AdvertApplyRequest;
import ozelders.io.business.requests.CreateAdvertRequest;
import ozelders.io.business.requests.RemoveApplicantRequest;
import ozelders.io.business.requests.UpdateAdvertRequest;
import ozelders.io.business.responses.GetAdvertByAdvertIdResponse;
import ozelders.io.business.responses.GetAdvertsByCategoryResponse;
import ozelders.io.business.responses.GetAdvertsByUserIdResponse;
import ozelders.io.business.responses.GetAllAdvertsResponse;
import ozelders.io.entities.concretes.Advert;

@CrossOrigin
@RestController
@RequestMapping("/api/adverts")
@AllArgsConstructor
public class AdvertController {
	private AdvertService advertService;
	
	@GetMapping()
	public List<GetAllAdvertsResponse> getAll(){
		return advertService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateAdvertRequest createAdvertRequest) {
		advertService.add(createAdvertRequest);
	}
	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void update(@RequestBody UpdateAdvertRequest updateAdvertRequest) {
		advertService.updateAdvert(updateAdvertRequest);
	}
	
	@GetMapping("/{userId}")
	public List<GetAdvertsByUserIdResponse> getAdvertsByUserIdResponse(@PathVariable int userId){
		return this.advertService.getAdvertsByUserId(userId);
	}
	@GetMapping("/category/{categoryId}")
	public List<GetAdvertsByCategoryResponse> getAdvertsByCategory(@PathVariable int categoryId){
		return this.advertService.getAdvertsByCategory(categoryId);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.advertService.delete(id);
	}
	@GetMapping("advert/{id}")
	public GetAdvertByAdvertIdResponse getById(@PathVariable int id) {
		return this.advertService.getAdvert(id);
	}
	@PutMapping("/advert/apply")
	public void applyAdvert(@RequestBody AdvertApplyRequest advertApplyRequest) {
		this.advertService.applyAdvert(advertApplyRequest);
	}
	@GetMapping("/getApplied/{id}")
	public List<Advert> getApplied(@PathVariable int id){
		return this.advertService.getAdvertsByApplied(id);
	}
	
	@PutMapping("/advert/removeApplicant")
	public void removeApplicant(@RequestBody() RemoveApplicantRequest removeApplicantRequest) {
		this.advertService.removeApplicant(removeApplicantRequest);
	}
}
