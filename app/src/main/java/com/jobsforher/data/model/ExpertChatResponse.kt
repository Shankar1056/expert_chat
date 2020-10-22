package com.jobsforher.data.model

data class ExpertChatResponse(
    var status: String,
    var response_code: Int,
    var auth: ExpertChatAuth,
    var body: ArrayList<ExpertCharBody>,

    )

data class ExpertCharBody(
    var id: Int? = null,
    var title: String? = null,
    var date: String? = null,
    var start_time: String? = null,
    var end_time: String? = null,
    var speaker: String? = null,
    var designation: String? = null,
    var group_id: Int? = null,
    var post_id: Int? = null,
    var description: String? = null,
    var created_by: Int? = null,
    var created_on: Int? = null,
    var modified_on: Int? = null,
    var group_name: Int? = null,
)

class ExpertChatAuth {

}
