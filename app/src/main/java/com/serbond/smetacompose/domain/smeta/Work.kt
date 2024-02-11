package com.serbond.smetacompose.domain.smeta

data class Work(
    val id: Long,
    val idRoom: Long,
    val idPlane: Long,
    val idElement: Long,
    val priceGroup: String,
    var name: String,
    var creation: Boolean, // монтаж,демонтаж
    var unit: String,
    var price: Double,
    var volume: Double,
    var status: Boolean,
    var check: Boolean
)
