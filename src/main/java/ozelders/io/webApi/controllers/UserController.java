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
import ozelders.io.business.abstracts.UserService;
import ozelders.io.business.requests.FillProfileRequest;
import ozelders.io.business.requests.GiveStarToUserRequest;
import ozelders.io.business.requests.UserAddRequest;
import ozelders.io.business.requests.UserLoginRequest;
import ozelders.io.business.requests.UserLogoutRequest;
import ozelders.io.business.requests.UserSellerRequest;
import ozelders.io.business.responses.GetAllUsersResponse;
import ozelders.io.business.responses.GetUserByUserEmailResponse;
import ozelders.io.business.responses.GetUserByUserIdResponse;
import ozelders.io.business.responses.UserLoginResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	@GetMapping()
	public List<GetAllUsersResponse> getAll(){
		return userService.getAll();
	}
	@GetMapping("/getByEmail/{userEmail}")
	public GetUserByUserEmailResponse getUser(@PathVariable String userEmail) {
		return userService.getUser(userEmail);
	}
	@GetMapping("/getById/{id}")
	public GetUserByUserIdResponse getUserById(@PathVariable int id) {
		return userService.getUser(id);
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() UserAddRequest userAddRequest) {
		this.userService.add(userAddRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.userService.delete(id);
	}
	
	@PutMapping("/login")
	public UserLoginResponse login(@RequestBody() UserLoginRequest userLoginRequest) {
		return this.userService.login(userLoginRequest);
	}
	@PutMapping("/logout")
	public void logout(@RequestBody() UserLogoutRequest userLogoutRequest) {
		this.userService.logout(userLogoutRequest);
	}
	@PutMapping("/beseller/{id}")
	public void beSeller(@PathVariable int id){
		this.userService.beSeller(id);
	}
	@PutMapping("/comment")
	public void comment(@RequestBody() GiveStarToUserRequest giveStarToUserRequest) {
		this.userService.comment(giveStarToUserRequest);
	}
	@PutMapping("/fillProfile")
	public void fillProfile(@RequestBody() FillProfileRequest fillProfileRequest) {
		this.userService.fillProfile(fillProfileRequest);
	}
}
