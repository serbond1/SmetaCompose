package com.serbond.smetacompose.domain.model

const val FLOOR = "пол"
const val CEIL = "потолок"
const val WALL = "стена"


data class BaseElement(
    val id: Long = 0,
    val roomId: Long,
    val name: String,
    val type: String,
    var area: Double = 0.0,
    var perimeter: Double = 0.0,
    var note: String = ""
)



