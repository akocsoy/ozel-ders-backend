package ozelders.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ozelders.io.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByEmail(String email);
	boolean existsByPassword(String password);
	User findByEmail(String Email);
}
