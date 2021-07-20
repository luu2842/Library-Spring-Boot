package mx.eve.library.service.interfaces;

import java.util.List;

import mx.eve.library.domain.Book;
import mx.eve.library.dto.BookDto;

public interface BookI {
	
	public List<Book> getAll();
	
	public Book save(BookDto dto);
	
	public Book get(Long id);
	
	public Book update(Long id, BookDto dto);
	
	public void delete(Long id);
}