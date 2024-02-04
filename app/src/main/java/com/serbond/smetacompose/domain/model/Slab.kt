package com.serbond.smetacompose.domain.model





data class Slab (
    val id: Long = 0,
    val roomId: Long,
    var name: String,
    val type: String,
    var area: Double = 0.0,
    var perimeter: Double = 0.0,
    var note: String = ""
)



