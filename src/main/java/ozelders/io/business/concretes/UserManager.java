package ozelders.io.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ozelders.io.business.abstracts.UserService;
import ozelders.io.business.requests.UserAddRequest;
import ozelders.io.business.requests.UserLoginRequest;
import ozelders.io.business.requests.UserLogoutRequest;
import ozelders.io.business.requests.UserSellerRequest;
import ozelders.io.business.responses.GetAllUsersResponse;
import ozelders.io.business.rules.UserBusinessRules;
import ozelders.io.core.utils.encoders.PasswordEncoderService;
import ozelders.io.core.utils.mappers.ModelMapperService;
import ozelders.io.dataAccess.abstracts.AdvertRepository;
import ozelders.io.dataAccess.abstracts.UserRepository;
import ozelders.io.entities.concretes.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService{
	private ModelMapperService modelMapperService;
	private UserRepository userRepository;
	private UserBusinessRules userBusinessRules;
	private PasswordEncoderService passwordEncoderService;
	private AdvertRepository advertRepository;
	@Override
	public void add(UserAddRequest userAddRequest) {
		
		this.userBusinessRules.checkIfUserNameExists(userAddRequest.getName());
		userAddRequest.setPassword(this.passwordEncoderService.encode(userAddRequest.getPassword())); 
		
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
		this.advertRepository.deleteAllByUserId(id);
		this.userRepository.deleteById(id);
	}
	@Override
	public void logout(UserLogoutRequest userLogoutRequest) {
		User userToLogout = this.userRepository.findById(userLogoutRequest.getId()).orElseThrow();
		userToLogout.setLogStatus(0);
		userRepository.save(userToLogout);
	}
	@Override
	public void beSeller(UserSellerRequest userSellerRequest) {
		User user = this.userRepository.findById(userSellerRequest.getId()).orElseThrow();
		user.setIsSeller(1);
		this.userRepository.save(user);
	}
	
	
}
