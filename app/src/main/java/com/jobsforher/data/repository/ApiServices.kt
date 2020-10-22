package com.bigappcompany.healthtunnel.data.repository

import com.jobsforher.data.model.ExpertChatReq
import com.jobsforher.data.model.ExpertChatResponse
import com.jobsforher.ui.utility.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiServices {
    @Headers("clientid:" + Constants.CLIENTID)
    @POST("expert_chat_details")
    fun getExpertChat(
        @Header("Authorization") auth: String,
        @Body request: ExpertChatReq
    ): Call<ExpertChatResponse>


}