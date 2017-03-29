package com.util;

import java.util.List;
import java.util.Scanner;

import com.metier.Habitation;
import com.pdf.EditionFacture;
import com.persistance.AccesData;

public class Traitement {
 public static void Insertion(){
	int nbFichier = Parametre.nbLevee();
	System.out.println("il y a "+ nbFichier +" fichier(s) à traiter");
	 if (nbFichier !=0){
		 System.out.println("traitement en cours");
		 InsertionLevee.traitementLevee();
		 System.out.println("traitement effectué");
	 }
	 else{
		 System.out.println("Aucun fichier à traiter");
	 }
 }
 public static void facturation(){
	Scanner in= new Scanner(System.in);
	List<Habitation> listeHab = AccesData.getLesHabitations();
	System.out.println("saisir le numero du mois");
	int mois =in.nextInt();
	System.out.println("Saisir l'année");
	int an = in.nextInt();
	if(listeHab.size() !=0){
		System.out.println("traitement en cours");
		for(Habitation h : listeHab){
			EditionFacture.editionElementFacture(h, an, mois);
		}
		System.out.println("traitement effectué");
	}
	else{
		System.out.print("Aucune habitation à traiter");
	}
	 
 }
}
