package com.test.bcrtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BcrTestReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "10001";
    private static final String default_channel_id = "default";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("BcrTestReceiver", "action: " + action);
        int id = 0;
        if (Intent.ACTION_LOCKED_BOOT_COMPLETED.equals(action)) id = 1;
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) id = 2;

        if (id > 0) {
            notify(context, id, action);
        }
    }

    private void notify(Context context, int id, String action) {
        Notification.Builder builder = new Notification.Builder(context, default_channel_id);
        builder.setContentTitle("BootReceiver: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        builder.setContentText("ACTION: " + (action != null ? action : "<NULL>"));
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setAutoCancel(true);
        builder.setChannelId(CHANNEL_ID);
        Notification notification = builder.build();
        NotificationManager mgr = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Boot Completed Receiver channel", importance);
        mgr.createNotificationChannel(channel);
        mgr.notify(id, notification);
    }
}
