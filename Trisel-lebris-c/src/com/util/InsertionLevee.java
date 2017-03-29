package com.util;
import java.text.*;
import java.util.*;
import org.jdom2.Document; 
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import com.metier.Levee;
import com.persistance.AccesData;
import com.persistance.HibernateSession;

import java.io.*;


/**
 * @author lebris-c
 * ouvre le fichier
 * recupère les informations du fichier txt
 * converti une chaine et une date
 * affiche la date, le code poubelle et le poids
 * recupere les informations du fichier xml
 * affiche la date, le code poubelle, le poids ...
 */
public class InsertionLevee {
	
	public static void traitementFichierTexte(String cheminLevee) {	
		// affiche la date de la levée
		Levee l=null;
		
		FichierTexte fichier = new FichierTexte();
		String ligne;
		fichier.openFileReader(cheminLevee);
		ligne = fichier.readLigne();
		String[] parts = ligne.split(":");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date laDate = sdf.parse(parts[2]);
	
			System.out.println("immatriculation : " + parts[0]);
			System.out.println("code chauffeur : " + parts[1]);
			System.out.println("date : " + sdf.format(laDate));
			String[] parts2;
			String idPoubelle;
			String poids;
			while ((ligne = fichier.readLigne()) != null) {
				parts2 = ligne.split(":");
				idPoubelle = parts2[0];
				System.out.println("Poubelle : " + idPoubelle);
				poids = parts2[1];
				double value = Double.parseDouble(poids);
				System.out.println("Poids : " + value);
				l=new Levee(laDate,Double.parseDouble(poids),idPoubelle,parts[0],parts[1]);
				AccesData.ajoutLevee(l);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fichier.closeFileReader();
	}
			
			
		
	
	
	/**
	 * @param cheminLevee
	 * affiche le poids, l'immatriculation, le code Pb et la date
	 */
	public static void traitementFichierXml(String cheminLevee) {
		Document document = null;
		//declaration élément racine
		Element racine = null;
		//on cree une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try {
			document = sxb.build(cheminLevee);
			racine = document.getRootElement();
			List<Element> listLevee = racine.getChildren("levee");
			ArrayList<String> listeCodePoubelle = new ArrayList<String>();
			ArrayList<String> listepoids = new ArrayList<String>();
			//poids
			//Double poids =Double.parseDouble(racine.getChild("poids").getText());
			//idPoubelle
			//String idPoubelle = racine.getChild("poubelle").getText();
			//immatriculation
			String immatriculation = racine.getChild("immatriculation").getText();
			System.out.println("immatriculation : "+ immatriculation);
			//Code chauffeur
			String codeC = racine.getChild("codechauffeur").getText();
			System.out.println("code chauffeur : " + codeC);
			//date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date laDate = null;
			String date = racine.getChild("date").getText();
			laDate = sdf.parse(date);
			System.out.println("date : " + sdf.format(laDate));
			//levee
			System.out.println("levee : ");
			for (Element e: listLevee)
	        {	 
				
	        	System.out.print("code : " + e.getChild("poubelle").getText() + "  " );
	        	String poids = e.getChild("poids").getText();
	            System.out.print( ", poids : "+ Double.parseDouble(poids) + " \n " );	 
	            // instanciation objet levee
	            String idPoubelle = e.getChild("poubelle").getText();
	            Levee le1 = new Levee (laDate, Double.parseDouble(poids), idPoubelle, immatriculation, codeC );
	            //insertion dans la base
	            
	            if (AccesData.ajoutLevee(le1)){
	            	System.out.println("levee créée");
	            }
	            else {
	            	System.out.println("levee non créée");
	            }
	            
	        }
		}
		catch (JDOMException e2){
			e2.printStackTrace();
		}
		catch (IOException e2) {
			e2.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		/**
		 * traitement levee
		 * recupere les chemins des dossiers
		 * verifie si le dossier est vide
		 * recupere l'extension du fichier
		 * deplace le fichier en fonction de son extension en appelant la methode deplacerFichier
		 */
		public static void traitementLevee() {
			File  atraiter= new File(Parametre.getCheminLeveeATraiter());
			File traites = new File(Parametre.getCheminLeveeTraites());
			File log =new File (Parametre.getCheminLeveeLog());
			if (atraiter.listFiles().length==0){
				System.out.println("aucun fichier");
			}
			else  {
				for (File fichier : atraiter.listFiles()) {
					if (fichier.isFile()){
						String extension = Parametre.getExtensionFichier(fichier.getName());
						switch (extension){
						case "txt" :
							System.out.println("cas txt");
							InsertionLevee.traitementFichierTexte(fichier.getPath());
							Parametre.deplacerFichier(fichier, traites.getPath());
							break;
						case "xml" :
							System.out.println("cas xml : ");
							InsertionLevee.traitementFichierXml(fichier.getPath());
							Parametre.deplacerFichier(fichier, traites.getPath());
							break;
						default: 
							System.out.println("fichier incorrect");
							Parametre.deplacerFichier(fichier, log.getPath());
							break;
						}
					}
						else{
							System.out.println("Le dossier à été déplacé vers le dossier log");
							Parametre.deplacerFichier(fichier, log.getPath());
							
						}
					}
				}					
			}			
		}		







