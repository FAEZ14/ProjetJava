package VariantesAwalé;

public class Chongkak extends TamtamApachi{

	/**
	 * Constructeur du Chongkak utilisant le constructeur avec parmetre de l'awalé 
	 * car le nombre de graine et de trous de cette variante ne sont pas les 
	 * même que la variante de base 
	 * cette variante elle est similaire que le tamtam-apachi au niveau des règles du jeu 
	 * donc pour ne pas repeter le code j'ai fait un deuxième constructeur dans la variante tamtam-apachi
	 * pour qu'elle hérite 
	 */
	public Chongkak() {
		super(98,14);
	}	
	/**
	 * specialisation de la méthode getNomVariant pour spécifier le nom de la variante
	 */
	public String getNomVariant() {
		return "Chongkak";
	}
}
