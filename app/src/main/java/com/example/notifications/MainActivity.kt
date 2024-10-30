package com.example.notifications

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.notifications.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: NotificationViewModel by viewModels {
        NotificationViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtonListeners()

    }

    private fun setupButtonListeners() {
        binding.mediaNotificationButton.setOnClickListener {
            viewModel.triggerMediaStyleNotification()
        }

        binding.progressNotificationButton.setOnClickListener {
            viewModel.triggerProgressStyleNotification()
        }

        binding.messagingNotificationButton.setOnClickListener {
            viewModel.triggerMessagingStyleNotification()
        }

        binding.groupNotificationButton.setOnClickListener {
            viewModel.triggerGroupNotification()
        }
    }
}