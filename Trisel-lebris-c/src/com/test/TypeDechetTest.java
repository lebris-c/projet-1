package com.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Levee;
import com.metier.TypeDechet;

public class TypeDechetTest {

	private TypeDechet t;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	@Before
	public void setUp() throws Exception {
		t = new TypeDechet("t1","type dechet",10.2);
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testTypeDechet() {
		assertNotNull("l type est créé", t);
	}

	@Test
	public void testGetIdTypeDechet() {
		assertEquals("Est ce que l'id est correct", 
				"t1",t.getIdTypeDechet());
	}

	@Test
	public void testSetIdTypeDechet() {
		t.setIdTypeDechet("t2");
		assertEquals("Est ce que l'id est correct", 
				"t2",t.getIdTypeDechet());
	}

	@Test
	public void testGetLibelle() {
		assertEquals("Est ce que le libelle est correct", 
				"type dechet",t.getLibelle());
	}

	@Test
	public void testSetLibelle() {
		t.setLibelle("type");
		assertEquals("Est ce que le libelle est correct", 
				"type",t.getLibelle());
	}

	@Test
	public void testGetTarif() {
		assertTrue("Est ce que le tarif est correct", 
				10.2==t.getTarif());
	}

	@Test
	public void testSetTarif() {
		t.setTarif(11.2);
		assertTrue("Est ce que le tarif est correct", 
				11.2==t.getTarif());
		
	}



}
