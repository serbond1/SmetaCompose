package com.serbond.smetacompose.domain.model


const val INNER = "Внутренний"
const val OUTER = "Наружный"
data class Dimensions(
    var length: Double,
    var height: Double,
    var angleType: String,   // внутренний угол
    var angle: Int,
)
