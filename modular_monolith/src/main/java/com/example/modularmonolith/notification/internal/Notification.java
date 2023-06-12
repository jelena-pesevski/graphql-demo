package com.example.modularmonolith.notification.internal;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notification {

    private LocalDateTime localDateTime;
    private  NotificationType notificationType;
    private int orderId;
}
