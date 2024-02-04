package com.serbond.smetacompose.domain.model

data class Stair (
    val id: Long,
    val stairWayId: Long,
    var name: String,
    var height: Double, //высота
    var width: Double,//ширина
    var note: String = ""
)