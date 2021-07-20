package mx.eve.library.service.interfaces;

import java.util.List;

import mx.eve.library.domain.Author;
import mx.eve.library.dto.AuthorDto;

public interface AuthorI {
	
	public List<Author> getAll();
	
	public Author save(AuthorDto dto);
	
	public Author get(Long id);
	
	public Author update(Long id, AuthorDto dto);
	
	public void delete(Long id);
	
}
