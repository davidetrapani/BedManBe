package it.padova.sanita.bedmanbe.dao;

/*import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import oracle.jdbc.internal.OracleTypes;
import java.sql.ResultSet;
import com.google.gson.Gson;*/

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import it.padova.sanita.bedmanbe.dto.Degente;
import it.padova.sanita.bedmanbe.dto.Rilevazione;

@Transactional()
public class RilevazioneDAO extends GenericHibernateDao<Rilevazione, Long> {

	public RilevazioneDAO(){
		super(Rilevazione.class);
	}

	// Completare con DAO specifici (non per id)
	@SuppressWarnings("unchecked")
	public List<Rilevazione> findByDegIdDate(Long degId, int dataRil) throws Exception
	{
		try
		{
			StringBuilder strQuery = new StringBuilder("from Rilevazione ril where ril.degente =:degId and ril.ril_data>= to_date(to_date('01011970','ddmmyyyy') + :dataRil/86400 ) and ril.ril_data<(to_date(to_date('01011970','ddmmyyyy') + :dataRil/86400 )+1)");
			Query hqlQuery = getSession().createQuery(strQuery.toString());
			hqlQuery.setLong("degId", degId);
			hqlQuery.setInteger("dataRil", dataRil);

			return (ArrayList<Rilevazione>) hqlQuery.list(); 
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
