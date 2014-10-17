package WindowBuilder;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;


import Package.AR;
import Package.AS;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;


public class appli extends JFrame {

	private JPanel contentPane;
	private JTextField TextDep;
	private JTextField TextNbKill;
	private JTextField TextDuree;
	private ButtonGroup GroupAllerRetour = new ButtonGroup();
	private ButtonGroup GroupSemWE = new ButtonGroup();
	private ButtonGroup GroupJourNuit = new ButtonGroup();
	int i=0;
	private static List<AR> AR =  new ArrayList<AR>();
	private static List<AS> AS =  new ArrayList<AS>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

methodes.connectionBase(AR, AS);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appli frame = new appli();
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
	public appli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JLabel LabelDep = new JLabel("Numéro du département :");
		LabelDep.setBounds(12, 66, 228, 15);
		contentPane.add(LabelDep);

		TextDep = new JTextField();
		TextDep.setBounds(222, 64, 53, 19);
		contentPane.add(TextDep);
		TextDep.setColumns(10);
		TextDep.requestFocus();

		JLabel LabelTitre = new JLabel("Calcul du coût d'un trajet en taxi");
		LabelTitre.setBounds(99, 12, 247, 15);
		contentPane.add(LabelTitre);


		JButton ButtonRechercher = new JButton("Rechercher");
		ButtonRechercher.setBounds(300, 61, 133, 25);
		contentPane.add(ButtonRechercher);

		JButton ButtonReinitialiser = new JButton("Réinitialiser");
		ButtonReinitialiser.setBounds(461, 61, 133, 25);
		contentPane.add(ButtonReinitialiser);

		final JLabel LabelNbKil = new JLabel("Nombre de kilométres à parcourir :");
		LabelNbKil.setBounds(12, 126, 263, 15);
		contentPane.add(LabelNbKil);
		LabelNbKil.setVisible(false);

		TextNbKill = new JTextField();
		TextNbKill.setBounds(270, 124, 53, 19);
		contentPane.add(TextNbKill);
		TextNbKill.setColumns(10);
		TextNbKill.setVisible(false);

		final JLabel LabelDuree = new JLabel("Durée du trajet (en minutes) :");
		LabelDuree.setBounds(12, 178, 222, 15);
		contentPane.add(LabelDuree);
		LabelDuree.setVisible(false);

		TextDuree = new JTextField();
		TextDuree.setBounds(232, 176, 61, 19);
		contentPane.add(TextDuree);
		TextDuree.setColumns(10);
		TextDuree.setVisible(false);

		final JRadioButton RadioJour = new JRadioButton("Jour");
		RadioJour.setBounds(27, 225, 100, 23);
		contentPane.add(RadioJour);
		RadioJour.setVisible(false);
		GroupJourNuit.add(RadioJour);


		final JRadioButton RadioNuit = new JRadioButton("Nuit");
		RadioNuit.setBounds(159, 225, 149, 23);
		contentPane.add(RadioNuit);
		RadioNuit.setVisible(false);
		GroupJourNuit.add(RadioNuit);

		final JRadioButton RadioSemaine = new JRadioButton("Semaine");
		RadioSemaine.setBounds(27, 272, 113, 23);
		contentPane.add(RadioSemaine);
		RadioSemaine.setVisible(false);
		GroupSemWE.add(RadioSemaine);

		final JRadioButton RadioWE = new JRadioButton("WE");
		RadioWE.setBounds(159, 272, 149, 23);
		contentPane.add(RadioWE);
		RadioWE.setVisible(false);
		GroupSemWE.add(RadioWE);

		final JRadioButton RadioAllerRetour = new JRadioButton("Aller retour");
		RadioAllerRetour.setBounds(27, 313, 133, 23);
		contentPane.add(RadioAllerRetour);
		RadioAllerRetour.setVisible(false);
		GroupAllerRetour.add(RadioAllerRetour);

