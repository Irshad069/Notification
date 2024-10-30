package com.example.notifications

import android.content.Context
import androidx.lifecycle.ViewModel

class NotificationViewModel(context: Context) : ViewModel() {

    private val repository = NotificationRepository(context)

    fun triggerMediaStyleNotification(){
        repository.sendMediaStyleNotification()
    }
    fun triggerProgressStyleNotification() {
        repository.sendProgressStyleNotification()
    }

    fun triggerMessagingStyleNotification() {
        repository.sendMessagingStyleNotification()
    }

    fun triggerGroupNotification() {
        repository.sendGroupStyleNotification()
    }

}