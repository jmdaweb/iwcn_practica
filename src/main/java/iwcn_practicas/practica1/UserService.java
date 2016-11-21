package iwcn_practicas.practica1;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserService{
	@Autowired
	private UserRepository usuarios;
	public List<GrantedAuthority> ROL_USUARIO;
	public List<GrantedAuthority> ROL_ADMIN;
	
	@PostConstruct
	private void init(){
		GrantedAuthority[] userRoles={new SimpleGrantedAuthority("ROLE_USER")};
		ROL_USUARIO=Arrays.asList(userRoles);
		this.usuarios.save(new User("user", "user", "usuario@test.com", ROL_USUARIO));
		
		GrantedAuthority[] adminRoles={new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN")};
		ROL_ADMIN=Arrays.asList(adminRoles);
		this.usuarios.save(new User("admin", "admin", "admin@test.com", ROL_ADMIN));
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
		u.setRoles(roles);
		usuarios.save(u);
	}
	
	public static boolean isAdmin(){
		//comprueba si el usuario actual es administrador
		boolean admin=false;
		Authentication auth = SecurityContextHolder .getContext().getAuthentication();
		if (auth.getAuthorities().contains( new SimpleGrantedAuthority("ROLE_ADMIN"))){
			admin=true;
		}
		return admin;
	}
	
	public boolean isAdmin(long id){
		//comprueba si el usuario especificado es administrador
		boolean admin=false;
		User u=getUser(id);
		if (u.getRoles()==ROL_ADMIN){
			admin=true;
		}
		return admin;
	}
}