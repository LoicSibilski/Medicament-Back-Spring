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
		String motDePasse = dto.getMotDePasse();
		String motDePasseConfirme = dto.getMotDePasseConfirme();
		
//		verifier que l'email est unique
		verifierEmailExiste(dto);
		
//		verifier que l'email correspond au bon format (regex)
		verifierEmailFormat(dto);
		
//		verifier que le mot de passe correspond au bon format (regex)
		verifierMotDePasseFormat(dto);

		
//		verifier que les mots de passe sont identiques
		verifierMotDePasses(motDePasse, motDePasseConfirme);
	}
	
	/**
	 * Cette méthode permet de vérifier si l'email existe dans la base de données
	 * @param dto
	 */
	private void verifierEmailExiste(CreationNouveauCompteDTO dto) {
		CreationNouveauCompteDTO compteRecupere = this.repository.findByEmail(dto.getEmail());
		System.out.println(compteRecupere);
		if(compteRecupere != null) {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'email existe déjà !");
		}
	}
	
	/**
	 * Cette méthode permet de vérifier si l'email correspond au bon format (regex)
	 * @param dto
	 */
	private void verifierEmailFormat(CreationNouveauCompteDTO dto) {
		String email = dto.getEmail();
        boolean emailValide = VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
//        System.out.println(email + " " + emailValide);
        if(!emailValide) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'email ne respecte pas le bon format");
        }
	}
	
	/**
	 * Cette méthode permet de vérifier si le mot de passe correspond au bon format (regex)
	 * @param dto
	 */
	private void verifierMotDePasseFormat(CreationNouveauCompteDTO dto) {
		String motDePasse = dto.getMotDePasse();
        boolean motDePasseValide = VALID_MOTDEPASSE_ADDRESS_REGEX.matcher(motDePasse).find();
//		System.out.println(motDePasse + " " + motDePasseValide);
        if(!motDePasseValide) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le mot de passe ne respecte pas le bon format");
        }
	}
	
	
	/**
	 * Cette méthode permet de vérifier que les deux mots de passe sont identiques
	 * @param motDePasse
	 * @param motDePasseConfirme
	 */
	private void verifierMotDePasses(String motDePasse, String motDePasseConfirme) {
		boolean motDePassesDifferents = (motDePasse.equals(motDePasseConfirme));
		if(!motDePassesDifferents) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Les mots de passe ne sont pas identiques");
		}
	}

	@Override
	public List<SimpleCompteDTO> recupererTousLesComptes() {
		List<Compte> comptes = this.repository.findAll();
		
		List<SimpleCompteDTO> compteDTO = new ArrayList<>();
		for (Compte compte : comptes) {
			compteDTO.add(this.mapper.convertValue(compte, SimpleCompteDTO.class));
		}
		return compteDTO;
	}

	@Override
	public SimpleCompteDTO recupererCompte(String id) {
		Compte compte = this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
		return mapper.convertValue(compte, SimpleCompteDTO.class);
	}
	
	
	
}
