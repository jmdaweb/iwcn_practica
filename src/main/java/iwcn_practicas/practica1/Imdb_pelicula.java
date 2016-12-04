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
	public void setId(String id){
		this.id=id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getYear(){
		return year;
	}
	public void setYear(String year){
		this.year=year;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getCast(){
		return cast.toString();
	}
	public void setCast(String[] cast){
		this.cast=cast;
	}
	public String getDirectors(){
		return directors.toString();
	}
	public void setDirectors(String[] directors){
		this.directors=directors;
	}
	public String getImage(){
		return image;
	}
	public void setImage(String image){
		this.image=image;
	}
	public String getRating(){
		return rating;
	}
	public void setRating(String rating){
		this.rating=rating;
	}
}