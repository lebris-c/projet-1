package com.vue;

import java.util.Scanner;

public class MenuConsole {
	public static void main(String[] args) {
		int choix=0;
		Scanner in=new Scanner(System.in);
		while (choix!=3)
		{
			System.out.println("Menu g�n�ral");
			System.out.println("1- Insertion des lev�es");
			System.out.println("2 -Edition des factures");
			System.out.println("3- quitter");
			System.out.println("Donner votre choix");
			choix=in.nextInt();
			switch (choix) {
			case 1 :
				// � compl�ter
				break;
			case 2 :
				// � compl�ter
				break;
			default: 
				break;
			}
		}

}
}
