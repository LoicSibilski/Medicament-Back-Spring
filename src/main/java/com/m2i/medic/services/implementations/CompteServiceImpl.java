package com.m2i.medic.services.implementations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.CreationNouveauCompteDTO;
import com.m2i.medic.dtos.SimpleCompteDTO;
import com.m2i.medic.models.Compte;
import com.m2i.medic.repositories.CompteRepository;
import com.m2i.medic.services.CompteService;

/**
 * Cette classe représente l'implémentation du service d'un compte
 * @author fabien
 *
 */
public class CompteServiceImpl implements CompteService {
	
	private ObjectMapper mapper;
	
	private CompteRepository repository;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^(.+)@(\\S+)$");
	
	public static final Pattern VALID_MOTDEPASSE_ADDRESS_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
	
	/**
	 * Constructeur
	 * @param repository
	 * @param mapperParam
	 */
	public CompteServiceImpl(CompteRepository repository, ObjectMapper mapperParam) {
		this.repository = repository;
		this.mapper = mapperParam;
	}

	@Override
	public CompteDTO creationNouveauCompte(CreationNouveauCompteDTO nouveauCompte) {
		verifierCreationCompte(nouveauCompte); 
		Compte compte = this.mapper.convertValue(nouveauCompte, Compte.class);
		compte.setMotDePasse(Base64.encode(nouveauCompte.getMotDePasse().getBytes())); // modifier le chiffrement (actuellement ce n'est pas sécurisé)
		compte.setDateCreation(LocalDateTime.now());
		compte.setDateMisJour(LocalDateTime.now());
		Compte compteSauvegarde = this.repository.save(compte);
		return this.mapper.convertValue(compteSauvegarde, CompteDTO.class);
	}

	/**
	 * Cette méthode permet de vérifier si le compte est conforme
	 * @param un compte
	 */
	private void verifierCreationCompte(CreationNouveauCompteDTO compte) {
		
//		verifier que l'email est unique
		verifierEmailExiste(compte);
		
//		verifier que l'email correspond au bon format (regex)
		verifierEmailFormat(compte);
		
//		verifier que le mot de passe correspond au bon format (regex)
		verifierMotDePasseFormat(compte);

	}
	
	/**
	 * Cette méthode permet de vérifier si l'email existe dans la base de données
	 * @param un compte
	 */
	private void verifierEmailExiste(CreationNouveauCompteDTO compte) {
		CreationNouveauCompteDTO compteRecupere = this.repository.findByEmail(compte.getEmail());
		System.out.println(compteRecupere);
		if(compteRecupere != null) {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'email existe déjà !");
		}
	}
	
	/**
	 * Cette méthode permet de vérifier si l'email correspond au bon format (regex)
	 * @param un compte
	 */
	private void verifierEmailFormat(CreationNouveauCompteDTO compte) {
		String email = compte.getEmail();
        boolean emailValide = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
        if(!emailValide) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'email ne respecte pas le bon format");
        }
	}
	
	/**
	 * Cette méthode permet de vérifier si le mot de passe correspond au bon format (regex)
	 * @param un compte
	 */
	private void verifierMotDePasseFormat(CreationNouveauCompteDTO compte) {
		String motDePasse = compte.getMotDePasse();
        boolean motDePasseValide = VALID_MOTDEPASSE_ADDRESS_REGEX.matcher(motDePasse).find();
        if(!motDePasseValide) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le mot de passe ne respecte pas le bon format");
        }
	}
	
	@Override
	public List<SimpleCompteDTO> recupererTousLesComptes() {
		List<Compte> listeComptes = this.repository.findAll();
		
		List<SimpleCompteDTO> nouvelleListeCompte = new ArrayList<>();
		for (Compte compte : listeComptes) {
			nouvelleListeCompte.add(this.mapper.convertValue(compte, SimpleCompteDTO.class));
		}
		return nouvelleListeCompte;
	}

	@Override
	public SimpleCompteDTO recupererUnCompte(String identifiant) {
		Compte compte = this.repository.findById(identifiant)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return mapper.convertValue(compte, SimpleCompteDTO.class);
	}

	@Override
	public void supprimerUnCompte(String identifiant) {
		if(this.repository.existsById(identifiant))
			this.repository.deleteById(identifiant);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
	}

	@Override
	public void supprimerTousLesComptes() {
		this.repository.deleteAll();
	}
	
	
	
}
