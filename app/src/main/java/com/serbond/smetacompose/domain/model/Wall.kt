package com.serbond.smetacompose.domain.model

const val INNER = "Внутренний"
const val OUTER = "Наружный"
data class Wall (
    val id: Long = 0,
    val roomId: Long,
    val name: String,
    val length: Double = 0.0,
    var heigh: Double = 0.0,
    var angleType: String = INNER,   // внутренний угол
    var angle: Int = 90,
    var chord: Double? = null,      //длина хорды
    var radiusType: String? = null, // выпуклость наружу
    var area: Double = 0.0,
    var active : Boolean = false,
    var note: String = ""
)