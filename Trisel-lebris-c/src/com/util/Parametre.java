package com.util;
import java.io.File;
import java.util.List;

import org.jdom2.Element;

import com.metier.Habitation;
import com.metier.Levee;
/**
 * @author lebris-c
 *recupere la ligne voulue 
 * methode pour deplacer le fichier vers un autre dossier
 */

public class Parametre {

	private static String nomFichier = "paramAppli.ini";
	
	/**
	 * @param nbLigne
	 * @return
	 */
	public static String readIni(int nbLigne){
		FichierTexte fichier = new FichierTexte();
		String ligne = null;
		fichier.openFileReader(nomFichier);
		for (int i = 0; i < nbLigne ;i++){
			ligne = fichier.readLigne();
		}
		return ligne;
	}
	public static String getCheminBd(){ 
		return readIni(2);
	}

	public static String getCheminLeveeATraiter() {
		return readIni(4);
	}
	public static String getCheminLeveeLog() { 
		return readIni(10);
	}
	public static String getCheminLeveeTraites() { 
		return readIni(6);
	}
	public static String getCheminFacturePdf() { 
		return readIni(8);
	}
	public static String getExtensionFichier(String nomFichier){
		String[] parts = nomFichier.split("\\.");		
		return parts[1];
	}
	/**
	 * @param fichier
	 * @param dossierFinal
	 * @return
	 * deplace le fichier vers un autre dossier
	 */
	public static Boolean deplacerFichier(File fichier, String dossierFinal){
		File fichierDesti = new File(dossierFinal,fichier.getName());
		Boolean retour =true;
		if (fichierDesti.exists()){
			fichierDesti.delete();
			retour = false;
		}		
		fichier.renameTo(fichierDesti);		
		return retour;
	}
	private static final String tabMois[]={
			"","janvier","fevrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"
	};
	public static String getNomFichier(Habitation hab,int mois, int an){
		String nomFichier = hab.getIdHabitation() + "-" + hab.getUsager().getIdUsager() + "-Facture-"+ tabMois[mois] +"-" + an + ".pdf";
		return nomFichier;
	}
	
	public static String getCheminFichier(Habitation hab, int mois, int an){
		String nomDossier = Parametre.getCheminFacturePdf() + "\\"+ tabMois[mois];
		String nomFichier = getNomFichier(hab,mois,an);
		String cheminComplet = nomDossier + "\\"+ nomFichier;
		return cheminComplet;
	}
	public static int nbLevee(){
		String cheminlevee = getCheminLeveeATraiter();
		File f = new File(cheminlevee);
		return f.listFiles().length;
		
		
	}
	
	
	
}


