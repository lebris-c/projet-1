package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.metier.Utilisateur;
import com.persistance.AccesData;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TestForm extends JFrame {

	private JPanel contentPane;
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnFichier = new JMenu("Fichier");
	private final JMenuItem mnsmQuitter = new JMenuItem("Quitter");
	private final JMenu mnLevee = new JMenu("Lev\u00E9e");
	private final JMenu mnFacture = new JMenu("Facture");
	private final JMenuItem mnsmGenerationFacture = new JMenuItem("G\u00E9n\u00E9ration facture");
	private final JMenuItem mnsmInsertionLevee = new JMenuItem("Insertion lev\u00E9e");
	private String login;
	private String mdp;
	private Utilisateur u;
	private final JPanel panelLogin = new JPanel();
	private final JLabel lblLogin = new JLabel("login :");
	private final JLabel lblpsw = new JLabel("mot de passe :");
	private final JTextField txtLogin = new JTextField();
	private final JPasswordField psw = new JPasswordField();
	private final JButton btnValider = new JButton("Valider");
	private final JMenu mnConsultation = new JMenu("Consultation");
	private final JMenuItem mnsmHabitation = new JMenuItem("Habitations par usager");
	private final JMenu mnDonnesDeBase = new JMenu("Donn\u00E9es de base");
	private final JMenuItem mnsmAjout = new JMenuItem("Ajout");
	private final JMenuItem mnsmChangementTarif = new JMenuItem("Changement tarif");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestForm frame = new TestForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestForm() {
		txtLogin.setText("lequay");
		txtLogin.setBounds(355, 108, 156, 20);
		txtLogin.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 441);
		setTitle("Gestion poubelles");
		menuBar.setEnabled(false);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnFichier);
		mnsmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnsmInsertionLevee.setEnabled(false);
		
		mnsmInsertionLevee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertionLevee();
			}
		});

		mnFichier.add(mnsmQuitter);
		
		menuBar.add(mnLevee);
		
		mnLevee.add(mnsmInsertionLevee);
		
		menuBar.add(mnFacture);
		mnsmGenerationFacture.setEnabled(false);
		mnsmGenerationFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertionFacture();
			}
		});
		
		mnFacture.add(mnsmGenerationFacture);
		
		menuBar.add(mnConsultation);
		mnsmHabitation.setEnabled(false);
		mnsmHabitation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				habitationParUsager();
			}
			
		});
		
		mnConsultation.add(mnsmHabitation);
		
		menuBar.add(mnDonnesDeBase);
		mnsmAjout.setEnabled(false);
		mnsmAjout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajoutTD();
			}
		});
		
		mnDonnesDeBase.add(mnsmAjout);
		mnsmChangementTarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				majTD();
			}
		});
		mnsmChangementTarif.setEnabled(false);
		
		mnDonnesDeBase.add(mnsmChangementTarif);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelLogin.setBounds(0, 0, 722, 381);
		
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		lblLogin.setBounds(280, 111, 46, 14);
		
		panelLogin.add(lblLogin);
		lblpsw.setBounds(260, 180, 85, 14);
		
		panelLogin.add(lblpsw);
		
		panelLogin.add(txtLogin);
		psw.setBounds(355, 178, 156, 17);
		
		panelLogin.add(psw);
		btnValider.setBounds(326, 276, 89, 23);
		
		panelLogin.add(btnValider);
		//panel
		
	
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login = txtLogin.getText();
				mdp =new String( psw.getPassword());
				u = AccesData.getUtilisateur(login, mdp);
				if (u== null){
					afficheMessage("login ou mot de passe incorrect");
					txtLogin.setText("");
					psw.setText("");
					txtLogin.requestFocus();
				}
				else {
					// connexion valide
					paramNiveau(u.getNiveau());
					fondEcran(u.getNomUtilisateur());
				}
			}
		});
		
		
		
		
	}
	public void paramNiveau(int niveau){
		switch(niveau){
		case 1 :{
			mnsmGenerationFacture.setEnabled(true);
			mnsmInsertionLevee.setEnabled(true);
			mnsmHabitation.setEnabled(true);
			mnsmAjout.setEnabled(true);
			mnsmChangementTarif.setEnabled(true);
			break;
		}
		case 2 :{
			mnsmGenerationFacture.setEnabled(true);
			mnsmInsertionLevee.setEnabled(false);
			mnsmHabitation.setEnabled(false);
			mnsmAjout.setEnabled(false);
			mnsmChangementTarif.setEnabled(false);
			break;
		}
		case 3 :{
			mnsmInsertionLevee.setEnabled(true);
			mnsmGenerationFacture.setEnabled(false);
			mnsmHabitation.setEnabled(false);
			mnsmAjout.setEnabled(false);
			mnsmChangementTarif.setEnabled(false);
			break;
		}
		}
	}
	private void insertionLevee() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelLevee
		this.setContentPane(new PanelLevee());
		// mets à jour le formulaire
		this.revalidate();
	}
	private void insertionFacture(){
		// on affecte le panel de la fenêtre
				// avec une instance de PanelLevee
				this.setContentPane(new PanelEditionFacture());
				// mets à jour le formulaire
				this.revalidate();
	}
	private void habitationParUsager(){
		// on affecte le panel de la fenêtre
				// avec une instance de PanelLevee
				this.setContentPane(new PanelHabitation());
				// mets à jour le formulaire
				this.revalidate();
	}
	private void fondEcran(String nomUtil){
		// on affecte le panel de la fenêtre
				// avec une instance de PanelLevee
				this.setContentPane(new PanelFondEcran(nomUtil));
				// mets à jour le formulaire
				this.revalidate();
	}
	private void ajoutTD() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelLevee
		this.setContentPane(new PanelAjoutTD());
		// mets à jour le formulaire
		this.revalidate();
	}
	private void majTD(){
		// on affecte le panel de la fenêtre
				// avec une instance de PanelLevee
				this.setContentPane(new PanelMAJTarif());
				// mets à jour le formulaire
				this.revalidate();
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	
}
