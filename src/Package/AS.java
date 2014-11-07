package Package;

/**
* AS est la classe comprenant toutes les infos pour un aller simple.
*
* @author PEAN Valentin
* @version 1.0
*/

public class AS extends Tarif {

//Attributs

	private double TarifNW;
	private double TarifJS;

//Accesseurs
/**
* Accesseur du tarif pour une nuit ou we
* @return Montant du tarif Nuit we (double)
*/
	public double getTarifNW(){
		return TarifNW;
	}

/**
* Accesseur du tarif pour un jour de la semaine
* @return Montant du tarif Jour semaine (double)
*/
	public double getTarifJS(){
		return TarifJS;
	}

//Modifieurs

	public void setTarifNW(double TNW){
		this.TarifNW = TNW;
	}

	public void setTarifJS(double TJS){
		this.TarifJS = TJS;
	}

//Constructeurs

	public AS() {
		TarifNW = 2.38;
		TarifJS = 1.58;
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
	public AS(int D, double PC, double THJ, double THN, double TNW, double TJS)
	{
		super(D, PC,  THJ,  THN);
		this.TarifNW = TNW;
		this.TarifJS = TJS;
	}

//Méthodes




	}


