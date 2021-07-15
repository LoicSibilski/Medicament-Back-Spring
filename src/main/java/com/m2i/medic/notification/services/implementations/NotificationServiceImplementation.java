package com.m2i.medic.notification.services.implementations;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.notification.dtos.NotificationDTO;
import com.m2i.medic.notification.entities.Notification;
import com.m2i.medic.notification.repositories.NotificateurRepository;
import com.m2i.medic.notification.services.NotificateurService;

/**
 * Cette classe représente l'implémentation du service de notifications
 * @author fabien
 *
 */
public class NotificationServiceImplementation implements NotificateurService {

	private ObjectMapper mapper;

	private NotificateurRepository repository;
	
	
	/**
	 * Constructeur
	 * @param mapper
	 * @param repository
	 */
	public NotificationServiceImplementation(ObjectMapper mapper, NotificateurRepository repository) {
		super();
		this.mapper = mapper;
		this.repository = repository;
	}


	@Override
	public void creerNotification(NotificationDTO notification) {
		Notification nouvelleNotification = new Notification();
		nouvelleNotification.setUtilisateurId(notification.getUtilisateurId());
		nouvelleNotification.setMessage(notification.getMessage());
		nouvelleNotification.setDateNotification(LocalDateTime.now());
		nouvelleNotification.setVue(false);
		this.repository.save(nouvelleNotification);
	}


	@Override
	public List<Notification> recupererNotificationsUtilisateur(String utilisateurId) {
		return this.repository.findAllByUtilisateurId(utilisateurId);
	}


	@Override
	public void modifierNotification(String message) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void désactiverNotification(boolean isVue) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void supprimerNotification(String notificationId) {
		// TODO Auto-generated method stub
		
	}

}
