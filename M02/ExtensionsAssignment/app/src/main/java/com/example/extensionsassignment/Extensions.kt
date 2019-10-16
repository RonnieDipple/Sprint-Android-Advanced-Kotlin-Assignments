package com.example.extensionsassignment

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import java.lang.reflect.Array.get

/*# Part - 1 Notification Builder (Extension Function using Lambda)
1. Follow the example for AlertDialog builder in the guided project and repeat that for the Notification Builder class.
2. Use NotificationCompat.Builder class to build the notification.
3. In the lambda for the Notification, pass in an id of 0 and an empty string for the channel Id.
4. The text should be "This is my Notification."
5. Set an icon and use colorPrimary when trying to get the color for the icon.*/


fun Context.showNotification(id: Int, CHANNEL_ID: String){
    val notificationCompat = NotificationCompat.Builder(this, CHANNEL_ID)
        .setContentTitle("This is my Notification Title")
        .setContentText("This is my Notification Title")
        .setSmallIcon(R.color.colorPrimary)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val notificationManager: NotificationManager =
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = ("Default Notification")
            val descriptionText = ("Default Notification")
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system

            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(id, notificationCompat.build())


}