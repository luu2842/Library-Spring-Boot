package mx.eve.library.domain.repository;
//2

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.eve.library.domain.User;

@Repository
public interface UserR  extends JpaRepository<User, Long>{

}
