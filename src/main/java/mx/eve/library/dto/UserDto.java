package mx.eve.library.dto;
//4
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class UserDto {
	public String name;
	
public UserDto() {
	// TODO Auto-generated constructor stub
}
}
