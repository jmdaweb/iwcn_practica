package iwcn_practicas.practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PeliculaController{
	@Autowired
	private PeliculaService peliculas;
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/peliculas")
	public ModelAndView listar(){
		return new ModelAndView("template_peliculas").addObject("peliculas", peliculas.listar());
	}
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping("/pelicula")
	public ModelAndView pelicula(@RequestParam long id){
		return new ModelAndView("template_pelicula").addObject("pelicula", peliculas.getPelicula(id));
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/peliculas/delete")
	public ModelAndView eliminar(@RequestParam long id){
		peliculas.eliminar(id);
		return new ModelAndView("template_pelicula_eliminar");
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/peliculas/add")
	public ModelAndView agregar(@RequestParam String nombre, @RequestParam int anio, @RequestParam String director, @RequestParam String reparto, @RequestParam String descripcion, @RequestParam String valoracion, @RequestParam String url_portada, @RequestParam String url_streaming){
		peliculas.agregar(nombre, anio, director, reparto, descripcion, valoracion, url_portada, url_streaming);
		return new ModelAndView("template_pelicula_agregar");
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/peliculas/edit")
	public ModelAndView form_editar(long id){
		return new ModelAndView("form_pelicula_editar").addObject("pelicula", peliculas.getPelicula(id));
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/peliculas/edit/confirm")
	public ModelAndView editar(@RequestParam long id, @RequestParam String nombre, @RequestParam int anio, @RequestParam String director, @RequestParam String reparto, @RequestParam String descripcion, @RequestParam String valoracion, @RequestParam String url_portada, @RequestParam String url_streaming){
		peliculas.actualizar(id, nombre, anio, director, reparto, descripcion, valoracion, url_portada, url_streaming);
		return new ModelAndView("template_pelicula_editar");
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/peliculas/buscar")
	public ModelAndView form_buscar(){
		return new ModelAndView("form_buscar");
	}
	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/peliculas/buscar/resultados")
	public ModelAndView buscar(@RequestParam String consulta){
		ImdbClient cliente=new ImdbClient();
		return new ModelAndView("template_buscar").addObject("resultados", cliente.buscar(consulta));
	}
}