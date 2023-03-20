package ozelders.io.business.abstracts;

import java.util.List;

import ozelders.io.business.requests.UserAddRequest;
import ozelders.io.business.requests.UserLoginRequest;
import ozelders.io.business.requests.UserLogoutRequest;
import ozelders.io.business.requests.UserSellerRequest;
import ozelders.io.business.responses.GetAllUsersResponse;

public interface UserService {
	void add(UserAddRequest userAddRequest);
	List<GetAllUsersResponse> getAll();
	void login(UserLoginRequest userLoginRequest);
	void delete(int id);
	void logout(UserLogoutRequest userLogoutRequest);
	void beSeller(UserSellerRequest userSellerRequest);
}
