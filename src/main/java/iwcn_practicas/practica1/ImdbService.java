package iwcn_practicas.practica1;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ImdbService{
	@GET("/api/search")
	imdb_searchResult buscar(@Query("q") String consulta);
	@GET("/api/{consulta}")
	Imdb_pelicula getPelicula(@Path("consulta") String consulta);
}