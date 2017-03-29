package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="habitation")
public class Habitation {
	@Id
	@Column(name="idHabitation")
	private String idHabitation;
	@Column(name="adrRueHab")
	private String adrRueHab;
	@Column(name="cpHab")
	private String cpHab;
	@Column(name="adrVilleHab")
	private String adrVilleHab;
	@Column(name="nbPersonne")
	private int nbPersonne;
	@OneToMany
	@JoinColumn (name="idHabitation")
	private List<Poubelle> lesPoubelles;
	@ManyToOne
	@JoinColumn (name="idUsager")
	private Usager usager;
	@OneToMany
	@JoinColumn (name="idhabitation")
	private List<Facture> lesFactures;

	public Habitation(String idHabitation, String adrRueHab, String cpHab, String adrVilleHab, int nbPersonne
	, Usager u) {
		super();
		this.idHabitation = idHabitation;
		this.adrRueHab = adrRueHab;
		this.cpHab = cpHab;
		this.adrVilleHab = adrVilleHab;
		this.nbPersonne = nbPersonne;
		this.lesPoubelles = new ArrayList<Poubelle>();
		this.usager = u;
		this.lesFactures = new ArrayList<Facture>();
	}
	public Habitation() {
				super();			
			}

	public Usager getUsager() {
		return usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}

	public List<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}

	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public String getAdrRueHab() {
		return adrRueHab;
	}

	public void setAdrRueHab(String adrRueHab) {
		this.adrRueHab = adrRueHab;
	}

	public String getCpHab() {
		return cpHab;
	}

	public void setCpHab(String cpHab) {
		this.cpHab = cpHab;
	}

	public String getAdrVilleHab() {
		return adrVilleHab;
	}

	public void setAdrVilleHab(String adrVilleHab) {
		this.adrVilleHab = adrVilleHab;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public boolean addPoubelle(Poubelle pb) {
		if (this.lesPoubelles.add(pb)) {
			return true;
		} else
			return false;
	}
	public double getCout (int an, int mois){
		double cout = 0;
		for(Poubelle p : lesPoubelles){
			cout=cout+p.getCout(an, mois);
		}
		return cout;
	}
	public List<Facture> getLesFactures(){
		return lesFactures;
	}
	public List<Facture> setLesFactures(List<Facture> lesFactures){
		return this.lesFactures = lesFactures;
	}
	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adrRueHab=" + adrRueHab + ", cpHab=" + cpHab
				+ ", adrVilleHab=" + adrVilleHab + ", nbPersonne=" + nbPersonne + ", lesPoubelles=" + lesPoubelles
				+ ", usager=" + usager + ", lesFactures=" + lesFactures + "]";
	}

	

}
