package com.serbond.smetacompose.domain.model

data class InfoObject(
    val id: Long,
    val objId: Long,
    var address: String = "",
    var fio: String = "",
    var tel: String = "",
    var email: String = "",
    var note: String = ""
)
