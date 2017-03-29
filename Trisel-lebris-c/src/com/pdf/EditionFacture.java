package com.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.*;
import com.persistance.AccesData;

import com.util.Parametre;


public class EditionFacture {

public static void testFacture(int an, int mois) {
ArrayList<Habitation> lesHabitations = AccesData.getLesHabitations();
if (lesHabitations.size() != 0) {
for (Habitation h : lesHabitations) {
editionElementFacture(h, an, mois);
}
}
}

public static void editionElementFacture(Habitation h, int an, int mois) {
DecimalFormat df1 = new DecimalFormat("0.000");
// date format
SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
// affichage de la date
String dateDuJour = dateFormat.format(new Date());
System.out.print("\n" + dateDuJour);
// collection de poubelle
List<Poubelle> lesPoubelles = null;
// collection de Levee
ArrayList<Levee> lesLevees = null;
// récupération tarif individuel dans la base de données
   double tarif = AccesData.getTarifIndividuel();
// variable de travail
double nbKilo = 0;
double prixHT = 0;
double totalLevee = 0;
double tva = 0;
double tauxTva = 0.2;
double totalTTC = 0;
double totalFixe = 0;
double totalHT = 0;
double totalFacture = 0;
// données Usager
Usager usag = h.getUsager();
String nomUsag = usag.getNom();
String prenomUsag = usag.getPrenom();
String rueUsag = usag.getAdrRueUsager();
String cpUsag = usag.getCpUsager();

String villeUsag = usag.getAdrVilleUsager();
String codeUsag = usag.getIdUsager();
int nbPersonne = h.getNbPersonne();
// affichage info usager
System.out.println("\n" + nomUsag + " " + prenomUsag + "\n" + rueUsag + "\n" + cpUsag + " " + villeUsag);

System.out.println("Adresse du logement concerné : ");

// données Habitaion
String rueHab = h.getAdrRueHab();
String cpHab = h.getCpHab();
String villeHab = h.getAdrVilleHab();
// affichage info hab
System.out.println(rueHab + "\n" + cpHab + " " + villeHab);

System.out.println("\nCode Usager : " + codeUsag);
System.out.println("Nombre de personnes déclarées : " + nbPersonne);

System.out.println("Taux part fixe : " + tarif);
totalHT = tarif * nbPersonne;
System.out.println("TotalHT : " + totalHT);

SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
TypeDechet type = null;
String idPoub = null;
String nature = null;
Date dateLevee = null;
lesPoubelles = h.getLesPoubelles();
for (Poubelle p : lesPoubelles) {
	idPoub = p.getIdPoubelle();
	lesLevees = p.getLesLevees(an, mois);
	type = p.getNature();
	nature = type.getLibelle();
	System.out.println("Poubelle : " + idPoub + " Nature des déchets : " + nature);
	for (Levee l : lesLevees) {
		dateLevee = l.getLaDate();
		nbKilo = l.getPoids();
		prixHT = type.getTarif();
		System.out.println("Date de pesée : " + dateFormat2.format(dateLevee));
		System.out.println("nombre de kg : " + nbKilo);
		System.out.println("prix HT au kg : " + prixHT);
		totalLevee = nbKilo * prixHT;
		System.out.println("total HT : " + df1.format(totalLevee));
	}
	totalFacture = p.getCout(an, mois);
	System.out.println("total HT : " + totalFacture);
}
totalFixe = h.getCout(an, mois) + totalHT;
tva = totalFixe * tauxTva;
totalTTC = totalFixe + tva;
System.out.println("Total HT : " + totalFixe + "\nMontant tva : " + tva + "\nTotal à payer : " + totalTTC);

Document document = new Document();
try {
	// création d'une instance pour associer le document avec le
	// fichier sur disque à créer
	PdfWriter.getInstance(document, new FileOutputStream(Parametre.getCheminFichier(h, mois, an)));
	// ouverture du document
	document.open();
	// Création d'un paragraphe 
	Paragraph date = new Paragraph(dateDuJour);
	//allignement a droite
	date.setAlignment(Element.ALIGN_RIGHT);
	// ajout d'un paragraphe au document
	document.add(date);
	// ajout d'une image
	Image imageTrisel = Image.getInstance("Trisel.jpg");
	document.add(imageTrisel);
	
	// Création d'un paragraphe info user 
	Paragraph user = new Paragraph(nomUsag + " " + prenomUsag + "\n" + rueUsag + "\n" + cpUsag + " " + villeUsag);
	//allignement a droite
	user.setAlignment(Element.ALIGN_RIGHT);
	// ajout d'un paragraphe au document
	document.add(user);
	
	// Création d'un paragraphe info habitation 
	Paragraph hab = new Paragraph("Adresse du logement concerné : \n\n" + rueHab + "\n" + cpHab + " " + villeHab + "\n\nCode Usager : " + codeUsag + "\nNombre de personnes déclarées : " + nbPersonne);
	// ajout d'un paragraphe au document
	document.add(hab);
	
	PdfPTable table= new PdfPTable(3); // 3 colonnes.
	// instanciation de cellules contenant des paragraphes
	PdfPCell cell1 = new PdfPCell (new Paragraph("Taux part fixe"));
	PdfPCell cell2 = new PdfPCell (new Paragraph("Nombre de personnes"));
	PdfPCell cell3 = new PdfPCell (new Paragraph("Total HT"));
	PdfPCell TauxPartFixe = new PdfPCell (new Paragraph(tarif + ""));
	PdfPCell nbPersonne2 = new PdfPCell (new Paragraph(nbPersonne + ""));
	PdfPCell ttHT = new PdfPCell (new Paragraph(totalHT + ""));
	// Définit la couleur BG.
	cell1.setBackgroundColor (BaseColor.LIGHT_GRAY); 
	cell2.setBackgroundColor (BaseColor.LIGHT_GRAY); 
	cell3.setBackgroundColor (BaseColor.LIGHT_GRAY); 
	// ajout des cellules à la table
	table.addCell (cell1);
	table.addCell (cell2);
	table.addCell (cell3);
	table.addCell (TauxPartFixe);
	table.addCell (nbPersonne2);
	table.addCell (ttHT);
	//espacement avant et après le tableau
	table.setSpacingBefore (20f);
	document.add (table);
	
	for (Poubelle p : lesPoubelles) {
		idPoub = p.getIdPoubelle();
		lesLevees = p.getLesLevees(an, mois);
		type = p.getNature();
		nature = type.getLibelle();
		PdfPTable tableLevee= new PdfPTable(4); // 3 colonnes.
		// instanciation de cellules contenant des paragraphes
		PdfPCell infoPoub = new PdfPCell (new Paragraph("Poubelle:" + idPoub + " Nature des déchets: " + nature));
		infoPoub.setColspan(4);
		infoPoub.setHorizontalAlignment(infoPoub.ALIGN_CENTER);
		PdfPCell cDatePesee = new PdfPCell (new Paragraph("Date de pesée"));
		PdfPCell cNbKg = new PdfPCell (new Paragraph("nombre de kg"));
		PdfPCell cPrixHtKg = new PdfPCell (new Paragraph("prix HT au kg"));
		PdfPCell cTotalHT = new PdfPCell (new Paragraph("total HT"));
		// Définit la couleur BG.
		cDatePesee.setBackgroundColor (BaseColor.LIGHT_GRAY); 
		cNbKg.setBackgroundColor (BaseColor.LIGHT_GRAY); 
		cPrixHtKg.setBackgroundColor (BaseColor.LIGHT_GRAY);
		cTotalHT.setBackgroundColor (BaseColor.LIGHT_GRAY);
		// ajout des cellules à la table
		tableLevee.addCell (infoPoub);
		tableLevee.addCell (cDatePesee);
		tableLevee.addCell (cNbKg);
		tableLevee.addCell (cPrixHtKg);
		tableLevee.addCell (cTotalHT);
		//espacement avant et après le tableau
		tableLevee.setSpacingBefore (20f);
		for (Levee l : lesLevees) {
			dateLevee = l.getLaDate();
			nbKilo = l.getPoids();
			prixHT = type.getTarif();
			totalLevee = nbKilo * prixHT;
			// instanciation de cellules contenant des paragraphes
			PdfPCell cDatePeseeValeur = new PdfPCell (new Paragraph(dateFormat2.format(dateLevee)));
			cDatePeseeValeur.setHorizontalAlignment(cDatePeseeValeur.ALIGN_CENTER);
			PdfPCell cNbKgValeur = new PdfPCell (new Paragraph(nbKilo + ""));
			cNbKgValeur.setHorizontalAlignment(cNbKgValeur.ALIGN_CENTER);
			PdfPCell cPrixHtKgValeur = new PdfPCell (new Paragraph(prixHT + ""));
			cPrixHtKgValeur.setHorizontalAlignment(cPrixHtKgValeur.ALIGN_CENTER);
			PdfPCell cTotalHTValeur = new PdfPCell (new Paragraph(df1.format(totalLevee) +""));
			cTotalHTValeur.setHorizontalAlignment(cTotalHTValeur.ALIGN_CENTER);
			// ajout des cellules à la table
			tableLevee.addCell (cDatePeseeValeur);
			tableLevee.addCell (cNbKgValeur);
			tableLevee.addCell (cPrixHtKgValeur);
			tableLevee.addCell (cTotalHTValeur);
		}
		totalHT = p.getCout(an, mois);
		PdfPCell cTotalHTPoubelle = new PdfPCell (new Paragraph("Total HT"));
		cTotalHTPoubelle.setColspan(3);
		cTotalHTPoubelle.setHorizontalAlignment(cTotalHTPoubelle.ALIGN_RIGHT);
		PdfPCell cTotalHTPoubelleValeur = new PdfPCell (new Paragraph(df1.format(totalHT) +""));
		// Définit la couleur BG.
		cTotalHTPoubelleValeur.setBackgroundColor (BaseColor.LIGHT_GRAY);
		tableLevee.addCell (cTotalHTPoubelle);
		tableLevee.addCell (cTotalHTPoubelleValeur);
		document.add (tableLevee);
	}
	
	PdfPTable tableFinal= new PdfPTable(4); // 3 colonnes.
	// instanciation de cellules contenant des paragraphes
	PdfPCell cTotalHT = new PdfPCell (new Paragraph("Total HT"));
	cTotalHT.setColspan(3);
	cTotalHT.setHorizontalAlignment(cTotalHT.ALIGN_RIGHT);
	PdfPCell cMontantTva = new PdfPCell (new Paragraph("Montant TVA"));
	cMontantTva.setColspan(3);
	cMontantTva.setHorizontalAlignment(cMontantTva.ALIGN_RIGHT);
	PdfPCell cTotalPayer = new PdfPCell (new Paragraph("Total à payer"));
	cTotalPayer.setColspan(3);
	cTotalPayer.setHorizontalAlignment(cTotalPayer.ALIGN_RIGHT);
	PdfPCell cTotalHTValeur = new PdfPCell (new Paragraph(df1.format(totalFixe)));
	cTotalHTValeur.setHorizontalAlignment(cTotalHTValeur.ALIGN_CENTER);
	PdfPCell cMontantTvaValeur = new PdfPCell (new Paragraph(df1.format(tva)));
	cMontantTvaValeur.setHorizontalAlignment(cMontantTvaValeur.ALIGN_CENTER);
	PdfPCell cTotalPayerValeur = new PdfPCell (new Paragraph(df1.format(totalTTC)));
	cTotalPayerValeur.setHorizontalAlignment(cTotalPayerValeur.ALIGN_CENTER);
	// Définit la couleur BG.
	cTotalPayerValeur.setBackgroundColor(BaseColor.LIGHT_GRAY);
	// ajout des cellules à la table
	tableFinal.addCell (cTotalHT);
	tableFinal.addCell (cTotalHTValeur);
	tableFinal.addCell (cMontantTva);
	tableFinal.addCell (cMontantTvaValeur);
	tableFinal.addCell (cTotalPayer);
	tableFinal.addCell (cTotalPayerValeur);
	//espacement avant et après le tableau
	tableFinal.setSpacingBefore (20f);
	document.add (tableFinal);
	
	// fermeture du document, important pour transférer les données //
	// au PdfWriter
	document.close();
	// affichage sous adobe
	Runtime.getRuntime().exec("explorer.exe " + Parametre.getCheminFichier(h, mois, an));
} catch (DocumentException e) {
	e.printStackTrace();
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException ex) {
	ex.printStackTrace();
}

String nomFichier = Parametre.getNomFichier(h, mois, an);
Facture f = new Facture(mois, an, nomFichier, h.getIdHabitation());
if (AccesData.ajouterControleFacture(f) == true){
	System.out.println("Insertion effectuée");
}
else
{
	System.out.println("Insertion non effectuée");
}


/*PdfPCell cDatePesee = new PdfPCell (new Paragraph(dateFormat2.format(dateLevee)));
PdfPCell cNbKg = new PdfPCell (new Paragraph(nbKilo + ""));
PdfPCell cPrixHtKg = new PdfPCell (new Paragraph(prixHT + ""));
PdfPCell cTotalHT = new PdfPCell (new Paragraph(nbPersonne + ""));*/
}

}

