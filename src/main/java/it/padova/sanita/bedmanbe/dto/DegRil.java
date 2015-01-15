package it.padova.sanita.bedmanbe.dto;

import java.util.List;

public class DegRil {

	private Degente degente;
	private List<Rilevazione> rilevazioneList;
	
	public Degente getDegente() {
		return degente;
	}
	public void setDegente(Degente degente) {
		this.degente = degente;
	}
	
	public List<Rilevazione> getRilevazioneList() {
		return rilevazioneList;
	}
	
	public void setRilevazioneList(List<Rilevazione> rilevazioneList) {
		this.rilevazioneList = rilevazioneList;
	}
	
	public void addRilevazione(Rilevazione rilevazione) {
		this.rilevazioneList.add(rilevazione);
	}
	
}
