package com.jobsforher.expert_chat

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jobsforher.R
import com.jobsforher.databinding.ActivityExpertChatBinding

class ExpertChatActivity : AppCompatActivity() {
    val viewModel: ExpertChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityExpertChatBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_expert_chat)

        binding.viewmodel = viewModel

    }
}