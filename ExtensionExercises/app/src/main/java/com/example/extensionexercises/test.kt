package com.example.extensionexercises

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import androidx.core.content.ContextCompat.getSystemService

class NotificationUtils(base: Context) : ContextWrapper(base) {

    private var mManager: NotificationManager? = null

    private val manager: NotificationManager?
        get() {
            if (mManager == null) {
                mManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            return mManager
        }

    init {
        createChannels()
    }

    fun createChannels() {

        // create android channel
        val androidChannel = NotificationChannel(
            ANDROID_CHANNEL_ID,
            ANDROID_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT
        )
        // Sets whether notifications posted to this channel should display notification lights
        androidChannel.enableLights(true)
        // Sets whether notification posted to this channel should vibrate.
        androidChannel.enableVibration(true)
        // Sets the notification light color for notifications posted to this channel
        androidChannel.lightColor = Color.GREEN
        // Sets whether notifications posted to this channel appear on the lockscreen or not
        androidChannel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

        manager!!.createNotificationChannel(androidChannel)

        // create ios channel
        val iosChannel = NotificationChannel(
            IOS_CHANNEL_ID,
            IOS_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH
        )
        iosChannel.enableLights(true)
        iosChannel.enableVibration(true)
        iosChannel.lightColor = Color.GRAY
        iosChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        manager!!.createNotificationChannel(iosChannel)
    }

    companion object {
        val ANDROID_CHANNEL_ID = ""
        val ID = 0

    }

        val IOS_CHANNEL_ID = "com.chikeandroid.tutsplustalerts.IOS"
        val ANDROID_CHANNEL_NAME = "ANDROID CHANNEL"
        val IOS_CHANNEL_NAME = "IOS CHANNEL"

}