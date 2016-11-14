package iwcn_practicas.practica1;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class UserService{
	@Autowired
	private UserRepository usuarios;
	@PostConstruct
	private void init(){
		
	}
	public void agregar(String nombre, String clave, String email, List<GrantedAuthority> roles){
		usuarios.save(new User(nombre, clave, email, roles));
	}
	public void eliminar(long id){
		usuarios.delete(id);;
	}
	public Iterable<User> listar(){
		return usuarios.findAll();
	}
	public User getUser(long id){
		return usuarios.findOne(id);
	}
	public void actualizar(long id, String nombre, String clave, String email, List<GrantedAuthority> roles){
		User u=getUser(id);
		u.setUser(nombre);
		u.setPassword(clave);
		u.setEmail(email);;
		u.setRoles(roles);;
		usuarios.save(u);
	}
}