package mx.eve.library.service.interfaces;
//3
import java.util.List;

import mx.eve.library.domain.User;
import mx.eve.library.dto.UserDto;


public interface UserI {
	public List<User> getAll();
	
	public User save(UserDto dto);
	
	public User get(Long id);
	
	public User update(Long id, UserDto dto);
	
	public void delete(Long id);

}

//ger¡nerar clase dto