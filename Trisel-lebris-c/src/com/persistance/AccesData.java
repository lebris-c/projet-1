package com.persistance;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Tarif;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.metier.Utilisateur;

public class AccesData {
	private static Session s = HibernateSession.getSession();
	private static Connection con = AccesBd.getInstance();
	public static ArrayList<Habitation> getLesHabitations(){
		ArrayList<Habitation> listeHab =(ArrayList<Habitation>) s.createQuery("from Habitation").list();
		return listeHab ;
	}
	public static Utilisateur getUtilisateur(String login, String mdp){
		Query q = s.createQuery("FROM Utilisateur u WHERE u.login = '"+login+"' AND u.mdp ='"+ mdp+"'");
		return (Utilisateur)q.uniqueResult();
	}
	public static Usager getUsager(){
		Query q = s.createQuery("FROM Usager u");
		return (Usager)q.uniqueResult();
	}
	public static List<Usager> getLesUsagers(){
		Query q = s.createQuery("FROM Usager u");
		return q.list();
	}
	public static double getTarifIndividuel(){
		Tarif tarif =  (Tarif)s.get(Tarif.class, 1);
		return tarif.getValeur() ;
	}
	public static boolean ajoutLevee(Levee uneLevee){		
		 boolean ok = false;
		  try{
		  Transaction t = s.beginTransaction();
		  s.save(uneLevee);
		  t.commit();
		  ok = true;
		  } catch (HibernateException e) {
		  ok = false;}
		  return ok;
	}
	public static boolean ajoutFacture(Facture f){
		  boolean ok = false;
		  try{
		  Transaction t = s.beginTransaction();
		  s.save(f);
		  t.commit();
		  ok = true;
		  } catch (HibernateException e) {
		  ok = false;
		  }
		return ok;
	}
	public static boolean ajouterControleFacture(Facture f) {
		boolean ok = false;
		String hql ="from Facture f where f.an="+ f.getAn();
		hql = hql +" and f.mois = "+ f.getMois();
		hql = hql + " and f.idHabitation ='"+f.getIdHabitation()+"'";
		Facture existf = (Facture) s.createQuery(hql).uniqueResult();
		if (existf == null){
			try{
				  Transaction t = s.beginTransaction();
				  s.save(f);
				  t.commit();
				  ok = true;
				  } catch (HibernateException e) {
					  e.printStackTrace();
				  }
		}
		return ok;
	}
	
	public static List<Habitation> getLesHabitationsUsager(String idUsager) {
		return   s.createQuery("from Habitation h where h.usager.idUsager ='"+ idUsager +"'").list();


	}
	public static List<Habitation> getLesHabitationsUsager() {
		return   s.createQuery("from Habitation h where h.usager.idUsager = 'usag2'").list();
	}
	public static boolean ajoutTypeDechet(TypeDechet td){
		  boolean ok = false;
		  try{
		  Transaction t = s.beginTransaction();
		  s.save(td);
		  t.commit();
		  ok = true;
		  } catch (HibernateException e) {
		  ok = false;
		  }
		return ok;
	}
	public static List<TypeDechet> getLesTypesDechet(){
		Query q = s.createQuery("FROM TypeDechet td");
		return q.list();
	}
	public static TypeDechet getTarifTD(String idType){
		Query q = s.createQuery("FROM TypeDechet td WHERE idTypeDechet= '"+ idType+"'");
		return (TypeDechet)q.uniqueResult();
	}
	public static TypeDechet getTypeDechet(String id){
		Query q = s.createQuery("FROM TypeDechet td WHERE idTypeDechet = '"+id+"'");
		return (TypeDechet)q.uniqueResult();
	}
	public static boolean updateTarifTD(TypeDechet td){
		boolean ok = false;
		  try{
		  Transaction t = s.beginTransaction();
		  s.update(td);
		  t.commit();
		  ok = true;
		  } catch (HibernateException e) {
		  ok = false;
		  }
		return ok;
		
	}
	
	
}
