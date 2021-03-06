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
	public boolean verifierIdExiste(String id);
	
	/**
	 * Cette méthode permet de vérifier si l'email existe
	 * @return vrai ou faux
	 */
	public boolean verifierEmailExiste(String email);
	
	/**
	 * Cette méthode permet de vérifier si le format de l'email est conforme
	 * @return vrai ou faux
	 */
	public boolean verifierEmailFormatValide(String email);
	
	/**
	 * Cette méthode permet de vérifier si le format du mot de passe est conforme
	 * @return vrai ou faux
	 */
	public boolean verifierMotDePasseFormatValide(String motDePasse);
}
