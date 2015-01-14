package it.padova.sanita.bedmanbe.services;

import java.util.List;
 
import it.padova.sanita.bedmanbe.dao.RilevazioneDAO;
import it.padova.sanita.bedmanbe.dto.Rilevazione;

import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/rest")
@Stateless
public class RilevazioneService {
    // Utilizzo GsonBuilder per il settaggio del formato della data
	//private Gson gson = new Gson();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
	private RilevazioneDAO rilevazioneDAO = new RilevazioneDAO();
	
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
	@Path("rilevazione")
	@Produces("application/json")
	public Response get()
	{
		try
		{
			//Get specific values
			List<Rilevazione> _rilevazioni = rilevazioneDAO.findAll();

			if(_rilevazioni != null) {
				return Response.status(200).entity(gson.toJson(_rilevazioni)).build(); 
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
	
	@GET
	@Path("rilevazione/{id}")
	@Produces("application/json")
	public Response getRilevazione(@PathParam("id") Long id)
	{
		try
		{
			//Get specific values
			Rilevazione _rilevazione = rilevazioneDAO.findById(id);

			if(_rilevazione != null) {
				return Response.status(200).entity(gson.toJson(_rilevazione)).build(); 
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
	
	@POST
	@Path("/rilevazione")
	public Response createOrUpdateRilevazione(String payload) {
		Rilevazione rilevazione = gson.fromJson(payload, Rilevazione.class);
		try {
			rilevazione = rilevazioneDAO.saveOrUpdate(rilevazione);
			return Response.status(200).entity(null).build();

		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
	}
	
	/*@POST
	@Path("/patientStoredPro")
	public Response InsertOrUpdateViaStoredPro(String payload) {
		Patient patient = gson.fromJson(payload, Patient.class);

		try {
			String ret = patientDAO.InsertOrUpdateViaStoredPro(patient);
			return Response.status(200).entity(ret).build();
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
	}*/

	@DELETE
	@Path("rilevazione/{id}")
	public Response deleteRilevazione(@PathParam("id") Long id)
	{
		try
		{
			//Get specific values
			Rilevazione _rilevazione = rilevazioneDAO.findById(id);

			if(_rilevazione != null) {
				rilevazioneDAO.delete(_rilevazione);
				return Response.status(200).entity(gson.toJson(null)).build(); 
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
	
}
