package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.persistance.AccesData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAjoutTD extends JPanel {
	private final JLabel lblNewLabel = new JLabel("Saisie d'un nouveau type de d\u00E9chet");
	private final JLabel lblNewLabel_1 = new JLabel("Code type d\u00E9chet :");
	private final JLabel lblLibellDchet = new JLabel("Libell\u00E9 d\u00E9chet :");
	private final JLabel lblNewLabel_2 = new JLabel("Tarif au kg :");
	private final JTextField textCodeTD = new JTextField();
	private final JTextField txtLibelleTD = new JTextField();
	private final JTextField textTarifKG = new JTextField();
	private final JButton btnValiderTD = new JButton("Valider");
	private final JButton btnAnnulerTD = new JButton("Annuler");
	private TypeDechet td ;
	/**
	 * Create the panel.
	 */
	public PanelAjoutTD() {
		textTarifKG.setBounds(232, 198, 86, 20);
		textTarifKG.setColumns(10);
		txtLibelleTD.setBounds(232, 138, 138, 20);
		txtLibelleTD.setColumns(10);
		textCodeTD.setBounds(232, 92, 138, 20);
		textCodeTD.setColumns(10);
		setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(97, 27, 305, 30);
		
		add(lblNewLabel);
		lblNewLabel_1.setBounds(97, 95, 110, 14);
		
		add(lblNewLabel_1);
		lblLibellDchet.setBounds(97, 144, 86, 14);
		
		add(lblLibellDchet);
		lblNewLabel_2.setBounds(97, 201, 86, 14);
		
		add(lblNewLabel_2);
		
		add(textCodeTD);
		
		add(txtLibelleTD);
		
		add(textTarifKG);
		td = new TypeDechet();
		
		//Validation
		btnValiderTD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String code = textCodeTD.getText();
				String libelle = txtLibelleTD.getText();
				String tarif = textTarifKG.getText();
				if (code.equals("")){
					afficheMessage("Saisie code incorrect");
					textCodeTD.requestFocus();
				}
				else if(libelle.equals("")){
					afficheMessage("Saisie libellé incorrect");
					txtLibelleTD.requestFocus();
				}
				else if (tarif.equals("")){
					afficheMessage("Saisie tarif incorrect");
					textTarifKG.requestFocus();
				}
				else if(code.length()!= 3){
					afficheMessage("Saisie code incorrect");
					textCodeTD.requestFocus();
				}
				else if(AccesData.getTypeDechet(code)!= null){
					afficheMessage("Saisie code incorrect");
					textCodeTD.requestFocus();
				}
				else{
					td.setIdTypeDechet(code);
					td.setLibelle(libelle);
					td.setTarif(Double.parseDouble(tarif));
					AccesData.ajoutTypeDechet(td);
				}				
			}
		});
		btnValiderTD.setBounds(97, 273, 89, 23);
		
		add(btnValiderTD);
		btnAnnulerTD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodeTD.setText(null);
				txtLibelleTD.setText(null);
				textTarifKG.setText(null);
			}
		});
		btnAnnulerTD.setBounds(281, 273, 89, 23);
		
		add(btnAnnulerTD);
		
		
		
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	
}
