package iwcn_practicas.practica1;

import java.net.URI;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeliculaService{
	@Autowired
	private PeliculaRepository peliculas;
	@PostConstruct
	private void init(){
		
	}
	public void agregar(String nombre, String anio, String director, String reparto, String descripcion, String valoracion, String url_portada, String url_streaming){
		try {
			URI uri = new URI(url_streaming);
			
			if (uri.getHost().toLowerCase().contains("youtube")) {
				url_streaming = url_streaming.replace("watch", "watch_popup");
			}
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
		}
		
		peliculas.save(new Pelicula(nombre, anio, director, reparto, descripcion, valoracion, url_portada, url_streaming));
	}
	public Pelicula getPelicula(long id){
		return peliculas.findOne(id);
	}
	public Iterable<Pelicula> listar(){
		return peliculas.findAll();
	}
	public void actualizar(long id, String nombre, String anio, String director, String reparto, String descripcion, String valoracion, String url_portada, String url_streaming){
		Pelicula p=getPelicula(id);
		p.setNombre(nombre);;
		p.setAnio(anio);
		p.setDirector(director);
		p.setReparto(reparto);
		p.setDescripcion(descripcion);
		p.setValoracion(valoracion);
		p.setUrl_portada(url_portada);
		p.setUrl_streaming(url_streaming);
		peliculas.save(p);
	}
	public void eliminar(long id){
		peliculas.delete(id);
	}
}