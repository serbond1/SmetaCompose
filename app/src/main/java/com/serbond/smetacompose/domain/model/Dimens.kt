package com.serbond.smetacompose.domain.model


const val INNER = "Внутренний"
const val OUTER = "Наружный"
data class Dimens(
    val id: Long = 0,
    val elementId: Long,
    val childElementId: Long,
    var size: Double,
    var angleType: String = INNER,   // внутренний угол
    var angle: Int = 90,
    var chord: Double? = null,      //длина хорды
    var radiusType: String? = null  // выпуклость наружу
)
