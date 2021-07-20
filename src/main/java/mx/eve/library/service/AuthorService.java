package mx.eve.library.service;
//5
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.eve.library.domain.Author;
import mx.eve.library.domain.repository.AuthorR;
import mx.eve.library.dto.AuthorDto;
import mx.eve.library.service.interfaces.AuthorI;

@Service
public class AuthorService implements AuthorI {

	@Autowired
	AuthorR repository;
	
	@Override
	public List<Author> getAll() {
      		return repository.findAll();
	}

	@Override
	public Author save(AuthorDto dto) {
		Author item = Author.builder()
				.name((dto.getName() !=null && !dto.getName().isEmpty())?dto.getName():"empty")
				.build();
		
		return repository.save(item) ;
	}

	@Override
	public Author get(Long id) {
		
		Optional<Author> opt = repository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		
		return null;
	}
	
	

	@Override
	public Author update(Long id, AuthorDto dto) {
		Optional<Author> opt = repository.findById(id);
		if (opt.isPresent()) {
			Author item = opt.get();
			item.setName( (dto.getName() !=null &&
					!dto.getName().isEmpty() )?dto.getName(): item.getName());
			return repository.save(item);
			
			
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Author> opt = repository.findById(id);
		if (opt.isPresent()) {
			repository.delete(opt.get());
		}
		
	}


	
	
	
}
