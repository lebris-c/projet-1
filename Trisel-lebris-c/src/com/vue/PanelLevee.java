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
		String texteLabel = "il y a " + Parametre.nbLevee() + " fichier(s) à traiter";
		lblNewLabel.setText(texteLabel);
		btnLancer.setBounds(173, 139, 91, 23);
		
			// désactivation du bouton si pas de fichier à traiter
			if (Parametre.nbLevee() == 0) {
				btnLancer.setEnabled(false);
				}	
		btnLancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertionLevee.traitementLevee();
				afficheMessage("Mise à jour effectuée");


			}
		});
		
		add(btnLancer);
		

	}
	// méthode pour afficher un message dans une boite de dial
		private void afficheMessage(String message)
		{
			JOptionPane.showMessageDialog(null,message);
		}

}
