package Package;

/**
* AR est la classe comprenant toutes les infos pour un aller retour.
*
* @author PEAN Valentin
* @version 1.0
*/

public class AR extends Tarif {

	private double TarifNW;
	private double TarifJS;

	//Accesseurs

/**
 * Accesseur du tarif pour une nuit ou we
* @return Montant du tarif Nuit we (double)
*/

		public double getTarifNW()
		{
			return TarifNW;
		}

/**
* Accesseur du tarif pour un jour de la semaine
* @return Montant du tarif Jour semaine (double)
*/

		public double getTarifJS()
		{
			return TarifJS;
		}

	//Modifieurs


		public void setTarifNW(double TNW)
		{
			this.TarifNW = TNW;
		}

		public void setTarifJS(double TJS)
		{
			this.TarifJS = TJS;
		}
	// Constructeurs

	public AR()
{
		TarifNW = 1.19;
		TarifJS = 0.79;
}

/**
* Constructeur � partir de param�tres
*
* @param d�partement (int)
* @param Prise en charge (double)
* @param Tarif horaire jour (double)
* @param Tarif horaire nuit (double)
* @param Tarif nuit we (double)
* @param Tarif jour semaine (double)
*/

	public AR(int D, double PC, double THJ, double THN, double TNW, double TJS)
	{
		super( D,  PC,  THJ, THN);
		this.TarifJS = TJS;
		this.TarifNW = TNW;
	}

	// methodes


	public void afficher()
	{
		System.out.println(TarifJS+","+TarifNW+".");
	}

}