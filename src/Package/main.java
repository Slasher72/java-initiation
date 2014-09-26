package Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main
{


	//static Scanner saisie = new Scanner(System.in);
//	static String typeduTrajet, jour, heure;
	//static int dept, dureeDepl, nbkm;


	public static void main(String[] args){
	// création des deux listes
int i=0;
	 List<AR> AR =  new ArrayList<AR>();
	 List<AS> AS =  new ArrayList<AS>();

	 Calcul.RepriseTableau(AR, AS);

	 Saisie saisie = new Saisie(AR);

	 boolean saisieOK = false;
	 do
	 {
	 i =0;
	 boolean trouve= false;

	 while (!trouve && i < AR.size())
	 { // si le departement correspond à celui saisie lors de la fonction
         if(AR.get(i).getDept() == saisie.getDept())
             trouve=true;
         else
         	i++;
     }

	 if (!trouve)
	 { Scanner saisies = new Scanner(System.in);
		System.out.print("Veuillez saisir un bon numero de departement (21 - 25 - 39 - 44 - 72 - 73 - 74 - 75 - 85 - 90 : ");
		saisie.setDept(saisies.nextInt());

	 }
	 else
		 saisieOK=true;
	 }
	 while (!saisieOK);

	 System.out.println("résultat : " +	 String.valueOf(Calcul.CalculTarifDepl(i, saisie, AR, AS)) + "€");
	}
}


