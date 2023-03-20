package ozelders.io.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ozelders.io.entities.concretes.Advert;

public interface AdvertRepository extends JpaRepository<Advert, Integer> {

		List<Advert> findByUserId(int userId);
		void deleteAllByUserId(int userId);
}
