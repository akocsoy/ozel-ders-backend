package ozelders.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ozelders.io.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByName(String name);
	boolean existsByPassword(String password);
	User findByName(String name);
}
