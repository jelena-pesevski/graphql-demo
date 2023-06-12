package com.example.modularmonolith.notification;

import com.example.modularmonolith.notification.internal.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private static final List<Notification> notifications = new ArrayList<>();

    //TODO: add event listener

}
