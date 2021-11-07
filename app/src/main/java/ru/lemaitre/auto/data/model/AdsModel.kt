package ru.lemaitre.auto.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AdsModel(
    val id: Long,
    val name: String,
//    val model: String = "",
    val year: Int,
//    val photos: List<String> = emptyList(),
//    val engineVolume: Double = 0.0,
//    val typeFuel: String = "",
//    val typeTransmission: String = "",
//    val typeDrive: String = "",
//    val mileage: Int = 0,
//    val horsePower: Int = 0,
//    val typeBody: String = "",
//    val color: String = "",
//    val locationSteeringWheel: String = "",
    val ownerNote: String,
//    val location: String = "",
//    val date: String = ""
)