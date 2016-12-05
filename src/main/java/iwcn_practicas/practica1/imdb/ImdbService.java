package iwcn_practicas.practica1.imdb;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ImdbService{
	@GET("/search?api_key=4a8e815d-9ab6-435d-b5ec-1b34af79e214")
	imdb_searchResult buscar(@Query("q") String consulta);
	@GET("/{consulta}?api_key=4a8e815d-9ab6-435d-b5ec-1b34af79e214")
	imdb_peliculaResult getPelicula(@Path("consulta") String consulta);
}