package com.serbond.smetacompose.domain.model

const val INNER = "Внутренний"
const val OUTER = "Наружный"
data class SidePlane (
    val id: Long ,
    val planeId: Long,
    val side: Side,
    var height: Boolean = false

)
data class Side(
    var length: Double, //длина
    var corner: Int = 90, //угол
    var cornerType: String = INNER, //тип угла
    var radius: Boolean = false,// если да
    var horda: Boolean = false,
)


