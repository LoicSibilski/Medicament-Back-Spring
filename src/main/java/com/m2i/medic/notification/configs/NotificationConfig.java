package com.m2i.medic.notification.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2i.medic.notification.repositories.NotificateurRepository;
import com.m2i.medic.notification.services.implementations.NotificationServiceImplementation;

/**
 * Cette classe représente la configuration de notifications
 * @author fabien
 *
 */
@Configuration
public class NotificationConfig {

	
	/**
	 * Cette méthode permet de retourner un bean pour utiliser le service de création d'une notification
	 * @param mapper
	 * @param repository
	 * @return un bean
	 */
	@Bean
	public NotificationServiceImplementation creerBeanNotificationServiceImplementation(ObjectMapper mapper, NotificateurRepository repository) {
		return new NotificationServiceImplementation(mapper, repository);
	}
}
