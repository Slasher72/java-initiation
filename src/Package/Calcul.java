package Package;
import java.util.ArrayList;
import java.util.List;



public class Calcul
{

	public Calcul()
	{
		// TODO Auto-generated constructor stub
	}

	static double[][] tarifdep =
		{
		 // Dept -- PriseCharge -- TarifARJ -- TarifASJ -- TarifHoraireJ -- TarifNuitAR -- TarifNuitAS -- TarifHoraireNuitWE
			{21,        2,            0.86,      1.72,        21.93,           1.29,           2.58,            21.93},

			{25,       2.1,           0.83,      1.66,        22.5,            1.2,            2.4,             22.5},

			{39,       2.1,           0.83,      1.66,        22.5,            1.23,           2.46,            25},

			{44,       2.2,           0.79,      1.58,        24.19,           1.19,           2.37,            24.19},

			{72,       2.15,          0.79,      1.58,        22.86,           1.19,           2.38,            22.86},

			{73,       2.4,           0.84,      1.68,        25.4,            1.26,           2.52,            25.4},

			{74,       3.15,          0.92,      1.84,        17.3,            1.38,           2.76,            17.3},

			{75,       2.5,           1,         1.24,        0.0,             1.5,            1.5,             0.0},

			{85,       2.3,           0.8,       1.6,         22.2,            1.2,            2.4,             22.2},

			{90,       2.2,           0.83,      1.66,        21,              1.15,           2.3,             21}
		};


	// création des deux listes

			 List<AR> AR =  new ArrayList<AR>();
			 List<AS> AS =  new ArrayList<AS>();


	// Reprise des données du tableau pour les ajouter à la liste.
	public void RepriseTableau()
		{
			for (int i=0;i<10;i++)
			{
				AS.add(new AS ((int)tarifdep[i][0],tarifdep[i][1],tarifdep[i][2],tarifdep[i][4],tarifdep[i][5],tarifdep[i][7]));


				AR.add(new AR ((int)tarifdep[i][0],tarifdep[i][1],tarifdep[i][3],tarifdep[i][4],tarifdep[i][6],tarifdep[i][7]));

			}
		}

}

