package com.jobsforher.expert_chat

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.jobsforher.R
import com.jobsforher.databinding.ActivityExpertChatBinding
import com.jobsforher.ui.expert_chat.adapter.ExpertChatAdapter
import kotlinx.android.synthetic.main.activity_expert_chat.*

class ExpertChatActivity : AppCompatActivity() {
    val viewModel: ExpertChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityExpertChatBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_expert_chat)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.getCurrentDate(this@ExpertChatActivity)
        viewModel.getExpertChat()

        viewModel.expertChatList.observe(this, Observer {
            expertChatRV.adapter = ExpertChatAdapter(it, object :
                ExpertChatAdapter.OnItemClickListener {
                override fun onJoinClicked(pos: Int) {
                    Toast.makeText(this@ExpertChatActivity, "join Clicked : pos - "+pos, Toast.LENGTH_SHORT).show()
                }

                override fun onViewDetailsClicked(pos: Int) {
                    Toast.makeText(this@ExpertChatActivity, "viewDetails Clicked : pos - "+pos, Toast.LENGTH_SHORT).show()
                }

            })
        })

    }
}