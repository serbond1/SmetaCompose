package com.serbond.smetacompose.domain.model


const val FLOOR = "Пол"
const val CEIL = "Потолок"
const val CEIL_MANSARD = "Потолок мансардный"
const val WALL = "Стена"
const val WALL_MANSARD = "Стена мансардная"
const val PARTITION = "Перегородка"
data class Plane(
    val id: Long = 0,
    val roomId: Long,
    var name: String,
    val type: String,
    var active : Boolean = true,
    var area: Double = 0.0,
    var perimeter: Double = 0.0,
    var depth: Double = 0.0,// толщина стены, перекрытия
    var note: String = "",
)
