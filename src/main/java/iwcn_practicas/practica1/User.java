package iwcn_practicas.practica1;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String user;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<GrantedAuthority> roles;
	public User(){}
	public User(String user, String password, List<GrantedAuthority> roles){
		this.user=user;
		this.password=new BCryptPasswordEncoder().encode(password);
		this.roles=roles;
	}
	public String getUser(){
		return user;
	}
	public long getId(){
		return id;
	}
	public void setUser(String user){
		this.user=user;
	}
	public void setPassword(String password){
		this.password=new BCryptPasswordEncoder().encode(password);
	}
	public List<GrantedAuthority> getRoles(){
		return roles;
	}
	public void setRoles(List<GrantedAuthority> roles){
		this.roles=roles;
	}
	public String getPasswordHash(){
		return password;
	}
}