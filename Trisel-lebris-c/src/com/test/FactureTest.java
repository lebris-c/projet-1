package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Facture;
import com.metier.Levee;

public class FactureTest {

	private Facture f;
	
	@Before
	public void setUp() throws Exception {
		f = new Facture(1,12,2010,"facture","hab1");
	}

	@After
	public void tearDown() throws Exception {
		f = null;
	}

	@Test
	public void testFacture() {
		assertNotNull("1 facture est créée",f);
	}

	@Test
	public void testGetIdFacture() {
		assertEquals("Est ce que l'id est correct", 1,f.getIdFacture());
	}

	@Test
	public void testSetIdFacture() {
		f.setIdFacture(2);
		assertEquals("Est ce que l'id est correct", 2,f.getIdFacture());
	}

	@Test
	public void testGetMois() {
		assertEquals("Est ce que le mois est correct", 12,f.getMois());
	}

	@Test
	public void testSetMois() {
		f.setMois(10);
		assertEquals("Est ce que le mois est correct", 10,f.getMois());
	}

	@Test
	public void testGetAn() {
		assertEquals("Est ce que le an est correct", 2010,f.getAn());
	}

	@Test
	public void testSetAn() {
		f.setAn(2016);
		assertEquals("Est ce que le an est correct", 2016,f.getAn());
	}

	@Test
	public void testGetNomFacture() {
		assertEquals("Est ce que le nom est correct", "facture",f.getNomFacture());
	}

	@Test
	public void testSetNomFacture() {
		f.setNomFacture("fct");
		assertEquals("Est ce que le nom est correct", "fct",f.getNomFacture());
	}

}
