package com.e.mypetskz.data.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.e.mypetskz.R;
import com.e.mypetskz.second.SecondActivity;

public class NotificationHelper {

    private static final String CHANNEL_ID = "channel_id";

    public static Notification createNotification(Context context, String title, String body) {
        createNotificationChannel(context);

        Intent intent = new Intent(context, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);

        Intent intent2 = new Intent(context, SecondActivity.class);
        PendingIntent pendingIntent2 = PendingIntent.getActivity(context, 1, intent2, 0);

        return new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_email)
                .setContentTitle(title)
                .setContentIntent(pendingIntent)
                .setContentText(body)
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .addAction(R.drawable.ic_add_alert, "Посмотреть новость!", pendingIntent2)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
    }

    public static void showNotification (Context context, Notification notification) {
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, notification);
    }

    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "channel name";
            String description = "channel desc";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(channel);
        }
    }
}
