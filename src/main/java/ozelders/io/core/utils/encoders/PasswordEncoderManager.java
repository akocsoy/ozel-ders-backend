package ozelders.io.core.utils.encoders;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PasswordEncoderManager implements PasswordEncoderService{
	
	private BCryptPasswordEncoder encoder;

	@Override
	public String encode(String password) {
		return encoder.encode(password);
	}

	@Override
	public boolean matches(String rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}

}
