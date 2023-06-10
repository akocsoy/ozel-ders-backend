package ozelders.io.business.rules;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ozelders.io.core.utils.encoders.PasswordEncoderService;
import ozelders.io.core.utils.exceptions.BusinessException;
import ozelders.io.dataAccess.abstracts.UserRepository;

@Service
@AllArgsConstructor
public class UserBusinessRules {
	private UserRepository userRepository;
	private PasswordEncoderService passwordEncoderService;
	
	public void checkIfUserEmailExists(String email) {
		if(this.userRepository.existsByEmail(email)) {
			throw new BusinessException("User name already exists");
		}
	}
	public void checkLogin(String email, String password) {
		if(this.userRepository.existsByEmail(email)) {
			if(!(this.passwordEncoderService.matches(password, userRepository.findByEmail(email).getPassword()))) {
				throw new BusinessException("Wrong password!");
			}
		}else {
			throw new BusinessException("User name not found!");
		}
	}
}
