package com.m2i.medic.notification.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe représente un DTO de notifications
 * @author fabien
 *
 */
@Data
@NoArgsConstructor
public class NotificationDTO {
	
	String utilisateurId;
	String message;
}
