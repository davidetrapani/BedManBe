package it.padova.sanita.bedmanbe.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import javax.transaction.Transactional;

//import oracle.jdbc.internal.OracleTypes;
//import java.sql.ResultSet;




//import com.google.gson.Gson;


import it.padova.sanita.bedmanbe.dto.Degente;

@Transactional()
public class DegenteDAO extends GenericHibernateDao<Degente, Long> {

	public DegenteDAO(){
		super(Degente.class);
	}

	// Completare con DAO specifici (non per id)
	@SuppressWarnings("unchecked")
	public List<Degente> findByWard(String ward) throws Exception
	{
		try
		{
			StringBuilder strQuery = new StringBuilder("from Degente deg where deg.deg_reparto_ass = :ward");
			Query hqlQuery = getSession().createQuery(strQuery.toString());
			hqlQuery.setString("ward", ward);

			return (ArrayList<Degente>) hqlQuery.list(); 
		}
		catch (HibernateException ex)
		{
			throw new Exception(ex); 
		}
	}
	
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
