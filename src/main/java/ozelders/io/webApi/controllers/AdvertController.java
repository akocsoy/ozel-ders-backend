package ozelders.io.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ozelders.io.business.abstracts.AdvertService;
import ozelders.io.business.requests.CreateAdvertRequest;
import ozelders.io.business.responses.GetAdvertsByUserIdResponse;
import ozelders.io.business.responses.GetAllAdvertsResponse;

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
	
	@GetMapping("/{userId}")
	public List<GetAdvertsByUserIdResponse> getAdvertsByUserIdResponse(@PathVariable int userId){
		return this.advertService.getAdvertsByUserId(userId);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.advertService.delete(id);
	}
}
