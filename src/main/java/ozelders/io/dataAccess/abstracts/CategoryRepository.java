package ozelders.io.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ozelders.io.entities.concretes.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
