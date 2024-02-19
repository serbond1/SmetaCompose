package com.serbond.smetacompose.domain.model.smeta

data class Price(
    val id: Long,
    var group: String,
    var elementType: String,
    var name: String,
    var creation: Boolean, // монтаж,демонтаж
    var unit: String,
    var price: Double
)
