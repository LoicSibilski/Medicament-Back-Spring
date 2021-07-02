package com.m2i.medic.compte.services.implementations;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.compte.dtos.DesactivationCompteDTO;
import com.m2i.medic.compte.dtos.InscriptionDTO;
import com.m2i.medic.compte.dtos.ModificationCompteDTO;
import com.m2i.medic.compte.entities.Compte;
import com.m2i.medic.compte.repositories.ModificateurCompteRepository;
import com.m2i.medic.compte.services.ModificateurCompteService;

/**
 * Cette classe représente l'implémentation du service de modification d'un
 * compte
 * 
 * @author fabien
 *
 */
public class ModificationCompteServiceImplementation implements ModificateurCompteService {

	private ObjectMapper mapper;

	private ModificateurCompteRepository repository;

	/**
	 * Constructeur
	 * 
	 * @param mapper
	 * @param repository
	 */
	public ModificationCompteServiceImplementation(ObjectMapper mapper, ModificateurCompteRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public void creerCompte(InscriptionDTO nouveauCompte) {
		verifierCompte(nouveauCompte);
		Compte compte = this.mapper.convertValue(nouveauCompte, Compte.class);
		compte.setDateCreation(LocalDateTime.now());
		compte.setDateMisJour(LocalDateTime.now());
		this.repository.save(compte);
	}
	
	@Override
	public void modifierCompte(ModificationCompteDTO compteModifie) {

	}

	@Override
	public void desactiverCompte(DesactivationCompteDTO compteDesactive) {

	}

	/**
	 * Cette méthode permet de supprimer un compte
	 */
	private void supprimerCompte() {

	}

	/**
	 * Cette méthode permet de vérifier la conformité d'un nouveau compte
	 * 
	 * @param nouveauCompte
	 */
	private void verifierCompte(InscriptionDTO nouveauCompte) {
		boolean emailExiste = this.repository.findByEmail(nouveauCompte.getEmail()) == null ? false : true;;
		boolean pseudoExiste = this.repository.findByPseudo(nouveauCompte.getPseudo()) == null ? false : true;;
		boolean emailFormatValide = verifierFormatEmail(nouveauCompte.getEmail());
		boolean pseudoFormatValide = verifierFormatPseudo(nouveauCompte.getPseudo());
		boolean motDePasseFormatValide = verifierFormatMotDePasse(nouveauCompte.getMotDePasse());

		if (!emailFormatValide || !pseudoFormatValide || !motDePasseFormatValide || emailExiste || pseudoExiste)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Cette méthode permet de vérifier que le format de l'email correspond à la norme RFC 5322
	 * 
	 * @param email
	 * @return vrai ou faux
	 */
	private boolean verifierFormatEmail(String email) {
		Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
				+ "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
				+ "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]"
				+ "|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]"
				+ ":(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
		return pattern.matcher(email).matches();
	}

	/**
	 * Cette méthode permet de vérifier le format du pseudo
	 * 
	 * @param pseudo
	 * @return vrai ou faux
	 */
	private boolean verifierFormatPseudo(String pseudo) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9-_]{2,36})$");
		return pattern.matcher(pseudo).matches();
	}

	/**
	 * Cette méthode permet de vérifier le format du mot de passe
	 * 
	 * @param motDePasse
	 * @return vrai ou faux
	 */
	private boolean verifierFormatMotDePasse(String motDePasse) {
		Pattern pattern = Pattern
				.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
		return pattern.matcher(motDePasse).matches();
	}

}
