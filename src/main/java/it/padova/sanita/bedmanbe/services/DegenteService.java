package it.padova.sanita.bedmanbe.services;

import java.util.List;
 
import it.padova.sanita.bedmanbe.dao.DegenteDAO;
import it.padova.sanita.bedmanbe.dto.Degente;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//import com.google.gson.reflect.TypeToken;
/*import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;*/

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/restdeg")
@Stateless
public class DegenteService {
    // Utilizzo GsonBuilder per il settaggio del formato della data
	//private Gson gson = new Gson();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
	private DegenteDAO degenteDAO = new DegenteDAO();
	
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
	/*@Path("/rilevazione")
	@GET 
    @Produces("text/plain")
    public String getIt() {
        return "Restful Web Services for Bed Management!";
    }*/

	@GET
	@Path("degente")
	@Produces("application/json")
	public Response get()
	{
		try
		{
			//Get specific values
			List<Degente> _degenti = degenteDAO.findAll();

			if(_degenti != null) {
				return Response.status(200).entity(gson.toJson(_degenti)).build(); 
			} else {
				return Response.status(404).entity("NOT FOUND").build();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity("ERROR").build();
		}
	}
	
	/*@GET
	@Path("degente/reparto/{id}")
	@Produces("application/json")
	public Response getDegenteReparto(@PathParam("id") int id)
	{
		try
		{
			//Get specific values
			List<Degente> _degenti = rilevazioneDAO.findByWard(id);

			if(_degenti != null) {
				return Response.status(200).entity(gson.toJson(_degenti)).build(); 
			} else {
				return Response.status(404).entity("NOT FOUND").build();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity("ERROR").build();
		}
	}*/
	
}