package com.digitalblood.donationbackend.repository;

import com.digitalblood.donationbackend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByReadFalse(); // To fetch unread notifications
}
