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
	private String name;
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<GrantedAuthority> roles;
	private String email;
	
	public User(){}
	
	public User(String name, String password, String email, List<GrantedAuthority> roles){
		this.name=name;
		this.password=new BCryptPasswordEncoder().encode(password);
		this.email=email;
		this.roles=roles;
	}
	
	public String getName(){
		return this.name;
	}
	
	public long getId(){
		return this.id;
	}
	
	public void setName(String name){
		this.name=name;
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
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
}