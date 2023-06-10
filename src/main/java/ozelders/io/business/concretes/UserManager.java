package ozelders.io.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
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
import ozelders.io.business.rules.UserBusinessRules;
import ozelders.io.core.utils.encoders.PasswordEncoderService;
import ozelders.io.core.utils.mappers.ModelMapperService;
import ozelders.io.dataAccess.abstracts.AdvertRepository;
import ozelders.io.dataAccess.abstracts.UserRepository;
import ozelders.io.entities.concretes.User;

@Service
@AllArgsConstructor
@Transactional
public class UserManager implements UserService{
	private ModelMapperService modelMapperService;
	private UserRepository userRepository;
	private UserBusinessRules userBusinessRules;
	private PasswordEncoderService passwordEncoderService;
	private AdvertRepository advertRepository;
	@Override
	public void add(UserAddRequest userAddRequest) {
		
		this.userBusinessRules.checkIfUserEmailExists(userAddRequest.getEmail());
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
	public UserLoginResponse login(UserLoginRequest userLoginRequest) {
		
			this.userBusinessRules.checkLogin(userLoginRequest.getEmail(), userLoginRequest.getPassword());
			
			User userToLogin = userRepository.findByEmail(userLoginRequest.getEmail());
			userToLogin.setLogStatus(1);
			userRepository.save(userToLogin);
			return this.modelMapperService.forResponse().map(userToLogin, UserLoginResponse.class);
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
	public void beSeller(int id){
		User user = this.userRepository.findById(id).orElseThrow();
		user.setIsSeller(1);
		this.userRepository.save(user);
	}
	@Override
	public GetUserByUserEmailResponse getUser(String userEmail) {
		User user = this.userRepository.findByEmail(userEmail);
		GetUserByUserEmailResponse response = this.modelMapperService.forResponse().map(user, GetUserByUserEmailResponse.class);
		return response;
	}
	@Override
	public void comment(GiveStarToUserRequest giveStarToUserRequest) {
		User user = this.userRepository.findById(giveStarToUserRequest.getUserId()).orElseThrow();
		List<Double> stars = user.getStar();
		if(stars == null) {
			stars = new ArrayList<Double>();
		}
		stars.add(giveStarToUserRequest.getPoints());
		user.setStar(stars);
		this.userRepository.save(user);
		
	}
	@Override
	public void fillProfile(FillProfileRequest fillProfileRequest) {
		User user = this.userRepository.findById(fillProfileRequest.getId()).orElseThrow();
		user.setName(fillProfileRequest.getName());
		user.setStudyInfo(fillProfileRequest.getStudyInfo());
		user.setCertificates(fillProfileRequest.getCertificates());
		user.setHobbies(fillProfileRequest.getHobbies());
		user.setAbilities(fillProfileRequest.getAbilities());
		this.userRepository.save(user);
		
	}
	@Override
	public GetUserByUserIdResponse getUser(int id) {
		GetUserByUserIdResponse resp = this.modelMapperService.forResponse().map(this.userRepository.findById(id).orElseThrow(), GetUserByUserIdResponse.class);
		return resp;
	}
	
	
}
