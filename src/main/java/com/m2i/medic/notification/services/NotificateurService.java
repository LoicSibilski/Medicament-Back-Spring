package com.m2i.medic.notification.services;

import java.util.List;

import com.m2i.medic.notification.entities.Notification;

/**
 * Cette interface représente un service de notifications
 * @author fabien
 *
 */
public interface NotificateurService {
	
	/**
	 * Cette méthode permet de créer une notification
	 * @param message
	 */
	public void creerNotification(Notification notification);
		
	/**
	 * Cette méthode permet de récupérer toutes les notifications d'un utilisateur
	 * @return liste de notifications d'un utilisateur
	 */
	public List<Notification> recupererNotificationsUtilisateur(String utilisateurId);
	
	/**
	 * Cette méthode permet de modifier une notification
	 * @param message
	 */
	public void modifierNotification(String message);
	
	/**
	 * Cette méthode permet de désactiver une notification
	 * @param isVue
	 */
	public void désactiverNotification(boolean isVue);
	
	/**
	 * Cette méthode permet de supprimer une notification
	 * @param notificationId
	 */
	public void supprimerNotification(String notificationId);
}
