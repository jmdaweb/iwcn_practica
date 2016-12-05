package iwcn_practicas.practica1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pelicula{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre;
	private String director;
	private String reparto;
	private String anio;
	private String valoracion;
	@Column(length=1024)
	private String descripcion;
	private String url_portada;
	private String url_streaming;
	public Pelicula(){}
	public Pelicula(String nombre, String anio, String director, String reparto, String descripcion, String valoracion, String url_portada, String url_streaming){
		this.nombre=nombre;
		this.anio=anio;
		this.director=director;
		this.reparto=reparto;
		this.descripcion=descripcion;
		this.valoracion=valoracion;
		this.url_portada=url_portada;
		this.url_streaming=url_streaming;
	}
	public String getNombre(){
		return nombre;
	}
	public String getAnio(){
		return anio;
	}
	public String getDirector(){
		return director;
	}
	public String getReparto(){
		return reparto;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public String getValoracion(){
		return valoracion;
	}
	public String getUrl_portada(){
		return url_portada;
	}
	public String getUrl_streaming(){
		return url_streaming;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public void setAnio(String anio){
		this.anio=anio;
	}
	public void setDirector(String director){
		this.director=director;
	}
	public void setReparto(String reparto){
		this.reparto=reparto;
	}
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	public void setValoracion(String valoracion){
		this.valoracion=valoracion;
	}
	public void setUrl_portada(String url){
		this.url_portada=url;
	}
	public void setUrl_streaming(String url){
		this.url_streaming=url;
	}
	public long getId(){
		return id;
	}
}