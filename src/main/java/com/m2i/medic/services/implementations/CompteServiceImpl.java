package com.m2i.medic.services.implementations;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import org.bson.internal.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.dtos.CompteDTO;
import com.m2i.medic.dtos.CreationNouveauCompteDTO;
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
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static final Pattern VALID_MOTDEPASSE_ADDRESS_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,15}$", Pattern.CASE_INSENSITIVE);
	
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
	public CompteDTO creationNouveauCompte(CreationNouveauCompteDTO dto) {
		verifierCreationCompte(dto); 
		Compte compte = this.mapper.convertValue(dto, Compte.class);
		compte.setMotDePasse(Base64.encode(dto.getMotDePasse().getBytes())); // modifier le chiffrement (actuellement ce n'est pas sécurisé)
		compte.setDateCreation(LocalDateTime.now());
		compte.setDateMisJour(LocalDateTime.now());
		Compte result = this.repository.save(compte);
		return this.mapper.convertValue(result, CompteDTO.class);
	}
	
	/**
	 * Cette méthode permet de vérifier si le compte est conforme
	 * @param dto
	 */
	private void verifierCreationCompte(CreationNouveauCompteDTO dto) {
//		verifier que l'email est unique
		verifierEmailExiste(dto);
		
//		verifier que l'email correspond au bon format (regex)
		verifierEmailFormat(dto);
		
//		verifier que le mot de passe correspond au bon format (regex)
		verifierMotDePasseFormat(dto);

		
//		verifier que les mots de passe sont identiques
		verifierMotDePasses(dto.getMotDePasse(), dto.getMotDePasseConfirme());
	}
	
	/**
	 * Cette méthode permet de vérifier si l'email existe dans la base de données
	 * @param dto
	 */
	private void verifierEmailExiste(CreationNouveauCompteDTO dto) {
		CreationNouveauCompteDTO compteRecupere = this.repository.findByEmail(dto.getEmail());
		System.out.println(compteRecupere);
		if(compteRecupere != null) {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Cette méthode permet de vérifier si l'email correspondent au bon format (regex)
	 * @param dto
	 */
	private void verifierEmailFormat(CreationNouveauCompteDTO dto) {
		String email = dto.getEmail();
        boolean emailValide = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
        if(!emailValide) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
	}
	
	/**
	 * Cette méthode permet de vérifier si le mot de passe correspondent au bon format (regex)
	 * @param dto
	 */
	private void verifierMotDePasseFormat(CreationNouveauCompteDTO dto) {
		String motDePasse = dto.getMotDePasse();
        boolean motDePasseValide = VALID_EMAIL_ADDRESS_REGEX.matcher(motDePasse).find();
        if(!motDePasseValide) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
	}
	
	
	/**
	 * Cette méthode permet de vérifier que les deux mots de passe sont identiques
	 * @param motDePasse
	 * @param motDePasseConfirme
	 */
	private void verifierMotDePasses(String motDePasse, String motDePasseConfirme) {
		System.out.println(motDePasse + " " + motDePasseConfirme);
		if(motDePasse != motDePasseConfirme) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
}
