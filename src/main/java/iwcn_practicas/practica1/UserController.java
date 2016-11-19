package iwcn_practicas.practica1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController{
	@Autowired
	private UserService usuarios;
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/users")
	public ModelAndView listar(){
		return new ModelAndView("template_users").addObject("usuarios", usuarios.listar());
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/users/add")
	public ModelAndView form_agregar(){
		return new ModelAndView("form_usuario_agregar");
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/users/add/confirm")
	public ModelAndView agregar(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam int rol){
		List<GrantedAuthority> roles=null;
		if (rol==0){
			//agregamos un usuario
			roles=usuarios.ROL_USUARIO;
		}else{
			//agregamos un administrador
			roles=usuarios.ROL_ADMIN;
		}
		usuarios.agregar(name, password, email, roles);
		return new ModelAndView("template_usuario_agregar");
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/users/delete")
	public ModelAndView delete(@RequestParam long id){
		usuarios.eliminar(id);
		return new ModelAndView("template_user_delete");
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/users/edit")
	public ModelAndView form_editar(@RequestParam long id){
		return new ModelAndView("form_usuario_editar").addObject(usuarios.getUser(id)).addObject(usuarios.isAdmin(id));
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/users/edit/confirm")
	public ModelAndView editar(@RequestParam long id, @RequestParam String user, @RequestParam String password, @RequestParam String email, @RequestParam int rol){
		List<GrantedAuthority> roles=null;
		if (rol==0){
			//agregamos un usuario
			roles=usuarios.ROL_USUARIO;
		}else{
			//agregamos un administrador
			roles=usuarios.ROL_ADMIN;
		}
		usuarios.actualizar(id, user, password, email, roles);
		return new ModelAndView("template_usuario_editar");
	}
}