package com.serbond.smetacompose.domain.model

const val INNER = "Внутренний"
const val OUTER = "Наружный"
data class Side (
    val id: Long ,
    val planeId: Long,
    var length: Double, //длина
    var corner: Int = 90, //угол
    var cornerType: String = INNER, //тип угла
    var radius: Boolean = false,// если да length - длина хорды
    var height: Boolean = false

)