package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarif")
public class Tarif {
	@Id
	@Column(name="typeTarif")
	int typeTarif;
	@Column(name="libelle")
	String libelle;
	@Column(name="valeur")
	double valeur;
	
	public Tarif(int typeTarif, String libelle, double valeur) {
		super();
		this.typeTarif = typeTarif;
		this.libelle = libelle;
		this.valeur = valeur;
	}
	public Tarif() {
		super();
		
	}
	public int getTypeTarif() {
		return typeTarif;
	}

	public void setTypeTarif(int typeTarif) {
		this.typeTarif = typeTarif;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return "Tarif [typeTarif=" + typeTarif + ", libelle=" + libelle + ", valeur=" + valeur + "]";
	}
	
}
