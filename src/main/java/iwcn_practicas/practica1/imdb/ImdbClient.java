package iwcn_practicas.practica1.imdb;

import java.util.List;

import retrofit.RestAdapter;

public class ImdbClient{
	private ImdbService servicio;
	public ImdbClient(){
		RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://imdb.wemakesites.net/api").build();
		servicio=adapter.create(ImdbService.class);
	}
	public List<imdb_title> buscar(String consulta){
		return servicio.buscar(consulta).data.results.titles;
	}
	public imdb_pelicula getPelicula(String consulta){
		return servicio.getPelicula(consulta).data;
	}
}