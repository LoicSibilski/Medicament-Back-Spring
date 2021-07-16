package com.m2i.medic.notification.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.m2i.medic.notification.entities.Notification;

/**
 * Cette interface représente un repository de notifications
 * @author fabien
 *
 */
public interface NotificateurRepository extends MongoRepository<Notification, String> {

	/**
	 * Cette méthode permet de recupérer tous les messages d'un utilisateur via son identifiant
	 * @return une liste de notifications pour un utilisateur
	 */
	public List<Notification> findAllByUtilisateurId(String utilisateurId);
}
