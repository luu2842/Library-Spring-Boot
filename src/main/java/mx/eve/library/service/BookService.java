package mx.eve.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.eve.library.domain.Author;
import mx.eve.library.domain.Book;
import mx.eve.library.domain.repository.BookR;
import mx.eve.library.dto.BookDto;
import mx.eve.library.service.interfaces.AuthorI;
import mx.eve.library.service.interfaces.BookI;

@Service
public class BookService implements BookI {

	@Autowired
	BookR repository;
	
	@Autowired
	AuthorI authori;
	
	@Override
	public List<Book> getAll() {
				return repository.findAll();
	}

	@Override
	public Book save(BookDto dto) {
		Author author = authori.get(dto.getAuthorId());
		Book item = Book.builder()
				.author(author)
				.name((dto.getName() !=null && !dto.getName().isEmpty())?dto.getName():"empty")
                .build();
		return repository.save(item);
	}

	@Override
	public Book get(Long id) {
		Optional<Book> opt = repository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} 
		return null;
	}

	@Override
	public Book update(Long id, BookDto dto) {
		Optional<Book> opt = repository.findById(id);
		if (opt.isPresent()) {
			Book item = opt.get();
			item.setName((dto.getName() !=null &&
					!dto.getName().isEmpty())?dto.getName(): item.getName());
			return repository.save(item);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Book> opt = repository.findById(id);
		if (opt.isPresent()) {
			repository.delete(opt.get());
		}
	}

}
