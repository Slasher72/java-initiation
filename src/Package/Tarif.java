package Package;

/**
* Tarif est la classe regroupant les infos permettant de calculer le tarif
*
* @author PEAN Valentin
* @version 1.0
*/

public class Tarif {

	private int Dept;
	private double PriseCharge;
	private double TarifHoraireJ;
	private double TarifHoraireNWE;

//Accesseurs

/**
* Accesseur du d�partement
* @return Num�ro du d�partement
*/

	public int getDept(){
		return Dept;
	}

/**
* Accesseur de la prise en charge
* @return Montant de la prise en charge
*/

	public double getPriseCharge(){
		return PriseCharge;
	}

/**
* Accesseur du tarif horaire jour
* @return Montant du tarif horaire jour
*/

	public double getTarifHoraireJ(){
		return TarifHoraireJ;
	}

/**
* Accesseur du tarif horaire nuit we
* @return Montant du tarif horaire nuit we
*/

	public double getTarifHoraireNWE(){
		return TarifHoraireNWE;
	}

// Modifieurs

	public void setDept(int D){
		this.Dept = D;
	}

	public void setPriseCharge(double PC){
		this.PriseCharge = PC;
	}

	public void setTarifHoraireJ(double THJ){
		this.TarifHoraireJ = THJ;
	}

	public void setTarifHoraireNWE(double THN){
		this.TarifHoraireNWE = THN;
	}

// Constructeurs

	public Tarif() {
		Dept = 72;
		PriseCharge = 2.15;
		TarifHoraireJ = 22.86;
		TarifHoraireNWE = 22.86;
	}

/**
* Constructeur
*
* @param d�partement (int)
* @param Prise en charge (double)
* @param Tarif horaire jour (double)
* @param Tarif horaire nuit (double)
*/

	public Tarif( int D, double PC, double THJ, double THN) {
		this.Dept = D;
		this.PriseCharge = PC;
		this.TarifHoraireJ = THJ;
		this.TarifHoraireNWE = THN;
	}

//Méthodes



}


