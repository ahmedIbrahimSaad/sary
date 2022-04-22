package com.example.sarycatalog.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatalogResponse(

	@Json(name ="result")
	val result: List<ResultItemCatalogResponse?>? = null,

	@Json(name ="other")
	val other: Other? = null,

	@Json(name ="message")
	val message: String? = null,

	@Json(name ="status")
	val status: Boolean? = null
)

@JsonClass(generateAdapter = true)
data class BusinessStatus(

	@Json(name ="id")
	val id: Int? = null,

	@Json(name ="title")
	val title: String? = null
)

@JsonClass(generateAdapter = true)
data class FiltersItem(

	@Json(name ="image")
	val image: Any? = null,

	@Json(name ="metadata")
	val metadata: Metadata? = null,

	@Json(name ="filter_id")
	val filterId: Int? = null,

	@Json(name ="name")
	val name: String? = null
)

@JsonClass(generateAdapter = true)
data class Other(

	@Json(name ="show_vat")
	val showVat: Boolean? = null,

	@Json(name ="business_status")
	val businessStatus: BusinessStatus? = null,

	@Json(name ="show_special_order_view")
	val showSpecialOrderView: Boolean? = null,

	@Json(name ="header")
	val header: Header? = null,

	@Json(name ="uncompleted_profile_settings")
	val uncompletedProfileSettings: UncompletedProfileSettings? = null
)

@JsonClass(generateAdapter = true)
data class DataItem(

	@Json(name ="cover")
	val cover: Any? = null,

	@Json(name ="image")
	val image: String? = null,

	@Json(name ="metadata")
	val metadata: Metadata? = null,

	@Json(name ="group_id")
	val groupId: Int? = null,

	@Json(name ="name")
	val name: String? = null,

	@Json(name ="header")
	val header: Any? = null,

	@Json(name ="group_type")
	val groupType: Any? = null,

	@Json(name ="filters")
	val filters: List<Any?>? = null,

	@Json(name ="deep_link")
	val deepLink: String? = null
)

@JsonClass(generateAdapter = true)
data class UncompletedProfileSettings(

	@Json(name ="image")
	val image: String? = null,

	@Json(name ="is_completed_profile")
	val isCompletedProfile: Boolean? = null,

	@Json(name ="show_tag")
	val showTag: Boolean? = null,

	@Json(name ="message")
	val message: String? = null
)

@JsonClass(generateAdapter = true)
data class Metadata(

	@Json(name ="sub_title")
	val subTitle: String? = null,

	@Json(name ="consumable_display")
	val consumableDisplay: Any? = null,

	@Json(name ="title")
	val title: String? = null
)

@JsonClass(generateAdapter = true)
data class Header(

	@Json(name ="image")
	val image: String? = null,

	@Json(name ="type")
	val type: String? = null
)

@JsonClass(generateAdapter = true)
data class ResultItemCatalogResponse(

	@Json(name ="metadata")
	val metadata: Metadata? = null,

	@Json(name ="ui_type")
	val uiType: String? = null,

	@Json(name ="data")
	val data: List<DataItem?>? = null,

	@Json(name ="show_title")
	val showTitle: Boolean? = null,

	@Json(name ="show_more_enabled")
	val showMoreEnabled: Boolean? = null,

	@Json(name ="subtitle")
	val subtitle: String? = null,

	@Json(name ="excluded_business_segments")
	val excludedBusinessSegments: List<Any?>? = null,

	@Json(name ="data_type")
	val dataType: String? = null,

	@Json(name ="id")
	val id: Int? = null,

	@Json(name ="title")
	val title: String? = null,

	@Json(name ="row_count")
	val rowCount: Int? = null,

	@Json(name ="items_count")
	val itemsCount: Int? = null,

	@Json(name ="group_id")
	val groupId: Int? = null
)
