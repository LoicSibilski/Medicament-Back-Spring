package com.m2i.medic.notification.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un modèle de notifications
 * @author fabien
 *
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

	@Id
	private String id;
	private String utilisateurId;
	private String message;
	private LocalDateTime dateNotification;
	private boolean isVue;
	
}