		final JRadioButton RadioAllerSimple = new JRadioButton("Aller simple");
		RadioAllerSimple.setBounds(159, 313, 149, 23);
		contentPane.add(RadioAllerSimple);
		RadioAllerSimple.setVisible(false);
		GroupAllerRetour.add(RadioAllerSimple);

		final JLabel LabelTotal = new JLabel("Pour ce trajet, vous devrez payer :");
		LabelTotal.setBounds(270, 481, 313, 15);
		contentPane.add(LabelTotal);
		LabelTotal.setVisible(false);

		final JButton ButtonCalculer = new JButton("Calculer");
		ButtonCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double prix = 0.0;
				System.out.print(i);

				if(RadioAllerSimple.isSelected())
				{ //Aller - Simple

		            if(RadioJour.isSelected() && RadioSemaine.isSelected())
		            {
		                prix = (AS.get(i).getPriseCharge()) + ((Integer.parseInt(TextNbKill.getText()) * AS.get(i).getTarifJS()));
		                if(Integer.parseInt(TextDuree.getText()) > 60) //Et de plus d'une heure
		                    prix = (int)(Integer.parseInt(TextDuree.getText())/60) * AS.get(i).getTarifHoraireJ();
		        }
		            else
		            {

		                prix = AS.get(i).getPriseCharge() + (Integer.parseInt(TextNbKill.getText()) * AS.get(i).getTarifNW());
		                if(Integer.parseInt(TextDuree.getText()) > 60)
		                    prix = (int)(Integer.parseInt(TextDuree.getText())/60) * AS.get(i).getTarifHoraireNWE();
		            }
		        }
		        else //if(saisies.getTypeduTrajet().equals("AR"))
		        { //Aller - Retour
		            if(RadioJour.isSelected() && RadioSemaine.isSelected())
		            {
		                prix = AR.get(i).getPriseCharge() + (Integer.parseInt(TextNbKill.getText()) * AR.get(i).getTarifJS());
		                if(Integer.parseInt(TextDuree.getText()) > 60)
		                    prix = (int)(Integer.parseInt(TextDuree.getText())/60) * AR.get(i).getTarifHoraireJ();
		            }
		            else

		            {
		                prix = AR.get(i).getPriseCharge() + (Integer.parseInt(TextNbKill.getText()) * AR.get(i).getTarifNW());
		                if(Integer.parseInt(TextDuree.getText()) > 60)
		                    prix = (int)(Integer.parseInt(TextDuree.getText())/60) * AR.get(i).getTarifHoraireNWE();
		            }


		        }
				//System.out.print("prix");
				LabelTotal.setVisible(true);
				LabelTotal.setText("Pour ce trajet, vous devrez payer : " + prix + "€");

				//calcul du tarif
			}
		});

		ButtonCalculer.setBounds(88, 476, 117, 25);
		contentPane.add(ButtonCalculer);
		ButtonCalculer.setVisible(false);

		ButtonRechercher.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {

		 boolean trouve= false;

		 System.out.println(AR.get(2).getDept());
		 System.out.println(AR.get(3).getDept());
		 while (!trouve && i < AR.size())
		 { // si le departement correspond à celui saisie lors de la fonction
	         if(AR.get(i).getDept() == Integer.parseInt(TextDep.getText()))
	             trouve=true
	             ;
	         else
	         	i++;
	     }


		 if (!trouve)
		 {
			LabelDep.setText("Erreur, veuillez saisir un département valide");
		 }
		 else
		 {
			LabelDep.setText("Bon numéro de département : " + TextDep.getText());
			LabelNbKil.setVisible(true);
		 	TextNbKill.setVisible(true);
			TextDuree.setVisible(true);
		 	LabelDuree.setVisible(true);
			RadioJour.setVisible(true);
			RadioNuit.setVisible(true);
			RadioSemaine.setVisible(true);
			RadioWE.setVisible(true);
			RadioAllerRetour.setVisible(true);
			RadioAllerSimple.setVisible(true);
			ButtonCalculer.setVisible(true);


		 }
		//recher du dept  - si trouve on affiche

		;

}

	});
}
}