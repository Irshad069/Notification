package com.example.notifications

import android.content.Context

class NotificationRepository(private val context: Context) {

    private val notificationHelper = NotificationHelper(context)

    fun sendMediaStyleNotification(){
        notificationHelper.sendMediaStyleNotification()
    }
    fun sendProgressStyleNotification(){
        notificationHelper.sendProgressStyleNotification()
    }
    fun sendMessagingStyleNotification(){
        notificationHelper.sendMessagingStyleNotification()
    }
    fun sendGroupStyleNotification(){
        notificationHelper.sendGroupNotification()
    }

}