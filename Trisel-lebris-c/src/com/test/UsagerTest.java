package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

public class UsagerTest {
	private Usager u;

	private Habitation h1;
	

	@Before
	public void setUp() throws Exception {
		
		h1 = new Habitation ("hab1", "rue", "29000", "Quimper", 5,u );	
		u = new Usager ("u1","nom1","prenom1", "rue1", "29000", "Quimper");
	}

	@After
	public void tearDown() throws Exception {
		u = null;
	}

	@Test
	public void testUsager() {
		assertNotNull("1 usager est créé", u);
	}

	@Test
	public void testGetLesHabitations() {
		assertTrue("est ce qu'il y a des hab",0==u.getLesHabitations().size());
	}

	@Test
	public void testSetLesHabitations() {
		ArrayList<Habitation> listeHabitation = new ArrayList <Habitation>();
		listeHabitation.add(h1);
		u.setLesHabitations(listeHabitation);
		assertTrue("est ce qu'il y a des hab",1==u.getLesHabitations().size());
		
	}

	@Test
	public void testGetIdUsager() {
		assertEquals("est qu'il existe un id", "u1", u.getIdUsager());
	}

	@Test
	public void testSetIdUsager() {
		u.setIdUsager("u2");
		assertEquals("est qu'il existe un id", "u2", u.getIdUsager());
	}

	@Test
	public void testGetNom() {
		assertEquals("est qu'il existe un nom", "nom1", u.getNom());
	}

	@Test
	public void testSetNom() {
		u.setNom("Le Bris");
		assertEquals("est qu'il existe un nom", "Le Bris", u.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertEquals("est qu'il existe un Prenom", "prenom1", u.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		u.setPrenom("Corentin");
		assertEquals("est qu'il existe un Prenom", "Corentin", u.getPrenom());
	}

	@Test
	public void testGetAdrRueUsager() {
		assertEquals("est qu'il existe une adr rue", "rue1", u.getAdrRueUsager());
	}

	@Test
	public void testSetAdrRueUsager() {
		u.setAdrRueUsager("laRue");
		assertEquals("est qu'il existe une adr rue", "laRue", u.getAdrRueUsager());
	}

	@Test
	public void testGetCpUsager() {
		assertEquals("est qu'il existe un cp", "29000", u.getCpUsager());
	}

	@Test
	public void testSetCpUsager() {
		u.setCpUsager("29500");
		assertEquals("est qu'il existe un cp", "29500", u.getCpUsager());
	}

	@Test
	public void testGetAdrVilleUsager() {
		assertEquals("est qu'il existe une adr ville", "Quimper", u.getAdrVilleUsager());
	}

	@Test
	public void testSetAdrVilleUsager() {
		u.setAdrVilleUsager("Brest");
		assertEquals("est qu'il existe une adr ville", "Brest", u.getAdrVilleUsager());
	}

	@Test
	public void testAjoutHabitation() {
		u.ajoutHabitation(h1);
		assertTrue("contient h1 : ", u.getLesHabitations().contains(h1));
	}

	@Test
	public void testSupprimerHabitation() {
		u.supprimerHabitation(h1);
		assertTrue("ne contient pas h1 : ", u.getLesHabitations().contains(h1));
	}

	

}
