package com.example.notifications

import android.content.Context

class NotificationRepository(private val context: Context) {

    private val notificationHelper = NotificationHelper(context)

    suspend fun sendMediaStyleNotification(){
        notificationHelper.sendMediaStyleNotification()
    }
    suspend fun sendProgressStyleNotification(){
        notificationHelper.sendProgressStyleNotification()
    }
    suspend fun sendMessagingStyleNotification(){
        notificationHelper.sendMessagingStyleNotification()
    }
    suspend fun sendGroupStyleNotification(){
        notificationHelper.sendGroupNotification()
    }

}