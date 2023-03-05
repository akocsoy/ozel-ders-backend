package ozelders.io.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ozelders.io.core.utils.exceptions.BusinessException;
import ozelders.io.dataAccess.abstracts.UserRepository;

@Service
@AllArgsConstructor
public class UserBusinessRules {
	private UserRepository userRepository;
	
	public void checkIfUserNameExists(String name) {
		if(this.userRepository.existsByName(name)) {
			throw new BusinessException("User name already exists");
		}
	}
	public void checkLogin(String name, String password) {
		if(this.userRepository.existsByName(name)) {
			if(!(this.userRepository.findByName(name).getPassword().equals(password))) {
				throw new BusinessException("Wrong password!");
			}
		}else {
			throw new BusinessException("User name not found!");
		}
	}
}
