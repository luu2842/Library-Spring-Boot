package mx.eve.library.domain.repository;
//2
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.eve.library.domain.Author;

@Repository
public interface AuthorR extends JpaRepository<Author, Long>{
	
	public List<Author> findAll();

}