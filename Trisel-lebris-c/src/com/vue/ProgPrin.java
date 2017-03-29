package com.vue;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.mysql.jdbc.ResultSet;
import com.pdf.EditionFacture;
import com.mysql.jdbc.ResultSet;
import com.persistance.AccesBd;
import com.persistance.AccesData;
import com.persistance.HibernateSession;
import com.util.*;
public class ProgPrin {

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		/*
		System.out.println("cas txt : ");
		InsertionLevee.traitementFichierTexte("pesee.txt");
		System.out.println("cas xml");
		InsertionLevee.traitementFichierXml("pesee.xml");
		*/
		//InsertionLevee.traitementLevee();
		/*
		System.out.println(Parametre.getCheminBd());		
		System.out.println(Parametre.getCheminLeveeATraiter());
		System.out.println(Parametre.getCheminLeveeLog());
		System.out.println(Parametre.getCheminLeveeTraites());
		System.out.println(Parametre.getCheminFacturePdf());
		System.out.println(Parametre.getExtensionFichier("pesee.xml"));
		*/
		/*
		Date d1 = null;
		SimpleDateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		d1 = dateFormat.parse("15/05/2015");
		Levee l = new Levee (d1,5.0, "pb1", "BM-330-EF", "C100");
		LeveeDAO ldao = new LeveeDAO();
		ldao.create(l);
		Connection cnx = AccesBd.getInstance();
		java.sql.ResultSet rs = cnx.createStatement().executeQuery("Select * From usager");
		TypeDechetDAO tdao = new TypeDechetDAO();
		System.out.println(tdao.find("ord"));
		System.out.println(ldao.find(1));
		UsagerDAO udao = new UsagerDAO();
		System.out.println(udao.find("usag1"));
		PoubelleDAO pDAO = new PoubelleDAO();
		System.out.println(pDAO.find("pb1"));
		HabitationDAO habDAO = new HabitationDAO();
		System.out.println(habDAO.find("hab1"));
		ArrayList<Habitation> listeHab = habDAO.retrieve();
		for(Habitation h : listeHab){
			System.out.println(h.toString());
		}*/
		/*	while(rs.next()){
			System.out.println(rs.getString(1));
		}
	*/		
		//EditionFacture.testFacture(2015,07);
		//Session s = HibernateSession.getSession();
		
		/*
		// accès à un élément ----> find
		TypeDechet td = (TypeDechet) s.get(TypeDechet.class, "ver");
		System.out.println(td.toString());
		
		// accès aux éléments-----> retriev
		//ArrayList<TypeDechet> listeDechet = (ArrayList) s.createQuery("from TypeDechet").list();
		ArrayList<TypeDechet> listeDechet =(ArrayList<TypeDechet>) s.createQuery("from TypeDechet").list();
		// création d'un nouveau TypeDechet
		System.out.println(listeDechet);
		//TypeDechet td1= new TypeDechet("pap","papier",0.15);
		/*Transaction t = s.beginTransaction();
		s.save(td1);
		t.commit();
		*/
		/*
		Usager u = (Usager) s.get(Usager.class, "usag1");
		System.out.println(u.toString());
		Usager u1= new Usager("usag4","Le Bris","Corentin","6 rue de Broceliande","29000", "Quimper");
		Transaction t = s.beginTransaction();
		s.save(u1);
		t.commit();
		/*
		Facture f = (Facture) s.get(Facture.class, 3);
		System.out.println(f.toString());
		ArrayList<Facture> listeFacture =(ArrayList<Facture>) s.createQuery("from Facture").list();
		Facture f1= new Facture(6,7,2015,"hab1","hab1");
		Transaction t = s.beginTransaction();
		s.save(f1);
		t.commit();
		
		SimpleDateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Levee l = (Levee) s.get(Levee.class, 1);
		System.out.println(l.toString());
		ArrayList<Levee> listeLevee =(ArrayList<Levee>) s.createQuery("from Levee").list();
		Levee l1= new Levee(6,dateFormat.parse("2015-07-15"),5,"pb1","BM-330-EF","C100");
		//ajoutLevee(l1);
		Transaction t = s.beginTransaction();
		s.save(l1);
		t.commit();
		
		Habitation hab = (Habitation) s.get(Habitation.class, "hab1");
		System.out.println(hab.toString());
		Usager u = (Usager) s.get(Usager.class, "usag4");
		Habitation hab1= new Habitation("hab4","rue","29000","Quimper",5, u);
		Transaction t = s.beginTransaction();
		s.save(hab1);
		t.commit();
		
		Poubelle pb = (Poubelle) s.get(Poubelle.class, "pb1");
		System.out.println(pb.toString());
		TypeDechet td1= new TypeDechet("pap","papier",0.15);
		Poubelle pb1= new Poubelle("pb7","hab1",td1);
		Transaction t = s.beginTransaction();
		s.save(pb1);
		t.commit();
		
		SimpleDateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Levee l2= new Levee(7,dateFormat.parse("2015-07-15"),5,"pb2","BM-330-EF","C100");
		AccesData.ajoutLevee(l2);
		
		Facture f1= new Facture(7,2015,"hab1","hab1");
		AccesData.ajoutFacture(f1);
		
		System.out.println(AccesData.getLesHabitations());
		
		 List<Habitation> listeHabitation = AccesData.getLesHabitationsUsager("usag1");
		  for(Habitation h : listeHabitation)
				{
					System.out.println(h.toString());
				}
*/
		Traitement.facturation();
	}

}
