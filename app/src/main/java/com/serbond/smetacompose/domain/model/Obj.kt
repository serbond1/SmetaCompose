package com.serbond.smetacompose.domain.model

data class Obj(
    val id: Long,
    var name: String,
    val dataStart: String,
    val dataFinish: String,
    var archive: Boolean,
    val info: InfoObject
)
