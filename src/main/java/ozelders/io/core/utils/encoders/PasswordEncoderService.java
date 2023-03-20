package ozelders.io.core.utils.encoders;

public interface PasswordEncoderService{
	String encode(String password);
	boolean matches(String rawPassword, String encodedPassword);
}
