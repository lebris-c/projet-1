package com.vue;

import javax.swing.JPanel;

import com.util.InsertionLevee;
import com.util.Parametre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLevee extends JPanel {
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JButton btnLancer = new JButton("Lancer");

	/**
	 * Create the panel.
	 */
	public PanelLevee() {
		setLayout(null);
		lblNewLabel.setBounds(163, 114, 118, 14);
		
		add(lblNewLabel);
		String texteLabel = "il y a " + Parametre.nbLevee() + " fichier(s) � traiter";
		lblNewLabel.setText(texteLabel);
		btnLancer.setBounds(173, 139, 91, 23);
		
			// d�sactivation du bouton si pas de fichier � traiter
			if (Parametre.nbLevee() == 0) {
				btnLancer.setEnabled(false);
				}	
		btnLancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertionLevee.traitementLevee();
				afficheMessage("Mise � jour effectu�e");


			}
		});
		
		add(btnLancer);
		

	}
	// m�thode pour afficher un message dans une boite de dial
		private void afficheMessage(String message)
		{
			JOptionPane.showMessageDialog(null,message);
		}

}
