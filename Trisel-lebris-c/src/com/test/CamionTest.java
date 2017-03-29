package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Camion;

public class CamionTest {

	
	private Camion camion;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Before
	public void setUp() throws Exception {
		camion = new Camion ("AB-777-CD",sdf.parse("12/12/2012"));
		//System.out.println(camion.getDateMiseEnCirculation());
	}

	@After
	public void tearDown() throws Exception {
		camion=null;
	}

	@Test
	public void testCamion() {
		assertNotNull("le camion est crée", camion);
	}

	@Test
	public void testGetImmatriculation() {
		assertEquals("Est ce que l'immatriculation est correct", "AB-777-CD", 
		camion.getImmatriculation());
	}

	@Test
	public void testSetImmatriculation() {
		camion.setImmatriculation("EF-888-IJ");
		assertEquals("Est ce que l'immatriculation est correst", "EF-888-IJ",
				camion.getImmatriculation());
	}

	@Test
	public void testGetDateMiseEnCirculation() throws Exception {
		
		assertEquals("Est ce que la date de mise en circulation est correct", sdf.parse("12/12/2012"),
				camion.getDateMiseEnCirculation());
	}

	@Test
	public void testSetDateMiseEnCirculation() throws Exception {
		camion.setDateMiseEnCirculation(sdf.parse("01/01/2001"));
		assertEquals("Est ce que la date de mise en circulation est correct", sdf.parse("01/01/2001"),
				camion.getDateMiseEnCirculation());
	}



}
