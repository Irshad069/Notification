package com.example.notifications

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.media.app.NotificationCompat.MediaStyle

class NotificationHelper(private val context: Context) {

    private val CHANNEL_ID = "notification_demo_channel"

    init {
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notification Demo"
            val descriptionText = "Channel for notification demo"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun getUniqueNotificationId(): Int {
        return System.currentTimeMillis().toInt()
    }

    private fun createPendingIntent(): PendingIntent {
        val intent = Intent(context, MainActivity::class.java)
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
    }

    @SuppressLint("MissingPermission")
    fun sendMediaStyleNotification() {
        val largeIcon = BitmapFactory.decodeResource(context.resources, R.drawable.ic_music_note)
        val notificationId = getUniqueNotificationId()

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_music_note)
            .setContentTitle("Now Playing")
            .setContentText("Song Title - Artist name")
            .setLargeIcon(largeIcon)
            .addAction(R.drawable.ic_previous, "Previous", null)
            .addAction(R.drawable.ic_pause, "Pause", null)
            .addAction(R.drawable.ic_next, "Next", null)
            .setStyle(MediaStyle())
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(createPendingIntent())
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, notification)
    }

    @SuppressLint("MissingPermission")
    fun sendProgressStyleNotification() {
        val maxProgress = 100
        val currentProgress = 50
        val notificationId = getUniqueNotificationId()

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_download)
            .setContentTitle("Download in progress")
            .setContentText("Downloading file...")
            .setProgress(maxProgress, currentProgress, false)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(createPendingIntent())
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, notification)
    }

    @SuppressLint("MissingPermission")
    fun sendMessagingStyleNotification() {
        val message1 = NotificationCompat.MessagingStyle.Message("Hey, how's it going?", System.currentTimeMillis(), "John")
        val message2 = NotificationCompat.MessagingStyle.Message("I'm doing great!", System.currentTimeMillis(), "You")
        val notificationId = getUniqueNotificationId()

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_message)
            .setStyle(NotificationCompat.MessagingStyle("You")
                .addMessage(message1)
                .addMessage(message2))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(createPendingIntent())
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, notification)
    }

    @SuppressLint("MissingPermission")
    fun sendGroupNotification() {
        val notificationId = getUniqueNotificationId()
        val summaryNotification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("New messages")
            .setContentText("You have new messages")
            .setSmallIcon(R.drawable.ic_message)
            .setStyle(NotificationCompat.InboxStyle()
                .addLine("Message from Alice")
                .addLine("Message from Bob")
                .setBigContentTitle("New messages"))
            .setGroup("group_key")
            .setGroupSummary(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(createPendingIntent())
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context).notify(notificationId, summaryNotification)
    }
}