package com.serbond.smetacompose.domain.model.smeta

import java.util.Date

data class Finance(
    val id: Long,
    val objId: Long,
    var summa: Double,
    var action: Boolean, //получено-потрачено
    var type: String, //работа,материалы
    val data: Date
)
