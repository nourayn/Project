package com.digitalblood.donationbackend.service;

import com.digitalblood.donationbackend.dto.NotificationDTO;
import com.digitalblood.donationbackend.model.Notification;
import com.digitalblood.donationbackend.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDTO createNotification(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setMessage(dto.getMessage());
        notification.setSource(dto.getSource());
        notification.setRead(false); // Always unread when created
        notification.setTimestamp(LocalDateTime.now());

        Notification saved = notificationRepository.save(notification);
        return mapToDTO(saved);
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NotificationDTO> getUnreadNotifications() {
        return notificationRepository.findByReadFalse()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NotificationDTO markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setRead(true);
        Notification updated = notificationRepository.save(notification);
        return mapToDTO(updated);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    // Helper method
    private NotificationDTO mapToDTO(Notification n) {
        return new NotificationDTO(n.getId(), n.getMessage(), n.getSource(), n.isRead(), n.getTimestamp());
    }
}
