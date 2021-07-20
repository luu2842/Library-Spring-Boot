package mx.eve.library.domain;
//1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor()
@ToString(of = {"id", "name"},
		includeFieldNames = true)
public class Author extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false)
	private String name;
	
	
	public Author() {}


}
