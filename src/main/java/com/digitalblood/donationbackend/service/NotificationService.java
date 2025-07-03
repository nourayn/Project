package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {

    NotificationDTO createNotification(NotificationDTO notificationDTO);

    List<NotificationDTO> getAllNotifications();

    List<NotificationDTO> getUnreadNotifications();

    NotificationDTO markAsRead(Long id);

    void deleteNotification(Long id);
}
