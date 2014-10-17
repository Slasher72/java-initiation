package WindowBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Package.AR;
import Package.AS;

public class methodes {

public static void connectionBase(List<AR> aR, List<AS> aS)
{
	 //Calcul.RepriseTableau(AR, AS);
	 Connection connection = null;
		try
		{
         Class.forName("org.postgresql.Driver");
         System.out.println("Drivers Ok!!");


         Connection maConnexion = DriverManager.getConnection("jdbc:postgresql://172.16.99.2:5432/vpean","v.pean","peanvplpbg");
         Statement maRequete = maConnexion.createStatement();

         System.out.println("Connection effective !");


      String texteRequete = "select * from \"Taxi\".taxi";
         //définition de l'objet qui récupera le résultat de l'éxecution de la requète
         ResultSet curseurResultat = maRequete.executeQuery(texteRequete);
         System.out.println("requete ok !");

         // Récupération des détails du résultats
         ResultSetMetaData detailsDonnees = curseurResultat.getMetaData();
         System.out.println("détail ok !");
         while(curseurResultat.next())
         {System.out.print(curseurResultat.getInt("departement"));
        	aR.add(new AR (curseurResultat.getInt("departement"),curseurResultat.getDouble("PriseCharge"), curseurResultat.getDouble("TarifHoraireJour"),curseurResultat.getDouble("TarifHoraireNuit"),curseurResultat.getDouble("TarifARNuit"),curseurResultat.getDouble("TarifARJour")));
 			aS.add(new AS (curseurResultat.getInt("departement"),curseurResultat.getDouble("PriseCharge"), curseurResultat.getDouble("TarifHoraireJour"),curseurResultat.getDouble("TarifHoraireNuit"),curseurResultat.getDouble("TarifASNuit"),curseurResultat.getDouble("TarifASJour")));
 			System.out.println("while ok !");
         }

         maConnexion.close();
		}
     catch (Exception e)
     {
       System.out.print("Erreur de connection");
     }
}
/*
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

*/

}