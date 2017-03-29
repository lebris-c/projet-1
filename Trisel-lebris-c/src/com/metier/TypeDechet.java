package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typedechet")
public class TypeDechet {
	@Id
	@Column(name="idTypeDechet")
	private String idTypeDechet;
	@Column(name="libelle")
	private String libelle;
	@Column(name="tarif")
	private Double tarif;
	public TypeDechet(String idTypeDechet, String libelle, Double tarif) {
		super();
		this.idTypeDechet = idTypeDechet;
		this.libelle = libelle;
		this.tarif = tarif;
	}
	public TypeDechet() {
		super();
		
	}
	
	public String getIdTypeDechet() {
		return idTypeDechet;
	}
	public void setIdTypeDechet(String idTypeDechet) {
		this.idTypeDechet = idTypeDechet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Double getTarif() {
		return tarif;
	}
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	@Override
	public String toString() {
		return "TypeDechet [idTypeDechet=" + idTypeDechet + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
	
}
