package mx.eve.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.eve.library.domain.User;
import mx.eve.library.domain.repository.UserR;
import mx.eve.library.dto.UserDto;
import mx.eve.library.service.interfaces.UserI;

@Service
public class UserService implements UserI{

	@Autowired
	UserR repository;
	
	@Override
	public List<User> getAll() {
		return repository.findAll();
	
	}

	@Override
	public User save(UserDto dto) {
		
		User item = User.builder()
				.name( (dto.getName() !=null && !dto.getName().isEmpty())?dto.getName():"empty")
                .build();
		return repository.save(item);
	}

	@Override
	public User get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(Long id, UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
