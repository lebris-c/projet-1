package com.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@SuiteClasses(value={
		// les classes a enchainer
	CamionTest.class,
	ChauffeurTest.class,
	FactureTest.class,
	HabitationTest.class,
	LeveeTest.class,
	PoubelleTest.class,
	TypeDechetTest.class,
	UsagerTest.class})
public class ExecuterTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		org.junit.runner.JUnitCore.main("ExecuterTest");
		
				
	}

}
