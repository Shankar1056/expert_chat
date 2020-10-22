package com.jobsforher.expert_chat

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.app.Application
import android.content.DialogInterface
import android.view.View
import android.widget.ArrayAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bigappcompany.healthtunnel.data.network.ApiCallback
import com.jobsforher.data.model.ExpertChatBody
import com.jobsforher.data.model.ExpertChatReq
import com.jobsforher.data.model.ExpertChatResponse
import com.jobsforher.ui.utility.HelperMethods
import java.text.SimpleDateFormat
import java.util.*


class ExpertChatViewModel(val app: Application) : AndroidViewModel(app) {
    var selectedMonth = MutableLiveData<String>("October")
    var selectedYear = MutableLiveData<String>("2020")
    var selected1Week = MutableLiveData<String>()
    var selected2Week = MutableLiveData<String>()
    var selected3Week = MutableLiveData<String>()
    var selected4Week = MutableLiveData<String>()
    var selected5Week = MutableLiveData<String>()
    var expertChatList = MutableLiveData<ArrayList<ExpertChatBody>>()
    lateinit var context: Activity

    fun getCurrentDate(context: Activity) {
        this.context = context
        getCurrentDate()
       // monthClicked("Months", HelperMethods.getMonths())
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

    fun getExpertChat() {
        val model = ExpertChatReq()
        model.month = 1
        model.year = 2020

        model.getExpertChat("Bearer y33lyPYy4k5LYKgs4xi3ZvkCtODHYmQptod4RyFD9G", model,
            object : ApiCallback() {
                override fun onSuccess(obj: Any?) {
                    val response = obj as ExpertChatResponse
                    expertChatList.value = response.body

                }

                override fun onHandledError() {
                }
            })

    }


    fun onMonthClicked(view: View) {
        monthClicked("Months", HelperMethods.getMonths())

    }


    fun onYearClicked(view: View) {
        monthClicked("Years", HelperMethods.getYears())

    }

    private fun monthClicked(clickedName: String, monthsYearList: ArrayList<String>) {
        val builderSingle: AlertDialog.Builder = AlertDialog.Builder(context)
        builderSingle.setTitle("Select $clickedName")

        val arrayAdapter =
            ArrayAdapter<String>(context, R.layout.select_dialog_singlechoice)
        arrayAdapter.addAll(monthsYearList)


        builderSingle.setNegativeButton("cancel",
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })

        builderSingle.setAdapter(arrayAdapter,
            DialogInterface.OnClickListener { dialog, which ->
                val strName = arrayAdapter.getItem(which)
                when(clickedName){
                    "Years" -> selectedYear.value = strName
                    "Months" -> selectedMonth.value = strName
                }

                dialog.dismiss()
            })
        builderSingle.show()
    }

}