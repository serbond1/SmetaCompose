package com.serbond.smetacompose.domain.model

data class Level(
    val id: Long,
    val objId: Long,
    var name: String,
    var note: String = ""
)
