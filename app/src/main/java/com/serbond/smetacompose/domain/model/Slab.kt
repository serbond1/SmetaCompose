package com.serbond.smetacompose.domain.model

const val FLOOR = "пол"
const val CEIL = "потолок"
data class Slab(
    val id: Long = 0,
    val roomId: Long,
    var name: String = "",
    var type: String = "",
    var area: Double = 0.0,
    var perimeter: Double = 0.0,
    var innerAngle: Int = 0,           // кол-во внутренних углов
    var outerAngle: Int = 0,           // кол-во наружних углов
    var note: String = ""
)
