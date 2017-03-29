package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.metier.Usager;
import com.persistance.AccesData;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class PanelMAJTarif extends JPanel {
	private final JLabel lblMiseJour = new JLabel("Mise \u00E0 jour tarif par type d\u00E9chet");
	private final JLabel lblTypeDchet = new JLabel("Type d\u00E9chet");
	private final JLabel lblTarifActuel = new JLabel("Tarif actuel");
	private final JLabel lblNouveauTarif = new JLabel("Nouveau tarif");
	private final JComboBox cbTypeDechet = new JComboBox();
	private final JTextField txtTarifActuel = new JTextField();
	private final JTextField txtNvTarif = new JTextField();
	
	private List<TypeDechet>lesTD;
	private final JButton btnValiderMAJ = new JButton("Valider");
	private final JButton btnAnnulerMAJ = new JButton("Annuler");
	/**
	 * Create the panel.
	 */
	public PanelMAJTarif() {
		txtNvTarif.setBounds(192, 249, 86, 20);
		txtNvTarif.setColumns(10);
		txtTarifActuel.setEditable(false);
		txtTarifActuel.setBounds(192, 188, 86, 20);
		txtTarifActuel.setColumns(10);
		setLayout(null);
		lblMiseJour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMiseJour.setBounds(65, 49, 329, 28);
		
		add(lblMiseJour);
		lblTypeDchet.setBounds(65, 133, 85, 14);
		
		add(lblTypeDchet);
		lblTarifActuel.setBounds(65, 191, 85, 14);
		
		add(lblTarifActuel);
		lblNouveauTarif.setBounds(65, 252, 85, 14);
		
		add(lblNouveauTarif);
		remplirListe();
		cbTypeDechet.setEditable(true);
		cbTypeDechet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbTypeDechet.getSelectedIndex()!= -1){
					TypeDechet t = AccesData.getTarifTD(lesTD.get(cbTypeDechet.getSelectedIndex()).getIdTypeDechet());
					txtTarifActuel.setText(t.getTarif().toString());
				}
				
			}
		});
		cbTypeDechet.setBounds(192, 130, 255, 20);
		
		add(cbTypeDechet);
		
		add(txtTarifActuel);
		
		add(txtNvTarif);
		btnValiderMAJ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeDechet t = AccesData.getTarifTD(lesTD.get(cbTypeDechet.getSelectedIndex()).getIdTypeDechet());
				t.setTarif(Double.parseDouble(txtNvTarif.getText()));
				AccesData.updateTarifTD(t);
				
			}
		});
		btnValiderMAJ.setBounds(65, 336, 89, 23);
		
		add(btnValiderMAJ);
		btnAnnulerMAJ.setBounds(358, 336, 89, 23);
		
		add(btnAnnulerMAJ);

	}
	public void remplirListe(){
		lesTD = AccesData.getLesTypesDechet();
		for (TypeDechet td : lesTD){
			String typeD = td.getIdTypeDechet()+ " : "+ td.getLibelle() ;
			cbTypeDechet.addItem(typeD);
		}
		cbTypeDechet.setSelectedIndex(0);
	}
}
