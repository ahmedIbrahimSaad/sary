package com.example.sarycatalog.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BannersResponse(

	@Json(name = "result")
	val result: List<ResultItem?>? = null,

	@Json(name = "status")
	val status: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class ResultItem(

	@Json(name = "image")
	val image: String? = null,

	@Json(name = "level")
	val level: String? = null,

	@Json(name = "expiry_date")
	val expiryDate: String? = null,

	@Json(name = "link")
	val link: String? = null,

	@Json(name = "description")
	val description: String? = null,

	@Json(name = "created_at")
	val createdAt: String? = null,

	@Json(name = "photo")
	val photo: String? = null,

	@Json(name = "title")
	val title: String? = null,

	@Json(name = "priority")
	val priority: Int? = null,

	@Json(name = "branch")
	val branch: Int? = null,

	@Json(name = "is_available")
	val isAvailable: Boolean? = null,

	@Json(name = "expiry_status")
	val expiryStatus: Boolean? = null,

	@Json(name = "id")
	val id: Int? = null,

	@Json(name = "button_text")
	val buttonText: String? = null,

	@Json(name = "start_date")
	val startDate: String? = null
)
