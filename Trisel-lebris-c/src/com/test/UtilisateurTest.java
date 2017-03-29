package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Utilisateur;

public class UtilisateurTest {

	private Utilisateur u;

	@Before
	public void setUp() throws Exception {
		u = new Utilisateur("u1", "Le Bris","Corentin", "clb", "c", 1 );
	}

	@After
	public void tearDown() throws Exception {
		u=null;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
