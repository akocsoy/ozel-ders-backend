package ozelders.io.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ozelders.io.business.abstracts.UserService;
import ozelders.io.business.requests.UserAddRequest;
import ozelders.io.business.requests.UserLoginRequest;
import ozelders.io.business.requests.UserLogoutRequest;
import ozelders.io.business.responses.GetAllUsersResponse;
import ozelders.io.business.rules.UserBusinessRules;
import ozelders.io.core.utils.mappers.ModelMapperService;
import ozelders.io.dataAccess.abstracts.UserRepository;
import ozelders.io.entities.concretes.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService{
	private ModelMapperService modelMapperService;
	private UserRepository userRepository;
	private UserBusinessRules userBusinessRules;
	@Override
	public void add(UserAddRequest userAddRequest) {
		
		this.userBusinessRules.checkIfUserNameExists(userAddRequest.getName());
		
		User newUser = this.modelMapperService.forRequest().map(userAddRequest, User.class);
		this.userRepository.save(newUser);
	}
	@Override
	public List<GetAllUsersResponse> getAll() {
		List<GetAllUsersResponse> response = this.userRepository.findAll().stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class)).collect(Collectors.toList());
		return response;
	}
	@Override
	public void login(UserLoginRequest userLoginRequest) {
		
			this.userBusinessRules.checkLogin(userLoginRequest.getName(), userLoginRequest.getPassword());
			
			User userToLogin = userRepository.findByName(userLoginRequest.getName());
			userToLogin.setLogStatus(1);
			userRepository.save(userToLogin);
		
	}
	@Override
	public void delete(int id) {
		this.userRepository.deleteById(id);
	}
	@Override
	public void logout(UserLogoutRequest userLogoutRequest) {
		User userToLogout = this.userRepository.findById(userLogoutRequest.getId()).orElseThrow();
		userToLogout.setLogStatus(0);
		userRepository.save(userToLogout);
	}
	
	
}
