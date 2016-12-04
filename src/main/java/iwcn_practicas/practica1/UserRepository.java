package iwcn_practicas.practica1;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByName(String name);
}