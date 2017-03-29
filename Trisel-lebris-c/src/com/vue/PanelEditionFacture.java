package com.vue;

import javax.swing.JPanel;

import com.pdf.EditionFacture;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.util.InsertionLevee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEditionFacture extends JPanel  implements PropertyChangeListener{
	private final JMonthChooser monthChooser = new JMonthChooser();
	private final JYearChooser yearChooser = new JYearChooser();
	private final JButton btnLancerEdit = new JButton("Lancer \u00E9dition");
	private int an;
	private int mois;
	private Calendar calendar;
	/**
	 * Create the panel.
	 */
	public PanelEditionFacture() {
		
		setLayout(null);
		monthChooser.setBounds(135, 105, 97, 20);
		
		add(monthChooser);
		yearChooser.setBounds(282, 105, 47, 20);
		
		add(yearChooser);
		btnLancerEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditionFacture.testFacture(an, mois);
				afficheMessage("Mise � jour effectu�e");
			}
		});
		btnLancerEdit.setBounds(182, 153, 120, 36);
		
		add(btnLancerEdit);
		// r�cup�ration ann�e et mois actuel
		calendar = Calendar.getInstance();
		an = getYear();
		mois  = getMonth() + 1;// + 1 car mois de 0 � 11 et non pas de 1 = 12
		monthChooser.addPropertyChangeListener(this);


	}

		
	

	// m�thodes utilitaires qui ram�ne l'ann�e et le mois courant
	public int getYear(){
			return calendar.get(Calendar.YEAR);
	}
	public int getMonth(){
			return calendar.get(Calendar.MONTH);
	}
	// proc�dure de tests des sources d'�v�nement
	public void propertyChange(PropertyChangeEvent evt) {
			if(evt.getPropertyName().equals("year")){
				an = (Integer)evt.getNewValue();
			}
			if(evt.getPropertyName().equals("month")){
				mois  = (Integer)evt.getNewValue() + 1;
			}
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}
