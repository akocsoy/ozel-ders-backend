package ozelders.io.business.abstracts;

import java.util.List;

import ozelders.io.business.requests.FillProfileRequest;
import ozelders.io.business.requests.GiveStarToUserRequest;
import ozelders.io.business.requests.UserAddRequest;
import ozelders.io.business.requests.UserLoginRequest;
import ozelders.io.business.requests.UserLogoutRequest;
import ozelders.io.business.responses.GetAllUsersResponse;
import ozelders.io.business.responses.GetUserByUserEmailResponse;
import ozelders.io.business.responses.GetUserByUserIdResponse;
import ozelders.io.business.responses.UserLoginResponse;

public interface UserService {
	void add(UserAddRequest userAddRequest);
	List<GetAllUsersResponse> getAll();
	GetUserByUserEmailResponse getUser(String userEmail);
	UserLoginResponse login(UserLoginRequest userLoginRequest);
	void delete(int id);
	void logout(UserLogoutRequest userLogoutRequest);
	void beSeller(int id);
	void comment(GiveStarToUserRequest giveStarToUserRequest);
	void fillProfile(FillProfileRequest fillProfileRequest);
	GetUserByUserIdResponse getUser(int id);
	

}
