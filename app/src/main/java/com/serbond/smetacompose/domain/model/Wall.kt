package com.serbond.smetacompose.domain.model


data class Wall(
    val id: Long ,
    val roomId: Long,
    var name: String = "",
    var area: Double = 0.0,
    val dimensions: Dimensions,
    var radial: Boolean,
    var note: String = ""
)
