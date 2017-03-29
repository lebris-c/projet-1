package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="usager")
public class Usager {
	@Id
	@Column(name="idUsager")
	private String idUsager;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="adrRueUsager")
	private String adrRueUsager;
	@Column(name="cpUsager")
	private String cpUsager;
	@Column(name="adrVilleUsager")
	private String adrVilleUsager;
	@OneToMany
	@JoinColumn(name="idUsager")
	private List<Habitation> lesHabitations;
	
	public Usager(String idUsager, String nom, String prenom, String adrRueUsager, String cpUsager,
			String adrVilleUsager) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.adrRueUsager = adrRueUsager;
		this.cpUsager = cpUsager;
		this.adrVilleUsager = adrVilleUsager;
		this.lesHabitations = new ArrayList<Habitation>();
	}
	public Usager() {
		super();		
	}

	public List getLesHabitations() {
		return lesHabitations;
	}

	public void setLesHabitations(List lesHabitations) {
		this.lesHabitations = lesHabitations;
	}

	public String getIdUsager() {
		return idUsager;
	}

	public void setIdUsager(String idUsager) {
		this.idUsager = idUsager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdrRueUsager() {
		return adrRueUsager;
	}

	public void setAdrRueUsager(String adrRueUsager) {
		this.adrRueUsager = adrRueUsager;
	}

	public String getCpUsager() {
		return cpUsager;
	}

	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}

	public String getAdrVilleUsager() {
		return adrVilleUsager;
	}

	public void setAdrVilleUsager(String adrVilleUsager) {
		this.adrVilleUsager = adrVilleUsager;
	}

	public boolean ajoutHabitation(Habitation h) {
		if (this.lesHabitations.add(h)) {
			return true;
		} else
			return false;
	}

	public boolean supprimerHabitation(Habitation h) {
		if (this.lesHabitations.add(h)) {
			return true;
		} else
			return false;
	}

	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adrRueUsager=" + adrRueUsager
				+ ", cpUsager=" + cpUsager + ", adrVilleUsager=" + adrVilleUsager + ", lesHabitations=" + lesHabitations
				+ "]";
	}

}
