package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;

public class LeveeTest {
	private Date d1 = null;
	private Date d2 = null;
	private SimpleDateFormat dateFormat = null;
	private Levee le1 = null;
	private Levee le2 = null;

	@Before
	public void setUp() throws Exception {
		// format de la date
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// instanciation date de levée au format français
			d1 = dateFormat.parse("15/05/2015");
			// instanciation objet Levée sans idLevee et avec
			le1 = new Levee(d1, 5.0, "pb1", "immat", "ch1");
			le2 = new Levee(2, d1, 10.0, "pb1", "immat", "ch1");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
		le1 = null;
		le2 = null;
	}
	@Test
	public void testLevee() {
		// test existence objet avec les 2 constructeurs
		assertNotNull(le1);
		assertNotNull(le2);
	}

	@Test
	public void testGetIdLevee() {
		assertTrue(le2.getIdLevee() == 2);
	}

	@Test
	public void testGetLaDate() {

		assertEquals("15/05/2015", dateFormat.format(le1.getLaDate()));
		assertEquals("15/05/2015", dateFormat.format(le2.getLaDate()));
	}

	@Test
	public void testSetLaDate() {
		// changement de date
		try {
			// instanciation date de levée au format français
			d2 = dateFormat.parse("30/06/2015");
			// changement date de levée
			le1.setLaDate(d2);
			// récupération date de la levée
			assertEquals("30/06/2015", dateFormat.format(le1.getLaDate()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPoids() {
		// assertEquals deprecated, remplacement par assertTrue
		assertTrue(le1.getPoids() == 5.0);
		assertTrue(le2.getPoids() == 10.0);
	}

	@Test
	public void testSetPoids() {
		le1.setPoids(10.0);
		assertFalse(le1.getPoids() == 5.0);
		assertTrue(le1.getPoids() == 10.0);
	}

	@Test
	public void testGetIdPoubelle() {
		le1.setIdPoubelle("pb2");
		assertEquals(le1.getIdPoubelle(), "pb2");
	}

	@Test
	public void testGetimmatriculation() {
		assertEquals(le1.getImmatriculation(), "immat");
	}

	@Test
	public void testSetimmatriculation() {
		le1.setImmatriculation("immat2");
		assertEquals(le1.getImmatriculation(), "immat2");
	}

	@Test
	public void testSetidChauffeur() {
		assertEquals(le1.getIdChauffeur(), "ch1");
	}

	@Test
	public void testSetIdChauffeur() {
		le1.setIdChauffeur("ch2");
		assertEquals(le1.getIdChauffeur(), "ch2");
	}

	@Test
	public void testSetIdPoubelle() {
		assertEquals(le1.getIdPoubelle(), "pb1");
		assertEquals(le2.getIdPoubelle(), "pb1");
	}
}
