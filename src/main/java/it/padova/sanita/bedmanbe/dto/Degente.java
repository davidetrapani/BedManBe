package it.padova.sanita.bedmanbe.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;*/
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DEGENTI_VW", schema="scott")
public class Degente
{	
	
	
	public Degente(long deg_id, int deg_stanza, int deg_letto, int deg_str_str,
			int deg_ric_anno, int deg_ric_cartella, int deg_ass_ipca,
			String deg_ass_cogn, String deg_ass_nome, Date deg_ass_datna,
			String deg_reparto_ass, String deg_desc_rep_ass) {
		
		this.deg_id = deg_id;
		this.deg_stanza = deg_stanza;
		this.deg_letto = deg_letto;
		this.deg_str_str = deg_str_str;
		this.deg_ric_anno = deg_ric_anno;
		this.deg_ric_cartella = deg_ric_cartella;
		this.deg_ass_ipca = deg_ass_ipca;
		this.deg_ass_cogn = deg_ass_cogn;
		this.deg_ass_nome = deg_ass_nome;
		this.deg_ass_datna = deg_ass_datna;
		this.deg_reparto_ass = deg_reparto_ass;
		this.deg_desc_rep_ass = deg_desc_rep_ass;
	}

	public Degente() {
	}
	
	private Long deg_id;
	
	private int deg_stanza;

	private int deg_letto;

	private int deg_str_str;

	private int deg_ric_anno;
	
	private int deg_ric_cartella;

	private int deg_ass_ipca;
	
	private String deg_ass_cogn;
	
	private String deg_ass_nome;
	
	private Date deg_ass_datna;
	
	private String deg_reparto_ass;
	
	private String deg_desc_rep_ass;

	@OneToMany(mappedBy="DEG_ID")
	private Set<Rilevazione> rilevazioni;
	
	@Id
	@Column(name="DEG_ID", nullable = false, unique=true)
	public Long getDeg_Id() {
		return deg_id;
	}
	 
	public void setDeg_Id(Long deg_id) {
		this.deg_id = deg_id;
	}
	
	@Column(name="DEG_STANZA", nullable = false, precision = 5, scale = 0)
	public int getDeg_stanza() {
		return deg_stanza;
	}

	public void setDeg_stanza(int deg_stanza) {
		this.deg_stanza = deg_stanza;
	}

	@Column(name="DEG_LETTO", nullable = false, precision = 4, scale = 0)
	public int getDeg_letto() {
		return deg_letto;
	}

	public void setDeg_letto(int deg_letto) {
		this.deg_letto = deg_letto;
	}

	@Column(name="DEG_STR_STR", nullable = false, precision = 5, scale = 0)
	public int getDeg_str_str() {
		return deg_str_str;
	}

	public void setDeg_str_str(int deg_str_str) {
		this.deg_str_str = deg_str_str;
	}

	@Column(name="DEG_RIC_ANNO", nullable = false, precision = 4, scale = 0)
	public int getDeg_ric_anno() {
		return deg_ric_anno;
	}

	public void setDeg_ric_anno(int deg_ric_anno) {
		this.deg_ric_anno = deg_ric_anno;
	}

	@Column(name="DEG_RIC_CARTELLA", nullable = false, precision = 12, scale = 0)
	public int getDeg_ric_cartella() {
		return deg_ric_cartella;
	}

	public void setDeg_ric_cartella(int deg_ric_cartella) {
		this.deg_ric_cartella = deg_ric_cartella;
	}

	@Column(name="DEG_ASS_IPCA", nullable = false, precision = 8, scale = 0)
	public int getDeg_ass_ipca() {
		return deg_ass_ipca;
	}

	public void setDeg_ass_ipca(int deg_ass_ipca) {
		this.deg_ass_ipca = deg_ass_ipca;
	}

	@Column(name = "DEG_ASS_COGN", nullable = false, length = 30)
	public String getDeg_ass_cogn() {
		return deg_ass_cogn;
	}

	public void setDeg_ass_cogn(String deg_ass_cogn) {
		this.deg_ass_cogn = deg_ass_cogn;
	}

	@Column(name = "DEG_ASS_NOME", nullable = false, length = 30)
	public String getDeg_ass_nome() {
		return deg_ass_nome;
	}

	public void setDeg_ass_nome(String deg_ass_nome) {
		this.deg_ass_nome = deg_ass_nome;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEG_ASS_DATNA", nullable = false, length = 8)
	public Date getDeg_ass_datna() {
		return deg_ass_datna;
	}
     
	public void setDeg_ass_datna(Date deg_ass_datna) {
		this.deg_ass_datna = deg_ass_datna;
	}
	
	@Column(name="DEG_REPARTO_ASS", nullable = false, length = 6)
	public String getDeg_reparto_ass() {
		return deg_reparto_ass;
	}

	public void setDeg_reparto_ass(String deg_reparto_ass) {
		this.deg_reparto_ass = deg_reparto_ass;
	}

	@Column(name="DEG_DESC_REP_ASS", nullable = false, length = 60)
	public String getDeg_desc_rep_ass() {
		return deg_desc_rep_ass;
	}

	public void setDeg_desc_rep_ass(String deg_desc_rep_ass) {
		this.deg_desc_rep_ass = deg_desc_rep_ass;
	}
	
}