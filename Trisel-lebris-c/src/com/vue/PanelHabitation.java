package com.vue;

import javax.swing.JPanel;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.metier.Usager;
import com.persistance.AccesData;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PanelHabitation extends JPanel {
	private final JComboBox cbUsager = new JComboBox();
	private final JLabel lblSlectionnerUsager = new JLabel("S\u00E9lectionner usager :");
	private final JTable tableUsager = new JTable();
	private List<Usager> lesUsagers;
	private ModeleListeHabitation modele;
	private final JScrollPane scrollPane = new JScrollPane();
	
	/**
	 * Create the panel.
	 */
	
	public PanelHabitation() {
		setLayout(null);
		add(lblSlectionnerUsager);
		scrollPane.setBounds(46, 118, 582, 141);
		
		add(scrollPane);
		scrollPane.setViewportView(tableUsager);
		
				cbUsager.setBounds(291, 72, 284, 20);
				remplirListe();
				add(cbUsager);
				lblSlectionnerUsager.setBounds(164, 75, 117, 14);
		cbUsager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(cbUsager.getSelectedIndex());
				if (cbUsager.getSelectedIndex()!=-1){
					System.out.println(AccesData.getLesHabitationsUsager().size());
					
					modele = new ModeleListeHabitation(lesUsagers.get(cbUsager.getSelectedIndex()).getIdUsager());
					
					System.out.println(lesUsagers.get(cbUsager.getSelectedIndex()).getIdUsager());
					tableUsager.setModel(modele);
					if (lesUsagers.get(cbUsager.getSelectedIndex()).getLesHabitations().size()== 0){
						afficheMessage("Aucune habitation référencée pour cet usager");
					}
					tableUsager.revalidate();
				}
			}
		});
		
		
	
	
}
	public void remplirListe(){
		lesUsagers = AccesData.getLesUsagers();
		for (Usager u : lesUsagers){
			String usager = u.getIdUsager()+ " - "+ u.getNom() + " "+u.getPrenom();
			cbUsager.addItem(usager);
		}
		cbUsager.setSelectedIndex(0);
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}
