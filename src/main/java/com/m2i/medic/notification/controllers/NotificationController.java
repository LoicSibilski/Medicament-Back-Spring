package com.m2i.medic.notification.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.medic.notification.entities.Notification;
import com.m2i.medic.notification.services.NotificateurService;

/**
 * Cette classe représent un contrôleur de notifications
 * @author fabien
 *
 */
@CrossOrigin
@RestController
@RequestMapping("notifications")
public class NotificationController {
	
	@Autowired
	private NotificateurService service;
	
	/**
	 * Cette méthode permet de créer une notification à partir du service
	 * @param notification
	 */
	@PostMapping("")
	public void creerNotification(@RequestBody Notification notification) {
		this.service.creerNotification(notification);
	}
	
	@GetMapping("/{utilisateurId}")
	public List<Notification> recupererNotificationsUtilisateur(@PathVariable String utilisateurId) {
		return this.service.recupererNotificationsUtilisateur(utilisateurId);
	}
	
}
