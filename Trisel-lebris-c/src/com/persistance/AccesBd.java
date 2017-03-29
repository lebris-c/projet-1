package com.persistance;

import java.sql.*;

import org.hibernate.Session;

import com.util.Parametre;

//	 classe permettant l'ouverture, la fermeture de la base //mysql bd_trisel sur localhost 
public class AccesBd {
	
	private  static Connection con=null;
	private static String url;
	public static Connection  getInstance() {
		// acc�s direct sans source de donn�es odbc
		url=Parametre.getCheminBd();
		if (con==null)
		{
			try
			{// chargement du driver, librairie mysql connector li�e au projet
				Class.forName("com.mysql.jdbc.Driver");
				// connexion utilisateur root ou changer avec votre code utilisateur
				con=DriverManager.getConnection(url,"root","root");
			}
			// ouverture de la connexion
			catch (ClassNotFoundException e)
			{
				System.out.println(e.getMessage());
				System.out.println("�chec driver");
			}
			catch (SQLException e)
			{
				System.out.println(e.getMessage());
				System.out.println("�chec de connexion bd ");
			}
		}

		return con;
	}
	//	 fermeture de la connexion
	public static void close(){
		try { 
			con.close();
		}
		catch(Exception e) {e.printStackTrace();
		System.out.println("probl�me lors de la fermeture");}
	}
}


