package iwcn_practicas.practica1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Imdb_pelicula{
	@Id
	private String id;
	private String title;
	private String year;
	private String description;
	private String[] cast;
	private String[] directors;
	private String image;
	private String rating;
	public Imdb_pelicula(){}
	public Imdb_pelicula(String id, String title, String year, String description, String[] cast, String[] directors, String image, String rating){
		this.id=id;
		this.title=title;
		this.year=year;
		this.description=description;
		this.cast=cast;
		this.directors=directors;
		this.image=image;
		this.rating=rating;
	}
	public String getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String getYear(){
		return year;
	}
	public String getDescription(){
		return description;
	}
	public String getCast(){
		return cast.toString();
	}
	public String getDirectors(){
		return directors.toString();
	}
	public String getImage(){
		return image;
	}
	public String getRating(){
		return rating;
	}
}