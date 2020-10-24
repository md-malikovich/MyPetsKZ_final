package com.e.mypetskz.data.notification;

import android.annotation.SuppressLint;
import android.app.Notification;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
public class FirebaseService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Notification notification = NotificationHelper.createNotification(getApplicationContext(),
                Objects.requireNonNull(remoteMessage.getNotification()).getTitle(),
                remoteMessage.getNotification().getBody());
        NotificationHelper.showNotification(getApplicationContext(), notification);
    }
}
