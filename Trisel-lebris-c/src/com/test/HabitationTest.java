package com.test;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;

public class HabitationTest {
	private Habitation hab = null;
	private Usager u1 = null;
	private Usager u2 = null;
	private TypeDechet td;
	private Poubelle pb1;
	private Poubelle pb2;
	private ArrayList<Poubelle> listePoubelle;

	@Before
	public void setUp() throws Exception {
		u1 = new Usager("u1", "Dupont", "Albert", "63 grand-rue", "29150", "chateaulin");
		u2 = new Usager("u2", "Durand", "Alain", "63 grand-rue", "29150", "chateaulin");
		hab = new Habitation("hab1", "63 grand-rue", "29150", "Châteaulin", 2, u1);
		td = new TypeDechet("Ver", "verre", 0.10);
		pb1 = new Poubelle("pb1", hab.getIdHabitation(), td);
		listePoubelle = new ArrayList<Poubelle>();
		listePoubelle.add(pb1);
		listePoubelle.add(pb2);
	}

	@Test
	public void testHabitation() {
		assertNotNull(hab);
	}

	@Test
	public void testGetIdHabitation() {
		assertEquals(hab.getIdHabitation(), "hab1");
	}

	@Test
	public void testGetAdrRueHab() {
		assertEquals(hab.getAdrRueHab(), "63 grand-rue");
	}

	@Test
	public void testSetAdrRueHab() {
		hab.setAdrRueHab("50, rue Pasteur");
		assertEquals(hab.getAdrRueHab(), "50, rue Pasteur");
	}

	@Test
	public void testGetCpHab() {
		assertEquals(hab.getCpHab(), "29150");
	}

	@Test
	public void testSetCpHab() {
		hab.setCpHab("29200");
		assertEquals(hab.getCpHab(), "29200");
	}

	@Test
	public void testGetAdrVilleHab() {
		assertEquals(hab.getAdrVilleHab(), "Châteaulin");
	}

	@Test
	public void testSetAdrVilleHab() {
		hab.setAdrVilleHab("Brest");
		assertEquals(hab.getAdrVilleHab(), "Brest");
	}

	@Test
	public void testGetNbPertsonne() {
		assertEquals(hab.getNbPersonne(), 2);
	}

	@Test
	public void testSetNbPertsonne() {
		hab.setNbPersonne(5);
		assertEquals(hab.getNbPersonne(), 5);
	}

	@Test
	public void testGetUnUsager() {
		assertEquals(hab.getUsager(), u1);
	}

	@Test
	public void testSetUnUsager() {
		hab.setUsager(u2);
		assertEquals(hab.getUsager(), u2);
	}

	@Test
	public void testGetLesPoubelles() {
		assertEquals(hab.getLesPoubelles().size(), 0);
		hab.setLesPoubelles(listePoubelle);
		assertEquals(hab.getLesPoubelles(), listePoubelle);
		assertEquals(hab.getLesPoubelles().size(), 2);
	}

	@Test
	public void testSetLesPoubelles() {
		assertEquals(hab.getLesPoubelles().size(), 0);
		hab.setLesPoubelles(listePoubelle);
		assertEquals(hab.getLesPoubelles(), listePoubelle);
		assertEquals(hab.getLesPoubelles().size(), 2);
	}

	@Test
	public void testAddPoubelle() {
		assertEquals(hab.getLesPoubelles().size(), 0);
		hab.addPoubelle(pb1);
		assertEquals(hab.getLesPoubelles().size(), 1);
		assertEquals(hab.getLesPoubelles().get(0), pb1);
		hab.addPoubelle(pb2);
		assertEquals(hab.getLesPoubelles().size(), 2);
	}

	@Test
	public void testGetCout() {
		int an = 2015;
		int mois = 5;
		hab.addPoubelle(pb1);
		System.out.println(hab.getCout(an, mois));
		assertTrue(hab.getCout(an, mois) == 1.50);
	}
}
