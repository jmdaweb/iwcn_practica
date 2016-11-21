package iwcn_practicas.practica1;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import retrofit.http.GET;
import retrofit.http.Path;

public interface ImdbService{
	@GET("/api/search")
	List<Imdb_pelicula> buscar(@RequestParam String consulta);
	@GET("/api/{consulta}")
	Imdb_pelicula getPelicula(@Path("consulta") String consulta);
}