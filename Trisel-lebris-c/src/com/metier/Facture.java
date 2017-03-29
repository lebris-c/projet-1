package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facture")
public class Facture {
	@Id
	@Column(name="idFacture")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFacture;
	@Column(name="moisF")
	private int mois;
	@Column(name="anF")
	private int an;
	@Column(name="nomFacture")
	private String nomFacture;
	@Column(name="idHabitation")
	private String idHabitation;
	public Facture(int idFacture, int mois, int an, String nomFacture, String idHabitation){
		super();
		this.idFacture = idFacture;
		this.mois = mois;
		this.an = an;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	public Facture(){
		super();		
	}
	public Facture( int mois, int an, String nomFacture, String idHabitation) {
		super();
		
		this.mois = mois;
		this.an = an;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	public int getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAn() {
		return an;
	}
	public void setAn(int an) {
		this.an = an;
	}
	public String getNomFacture() {
		return nomFacture;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", mois=" + mois + ", an=" + an + ", nomFacture=" + nomFacture
				+ ", idHabitation=" + idHabitation + "]";
	}
	
}
