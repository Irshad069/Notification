package com.example.notifications

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NotificationRepository(application)

    fun triggerMediaStyleNotification(){
        viewModelScope.launch(Dispatchers.IO){
            repository.sendMediaStyleNotification()
        }
    }
    fun triggerProgressStyleNotification() {
        viewModelScope.launch(Dispatchers.IO){
            repository.sendProgressStyleNotification()
        }
    }

    fun triggerMessagingStyleNotification() {
        viewModelScope.launch(Dispatchers.IO){
            repository.sendMessagingStyleNotification()
        }
    }

    fun triggerGroupNotification() {
        viewModelScope.launch(Dispatchers.IO){
            repository.sendGroupStyleNotification()
        }
    }

}