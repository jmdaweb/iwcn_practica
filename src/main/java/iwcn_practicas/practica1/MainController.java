package iwcn_practicas.practica1;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController{
	@RequestMapping("/")
	public ModelAndView index(){
		return new ModelAndView("template_index");
	}
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("template_login");
	}
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/logout")
	public ModelAndView logout(){
		return new ModelAndView("template_logout");
	}
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/home")
	public ModelAndView home(){
		//se muestra la home que ve el usuario tras hacer login
		return new ModelAndView("template_home").addObject("admin", UserService.isAdmin());
	}
}