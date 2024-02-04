package com.serbond.smetacompose.domain.model

const val INNER = "Внутренний"
const val OUTER = "Наружный"
data class Side (
    val id: Long ,
    val planeId: Long,
    var length: Double, //длина
    //var height: Double = 0.0, //высота
    var corner: Int = 90, //угол
    var cornerType: String = INNER, //тип угла
    var radius: Boolean = false,
    var chord: Double? = null,
    var radiusType: String? = null
)