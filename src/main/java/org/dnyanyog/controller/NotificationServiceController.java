package org.dnyanyog.controller;

import org.dnyanyog.dto.NotificationRequest;
import org.dnyanyog.dto.NotificationResponse;
import org.dnyanyog.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationServiceController {
	
@Autowired
NotificationServiceImpl notificationService;


@PostMapping
(path="/api/notification/v1/notify",consumes={"application/json","application/xml"},
		produces={"application/json","application/xml"})
public NotificationResponse ActivateNotification(@RequestBody NotificationRequest notificationRequest)
{
	return notificationService.ActivateNotification(notificationRequest);
}

}
