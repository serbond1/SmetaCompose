package com.serbond.smetacompose.domain.model.stair

data class StairCase (
    val id: Long,
    val stairWayId: Long,
    var name: String,
    var length: Double, //длина марша, площадки
    var width: Double,//ширина марша, площадки
    var note: String = ""
)