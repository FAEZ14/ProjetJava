package VariantesAwal�;

public class Chongkak extends TamtamApachi{

	/**
	 * Constructeur du Chongkak utilisant le constructeur avec parmetre de l'awal� 
	 * car le nombre de graine et de trous de cette variante ne sont pas les 
	 * m�me que la variante de base 
	 * cette variante elle est similaire que le tamtam-apachi au niveau des r�gles du jeu 
	 * donc pour ne pas repeter le code j'ai fait un deuxi�me constructeur dans la variante tamtam-apachi
	 * pour qu'elle h�rite 
	 */
	public Chongkak() {
		super(98,14);
	}	
	/**
	 * specialisation de la m�thode getNomVariant pour sp�cifier le nom de la variante
	 */
	public String getNomVariant() {
		return "Chongkak";
	}
}
