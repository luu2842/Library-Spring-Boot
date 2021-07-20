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
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data //Para generar get y set
@Builder //Necesario para construir el de set/get
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor //Agregar constructores
@NoArgsConstructor//Se genera el constructor
@ToString(includeFieldNames = true)
public class User {
//Extendera de Audit model para tener las columnas de audtoria 
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String name;

@Column (nullable = false, unique = true)
private String email;
}
