package it.padova.sanita.bedmanbe.services;

import it.padova.sanita.bedmanbe.dao.DegenteDAO;
import it.padova.sanita.bedmanbe.dao.RilevazioneDAO;
import it.padova.sanita.bedmanbe.dto.DegRil;
import it.padova.sanita.bedmanbe.dto.Degente;
import it.padova.sanita.bedmanbe.dto.Rilevazione;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private RilevazioneDAO rilevazioneDAO = new RilevazioneDAO();

	Gson gson = new GsonBuilder().setDateFormat(DateFormat.LONG).create();
	
	@GET
	@Path("rileva/{wardId}/{userId}/{token}/{dataRil}")
	@Produces("application/json")
	public Response get(@PathParam("wardId") String wardId,
			@PathParam("userId") String userId,
			@PathParam("token") String token,
			@PathParam("dataRil") int dataRil)
	{
		List<DegRil> _degentirilevazioni = null;
        Date _dataRil = new Date((long) dataRil*1000);
         
		try
		{
			_degentirilevazioni = new ArrayList<DegRil>();
			List<Degente> _degenti = degenteDAO.findByWard(wardId);
			for(Degente _deg : _degenti){	
				DegRil _degril = new DegRil();
				_degril.setDegente(_deg);
				List<Rilevazione> _rilevazioni = rilevazioneDAO.findByDegIdDate(_degril.getDegente().getDeg_Id(), dataRil);
				if(_rilevazioni.size()!=0){
					_degril.setRilevazioneList(_rilevazioni);
				}
				else {
					Rilevazione _rilevazione1 = new Rilevazione();
					Rilevazione _rilevazione2 = new Rilevazione();
					Rilevazione _rilevazione3 = new Rilevazione();
					Rilevazione _rilevazione4 = new Rilevazione();
					_rilevazione1.setDegente(_deg);
					_rilevazione1.setRil_ute_ins("Davide");
					_rilevazione1.setRil_data(new Date((long) (dataRil+21600)*1000));
					_rilevazione2.setDegente(_deg);
					_rilevazione2.setRil_data(new Date((long) (dataRil+43200)*1000));
					_rilevazione3.setDegente(_deg);
					_rilevazione3.setRil_data(new Date((long) (dataRil+64800)*1000));
					_rilevazione4.setDegente(_deg);
					_rilevazione4.setRil_data(new Date((long) (dataRil+86400)*1000));
					List<Rilevazione> _rilevazioneList = new ArrayList<Rilevazione>();
					_rilevazioneList.add(_rilevazione1);
					_rilevazioneList.add(_rilevazione2);
					_rilevazioneList.add(_rilevazione3);
					_rilevazioneList.add(_rilevazione4);
					_degril.setRilevazioneList(_rilevazioneList);
					;
				}
				
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
