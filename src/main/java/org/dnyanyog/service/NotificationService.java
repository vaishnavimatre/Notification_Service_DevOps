package org.dnyanyog.service;

import org.dnyanyog.dto.NotificationRequest;
import org.dnyanyog.dto.NotificationResponse;

public interface NotificationService {
	NotificationResponse ActivateNotification(NotificationRequest request );
}
