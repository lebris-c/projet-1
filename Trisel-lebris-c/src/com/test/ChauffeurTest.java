package com.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Chauffeur;

public class ChauffeurTest {

	
	private Chauffeur chauffeur;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Before
	public void setUp() throws Exception {
		chauffeur = new Chauffeur("c1","Le Bris", "Corentin", sdf.parse("14/05/2016"));
	}

	@After
	public void tearDown() throws Exception {
		chauffeur = null ;
	}

	@Test
	public void testChauffeur() {
		assertNotNull("le chauffeur est crée", chauffeur);
	}

	@Test
	public void testGetIdChauffeur() {
		assertEquals("Est ce que l'id est correct", 
				"c1",chauffeur.getIdChauffeur());
	}

	@Test
	public void testSetIdChauffeur() {
		chauffeur.setIdChauffeur("c2");
		assertEquals("Est ce que l'id est correst", "c2",
				chauffeur.getIdChauffeur());
	}

	@Test
	public void testGetNomChauffeur() {
		assertEquals("Est ce que le Nom est correct", 
				"Le Bris",chauffeur.getNomChauffeur());
	}

	@Test
	public void testSetNomChauffeur() {
		chauffeur.setNomChauffeur("lb");
		assertEquals("Est ce que le Nom est correct", 
				"lb",chauffeur.getNomChauffeur());
	}

	@Test
	public void testGetPrenomChauffeur() {
		assertEquals("Est ce que le prenom est correct", 
				"Corentin",chauffeur.getPrenomChauffeur());
	}

	@Test
	public void testSetPrenomChauffeur() {
		chauffeur.setPrenomChauffeur("c");
		assertEquals("Est ce que le prenom est correct", 
				"c",chauffeur.getPrenomChauffeur());
	}

	@Test
	public void testGetDateEmbauche()  throws Exception {
		assertEquals("Est ce que la date d'embauche est correct", sdf.parse("14/05/2016"),
				chauffeur.getDateEmbauche());
	}

	@Test
	public void testSetDateEmbauche()  throws Exception {
		chauffeur.setDateEmbauche(sdf.parse("01/01/2001"));
		assertEquals("Est ce que la date d'embauche est correct", sdf.parse("01/01/2001"),
				chauffeur.getDateEmbauche());
	}

	

}
