package com.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="Poubelle")
public class Poubelle {
	@Id
	@Column(name="idPoubelle")
	private String idPoubelle;
	@ManyToOne // plusieurs pb pour 1 type de dechet
	@JoinColumn(name="idTypeDechet")
	private TypeDechet nature;
	@OneToMany // plusieurs levées pour 1 poubelle
	@JoinColumn(name ="idPoubelle")
	private List<Levee> lesLevees;
	@Column(name="idHabitation")
	private String idHabitation;

	public Poubelle(String idPoubelle, String idHabitation, TypeDechet nature) {
		super();
		this.idPoubelle = idPoubelle;
		this.nature = nature;
		this.lesLevees = new ArrayList <Levee>();
		this.idHabitation = idHabitation;

	}
	public Poubelle() {
		super();
	}
	public String getIdPoubelle(){
		return idPoubelle;
	}
	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public TypeDechet getNature() {
		return nature;
	}

	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}

	public List<Levee> getLesLevees() {
		return lesLevees;
	}

	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}
	public boolean addLevee(Levee l){
		if(this.lesLevees.add(l)){
			return true;
		}
		else return false;
	}
	public boolean suppLevee (Levee l){
		if(this.lesLevees.remove(l)){
			return true;
		}
		else return false;
	}
	public ArrayList<Levee>getLesLevees(int an,int mois){
		//declaration collection de travail
		ArrayList<Levee>listeLevee = new ArrayList<Levee>();
		//parcours des levees de la pb
		for(Levee l : lesLevees){
			
			Calendar date = Calendar.getInstance();
			date.setTime(l.getLaDate());
			int moisL = date.get(Calendar.MONTH)+1;
			int anL = date.get(Calendar.YEAR);			
			if (( moisL== mois)&&(anL==an)){
				listeLevee.add(l);
			}
		}
		return listeLevee;
	}
	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", nature=" + nature + ", lesLevees=" + lesLevees
				+ ", idHabitation=" + idHabitation + "]";
	}
	public double getCout (int an, int mois){
		double cout = 0;
		ArrayList<Levee>listeLevee = this.getLesLevees(an,mois);
		for(Levee l : listeLevee){
			cout = cout + l.getPoids()*nature.getTarif();
		}
		return cout;
	}
					

	}
	

