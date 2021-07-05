package com.m2i.medic.compte.services;

/**
 * Cette interface représente un vérificateur de dto d'un compte
 * @author fabien
 *
 */
public interface VerificateurCompteService {

	/**
	 * Cette méthode permet de vérifier si l'identifiant existe
	 * @return vrai ou faux
	 */
	public boolean idExiste();
	
	/**
	 * Cette méthode permet de vérifier si l'email existe
	 * @return vrai ou faux
	 */
	public boolean emailExiste();
	
	/**
	 * Cette méthode permet de vérifier si le pseudo existe
	 * @return vrai ou faux
	 */
	public boolean pseudoExiste();
	
	/**
	 * Cette méthode permet de vérifier si le format de l'email est conforme
	 * @return vrai ou faux
	 */
	public boolean emailFormatValide();
	
	/**
	 * Cette méthode permet de vérifier si le format de le pseudo est conforme
	 * @return vrai ou faux
	 */
	public boolean pseudoFormatValide();
	
	/**
	 * Cette méthode permet de vérifier si le format du mot de passe est conforme
	 * @return vrai ou faux
	 */
	public boolean motDePasseFormatValide();
	
	/**
	 * Cette méthode permet de vérifier si le chiffrement du mot de passe est conforme
	 * @return vrai ou faux
	 */
	public boolean motDePasseChiffrementValide();
}
