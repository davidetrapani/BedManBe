package it.padova.sanita.bedmanbe.dao;

import java.sql.CallableStatement;
import java.sql.Date;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

//import oracle.jdbc.internal.OracleTypes;


import org.hibernate.HibernateException;
import org.hibernate.Query;

//import com.google.gson.Gson;


import it.padova.sanita.bedmanbe.dto.Rilevazione;

@Transactional()
public class RilevazioneDAO extends GenericHibernateDao<Rilevazione, Long> {

	public RilevazioneDAO(){
		super(Rilevazione.class);
	}

	// Completare con DAO specifici (non per id)
	/*@SuppressWarnings("unchecked")
	public List<Patient> findByName(String name) throws Exception
	{
		try
		{
			StringBuilder strQuery = new StringBuilder("from Assistito p where p.ass_name = :name");
			Query hqlQuery = getSession().createQuery(strQuery.toString());
			hqlQuery.setString("name", name);

			return (ArrayList<Patient>) hqlQuery.list(); 
		}
		catch (HibernateException ex)
		{
			throw new Exception(ex); 
		}
	}*/
	
	// Completare con interfacce a procedure db Oracle
	// Commento su segnalazione warning di Eclipse Luna
	//@SuppressWarnings("unchecked")
	/*public String InsertOrUpdateViaStoredPro(Patient patient) throws Exception
	{
		//http://stackoverflow.com/questions/13015749/getting-a-result-back-from-a-stored-procedure-in-java
		String ret = "";
		CallableStatement callableStatement = null;
		try{
			callableStatement = getConnection().prepareCall("call INSUPDPATIENT(?,?,?,?,?,?,?,?)");
			callableStatement.setLong(1,patient.getAss_Ipca());
			callableStatement.setString(2,patient.getAss_Nome());
			callableStatement.setString(3,patient.getAss_Cogn());
			callableStatement.setString(4,patient.getAss_Tel());
			callableStatement.setString(5,patient.getAss_Email());
			callableStatement.setDate(6,(Date) patient.getAss_Datna());
			callableStatement.setLong(7,patient.getAss_Citta());

			callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);

			callableStatement.execute();
			
			ret = callableStatement.getString(8);
			//System.out.println(result);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ret;
	}*/
}
