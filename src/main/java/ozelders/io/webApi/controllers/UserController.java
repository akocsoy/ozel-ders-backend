package ozelders.io.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
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
import ozelders.io.business.requests.UserAddRequest;
import ozelders.io.business.requests.UserLoginRequest;
import ozelders.io.business.requests.UserLogoutRequest;
import ozelders.io.business.requests.UserSellerRequest;
import ozelders.io.business.responses.GetAllUsersResponse;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	
	private UserService userService;
	
	@GetMapping()
	public List<GetAllUsersResponse> getAll(){
		return userService.getAll();
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
	public void login(@RequestBody() UserLoginRequest userLoginRequest) {
		this.userService.login(userLoginRequest);
	}
	@PutMapping("/logout")
	public void login(@RequestBody() UserLogoutRequest userLogoutRequest) {
		this.userService.logout(userLogoutRequest);
	}
	@PutMapping("/beseller")
	public void beSeller(@RequestBody() UserSellerRequest userSellerRequest) {
		this.userService.beSeller(userSellerRequest);
	}
}
