package com.jobsforher.expert_chat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*

class ExpertChatViewModel(val app: Application) : AndroidViewModel(app) {
    var selectedMonth = MutableLiveData<String>()
    var selected1Week = MutableLiveData<String>()
    var selected2Week = MutableLiveData<String>()
    var selected3Week = MutableLiveData<String>()
    var selected4Week = MutableLiveData<String>()
    var selected5Week = MutableLiveData<String>()

    init {
        getCurrentDate()
    }

    private fun getCurrentDate() {
        val now = Calendar.getInstance()

        val format = SimpleDateFormat("MM/dd/yyyy")

        val days = arrayOfNulls<String>(7)
        val delta = -now[GregorianCalendar.DAY_OF_WEEK] + 2 //add 2 if your week start on monday

        now.add(Calendar.DAY_OF_MONTH, delta)
        for (i in 0..6) {
            days[i] = format.format(now.time)
            now.add(Calendar.DAY_OF_MONTH, 1)
        }
        System.out.println(Arrays.toString(days))



    }

}