package it.padova.sanita.bedmanbe.services;

import it.padova.sanita.bedmanbe.dao.DegenteDAO;
import it.padova.sanita.bedmanbe.dto.DegRil;
import it.padova.sanita.bedmanbe.dto.Degente;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/restdegril")
@Stateless
public class DegenteRilevazioneService {
	private DegenteDAO degenteDAO = new DegenteDAO();
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssX").create();
	
	@GET
	@Path("rileva/{wardId}")
	@Produces("application/json")
	public Response get(@PathParam("wardId") String wardId)
	{
		List<DegRil> _degentirilevazioni = null;

		try
		{
			_degentirilevazioni = new ArrayList<DegRil>();
			List<Degente> _degenti = degenteDAO.findByWard(wardId);
			for(Degente _deg : _degenti){	
				DegRil _degril = new DegRil();
				_degril.setDegente(_deg);
				_degentirilevazioni.add(_degril) ;
			}
			
			
//			//Get specific values
//			List<Degente> _degenti = degenteDAO.findAll();
//
//			if(_degenti != null) {
//				return Response.status(200).entity(gson.toJson(_degenti)).build(); 
//			} else {
//				return Response.status(404).entity("NOT FOUND").build();
//			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return Response.status(500).entity("ERROR").build();
		}
		
		return Response.status(200).entity(gson.toJson(_degentirilevazioni)).build(); 
	}
	
}
